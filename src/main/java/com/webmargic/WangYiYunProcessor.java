package com.webmargic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.model.WyyComment;
import com.model.WyyHotComment;
import com.model.WyyMusic;
import com.model.WyyUser;
import com.service.IWangYiYunService;
import com.webmargic.utils.WangYiYunEncryptUtils;
import com.webmargic.vo.CommentVO;
import com.webmargic.vo.RequestModel;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Liukx
 * @create 2017-03-29 17:54
 * @email liukx@elab-plus.com
 **/
public class WangYiYunProcessor implements PageProcessor {

    private IWangYiYunService wangYiYunService;


    public WangYiYunProcessor(IWangYiYunService wangYiYunService) {
        this.wangYiYunService = wangYiYunService;
    }

    private Site site;

    private String contentMatch = "http://music.163.com/song\\?id=\\d+";

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
        if (page.getUrl().regex(contentMatch).match()) {
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
            Integer total = jsonObject.getInteger("total");
            Integer totalCount = total ;
            for (int c = 0; c < 100 + 1; c++) {
                model.setOffset(c * 100);
                jsonObject = JSON.parseObject(crawlAjaxUrl(musicId, model));
                JSONArray hotComments = jsonObject.getJSONArray("hotComments");
                JSONArray comments = jsonObject.getJSONArray("comments");
                CommentVO vo = new CommentVO();
                List<WyyHotComment> hotCommentList = new ArrayList<WyyHotComment>();
                List<WyyUser> userList = new ArrayList<WyyUser>();
                List<WyyComment> commentList = new ArrayList<WyyComment>();


                // 热评
                if(hotComments != null) {
                    for (int i = 0; i < hotComments.size(); i++) {
                        JSONObject hotComments1 = hotComments.getJSONObject(i);
                        insertHotComment(hotComments1, musicId, url, hotCommentList, userList);
                    }
                }
                if(comments != null) {
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
                if(c == 0) {
                    vo.setMusic(music);
                }
                wangYiYunService.insertMusic(vo);
            }
        } else {
            System.out.println("没有匹配");
            page.addTargetRequests(page.getHtml().xpath("//*[@id=\"song-list-pre-cache\"]").xpath("div/ul/li/a").links().all());
        }
    }

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

    private void insertComment(JSONObject hotComments1, String musicId, String url, List<WyyComment> commentList, List<WyyUser> userList) {
        WyyComment hotComment = new WyyComment();
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
        commentList.add(hotComment);
        insertUser(hotComments1, userList);
    }

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
            site = Site.me().setDomain("163.com").addStartUrl("http://music.163.com/artist?id=6452")
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
            String secKey = new BigInteger(100, new SecureRandom()).toString(32).substring(0, 16);
            String text = JSON.toJSONString(requestModel);
            System.out.println("请求参数:" + text);
            Map<String, String> encrypt = WangYiYunEncryptUtils.encrypt(text);
//            System.out.println("加密时间:"+encrypt);
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

    public static void main(String[] args) {
//        IWangYiYunService wangYiYunService = new WangYiYunServiceImpl();
//        Spider.create(new WangYiYunProcessor()).thread(5).run();
        int count = 66823 - 559 -1;
        RequestModel req = new RequestModel();
        req.setLimit(20);
        req.setOffset(count*20);
        req.setTotal(false);
        String s = crawlAjaxUrl("186016",req);
        JSONObject jsonObject = JSON.parseObject(s);
        System.out.println(s);

//   TtrnVsXpngdFQpkSwHJLG8Wq8wJ5YmAlndHmzP2PsFhxF9G7oUxOWUns821mSjnKK58VF3RUxl1D
    }
}
