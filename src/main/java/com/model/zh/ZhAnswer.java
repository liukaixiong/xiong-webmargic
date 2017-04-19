package com.model.zh;

import java.util.Date;

public class ZhAnswer extends ZhAnswerKey {
     // 问题编号
     // 表字段 : zh_answer.question_id
    private Integer questionId;

     // 标题
     // 表字段 : zh_answer.title
    private String title;

     // 用户编号
     // 表字段 : zh_answer.user_id
    private String userId;

     // 点赞数
     // 表字段 : zh_answer.voteup_count
    private Integer voteupCount;

     // 评论数
     // 表字段 : zh_answer.comment_count
    private Integer commentCount;

     // 摘录
     // 表字段 : zh_answer.excerpt
    private String excerpt;

     // 是否可复制
     // 表字段 : zh_answer.is_copyable
    private String isCopyable;

     // 感谢总数
     // 表字段 : zh_answer.thanks_count
    private Integer thanksCount;

     // 创建时间
     // 表字段 : zh_answer.created_time
    private Date createdTime;

     // 修改时间
     // 表字段 : zh_answer.updated_time
    private Date updatedTime;

     // 系统创建时间
     // 表字段 : zh_answer.system_time
    private Date systemTime;

     // 内容
     // 表字段 : zh_answer.content
    private String content;

    /**
     * 描述 ： 问题编号
     * 对应数据库： ->  zh_answer.question_id
     *
     * @mbg.generated
     */
    public Integer getQuestionId() {
        return questionId;
    }

    /**
     * 描述 ： 问题编号
     * 对应数据库： ->  zh_answer.question_id
     *
     * @mbg.generated
     */
    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    /**
     * 描述 ： 标题
     * 对应数据库： ->  zh_answer.title
     *
     * @mbg.generated
     */
    public String getTitle() {
        return title;
    }

    /**
     * 描述 ： 标题
     * 对应数据库： ->  zh_answer.title
     *
     * @mbg.generated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 描述 ： 用户编号
     * 对应数据库： ->  zh_answer.user_id
     *
     * @mbg.generated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 描述 ： 用户编号
     * 对应数据库： ->  zh_answer.user_id
     *
     * @mbg.generated
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 描述 ： 点赞数
     * 对应数据库： ->  zh_answer.voteup_count
     *
     * @mbg.generated
     */
    public Integer getVoteupCount() {
        return voteupCount;
    }

    /**
     * 描述 ： 点赞数
     * 对应数据库： ->  zh_answer.voteup_count
     *
     * @mbg.generated
     */
    public void setVoteupCount(Integer voteupCount) {
        this.voteupCount = voteupCount;
    }

    /**
     * 描述 ： 评论数
     * 对应数据库： ->  zh_answer.comment_count
     *
     * @mbg.generated
     */
    public Integer getCommentCount() {
        return commentCount;
    }

    /**
     * 描述 ： 评论数
     * 对应数据库： ->  zh_answer.comment_count
     *
     * @mbg.generated
     */
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * 描述 ： 摘录
     * 对应数据库： ->  zh_answer.excerpt
     *
     * @mbg.generated
     */
    public String getExcerpt() {
        return excerpt;
    }

    /**
     * 描述 ： 摘录
     * 对应数据库： ->  zh_answer.excerpt
     *
     * @mbg.generated
     */
    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt == null ? null : excerpt.trim();
    }

    /**
     * 描述 ： 是否可复制
     * 对应数据库： ->  zh_answer.is_copyable
     *
     * @mbg.generated
     */
    public String getIsCopyable() {
        return isCopyable;
    }

    /**
     * 描述 ： 是否可复制
     * 对应数据库： ->  zh_answer.is_copyable
     *
     * @mbg.generated
     */
    public void setIsCopyable(String isCopyable) {
        this.isCopyable = isCopyable == null ? null : isCopyable.trim();
    }

    /**
     * 描述 ： 感谢总数
     * 对应数据库： ->  zh_answer.thanks_count
     *
     * @mbg.generated
     */
    public Integer getThanksCount() {
        return thanksCount;
    }

    /**
     * 描述 ： 感谢总数
     * 对应数据库： ->  zh_answer.thanks_count
     *
     * @mbg.generated
     */
    public void setThanksCount(Integer thanksCount) {
        this.thanksCount = thanksCount;
    }

    /**
     * 描述 ： 创建时间
     * 对应数据库： ->  zh_answer.created_time
     *
     * @mbg.generated
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 描述 ： 创建时间
     * 对应数据库： ->  zh_answer.created_time
     *
     * @mbg.generated
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 描述 ： 修改时间
     * 对应数据库： ->  zh_answer.updated_time
     *
     * @mbg.generated
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 描述 ： 修改时间
     * 对应数据库： ->  zh_answer.updated_time
     *
     * @mbg.generated
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * 描述 ： 系统创建时间
     * 对应数据库： ->  zh_answer.system_time
     *
     * @mbg.generated
     */
    public Date getSystemTime() {
        return systemTime;
    }

    /**
     * 描述 ： 系统创建时间
     * 对应数据库： ->  zh_answer.system_time
     *
     * @mbg.generated
     */
    public void setSystemTime(Date systemTime) {
        this.systemTime = systemTime;
    }

    /**
     * 描述 ： 内容
     * 对应数据库： ->  zh_answer.content
     *
     * @mbg.generated
     */
    public String getContent() {
        return content;
    }

    /**
     * 描述 ： 内容
     * 对应数据库： ->  zh_answer.content
     *
     * @mbg.generated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}