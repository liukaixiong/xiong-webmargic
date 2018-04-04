package com.webmargic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.model.WyyComment;
import com.model.WyyHotComment;
import com.model.WyyMusic;
import com.model.WyyUser;
import com.model.common.RequestTaskModel;
import com.service.ICrawlerService;
import com.webmargic.utils.CommentUtils;
import com.webmargic.utils.WangYiYunEncryptUtils;
import com.webmargic.vo.CommentVO;
import com.webmargic.vo.RequestModel;
import com.webmargic.vo.wyy.KeywordModel;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 网易云评论抓取规则解析
 *
 * @author Liukx
 * @create 2017-03-29 17:54
 * @email liukx@elab-plus.com
 **/
public class WangYiYunProcessor implements PageProcessor {
    private Integer maxReadComment = 10000;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    // 1. 周杰伦歌曲评论地址:http://music.163.com/artist?id=6452
    private ICrawlerService crawlerService;

    private String url = "http://music.163.com/song?id=186016";

    private String keyword;

    public WangYiYunProcessor(ICrawlerService crawlerService, RequestTaskModel requestTaskModel) {
        this.crawlerService = crawlerService;
        if (StringUtils.isNotBlank(requestTaskModel.getUrl())) {
            this.url = requestTaskModel.getUrl();
        }
        this.keyword = requestTaskModel.getKeyword();
    }

    private Site site;

    private String contentMatch = "http://music.163.com/song\\?id=\\d+";

    private String searchMatch = "http://music.163.com/#/search/m/";

    //加密使用到的文本
    public static final String TEXT = "{\"username\": \"\", \"rememberLogin\": \"true\", \"password\": \"\", \"offset\": \"\"}";

    //主域名
    public static final String BASE_URL = "http://music.163.com/";


    /**
     * 具体要执行的抓去内容处理
     *
     * @param page
     */
    public void process(Page page) {

        // 关键字搜索
        if (StringUtils.isNotBlank(keyword)) {
            logger.debug("网易云 - 关键字搜索开始  搜索的关键字 : " + keyword);
            keywodSearch(page, 0);
        }
        // 单个歌曲详情
        else if (page.getUrl().regex(contentMatch).match()) {
            logger.debug("网易云 - 开始爬取 单个歌曲详情 歌曲地址: " + page.getUrl());
            singMusic(page);
        } else {
            logger.debug("网易云 - 开始爬取 歌曲列表 地址 - " + page.getUrl());
            // 歌手列表页面
            page.addTargetRequests(page.getHtml().xpath("//*[@id=\"song-list-pre-cache\"]").xpath("div/ul/li/a").links().all());
        }
        logger.debug("网易云 - " + page.getUrl() + " 爬取结束...");
    }

    /**
     * 单个歌曲处理
     *
     * @param page
     */
    private void singMusic(Page page) {
        RequestModel model = new RequestModel();
        model.setLimit(100);
        model.setTotal(false);
        model.setOffset(0);
        // 歌曲的url
        String url = page.getUrl().toString();
        // 歌曲编号
        String musicId = url.substring(url.indexOf("id=") + 3);
        String zuozhe = page.getHtml().xpath("//*span/a[@class=s-fc7]/text()").get();
        String album = page.getHtml().xpath("//*p/a[@class=s-fc7]/text()").get();
        String musicName = page.getHtml().xpath("//*div/em[@class=f-ff2]/text()").get();
        JSONObject jsonObject = JSON.parseObject(crawlAjaxUrl(musicId, model));
        // 获取歌曲的评论总数
        Integer total = jsonObject.getInteger("total");
        // 每条100条
        int start = 0;
        int pageSize = 100;
        // 当总数大于1W时 , 开始划分成两组
        if (total > maxReadComment) {
            pageSize = total / pageSize;
        }

        List<WyyComment> commentListTest = new ArrayList<WyyComment>();

        for (int c = start; c < pageSize; c++) {

            // 当页数大于100时,则将起始值初始到倒数100页
            if (pageSize > model.getLimit() && c == (model.getLimit() + 1)) {
                c = pageSize - model.getLimit();
            }

            model.setOffset(c * 100);
            jsonObject = JSON.parseObject(crawlAjaxUrl(musicId, model));
            JSONArray hotComments = jsonObject.getJSONArray("hotComments");
            JSONArray comments = jsonObject.getJSONArray("comments");

            CommentVO vo = new CommentVO();
            List<WyyHotComment> hotCommentList = new ArrayList<WyyHotComment>();
            List<WyyUser> userList = new ArrayList<WyyUser>();
            List<WyyComment> commentList = new ArrayList<WyyComment>();
            // 热评
            if (hotComments != null) {
                for (int i = 0; i < hotComments.size(); i++) {
                    JSONObject hotComments1 = hotComments.getJSONObject(i);
                    insertHotComment(hotComments1, musicId, url, hotCommentList, userList);
                }
            }
            if (comments != null) {
                // 评论
                for (int i = 0; i < comments.size(); i++) {
                    JSONObject commentsObject = comments.getJSONObject(i);
                    insertComment(commentsObject, musicId, url, commentList, userList);
                }
            }
            vo.setHotComment(hotCommentList);
            vo.setUser(userList);
            vo.setComments(commentList);

            WyyMusic music = new WyyMusic();
            music.setComment_count(total);
            music.setName(zuozhe);
            music.setMusic_Album(album);
            music.setMusic_name(musicName);
            music.setTime(new Date());
            music.setMusic_url(url);
            music.setMusic_id(Integer.valueOf(musicId));
            if (c == 0) {
                vo.setMusic(music);
            }
            commentListTest.addAll(commentList);
            try {
                crawlerService.insertData(vo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关键字查询处理
     *
     * @param page   页面处理类
     * @param offset 起始值 - 递归入参
     */
    private void keywodSearch(Page page, int offset) {
        int defaultSize = 30;
        KeywordModel keywordModel = new KeywordModel();
        keywordModel.setS(keyword);
        keywordModel.setLimit(defaultSize);
        keywordModel.setOffset(offset);
        //默认歌曲
        keywordModel.setType("1");
        String s = crawlSearchUrl(keywordModel);
        JSONObject jsonObject = JSON.parseObject(s);
        JSONObject result = jsonObject.getJSONObject("result");
        Integer songCount = result.getInteger("songCount");
        JSONArray songs = result.getJSONArray("songs");
        List<String> urlList = new ArrayList<>();
        for (int i = 0; i < songs.size(); i++) {
            JSONObject song = songs.getJSONObject(i);
            Integer id = song.getInteger("id");
            String url = "http://music.163.com/song?id=" + id;
            System.out.println("u - " + url);
            urlList.add(url);
        }
        int nextOffset = keywordModel.getOffset() + defaultSize;
        page.addTargetRequests(urlList);
        if (nextOffset < songCount) {
            keywodSearch(page, nextOffset);
        } else {
            // 关键字查询完毕,清空,交给爬虫去爬地址页面
            keyword = null;
        }
    }

    /**
     * 添加热评
     *
     * @param hotComments1
     * @param musicId
     * @param url
     * @param hotCommentList
     * @param userList
     */
    private void insertHotComment(JSONObject hotComments1, String musicId, String url, List<WyyHotComment> hotCommentList, List<WyyUser> userList) {
        WyyHotComment hotComment = new WyyHotComment();
        // 评论
        String content = hotComments1.getString("content");
        // 点赞总数
        int likedCount = hotComments1.getInteger("likedCount");
        // 评论时间
        Date time = hotComments1.getDate("time");
        // 评论编号
        Integer id = hotComments1.getInteger("commentId");
        String liked = hotComments1.getString("liked");
        hotComment.setContent(content);
        hotComment.setLike_count(likedCount);
        hotComment.setComment_time(time);
        hotComment.setComment_id(id);
        hotComment.setLiked(liked);
        hotComment.setMusic_id(Integer.valueOf(musicId));
        hotComment.setMusic_url(url);
        // 用户信息
        JSONObject user = hotComments1.getJSONObject("user");
        // 用户编号
        int userid = user.getInteger("userId");
        hotComment.setUser_id(userid);
        hotCommentList.add(hotComment);
        insertUser(hotComments1, userList);
    }

    /**
     * 添加普通评论
     *
     * @param hotComments1
     * @param musicId
     * @param url
     * @param commentList
     * @param userList
     */
    private void insertComment(JSONObject hotComments1, String musicId, String url, List<WyyComment> commentList, List<WyyUser> userList) {
        WyyComment hotComment = new WyyComment();
        // 评论
        String content = hotComments1.getString("content");

        // 筛选评论
        if (!CommentUtils.commentFilter(content)) {
            return;
        }


        // 点赞总数
        int likedCount = hotComments1.getInteger("likedCount");
        // 评论时间
        Date time = hotComments1.getDate("time");
        // 评论编号
        Integer id = hotComments1.getInteger("commentId");
        String liked = hotComments1.getString("liked");
        hotComment.setContent(content);
        hotComment.setLike_count(likedCount);
        hotComment.setComment_time(time);
        hotComment.setComment_id(id);
        hotComment.setLiked(liked);
        hotComment.setMusic_id(Integer.valueOf(musicId));
        hotComment.setMusic_url(url);
        // 用户信息
        JSONObject user = hotComments1.getJSONObject("user");
        // 用户编号
        int userid = user.getInteger("userId");
        hotComment.setUser_id(userid);
        commentList.add(hotComment);
        insertUser(hotComments1, userList);
    }

    /**
     * 添加用户
     *
     * @param hotComments1
     * @param userList
     */
    private void insertUser(JSONObject hotComments1, List<WyyUser> userList) {
        WyyUser wyyUser = new WyyUser();
        // 用户信息
        JSONObject user = hotComments1.getJSONObject("user");
        // 用户编号
        int userid = user.getInteger("userId");
        wyyUser.setUserid(userid);
        // 是否是vip
        Integer vipType = user.getInteger("vipType");
        wyyUser.setVip_type(vipType);
        // 用户名称
        String nickname = user.getString("nickname");
        wyyUser.setNike_name(nickname);
        //用户主页
        String userUrl = "http://music.163.com/user/home?id=" + userid;
        String avatarUrl = user.getString("avatarUrl");
        String remarkName = user.getString("remarkName");
        String expertTags = user.getString("expertTags");
        Integer userType = user.getInteger("userType");
        wyyUser.setUser_url(userUrl);
        wyyUser.setCreate_date(new Date());
        wyyUser.setRemark_name(remarkName);
        wyyUser.setExpert_tags(expertTags);
        wyyUser.setUser_type(userType);
        wyyUser.setHead_url(avatarUrl);
        userList.add(wyyUser);
    }

    /**
     * @return
     */
    public Site getSite() {
        if (site == null) {
            //http://music.163.com/discover/toplist  -- 排行榜
            site = Site.me().setDomain("163.com").addStartUrl(url)
                    .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");
        }
        return site;
    }


    //对AJAX数据进行单独请求
    public static String crawlAjaxUrl(String songId, RequestModel requestModel) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;

        try {
            //参数加密
            String text = JSON.toJSONString(requestModel);
            System.out.println("请求参数:" + text);
            Map<String, String> encrypt = WangYiYunEncryptUtils.encrypt(text);
            HttpPost httpPost = new HttpPost("http://music.163.com/weapi/v1/resource/comments/R_SO_4_" + songId + "/?csrf_token=");
            httpPost.addHeader("Referer", BASE_URL);

            List<NameValuePair> ls = new ArrayList<NameValuePair>();
            ls.add(new BasicNameValuePair("params", encrypt.get("params").toString()));
            ls.add(new BasicNameValuePair("encSecKey", encrypt.get("encSecKey").toString()));

            UrlEncodedFormEntity paramEntity = new UrlEncodedFormEntity(ls, "utf-8");
            httpPost.setEntity(paramEntity);

            response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                return EntityUtils.toString(entity, "utf-8");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "";
    }


    /**
     * 关键字搜索查询
     *
     * @param requestModel
     * @return
     */
    public static String crawlSearchUrl(KeywordModel requestModel) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;

        try {
            //参数加密
            String text = JSON.toJSONString(requestModel);
            System.out.println("请求参数 : " + text);
            Map<String, String> encrypt = WangYiYunEncryptUtils.encrypt(text);
            HttpPost httpPost = new HttpPost("http://music.163.com/weapi/cloudsearch/get/web?csrf_token=");

            List<NameValuePair> ls = new ArrayList<NameValuePair>();
            ls.add(new BasicNameValuePair("params", encrypt.get("params").toString()));
            ls.add(new BasicNameValuePair("encSecKey", encrypt.get("encSecKey").toString()));
            UrlEncodedFormEntity paramEntity = new UrlEncodedFormEntity(ls, "utf-8");
            httpPost.setEntity(paramEntity);

            response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                return EntityUtils.toString(entity, "utf-8");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "";
    }

    public static void main(String[] args) {
//        IWangYiYunService wangYiYunService = new WangYiYunServiceImpl();
//        RequestTaskModel model = new RequestTaskModel();
//        model.setUrl("http://music.163.com/#/search/m/?%23%2F404=&s=%E5%8F%AF%E6%83%9C&type=1");
//        Spider.create(new WangYiYunProcessor(null,null,null)).thread(5).run();
//        int count = 66823 - 559 - 1;
//        RequestModel req = new RequestModel();
//        req.setLimit(20);
//        req.setOffset(0 * 20);
//        req.setTotal(false);
//        String s = crawlAjaxUrl("418603077", req);
//        System.out.println(s);
//        JSONObject jsonObject = JSON.parseObject(s);
//        System.out.println(s);
//        String s = crawlSearchUrl();
//        JSONObject jsonObject = JSON.parseObject(s);
//        System.out.println("sss");
//        System.out.println(s);
//        JSONObject jsonObject = JSON.parseObject(text);
//        System.out.println(jsonObject.toJSONString());
//        String text = "{\"rid\":\"R_SO_4_186016\",\"offset\":\"40\",\"total\":\"false\",\"limit\":\"20\",\"csrf_token\":\"\"}";
//        String s = crawlAjaxUrl("186016", null);
//        System.out.println(s);
    }
}
