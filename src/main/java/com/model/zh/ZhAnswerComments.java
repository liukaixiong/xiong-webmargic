package com.model.zh;

import java.util.Date;

public class ZhAnswerComments extends ZhAnswerCommentsKey {
     // 用户编号
     // 表字段 : zh_answer_comments.user_id
    private String userId;

     // 点赞数
     // 表字段 : zh_answer_comments.vote_count
    private Integer voteCount;

     // 评论编号
     // 表字段 : zh_answer_comments.answer_id
    private Integer answerId;

     // 创建时间
     // 表字段 : zh_answer_comments.created_time
    private Date createdTime;

     // 系统时间
     // 表字段 : zh_answer_comments.system_time
    private Date systemTime;

     // 内容
     // 表字段 : zh_answer_comments.content
    private String content;

    /**
     * 描述 ： 用户编号
     * 对应数据库： ->  zh_answer_comments.user_id
     *
     * @mbg.generated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 描述 ： 用户编号
     * 对应数据库： ->  zh_answer_comments.user_id
     *
     * @mbg.generated
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 描述 ： 点赞数
     * 对应数据库： ->  zh_answer_comments.vote_count
     *
     * @mbg.generated
     */
    public Integer getVoteCount() {
        return voteCount;
    }

    /**
     * 描述 ： 点赞数
     * 对应数据库： ->  zh_answer_comments.vote_count
     *
     * @mbg.generated
     */
    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    /**
     * 描述 ： 评论编号
     * 对应数据库： ->  zh_answer_comments.answer_id
     *
     * @mbg.generated
     */
    public Integer getAnswerId() {
        return answerId;
    }

    /**
     * 描述 ： 评论编号
     * 对应数据库： ->  zh_answer_comments.answer_id
     *
     * @mbg.generated
     */
    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    /**
     * 描述 ： 创建时间
     * 对应数据库： ->  zh_answer_comments.created_time
     *
     * @mbg.generated
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 描述 ： 创建时间
     * 对应数据库： ->  zh_answer_comments.created_time
     *
     * @mbg.generated
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 描述 ： 系统时间
     * 对应数据库： ->  zh_answer_comments.system_time
     *
     * @mbg.generated
     */
    public Date getSystemTime() {
        return systemTime;
    }

    /**
     * 描述 ： 系统时间
     * 对应数据库： ->  zh_answer_comments.system_time
     *
     * @mbg.generated
     */
    public void setSystemTime(Date systemTime) {
        this.systemTime = systemTime;
    }

    /**
     * 描述 ： 内容
     * 对应数据库： ->  zh_answer_comments.content
     *
     * @mbg.generated
     */
    public String getContent() {
        return content;
    }

    /**
     * 描述 ： 内容
     * 对应数据库： ->  zh_answer_comments.content
     *
     * @mbg.generated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}