package com.webmargic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.model.common.RequestTaskModel;
import com.model.wb.WbComments;
import com.model.wb.WbInsertModel;
import com.model.wb.WbReply;
import com.model.wb.WbTopic;
import com.service.WeiBoService;
import com.webmargic.utils.CommentUtils;
import com.webmargic.utils.HttpClientUtil;
import com.webmargic.utils.WeiBoUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 微博网站
 *
 * @author Liukx
 * @create 2017-03-29 17:54
 * @email liukx@elab-plus.com
 **/
public class WeiBoProcessor implements PageProcessor {


    private Site site;

    // 如果爬出来的页面不对劲,非常有可能是cookie过期了,请更换!!!
//    private String cookie = "SINAGLOBAL=6308490169689.749.1488338237328; wb_publish_fist100_2630551761=1; un=444368875@qq.com; wvr=6; __utma=15428400.1852760086.1493011752.1493011752.1493011752.1; __utmz=15428400.1493011752.1.1.utmcsr=weibo.com|utmccn=(referral)|utmcmd=referral|utmcct=/friends; Hm_lvt_407473d433e871de861cf818aa1405a1=1493011448,1493011745,1493012254,1493013842; SCF=AiErfjlUf6oJkzA9r38SD-Aaf90ZPioEB8b4Suer34xVBOmi5UyAbRsh03hSbayaCnSYcleSBM1zP11bv0Wv96Y.; SUB=_2A251-4ofDeThGeRI6FIU9S_LzT2IHXVXcPzXrDV8PUJbmtBeLVP3kW9RN7UHVFm5_gDVloP0plxAsvroWg..; SUBP=0033WrSXqPxfM725Ws9jqgMF55529P9D9Wh22jMvZnZ9WKG0j2G0iqZs5JpX5o2p5NHD95QESoe7SK-pS0qpWs4Dqcj6i--Ri-i2i-8hi--Ri-isiKnNi--Ri-iWi-8Fi--NiKyFi-8hi--RiKnNi-8Wi--fiKysi-z4i--ciKnpi-8s; SUHB=0xnTI8TvtoONuG; ALF=1524620316; SSOLoginState=1493170767; _s_tentry=login.sina.com.cn; UOR=www.csdn.net,widget.weibo.com,code.cocoachina.com; YF-Page-G0=340a8661f2b409bf3ea4c8981c138854; Apache=5392543884216.043.1493189980535; ULV=1493189980561:11:7:4:5392543884216.043.1493189980535:1493084325040; YF-V5-G0=5f9bd778c31f9e6f413e97a1d464047a; YF-Ugrow-G0=9642b0b34b4c0d569ed7a372f8823a8e;";
    private String cookie;
    // TODO 必填
    //微博帐号
    private String username = "444368875@qq.com";
    // 微博密码
    private String password = "lkx3551211";


    private String contentMatch = "http://weibo.com/p/aj/v6/mblog/mbloglist";

    private String comentsUrl = "http://weibo.com/aj/v6/comment/big";

    private String userDetails = "http://weibo.com/p/[A-Za-z0-9]+/info";

    private String commentsMatch = "http://weibo.com/\\d+/[A-Za-z0-9]+\\?[A-Za-z0-9=_&]+";

    //微博手机端评论地址
    private String mobileCommentUrl = "https://m.weibo.cn/api/comments/show";

    private String mobileUrl = "https://m.weibo.cn/status";

    private String base_url = "weibo.com";

    private String search_url = "http://s.weibo.com/weibo";

    private AtomicInteger count = new AtomicInteger();

    //主域名
    public String BASE_Node_URL;

    private WeiBoService weiBoService;

    private String keyword;

    public WeiBoProcessor(WeiBoService weiBoService, RequestTaskModel requestTaskModel) throws Exception {
        this.BASE_Node_URL = requestTaskModel.getUrl();
        this.keyword = requestTaskModel.getKeyword();
        this.weiBoService = weiBoService;
        this.cookie = WeiBoUtils.login(username, password);
    }


    /**
     * 具体要执行的抓去内容处理
     *
     * @param page
     */
    public void process(Page page) {
        // 如果是请求微博列表页面
        if (page.getUrl().toString().startsWith(contentMatch)) {

        }
        // 手机端评论请求
        else if (page.getUrl().toString().startsWith(mobileUrl)) {
            WbInsertModel wbInsertModel = new WbInsertModel();
            parseMobileHtml(page, wbInsertModel);
        }
        // 如果是评论或者回复的情况下
        else if (page.getUrl().toString().startsWith(comentsUrl)) {

        }
        //如果是大厅搜索关键字查询的结果
        else if (page.getUrl().toString().startsWith(search_url)) {
            //todo 感觉抓取到的评论不是特别想要的.暂时不去做实现
            resolveKeywordSubject(page, new WbInsertModel());
        }
        // 用户信息
        else if (page.getUrl().regex(userDetails).match()) {
            String script = page.getHtml().xpath("/html/body/script[14]").get();
            String json = script.substring(script.indexOf("{"), script.lastIndexOf("}") + 1);
            JSONObject jsonObject = JSON.parseObject(json);
        }
        // 评论详情页面
        else if (page.getUrl().regex(commentsMatch).match()) {
            try {
                WbInsertModel model = new WbInsertModel();
                resolveSingleSubject(page, model);
                System.out.println("---------------数据爬取完毕--------------");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // 微博博主列表信息
            String url = page.getUrl().toString();
//            System.out.println("url - > " + url);
            WbInsertModel model = new WbInsertModel();
            resolveUserInfo(page, model);
        }
    }

    /**
     * 抓取手机端传递过来的页面
     * @param page
     * @param model
     */
    private void parseMobileHtml(Page page, WbInsertModel model) {
        String renderDataStr = scripteResolveJSON(page, "$render_data");
        String rederData = renderDataStr.substring(renderDataStr.indexOf("[{"), renderDataStr.lastIndexOf("}]") + 2);
        String data = CommentUtils.Html2Text(rederData);
        JSONArray objects = JSON.parseArray(data);
        JSONObject status = objects.getJSONObject(0).getJSONObject("status");
        String text = status.getString("text");
        String id = status.getString("id");
        Integer likeCount = status.getInteger("attitudes_count");
        Integer reportsCount = status.getInteger("reposts_count");
        Integer commentsCount = status.getInteger("comments_count");
        JSONObject user = status.getJSONObject("user");
        String userId = user.getString("id");
        String username = user.getString("screen_name");
        String homePage = user.getString("profile_url");
        WbTopic topic = new WbTopic();
        topic.setCommentsCount(commentsCount);
        topic.setContent(text);
        topic.setForwardCount(reportsCount);
        topic.setLikeCount(likeCount);
        topic.setSystemTime(new Date());
        topic.setTopicId(id);
        topic.setUsername(username);
        topic.setUserNo(userId);
        topic.setHomePage(homePage);
        model.setWbTopic(topic);
        String url = mobileCommentUrl + "?id=" + id;
        Long start = System.currentTimeMillis();
        mobileCommentList(model, id, text, url, 0);
        System.out.println("一共抓去耗时:" + (System.currentTimeMillis() - start));
    }

    private void mobileCommentList(WbInsertModel model, String topicId, String title, String url, int page) {
        StringBuffer sb = new StringBuffer(url);
        sb.append("&page=" + page);
        System.out.println("请求参数:" + sb.toString());
        String resultData = HttpClientUtil.doGet(sb.toString());
        JSONObject resultJson = JSON.parseObject(resultData);
        JSONArray dataList = resultJson.getJSONArray("data");
        if (dataList == null || dataList.size() == 0) {
            System.out.println("★★★★★★★★★★★★★★★★★★" + resultJson.toJSONString());
            // 防止请求太快,返回不了正确的结果集!
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mobileCommentList(new WbInsertModel(), topicId, title, url, page);
            return;
        }
        int max = resultJson.getInteger("max");
        int count = resultJson.getInteger("total_number");
        List<WbReply> replyList = model.getReplyList();
        List<WbComments> commentsList = model.getCommentsList();

        for (int i = 0; i < dataList.size(); i++) {
            JSONObject jsonObject = dataList.getJSONObject(i);

            String text = jsonObject.getString("text");

            // 默认高质量评论 字数必须大于10
            if (!CommentUtils.commentFilter(text)) {
                continue;
            }
            String id = jsonObject.getString("id");
            Integer like_counts = jsonObject.getInteger("like_counts");
            String created_at = jsonObject.getString("created_at");

            JSONObject user = jsonObject.getJSONObject("user");
            String username = user.getString("screen_name");
            String userId = user.getString("id");
            String profile_url = user.getString("profile_url");
            if (text.startsWith("回复") || text.startsWith("回復") || text.startsWith("回覆")) {
                String reply_id = jsonObject.getString("reply_id");
                String reply_text = jsonObject.getString("reply_text");
                //回復内容
                WbReply reply = new WbReply();
                reply.setCommentsId(id);
                reply.setContent(text);
                reply.setCreated(created_at);
                reply.setHomePage(profile_url);
                reply.setTopicId(topicId);
                reply.setLikeCount(like_counts);
                reply.setUserId(userId);
                reply.setUsername(username);
                reply.setSystemTime(new Date());
                reply.setReplyId(reply_id);
                reply.setReplyText(reply_text);
                replyList.add(reply);
            } else {
                //评论内容
                WbComments comments = new WbComments();
                comments.setCommentsId(id);
                comments.setContent(CommentUtils.Html2Text(text));
                comments.setLikeCount(like_counts);
                comments.setCreated(created_at);
                comments.setUsername(username);
                comments.setUserNo(userId);
                comments.setSystemTime(new Date());
                comments.setHomePage(profile_url);
                comments.setTopicId(topicId);
                comments.setTopicText(title);
                commentsList.add(comments);
            }
            //System.out.println("第 [" + ((page * 10) + i) + "] --- 评论 : " + text);
        }

        try {
            weiBoService.insertData(model);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (page < max) {
            int nextPage = page + 1;
            mobileCommentList(new WbInsertModel(), topicId, title, url, nextPage);
        }

    }

    /**
     * 获取用户信息
     *
     * @param page
     */
    private void resolveUserInfo(Page page, WbInsertModel model) {
        // 截取字符 评论列表
        String scriptValue = page.getHtml().xpath("/html/head/script").all().get(2);
        JSONObject jsonObject = resolveData(scriptValue);
        //总数统计
        List<String> countList = page.getHtml().xpath("/html/body/script[17]").regex(">[0-9]+<").regex("[0-9]+").all();
        // 关注
        String guanzhu = countList.get(0);
        // 粉丝
        String fansCount = countList.get(1);
        //微博
        String weiboCount = countList.get(2);
        resolveFirst(page, jsonObject, 1, 0, model);
    }

    /**
     * 查询博主列表页面
     *
     * @param page       爬虫对象
     * @param jsonObject 页面的js渲染对象
     * @param pageNo     当前页数
     * @param pageBar    渲染页面
     */
    private void resolveFirst(Page page, JSONObject jsonObject, int pageNo, int pageBar, WbInsertModel model) {
        StringBuffer sb = new StringBuffer("http://weibo.com/p/aj/v6/mblog/mbloglist?ajwvr=6");
        sb.append("&domain=" + jsonObject.getString("domain"));
        //是否热门
        //sb.append("&is_hot=1");
        //是否展示所有
        sb.append("&is_all=1");
        sb.append("&pagebar=" + pageBar);
        sb.append("&pre_page=" + pageBar);
        sb.append("&id=" + jsonObject.getString("page_id"));
        sb.append("&page=" + pageNo);
        System.out.println("请求地址:" + sb.toString());

        Map header = new HashMap<>();
        header.put("Cookie", cookie);
        String resultData = HttpClientUtil.doGetHeader(sb.toString(), header);
        JSONObject resultJson = JSON.parseObject(resultData);
        String data = resultJson.getString("data");
        Html html = new Html(data);
        // 获取微博信息
        Selectable xpathList = html.xpath("html/body/div");
        // 话题
        List<String> subjectList = xpathList.xpath("/div/div/div/div[3]/text()").all();
        //跳转次数
        List<String> forwardList = html.xpath("/html/body/div/div[2]/div/ul/li[2]/a/span/span/span/em[2]/text()").all();
        // 评论次数
        List<String> commentsList = html.xpath("/html/body/div/div[2]/div/ul/li[3]/a/span/span/span/em[2]/text()").all();
        // 点赞数
        List<String> likeList = html.xpath("/html/body/div/div[2]/div/ul/li[4]/a/span/span/span/em[2]/text()").all();
        // 创建时间
        Selectable linkeList = html.xpath("/html/body/div/div[1]/div[3]/div[2]/a[1]");
        for (int i = 0; i < subjectList.size(); i++) {
            //////////////////////////////话题详情资料///////////////////////////////////
            String subject = subjectList.get(i);
            String forwardCount = forwardList.get(i);
            String commentsCount = commentsList.get(i);
            String likeCount = likeList.get(i);
            String created = html.$("body > div:nth-child(" + (i + 1) + ") > div.WB_feed_detail.clearfix > div.WB_detail > div.WB_from.S_txt2 > a:nth-child(1)", "title").get();
            // 评论编号
            String commentsId = html.$("body > div:nth-child(" + (i + 1) + ") > div.WB_feed_detail.clearfix > div.WB_detail > div.WB_from.S_txt2 > a:nth-child(1)", "name").get();
            String aObj = linkeList.links().all().get(i);
            // 评论加密编号
            String subjectId = aObj.substring(aObj.lastIndexOf("/") + 1, aObj.indexOf("?"));
            // 页面编号
            String page_id = jsonObject.getString("page_id");
            Integer pid = jsonObject.getInteger("pid");
            Integer oid = jsonObject.getInteger("oid");
            String uid = jsonObject.getString("uid");
            String userNo = getCurrentUserId(page);
            //////////////////////////////话题详情资料///////////////////////////////////

            //////////////////////////////抓去相关评论///////////////////////////////////
            resolveComments(commentsId, 1, model);
        }
        ///////////////////////////////为微博列表添加详情连接///////////////////////////////////
        List<String> allLinks = html.xpath("/html/body/div/div[1]/div[3]/div[2]/a[1]").links().all();
        page.addTargetRequests(allLinks);
        System.out.println("resultJson - " + resultJson.toJSONString());
    }


    private Html scripteResolveHtml(Page page, String indexOf) {
        List<String> scriptList = page.getHtml().xpath("/html/body/script").all();
        String script = "";
        for (int i = 0; i < scriptList.size(); i++) {
            String html = scriptList.get(i);
            if (html.indexOf(indexOf) > 0) {
                script = html;
                break;
            }
        }
        String htmls = script.substring(script.indexOf("<div"), script.lastIndexOf("div>") + 4);
        Html html = new Html(StringEscapeUtils.unescapeEcmaScript(htmls));
        return html;
    }


    private String scripteResolveJSON(Page page, String indexOf) {
        List<String> scriptList = page.getHtml().xpath("/html/body/script").all();
        String script = "";
        for (int i = 0; i < scriptList.size(); i++) {
            String html = scriptList.get(i);
            if (html.indexOf(indexOf) > 0) {
                script = html;
                break;
            }
        }
        return script;
    }

    private void resolveKeywordSubject(Page page, WbInsertModel model) {
//        WbTopic wbTopic = model.getWbTopic();
//        // 话题 scripte 标识
//        String indexOf = "feed_lists W_texta";
//        // 评论
//        Html html = scripteReslveHtml(page, indexOf);
//        // 内容
//        List<String> contentList = html.xpath("/html/body/div/div/div/div/div/div/dl/div/div/div/p/html()").all();
//        // 内容编号
//        String contentId = html.$("body > div > div > div > div.WB_feed_detail.clearfix > div.WB_detail > div.WB_from.S_txt2 > a:nth-child(1)", "name").get();
//
//        // 创建时间
//        String created = html.$("body > div > div > div > div.WB_feed_detail.clearfix > div.WB_detail > div.WB_from.S_txt2 > a:nth-child(1)", "title").get();
//        // 用户主页
//        String url = html.$("body > div > div > div > div.WB_feed_detail.clearfix > div.WB_detail > div.WB_from.S_txt2 > a:nth-child(1)", "href").get();
//        // 用户昵称
//        String username = html.xpath("/html/body/div/div/div/div/div/div[1]/a/text()").regex("\\S+").get();
//        // 转发
//        String forwardCount = html.xpath("/html/body/div/div/div/div[2]/div/ul/li[2]/a/span/span/span/em[2]/text()").get();
//        // 评论
//        String commentCount = html.xpath("/html/body/div/div/div/div[2]/div/ul/li[3]/a/span/span/span/em[2]/text()").get();
//        // 点赞
//        String likeCount = html.xpath("/html/body/div/div/div/div[2]/div/ul/li[4]/a/span/span/span/em[2]/text()").get();
//        // 用户编号
//        String userId = url.substring(url.indexOf("com/") + 4, url.lastIndexOf("/"));
//
//        wbTopic.setContent(content);
//        wbTopic.setTopicId(contentId);
//        wbTopic.setCreated(created);
//        // 昵称
//        wbTopic.setCommentsCount(Integer.valueOf(commentCount));
//        wbTopic.setForwardCount(formatForwardCount(forwardCount));
//        wbTopic.setLikeCount(likeConverZero(likeCount));
//        wbTopic.setUserNo(userId);
//        wbTopic.setSystemTime(new Date());
//        wbTopic.setHomePage("http://weibo.com/" + userId);
//        wbTopic.setUsername(username);
//        System.out.println("话题 ----> " + content);
//        resolveComments(contentId, 1, model);
    }

    /**
     * 获取单个话题信息
     *
     * @param page
     */
    private void resolveSingleSubject(Page page, WbInsertModel model) {
        WbTopic wbTopic = model.getWbTopic();
        // 话题 scripte 标识
        String indexOf = "pl.content.weiboDetail.index";
        // 评论
        Html html = scripteResolveHtml(page, indexOf);
        // 内容
        String content = html.xpath("/html/body/div/div/div/div/div/div[3]/html()").get();
        // 内容编号
        String contentId = html.$("body > div > div > div > div.WB_feed_detail.clearfix > div.WB_detail > div.WB_from.S_txt2 > a:nth-child(1)", "name").get();

        // 创建时间
        String created = html.$("body > div > div > div > div.WB_feed_detail.clearfix > div.WB_detail > div.WB_from.S_txt2 > a:nth-child(1)", "title").get();
        // 用户主页
        String url = html.$("body > div > div > div > div.WB_feed_detail.clearfix > div.WB_detail > div.WB_from.S_txt2 > a:nth-child(1)", "href").get();
        // 用户昵称
        String username = html.xpath("/html/body/div/div/div/div/div/div[1]/a/text()").regex("\\S+").get();
        // 转发
        String forwardCount = html.xpath("/html/body/div/div/div/div[2]/div/ul/li[2]/a/span/span/span/em[2]/text()").get();
        // 评论
        String commentCount = html.xpath("/html/body/div/div/div/div[2]/div/ul/li[3]/a/span/span/span/em[2]/text()").get();
        // 点赞
        String likeCount = html.xpath("/html/body/div/div/div/div[2]/div/ul/li[4]/a/span/span/span/em[2]/text()").get();
        // 用户编号
        String userId = url.substring(url.indexOf("com/") + 4, url.lastIndexOf("/"));

        wbTopic.setContent(content);
        wbTopic.setTopicId(contentId);
        wbTopic.setCreated(created);
        // 昵称
        wbTopic.setCommentsCount(Integer.valueOf(commentCount));
        wbTopic.setForwardCount(formatForwardCount(forwardCount));
        wbTopic.setLikeCount(likeConverZero(likeCount));
        wbTopic.setUserNo(userId);
        wbTopic.setSystemTime(new Date());
        wbTopic.setHomePage("http://weibo.com/" + userId);
        wbTopic.setUsername(username);
        System.out.println("话题 ----> " + content);
        resolveComments(contentId, 1, model);
    }

    /**
     * 解析评论列表
     *
     * @param id
     * @param pageNo
     */
    private void resolveComments(String id, int pageNo, WbInsertModel model) {
        StringBuffer sb = new StringBuffer("http://weibo.com/aj/v6/comment/big?");
        sb.append("&id=" + id);
        //是否热门
        //sb.append("&is_hot=1");
        //是否展示所有  all hot
        sb.append("&filter=all");
        sb.append("&page=" + pageNo);
        System.out.println("请求地址:" + sb.toString());

        Map header = new HashMap<>();
        header.put("Cookie", cookie);
        String resultData = HttpClientUtil.doGetHeader(sb.toString(), header);
        JSONObject resultJson = JSON.parseObject(resultData);
        JSONObject data = resultJson.getJSONObject("data");
        // 当前评论总数
        Integer count = data.getInteger("count");
        // 当前html代码
        String html = data.getString("html");
        // 分页信息
        JSONObject page = data.getJSONObject("page");
        // 当前评论总页数
        Integer totalpage = page.getInteger("totalpage");
        // 当前页数
        Integer pagenum = page.getInteger("pagenum");

        Html htmls = new Html(html);
//        System.out.println("htmls = " + htmls);
        // 评论
        List<String> contentList = htmls.xpath("/html/body/div/div/div/div[2]/div[1]/text()").replace("：", "").replace("回复:", "").all();
        // 点赞
        List<String> likeList = htmls.xpath("/html/body/div/div/div/div/div/div[1]/ul/li/span/a/span/em[2]/text()").all();
        // 用户昵称
        List<String> nameList = htmls.xpath("/html/body/div/div/div/div[2]/div[1]/a[1]/text()").all();
        // 时间
        List<String> timeList = htmls.xpath("/html/body/div/div/div/div/div/div[2]/text()").all();
        // 评论总数
//        List<String> commentList = htmls.xpath("/html/body/div/div/div/div/div/div[1]/ul/li/span/a/span/em[2]/text()").all();
        // 对应的用户编号
        List<String> userList = htmls.xpath("/html/body/div/div/div/div[2]/div[1]/a[1]").links().all();
        List<String> commentIdList = htmls.$("body > div > div > div", "comment_id").regex("\\S+").all();
        try {
            for (int i = 0; i < contentList.size(); i++) {
//            //////////////////////////////评论详情资料///////////////////////////////////
                String content = contentList.get(i);
                if (StringUtils.isBlank(content) || content.trim().equals("图片评论")) {
                    continue;
                }
                String likeCount = likeList.get(i);
                String name = nameList.get(i);
                // 和系统时间去比较 可以得到创建时间
                String time = timeList.get(i);
//                String commentCount = commentList.get(i);
                String userid = userList.get(i).substring(1, userList.get(i).length());
                String commentId = commentIdList.get(i);
                WbComments comments = new WbComments();
                comments.setContent(content);
                comments.setLikeCount(likeConverZero(likeCount));
                comments.setCreated(time);
//                comments.setCommentsCount(Integer.valueOf(commentCount));
                comments.setUserNo(userid);
                comments.setSystemTime(new Date());
                comments.setCommentsId(commentId);
                comments.setHomePage("http://weibo.com/" + userid);
                comments.setTopicId(id);
                comments.setUsername(name);
                //System.out.println("内容:" + content + " \t 点赞:" + likeCount);
                //////////////////////////////评论详情资料///////////////////////////////////
                ////////////////////////////获取回复详情///////////////////////////////////
                StringBuffer reply = new StringBuffer("http://weibo.com/aj/v6/comment/big?is_child_comment=ture&from=singleWeiBo");
                reply.append("&root_comment_id=" + commentId);
                reply.append("&id=" + id);
                resolveReplyInfo(reply.toString(), model, id, commentId, comments);
                model.getCommentsList().add(comments);
                ////////////////////////////////////////////////////////////////////////////

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (pagenum < totalpage) {
            resolveComments(id, pagenum + 1, model);
        }
    }

    /**
     * 解析回复内容信息
     *
     * @param url
     * @param model
     * @param comments
     */
    private void resolveReplyInfo(String url, WbInsertModel model, String id, String commentsId, WbComments comments) {
        Map header = new HashMap<>();
        header.put("Cookie", cookie);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String resultData = HttpClientUtil.doGetHeader(url, header);
        JSONObject resultJson = JSON.parseObject(resultData);
        JSONObject data = resultJson.getJSONObject("data");
        Integer count = data.getInteger("count");
        comments.setCommentsCount(count);
        String htmls = data.getString("html");
        Html html = new Html(htmls);
        // 评论
        List<String> contentList = html.xpath("/html/body/div/div/div[1]/text()").replace("：", "").replace("回复:", "").all();
        // 点赞                               /html/body/div/div/div/div/div[1]/text()
        List<String> likeList = html.xpath("/html/body/div/div/div/div/ul/li/span/a/span/em[2]/text()").all();
        // 用户昵称
        List<String> nameList = html.xpath("/html/body/div/div/div/a[1]/text()").all();
        // 时间  --0-0
        List<String> timeList = html.xpath("/html/body/div/div/div/div[2]/text()").all();
        // 对应的用户编号
        List<String> userList = html.$("body > div > div > div.WB_text > a", "userCard").regex("\\d+").all();
        // 评论编号
        List<String> commentIdList = html.$("body > div", "comment_id").regex("\\S+").all();
        int size = contentList.size();
        for (int i = 0; i < size; i++) {
            //////////////////////////////评论详情资料///////////////////////////////////
            String content = contentList.get(i);
            if (StringUtils.isBlank(content) || content.trim().equals("图片评论")) {
                continue;
            }
            String likeCount = likeList.get(i);
            String name = nameList.get(i);
            // 和系统时间去比较 可以得到创建时间
            String time = timeList.get(i);
            String userid = userList.get(i);
            String commentId = commentIdList.get(i);
            WbReply wbReply = new WbReply();
            wbReply.setContent(content);
//            wbReply.setLikeCount(likeConverZero(likeCount));
            wbReply.setCreated(time);
            wbReply.setUserId(userid);
            wbReply.setSystemTime(new Date());
            wbReply.setReplyId(commentId);
            wbReply.setHomePage("http://weibo.com/" + userid);
            wbReply.setUsername(name);
            wbReply.setCommentsId(commentsId);
            wbReply.setTopicId(id);
            model.getReplyList().add(wbReply);
            //////////////////////////////评论详情资料///////////////////////////////////
//            System.out.println("回复内容:" + content + " \t 点赞:" + likeCount);
        }
        String aUrl = html.$("body > div.list_li_v2 > div > a", "action-data").get();
        if (size < count) {
            aUrl = "http://weibo.com/aj/v6/comment/big?is_child_comment=ture&from=singleWeiBo&" + aUrl;
            resolveReplyInfo(aUrl, model, id, commentsId, comments);
        }

    }

    private Integer likeConverZero(String text) {
        if (text == null || text.equals("赞")) {
            return 0;
        }
        return Integer.valueOf(text);
    }

    private Integer formatForwardCount(String text) {
        if (StringUtils.isBlank(text) || text.equals("转发")) {
            return 0;
        }
        return Integer.valueOf(text);
    }


    private String getCurrentUserId(Page page) {
        String url = page.getUrl().get();
        String userId = "";
        if (url.indexOf("?") > 0) {
            userId = url.substring(url.lastIndexOf("/") + 1, url.indexOf("?"));
        } else {
            userId = url.substring(url.lastIndexOf("/") + 1, url.length());
        }
        return userId;
    }


    /**
     * 解析javascript对象为json对象
     *
     * @param script
     * @return
     */
    private JSONObject resolveData(String script) {
        String[] split = script.split(";");
        JSONObject json = new JSONObject();
        if (split.length > 0) {
            for (int i = 0; i < split.length; i++) {
                String obj = split[i];
                if (obj.indexOf("['") > 0) {
                    int startIndex = obj.indexOf("['") + 2;
                    int endIndex = obj.indexOf("']");
                    String key = obj.substring(startIndex, endIndex);
                    startIndex = obj.indexOf("='") + 2;
                    endIndex = obj.lastIndexOf("'");
                    String value = obj.substring(startIndex, endIndex);
                    json.put(key, value);
                }
            }
        }
        return json;
    }

    /**
     * @return
     */
    public Site getSite() {
        if (site == null) {
            //http://music.163.com/discover/toplist  -- 排行榜
            site = Site.me().setDomain(base_url).addStartUrl(BASE_Node_URL)
                    .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31")
                    .addHeader("Cookie", cookie);
        }
        return site;
    }


    public static void main(String[] args) {
        //http://weibo.com/topgirls8
//        Spider.create(new WeiBoProcessor("http://weibo.com/1713926427/Etq2WnSiR?type=comment")).thread(5).run();
    }
}
