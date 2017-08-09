package com.model.wb;

import java.util.Date;

public class WbTopic {
    //
    // 表字段 : wb_topic.id
    private Integer id;

    // 用户编号
    // 表字段 : wb_topic.user_no
    private String userNo;

    // 用户昵称
    // 表字段 : wb_topic.username
    private String username;

    // 用户主页
    // 表字段 : wb_topic.home_page
    private String homePage;

    // 话题编号
    // 表字段 : wb_topic.topic_id
    private String topicId;

    // 转发总数
    // 表字段 : wb_topic.forward_count
    private Integer forwardCount;

    // 评论总数
    // 表字段 : wb_topic.comments_count
    private Integer commentsCount;

    // 点赞总数
    // 表字段 : wb_topic.like_count
    private Integer likeCount;

    // 创建时间
    // 表字段 : wb_topic.created
    private String created;

    // 系统生成时间
    // 表字段 : wb_topic.system_time
    private Date systemTime;

    // 内容
    // 表字段 : wb_topic.content
    private String content;

    /**
     * 描述 ：
     * 对应数据库： ->  wb_topic.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * 描述 ：
     * 对应数据库： ->  wb_topic.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 描述 ： 用户编号
     * 对应数据库： ->  wb_topic.user_no
     *
     * @mbg.generated
     */
    public String getUserNo() {
        return userNo;
    }

    /**
     * 描述 ： 用户编号
     * 对应数据库： ->  wb_topic.user_no
     *
     * @mbg.generated
     */
    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    /**
     * 描述 ： 用户昵称
     * 对应数据库： ->  wb_topic.username
     *
     * @mbg.generated
     */
    public String getUsername() {
        return username;
    }

    /**
     * 描述 ： 用户昵称
     * 对应数据库： ->  wb_topic.username
     *
     * @mbg.generated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 描述 ： 用户主页
     * 对应数据库： ->  wb_topic.home_page
     *
     * @mbg.generated
     */
    public String getHomePage() {
        return homePage;
    }

    /**
     * 描述 ： 用户主页
     * 对应数据库： ->  wb_topic.home_page
     *
     * @mbg.generated
     */
    public void setHomePage(String homePage) {
        this.homePage = homePage == null ? null : homePage.trim();
    }

    /**
     * 描述 ： 话题编号
     * 对应数据库： ->  wb_topic.topic_id
     *
     * @mbg.generated
     */
    public String getTopicId() {
        return topicId;
    }

    /**
     * 描述 ： 话题编号
     * 对应数据库： ->  wb_topic.topic_id
     *
     * @mbg.generated
     */
    public void setTopicId(String topicId) {
        this.topicId = topicId == null ? null : topicId.trim();
    }

    /**
     * 描述 ： 转发总数
     * 对应数据库： ->  wb_topic.forward_count
     *
     * @mbg.generated
     */
    public Integer getForwardCount() {
        return forwardCount;
    }

    /**
     * 描述 ： 转发总数
     * 对应数据库： ->  wb_topic.forward_count
     *
     * @mbg.generated
     */
    public void setForwardCount(Integer forwardCount) {
        this.forwardCount = forwardCount;
    }

    /**
     * 描述 ： 评论总数
     * 对应数据库： ->  wb_topic.comments_count
     *
     * @mbg.generated
     */
    public Integer getCommentsCount() {
        return commentsCount;
    }

    /**
     * 描述 ： 评论总数
     * 对应数据库： ->  wb_topic.comments_count
     *
     * @mbg.generated
     */
    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

    /**
     * 描述 ： 点赞总数
     * 对应数据库： ->  wb_topic.like_count
     *
     * @mbg.generated
     */
    public Integer getLikeCount() {
        return likeCount;
    }

    /**
     * 描述 ： 点赞总数
     * 对应数据库： ->  wb_topic.like_count
     *
     * @mbg.generated
     */
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * 描述 ： 创建时间
     * 对应数据库： ->  wb_topic.created
     *
     * @mbg.generated
     */
    public String getCreated() {
        return created;
    }

    /**
     * 描述 ： 创建时间
     * 对应数据库： ->  wb_topic.created
     *
     * @mbg.generated
     */
    public void setCreated(String created) {
        this.created = created == null ? null : created.trim();
    }

    /**
     * 描述 ： 系统生成时间
     * 对应数据库： ->  wb_topic.system_time
     *
     * @mbg.generated
     */
    public Date getSystemTime() {
        return systemTime;
    }

    /**
     * 描述 ： 系统生成时间
     * 对应数据库： ->  wb_topic.system_time
     *
     * @mbg.generated
     */
    public void setSystemTime(Date systemTime) {
        this.systemTime = systemTime;
    }

    /**
     * 描述 ： 内容
     * 对应数据库： ->  wb_topic.content
     *
     * @mbg.generated
     */
    public String getContent() {
        return content;
    }

    /**
     * 描述 ： 内容
     * 对应数据库： ->  wb_topic.content
     *
     * @mbg.generated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}