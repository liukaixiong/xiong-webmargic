package com.model.tt;

import com.model.common.SearchModel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TtComment extends SearchModel {
    // 主键
    // 表字段 : tt_comment.id
    private Integer id;

    // 点赞总数
    // 表字段 : tt_comment.like_count
    private Integer likeCount;

    // 评论内容
    // 表字段 : tt_comment.text
    private String text;

    // 创建时间
    // 表字段 : tt_comment.created_time
    private Date createdTime;

    // 用户编号
    // 表字段 : tt_comment.user_id
    private String userId;

    // 用户昵称
    // 表字段 : tt_comment.username
    private String username;

    // 评论编号
    // 表字段 : tt_comment.comment_id
    private String commentId;

    // 标题编号
    // 表字段 : tt_comment.topic_id
    private String topicId;

    // 评论的标题
    // 表字段 : tt_comment.title
    private String title;

    // 系统创建时间
    // 表字段 : tt_comment.system_time
    private Date systemTime;

    private String fmtCreatedTime;

    private String fmtSystemTime;

    private String likeMin;

    private String likeMax;

    public String getLikeMin() {
        return likeMin;
    }

    public void setLikeMin(String likeMin) {
        this.likeMin = likeMin;
    }

    public String getLikeMax() {
        return likeMax;
    }

    public void setLikeMax(String likeMax) {
        this.likeMax = likeMax;
    }

    public String getFmtCreatedTime() {
        if (createdTime != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return simpleDateFormat.format(createdTime);
        }
        return fmtCreatedTime;
    }

    public void setFmtCreatedTime(String fmtCreatedTime) {
        this.fmtCreatedTime = fmtCreatedTime;
    }

    public String getFmtSystemTime() {
        if (systemTime != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return simpleDateFormat.format(systemTime);
        }
        return fmtSystemTime;
    }

    public void setFmtSystemTime(String fmtSystemTime) {
        this.fmtSystemTime = fmtSystemTime;
    }

    /**
     * 描述 ： 主键
     * 对应数据库： ->  tt_comment.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * 描述 ： 主键
     * 对应数据库： ->  tt_comment.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 描述 ： 点赞总数
     * 对应数据库： ->  tt_comment.like_count
     *
     * @mbg.generated
     */
    public Integer getLikeCount() {
        return likeCount;
    }

    /**
     * 描述 ： 点赞总数
     * 对应数据库： ->  tt_comment.like_count
     *
     * @mbg.generated
     */
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * 描述 ： 评论内容
     * 对应数据库： ->  tt_comment.text
     *
     * @mbg.generated
     */
    public String getText() {
        return text;
    }

    /**
     * 描述 ： 评论内容
     * 对应数据库： ->  tt_comment.text
     *
     * @mbg.generated
     */
    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    /**
     * 描述 ： 创建时间
     * 对应数据库： ->  tt_comment.created_time
     *
     * @mbg.generated
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 描述 ： 创建时间
     * 对应数据库： ->  tt_comment.created_time
     *
     * @mbg.generated
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 描述 ： 用户编号
     * 对应数据库： ->  tt_comment.user_id
     *
     * @mbg.generated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 描述 ： 用户编号
     * 对应数据库： ->  tt_comment.user_id
     *
     * @mbg.generated
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 描述 ： 用户昵称
     * 对应数据库： ->  tt_comment.username
     *
     * @mbg.generated
     */
    public String getUsername() {
        return username;
    }

    /**
     * 描述 ： 用户昵称
     * 对应数据库： ->  tt_comment.username
     *
     * @mbg.generated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 描述 ： 评论编号
     * 对应数据库： ->  tt_comment.comment_id
     *
     * @mbg.generated
     */
    public String getCommentId() {
        return commentId;
    }

    /**
     * 描述 ： 评论编号
     * 对应数据库： ->  tt_comment.comment_id
     *
     * @mbg.generated
     */
    public void setCommentId(String commentId) {
        this.commentId = commentId == null ? null : commentId.trim();
    }

    /**
     * 描述 ： 标题编号
     * 对应数据库： ->  tt_comment.topic_id
     *
     * @mbg.generated
     */
    public String getTopicId() {
        return topicId;
    }

    /**
     * 描述 ： 标题编号
     * 对应数据库： ->  tt_comment.topic_id
     *
     * @mbg.generated
     */
    public void setTopicId(String topicId) {
        this.topicId = topicId == null ? null : topicId.trim();
    }

    /**
     * 描述 ： 评论的标题
     * 对应数据库： ->  tt_comment.title
     *
     * @mbg.generated
     */
    public String getTitle() {
        return title;
    }

    /**
     * 描述 ： 评论的标题
     * 对应数据库： ->  tt_comment.title
     *
     * @mbg.generated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 描述 ： 系统创建时间
     * 对应数据库： ->  tt_comment.system_time
     *
     * @mbg.generated
     */
    public Date getSystemTime() {
        return systemTime;
    }

    /**
     * 描述 ： 系统创建时间
     * 对应数据库： ->  tt_comment.system_time
     *
     * @mbg.generated
     */
    public void setSystemTime(Date systemTime) {
        this.systemTime = systemTime;
    }
}