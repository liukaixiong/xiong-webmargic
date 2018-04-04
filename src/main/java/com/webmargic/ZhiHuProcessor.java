package com.webmargic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.model.common.RequestTaskModel;
import com.model.zh.*;
import com.service.ZhiHuService;
import com.webmargic.utils.CommentUtils;
import com.webmargic.utils.HttpClientUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 知乎网站
 *
 * @author Liukx
 * @create 2017-03-29 17:54
 * @email liukx@elab-plus.com
 **/
public class ZhiHuProcessor implements PageProcessor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Site site;

    // 接口调用需要返回的认证token
    private String authorization = "oauth c3cef7c66a1843f8b3a9e6a1e3160e20";

    private String contentMatch = "https://www.zhihu.com/question/\\d+";

    private String base_url = "zhihu.com";

    private AtomicInteger count = new AtomicInteger();

    //主域名
    public String BASE_Node_URL = "https://www.zhihu.com";

    private String keyword;

    private ZhiHuService zhiHuService;

    public ZhiHuProcessor(ZhiHuService zhiHuService, RequestTaskModel search) {
        this.keyword = search.getKeyword();
        if (StringUtils.isNotBlank(search.getUrl())) {
            this.BASE_Node_URL = search.getUrl();
        }
        this.zhiHuService = zhiHuService;
    }

    /**
     * 具体要执行的抓去内容处理
     *
     * @param page
     */
    public void process(Page page) {
        if (page.getUrl().regex(contentMatch).match()) {
            // 知乎单个提问详情
            String url = page.getUrl().get();
            String id = url.substring(url.lastIndexOf("/") + 1, url.length());
            if (id.indexOf("?") > 0) {
                id = id.substring(0, id.indexOf("?"));
            }
            System.out.println("抓取地址 -> " + url);
            // ajax 获取对应的答题参数
            ZhRequestModel requestModel = new ZhRequestModel();
            // 问题本身详情
            sendHttpURLSub(requestModel, "https://www.zhihu.com/api/v4/questions/" + id + "/answers?include=data%5B*%5D.is_normal%2Cis_sticky%2Ccollapsed_by%2Csuggest_edit%2Ccomment_count%2Ccan_comment%2Ccontent%2Ceditable_content%2Cvoteup_count%2Creshipment_settings%2Ccomment_permission%2Cmark_infos%2Ccreated_time%2Cupdated_time%2Crelationship.is_authorized%2Cis_author%2Cvoting%2Cis_thanked%2Cis_nothelp%2Cupvoted_followees%3Bdata%5B*%5D.author.is_blocking%2Cis_blocked%2Cis_followed%2Cvoteup_count%2Cmessage_thread_token%2Cbadge%5B%3F(type%3Dbest_answerer)%5D.topics&sort_by=default", 0, 20);
            getQuestionsInfo(requestModel, page, id);
            zhiHuService.insertData(requestModel);
        } else {
            // 知乎大厅
            sendHttpURLParent("https://www.zhihu.com/r/search?q=" + keyword + "&sort=upvote&type=content", page);
        }
    }

    /**
     * 获取知乎大厅里面的列表内容
     *
     * @param url  抓取的url内容
     * @param page 页面内容
     */
    public void sendHttpURLParent(String url, Page page) {
        Map header = new HashMap();
        header.put("authorization", authorization);
        String result = HttpClientUtil.doGetHeader(url, header);
        JSONObject resultObject = JSON.parseObject(result);
        JSONArray htmlsList = resultObject.getJSONArray("htmls");
        for (int i = 0; i < htmlsList.size(); i++) {
            String htmlString = htmlsList.getString(i);
            String title = new Html(htmlString).xpath("/html/body/li/div/a/html()").get().replaceAll("<em>", "").replaceAll("</em>", "");
            String links = new Html(htmlString).xpath("/html/body/li/div/a").links().get();
            page.addTargetRequest(BASE_Node_URL + links);
//            System.out.println(count.incrementAndGet()+"--------->" + title);
        }
        JSONObject paging = resultObject.getJSONObject("paging");
        if (paging != null && StringUtils.isNotBlank(paging.getString("next"))) {
            String nextURL = "https://www.zhihu.com/" + paging.getString("next");
            sendHttpURLParent(nextURL, page);
        }

    }

    /**
     * 获取提问者本身详情
     *
     * @param page 页面内容
     */
    private void getQuestionsInfo(ZhRequestModel requestModel, Page page, String id) {
        ZhQuestion question = requestModel.getQuestion();
        // 同时抓去问题的相关内容
        String url = page.getUrl().get();
//        String id = url.substring(url.lastIndexOf("/") + 1, url.length());

        //关注者
        String guanzhuzhe = page.getHtml().xpath("//*[@id=\"root\"]/div/main/div/div[1]/div[2]/").xpath("div[1]").xpath("/div/div/div/div/div[2]/text()").get();
        //被浏览数
        String liulanshu = page.getHtml().xpath("//*[@id=\"root\"]/div/main/div/div[1]/div[2]/div[1]/div[2]/div/div/div/div[3]/div[2]/text()").get();
        // 标题
        String title = page.getHtml().xpath("//*[@id=\"root\"]/div/main/div/div[1]/div[2]/div[1]/div[1]/h1/text()").get();
        if (StringUtils.isEmpty(title)) {
            title = page.getHtml().xpath("//*[@id=\"root\"]/div/main/div/div[1]/div/div/div/h1/text()").get();
        }
        // 问题内容
        String wentiContent = page.getHtml().xpath("//*[@id=\"root\"]/div/main/div/div[1]/div[2]/div[1]/div[1]/div[2]/div/div/span/text()").get();
        if (StringUtils.isEmpty(wentiContent)) {
            wentiContent = page.getHtml().xpath("//*[@id=\"root\"]/div/main/div/div/div/div/div/div/div/div/div/span/text()").get();
        }
        // 问题分类标签
        List<Selectable> tagsNode = page.getHtml().xpath("//*[@id=\"root\"]/div/main/div/div[1]/div[2]/div[1]/div[1]/div[1]/div").xpath("/div/span").xpath("/span/a/div/div/text()").nodes();
        StringBuffer tagString = new StringBuffer();
        for (int i = 0; i < tagsNode.toArray().length; i++) {
            tagString.append(tagsNode.toArray()[i] + " ");
        }
        question.setQuestionId(Integer.valueOf(id));
        question.setFollowCount(guanzhuzhe == null ? 0 : Integer.valueOf(guanzhuzhe));
        question.setBrowseCount(liulanshu == null ? 0 : Integer.valueOf(liulanshu));
        question.setTitle(title);
        question.setRemark(wentiContent);
        question.setTag(tagString.toString());
        question.setUrl(url);
        question.setSystemTime(new Date());
    }


    /**
     * 获取知乎问题列表中的回答详情内容
     *
     * @param url    地址
     * @param offset 起始值
     * @param limit  每页大小
     */
    public void sendHttpURLSub(ZhRequestModel zhRequestModel, String url, int offset, int limit) {
        int size = 20;
        Map header = new HashMap();
        header.put("authorization", authorization);
        String urlText = url;
        urlText = urlText + "&offset=" + offset + "&limit=" + limit;
        logger.info(" 知乎 发送查询回答详情内容 地址:" + urlText);
        String result = HttpClientUtil.doGetHeader(urlText, header);
        JSONObject resultObject = JSON.parseObject(result);
        JSONObject paging = resultObject.getJSONObject("paging");
        JSONArray dataArrays = resultObject.getJSONArray("data");
        Integer total = paging.getInteger("totals");
        logger.info(" 获取的数据大小 : " + total);
        zhRequestModel.getQuestion().setTotal(total);
        for (int i = 0; i < dataArrays.size(); i++) {
            JSONObject dataObject = dataArrays.getJSONObject(i);
            setAnswer(zhRequestModel, dataObject);
        }
        Integer totals = paging.getInteger("totals");
        if (totals > offset) {
            sendHttpURLSub(zhRequestModel, url, offset + size, size);
        }
    }

    /**
     * 请求评论数
     *
     * @param zhRequestModel
     * @param id
     * @param offset
     */
    public void saveComments(ZhRequestModel zhRequestModel, Integer id, int offset) {
        int limit = 500;
        Map header = new HashMap();
        header.put("authorization", authorization);
        String urlText = "https://www.zhihu.com/api/v4/answers/" + id + "/comments?include=data%5B*%5D.author%2Ccollapsed%2Creply_to_author%2Cdisliked%2Ccontent%2Cvoting%2Cvote_count%2Cis_parent_author%2Cis_author&order=normal&limit=" + limit + "&status=open";
        urlText = urlText + "&offset=" + offset;
        String result = HttpClientUtil.doGetHeader(urlText, header);
        JSONObject resultObject = JSON.parseObject(result);
        JSONObject paging = resultObject.getJSONObject("paging");
        JSONArray dataArrays = resultObject.getJSONArray("data");
        ////////////////////添加评论/////////////////////////
        for (int i = 0; i < dataArrays.size(); i++) {
            JSONObject dataObject = dataArrays.getJSONObject(i);
            JSONObject userInfo = dataObject.getJSONObject("author");
            JSONObject member = userInfo.getJSONObject("member");
            String userId = member.getString("id");
            //添加评论
            insertComments(zhRequestModel, dataObject, id, userId);

        }
        Integer totals = paging.getInteger("totals");
        if (totals > offset) {
            saveComments(zhRequestModel, id, offset + limit);
        }
    }

    /**
     * 添加用户
     *
     * @param zhRequestModel
     * @param jsonObject
     */
    private void insertUser(ZhRequestModel zhRequestModel, JSONObject jsonObject) {
        String id = jsonObject.getString("id");
        String name = jsonObject.getString("name");
        //过滤匿名用户
        if ("0".equals(id) || "知乎用户".equals(name)) {
            return;
        }

        String avatar_url_template = jsonObject.getString("avatar_url_template");

        String headline = jsonObject.getString("headline");
        Integer gender = jsonObject.getInteger("gender");
        String avatar_url = jsonObject.getString("avatar_url");
        String type = jsonObject.getString("type");
        String is_org = jsonObject.getString("is_org");
        String url_token = jsonObject.getString("url_token");
        String is_following = jsonObject.getString("is_following");
        String is_followed = jsonObject.getString("is_followed");
        String userType = jsonObject.getString("user_type");

        ZhUser user = new ZhUser();
        user.setUserId(id);
        user.setAvatarUrlTemplate(avatar_url_template);
        user.setName(name);
        user.setHeadline(headline);
        user.setGender(gender);
        user.setAvatarUrl(avatar_url);
        user.setType(type);
        user.setIsOrg(is_org);
        user.setUrlToken(url_token);
        user.setIsFollowed(is_followed);
        user.setIsFollowing(is_following);
        user.setUserType(userType);
        user.setSystemTime(new Date());
        zhRequestModel.getUserList().add(user);
    }

    /**
     * 添加评论结果
     *
     * @param zhRequestModel 结果对象
     * @param jsonObject
     * @param answerId
     * @param userId
     */
    private void insertComments(ZhRequestModel zhRequestModel, JSONObject jsonObject, Integer answerId, String userId) {
        // 评论编号
        Integer comment_id = jsonObject.getInteger("id");
        // 正文内容
        String content = jsonObject.getString("content");
        if (!CommentUtils.commentFilter(content)) {
            return;
        }

        // 点赞
        Integer vote_count = jsonObject.getInteger("vote_count");
        // 创建时间
        Date created_time = jsonObject.getDate("created_time");

        ZhAnswerComments comments = new ZhAnswerComments();
        comments.setCommentsId(comment_id);
        comments.setAnswerId(answerId);
        comments.setContent(content);
        comments.setVoteCount(vote_count);
        comments.setCreatedTime(created_time);
        comments.setUserId(userId);
        comments.setSystemTime(new Date());
        zhRequestModel.getCommentsList().add(comments);

        // 添加用户
        JSONObject userInfo = jsonObject.getJSONObject("author");
        JSONObject member = userInfo.getJSONObject("member");
        insertUser(zhRequestModel, member);
    }

    private void setAnswer(ZhRequestModel zhRequestModel, JSONObject dataObject) {
        ////////////////////////////答题详情//////////////////////////////
        Integer id = dataObject.getInteger("id");
        // 正文内容
        String editable_content = dataObject.getString("content");
        //摘录
        String excerpt = dataObject.getString("excerpt");
        // 点赞数
        Integer voteup_count = dataObject.getInteger("voteup_count");
        // 编辑时间
        Date updated_time = dataObject.getDate("updated_time");
        // 评论总数
        Integer comment_count = dataObject.getInteger("comment_count");
        // 感谢数
        Integer thanks_count = dataObject.getInteger("thanks_count");
        // 创建时间
        Date created_time = dataObject.getDate("created_time");
        // 问题编号
        Integer questionId = dataObject.getJSONObject("question").getInteger("id");
        // 回答者编号
        String answerUserId = dataObject.getJSONObject("author").getString("id");
        Date questionCreatedDate = dataObject.getJSONObject("question").getDate("created");
        Date questionUpdateDate = dataObject.getJSONObject("question").getDate("updated_time");
        String question_type = dataObject.getJSONObject("question").getString("question_type");
        String questionType = dataObject.getJSONObject("question").getString("type");
        // 问题字段补充
        ZhQuestion question = zhRequestModel.getQuestion();
        question.setCreated(questionCreatedDate);
        question.setUpdatetime(questionUpdateDate);
        question.setQuestionType(question_type);
        question.setType(questionType);


        String is_copyable = dataObject.getString("is_copyable");
        //////////////////添加用户////////////////////
        JSONObject author = dataObject.getJSONObject("author");
        insertUser(zhRequestModel, author);

        ///////////////////////答题封装/////////////////////////
        ZhAnswer answer = new ZhAnswer();
        answer.setAnswerId(id);
        answer.setQuestionId(questionId);
        answer.setContent(editable_content);
        answer.setVoteupCount(voteup_count);
        answer.setSystemTime(new Date());
        answer.setUserId(answerUserId);
        answer.setCommentCount(comment_count);
        answer.setCreatedTime(created_time);
        answer.setUpdatedTime(updated_time);
        answer.setThanksCount(thanks_count);
        answer.setExcerpt(excerpt);
        answer.setIsCopyable(is_copyable);
        zhRequestModel.getAnswerList().add(answer);
        ///////////////////////评论详情/////////////////////////
        if (comment_count > 0) {
            saveComments(zhRequestModel, id, 0);
        }
    }


    /**
     * @return
     */

    public Site getSite() {
        if (site == null) {
            //http://music.163.com/discover/toplist  -- 排行榜
            site = Site.me().setDomain(base_url).addStartUrl(BASE_Node_URL);
            //.setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");
        }
        return site;
    }


    public void test(String id) {
        ZhRequestModel requestModel = new ZhRequestModel();
        sendHttpURLSub(requestModel, "https://www.zhihu.com/api/v4/questions/" + id + "/answers?include=data%5B*%5D.is_normal%2Cis_sticky%2Ccollapsed_by%2Csuggest_edit%2Ccomment_count%2Ccan_comment%2Ccontent%2Ceditable_content%2Cvoteup_count%2Creshipment_settings%2Ccomment_permission%2Cmark_infos%2Ccreated_time%2Cupdated_time%2Crelationship.is_authorized%2Cis_author%2Cvoting%2Cis_thanked%2Cis_nothelp%2Cupvoted_followees%3Bdata%5B*%5D.author.is_blocking%2Cis_blocked%2Cis_followed%2Cvoteup_count%2Cmessage_thread_token%2Cbadge%5B%3F(type%3Dbest_answerer)%5D.topics&sort_by=default", 0, 20);
        // 问题本身详情
        //getQuestionsInfo(requestModel, page);
        System.out.println("数据封装成功~");
    }

    public static void main(String[] args) {
//        Spider.create(new ZhiHuProcessor("周杰伦")).thread(5).run();
//        saveComments("56584856",0);
//        ZhiHuProcessor zhiHuProcessor = new ZhiHuProcessor("周杰伦");
//        zhiHuProcessor.test("28048027");
    }
}
