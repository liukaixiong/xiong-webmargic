package com.crawler.model.wb;

import java.util.Date;

public class WbReply {
     // 
     // 表字段 : wb_reply.id
    private Integer id;

     // 
     // 表字段 : wb_reply.user_id
    private String userId;

     // 用户昵称
     // 表字段 : wb_reply.username
    private String username;

     // 
     // 表字段 : wb_reply.home_page
    private String homePage;

     // 
     // 表字段 : wb_reply.topic_id
    private String topicId;

     // 
     // 表字段 : wb_reply.comments_id
    private String commentsId;

     // 
     // 表字段 : wb_reply.reply_id
    private String replyId;

     // 回复评论信息
     // 表字段 : wb_reply.reply_text
    private String replyText;

     // 
     // 表字段 : wb_reply.like_count
    private Integer likeCount;

     // 用户昵称
     // 表字段 : wb_reply.created
    private String created;

     // 
     // 表字段 : wb_reply.system_time
    private Date systemTime;

     // 
     // 表字段 : wb_reply.content
    private String content;

    /**
     * 描述 ： 
     * 对应数据库： ->  wb_reply.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  wb_reply.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  wb_reply.user_id
     *
     * @mbg.generated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  wb_reply.user_id
     *
     * @mbg.generated
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 描述 ： 用户昵称
     * 对应数据库： ->  wb_reply.username
     *
     * @mbg.generated
     */
    public String getUsername() {
        return username;
    }

    /**
     * 描述 ： 用户昵称
     * 对应数据库： ->  wb_reply.username
     *
     * @mbg.generated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  wb_reply.home_page
     *
     * @mbg.generated
     */
    public String getHomePage() {
        return homePage;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  wb_reply.home_page
     *
     * @mbg.generated
     */
    public void setHomePage(String homePage) {
        this.homePage = homePage == null ? null : homePage.trim();
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  wb_reply.topic_id
     *
     * @mbg.generated
     */
    public String getTopicId() {
        return topicId;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  wb_reply.topic_id
     *
     * @mbg.generated
     */
    public void setTopicId(String topicId) {
        this.topicId = topicId == null ? null : topicId.trim();
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  wb_reply.comments_id
     *
     * @mbg.generated
     */
    public String getCommentsId() {
        return commentsId;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  wb_reply.comments_id
     *
     * @mbg.generated
     */
    public void setCommentsId(String commentsId) {
        this.commentsId = commentsId == null ? null : commentsId.trim();
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  wb_reply.reply_id
     *
     * @mbg.generated
     */
    public String getReplyId() {
        return replyId;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  wb_reply.reply_id
     *
     * @mbg.generated
     */
    public void setReplyId(String replyId) {
        this.replyId = replyId == null ? null : replyId.trim();
    }

    /**
     * 描述 ： 回复评论信息
     * 对应数据库： ->  wb_reply.reply_text
     *
     * @mbg.generated
     */
    public String getReplyText() {
        return replyText;
    }

    /**
     * 描述 ： 回复评论信息
     * 对应数据库： ->  wb_reply.reply_text
     *
     * @mbg.generated
     */
    public void setReplyText(String replyText) {
        this.replyText = replyText == null ? null : replyText.trim();
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  wb_reply.like_count
     *
     * @mbg.generated
     */
    public Integer getLikeCount() {
        return likeCount;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  wb_reply.like_count
     *
     * @mbg.generated
     */
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * 描述 ： 用户昵称
     * 对应数据库： ->  wb_reply.created
     *
     * @mbg.generated
     */
    public String getCreated() {
        return created;
    }

    /**
     * 描述 ： 用户昵称
     * 对应数据库： ->  wb_reply.created
     *
     * @mbg.generated
     */
    public void setCreated(String created) {
        this.created = created == null ? null : created.trim();
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  wb_reply.system_time
     *
     * @mbg.generated
     */
    public Date getSystemTime() {
        return systemTime;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  wb_reply.system_time
     *
     * @mbg.generated
     */
    public void setSystemTime(Date systemTime) {
        this.systemTime = systemTime;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  wb_reply.content
     *
     * @mbg.generated
     */
    public String getContent() {
        return content;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  wb_reply.content
     *
     * @mbg.generated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}