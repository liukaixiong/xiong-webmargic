package com.model.zh;

public class ZhAnswerCommentsKey {
     // 
     // 表字段 : zh_answer_comments.id
    private Integer id;

     // 
     // 表字段 : zh_answer_comments.comments_id
    private Integer commentsId;

    /**
     * 描述 ： 
     * 对应数据库： ->  zh_answer_comments.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  zh_answer_comments.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  zh_answer_comments.comments_id
     *
     * @mbg.generated
     */
    public Integer getCommentsId() {
        return commentsId;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  zh_answer_comments.comments_id
     *
     * @mbg.generated
     */
    public void setCommentsId(Integer commentsId) {
        this.commentsId = commentsId;
    }
}