package com.crawler.webmargic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.crawler.model.common.RequestTaskModel;
import com.crawler.model.es.EsModel;
import com.crawler.model.tt.TTCommentVO;
import com.crawler.model.tt.TtComment;
import com.crawler.service.ICrawlerService;
import com.crawler.webmargic.utils.CommentUtils;
import com.crawler.webmargic.utils.HttpClientUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.*;

/**
 * 今日头条评论数据获取
 *
 * @author Liukx
 * @create 2017-05-12 15:05
 * @email liukx@elab-plus.com
 **/
public class TTProcessor implements PageProcessor {

    private Logger logger = LoggerFactory.getLogger(TTProcessor.class);

    private Site site;

    // 接口调用需要返回的认证token
//    private String authorization = "oauth c3cef7c66a1843f8b3a9e6a1e3160e20";

    //详情地址
    private String contentMatch = "http://www.toutiao.com/a\\d+";

    private String contentMatch2 = "https://m.toutiao.com/group";

    //关键字
    private String keyword;

    private String base_url = "toutiao.com";

//    private AtomicInteger count = new AtomicInteger();

    //主域名
//    public static final String BASE_Node_URL = "http://www.toutiao.com/search/?keyword=%E5%91%A8%E6%9D%B0%E4%BC%A6";
    public String BASE_Node_URL = "https://m.toutiao.com/group/6422571796587053313/?iid=10391972388&app=news_article&tt_from=android_share&utm_source=email&utm_medium=toutiao_android&utm_campaign=client_share";
    //    public String BASE_Node_URL = "http://www.toutiao.com/a6406084872905998594";

//    private EsClient es = new EsClient();

    private ICrawlerService crawlerService;

    private RequestTaskModel requestTaskModel;

    public TTProcessor(ICrawlerService crawlerService, RequestTaskModel request) {
        this.crawlerService = crawlerService;
        if (StringUtils.isNotBlank(request.getUrl())) {
            this.BASE_Node_URL = request.getUrl();
        }
        this.keyword = request.getKeyword();
    }

    /**
     * 具体要执行的抓去内容处理
     *
     * @param page
     */
    public void process(Page page) {
        // 数据承装集合
        List<TtComment> list = new ArrayList<TtComment>();
        //抓去详情内容
        if (StringUtils.isNotBlank(keyword)) {
            try {
                getHttpList(list, keyword, 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (page.getUrl().regex(contentMatch).match()) {
            String url = page.getUrl().get();
            String itemsid = page.getHtml().xpath("/html/body/script").regex("item_id: '\\d+'").regex("\\d+").get();
            String groupId = url.substring(url.lastIndexOf("/a") + 2, url.length());
            String title = page.getHtml().xpath("//*[@id=\"article-main\"]/h1/text()").get();
            if (StringUtils.isEmpty(title)) {
                title = page.getHtml().xpath("title/text()").get();
            }
            try {
                getHttpComment(list, title, groupId.replace("/", ""), itemsid, 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (page.getUrl().regex(contentMatch2).match()) {
            String url = page.getUrl().get();
            int startNo = url.indexOf("group/") + 6;
            String htmlNo = url.substring(startNo, url.indexOf("/", startNo));
            page.addTargetRequest("http://www.toutiao.com/a" + htmlNo);
        } else {
            logger.error("头条没有匹配到相应的地址:" + page.getUrl().get());
            return;
        }
        logger.info(" 开始添加数据 数据大小 : " + list.size());
        TTCommentVO ttCommentVO = new TTCommentVO();
        ttCommentVO.setCommentList(list);
        try {
            crawlerService.insertData(ttCommentVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void resolveContent(Page page) {
        // 正文内容
        String text = page.getHtml().xpath("//*[@id=\"article-main\"]/div[2]/div").get();
        // 标题
        String title = page.getHtml().xpath("//*[@id=\"article-main\"]/h1/text()").get();
    }


    /**
     * @return
     */
    public Site getSite() {
        if (site == null) {
            site = Site.me().setDomain(base_url); //.addStartUrl(BASE_Node_URL);
        }
        return site;
    }

    /**
     * http调用评论接口
     *
     * @param list    数据承装集合
     * @param title   文章标题
     * @param groupId 分组编号
     * @param itemsId 节点编号
     * @param offset  第几条开始
     * @return
     */
    private void getHttpComment(List<TtComment> list, String title, String groupId, String itemsId, int offset) throws Exception {
        int size = 50;
        StringBuffer url = new StringBuffer("http://is.snssdk.com/article/v2/tab_comments/?");
        url.append("group_id=" + groupId);
        url.append("&item_id=" + itemsId);
        url.append("&aggr_type=1");
        url.append("&count=" + size);
        url.append("&offset=" + offset);
        logger.info("==================================请求的接口地址 : " + url.toString() + "===============");
        String json = HttpClientUtil.doGet(url.toString());
        JSONObject jsonObject = JSON.parseObject(json);
        JSONArray data = jsonObject.getJSONArray("data");
        if (data == null) {
            logger.error("参数爬取不完整 url : " + url.toString() + "  返回结果 : " + jsonObject.toJSONString());
            return;
        }
        Integer count = jsonObject.getInteger("total_number");
        EsModel model = new EsModel();
        model.setIndex(groupId);
        //默认今日头条
        model.setType("jrtt");

        for (int i = 0; i < data.size(); i++) {
            JSONObject dataObject = data.getJSONObject(i);
            JSONObject comment = dataObject.getJSONObject("comment");
            String text = comment.getString("text");
            //点赞
            Integer digg_count = comment.getInteger("digg_count");
            // 创建时间
            Long createdLongTime = comment.getLong("create_time");

            //将long类型的时间转换成date
            Date createdTime = CommentUtils.timestampConvertDate(createdLongTime);

            // 用户昵称
            String username = comment.getString("user_name");
            //回复内容
            JSONArray reply_list = comment.getJSONArray("reply_list");
            //用户编号
            String user_id = comment.getString("user_id");
            //主键
            String id = comment.getString("id");
            // 评论的字数必须大于10个字
            if (CommentUtils.commentFilter(text)) {
                //System.out.println((i + offset) + "评论:" + comment.getString("text") + " 赞:" + digg_count);
                TtComment comment1 = new TtComment();
                comment1.setCommentId(id);
                comment1.setLikeCount(digg_count);
                comment1.setText(text);
                comment1.setCreatedTime(createdTime);
                comment1.setUsername(username);
                comment1.setTitle(title);
                comment1.setTopicId(groupId);
                comment1.setUserId(user_id);
                comment1.setSystemTime(new Date());
                list.add(comment1);
            }
        }
        logger.info(" 处理完 [" + list.size() + "] 条数据 ");
        if (offset < count) {
            getHttpComment(list, title, groupId, itemsId, offset + size);
        }
    }

    /**
     * 根据关键字查询新闻列表
     *
     * @param list
     * @param keyword 关键字
     * @param offset  关键字获取
     * @return
     */
    public void getHttpList(List<TtComment> list, String keyword, int offset) throws Exception {
        StringBuffer url = new StringBuffer("http://www.toutiao.com/search_content/?");
        url.append("offset=" + offset);
        url.append("&format=json");
        url.append("&keyword=" + keyword);
        // 为true的情况下就是把data里面的数据格式化成html
//        url.append("&format=true");
        url.append("&count=100");
        url.append("&&cur_tab=1");
        logger.info("请求参数:" + url.toString());
        Map header = new HashMap();
        header.put("Content-Type", "application/json");
        String dataJSON = HttpClientUtil.doGetHeader(url.toString(), header);
        JSONObject data = JSON.parseObject(dataJSON);
        JSONArray data1 = data.getJSONArray("data");
        List<String> dataList = new ArrayList();
        for (int i = 0; i < data1.size(); i++) {
            JSONObject dataObject = data1.getJSONObject(i);
            // 获取title
            String title = dataObject.getString("title");
            // 关键字
            String keywords = dataObject.getString("keywords");
            String urls = dataObject.getString("url");
            String comment_count = dataObject.getString("comment_count");
            Date create_time = dataObject.getDate("create_time");
            String dateTime = dataObject.getString("datetime");
            String abstractText = dataObject.getString("abstract");
            // 标识文章详情的
            String item_id = dataObject.getString("item_id");
            String group_id = dataObject.getString("group_id");
            // 递归评论
            getHttpComment(list, title, group_id, item_id, 0);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("title", title);
            jsonObject.put("keywords", keyword);
            dataList.add(jsonObject.toJSONString());
        }
//        EsModel model = new EsModel();
//        model.setIndex("title");
        logger.info(" 数据展示 : " + data.toJSONString());
    }

    public static void main(String[] args) throws Exception {
//        getHttpComment("6406084872905998594", "6406087986466783745", 0);
//        getHttpList("你最穷的时候", 0);
//        Spider.create(new TTProcessor()).thread(5).run();
//        TTProcessor t = new TTProcessor(n);
//        t.getHttpList("你最穷的时候", 0);
//        t.getHttpComment("20几岁最穷的时候，你是怎么度过的", "6391302245694357762", "6390587365978571266", 0);
//        t.getHttpComment("www", "6406084872905998594", "6406084872905998594", 1061);
//        Spider.create(new TTProcessor()).thread(5).run();
    }

}
