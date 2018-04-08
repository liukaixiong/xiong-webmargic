package com.crawler.model.zh;

public class ZhQuestionKey {
     // 
     // 表字段 : zh_question.id
    private Integer id;

     // 问题编号
     // 表字段 : zh_question.question_id
    private Integer questionId;

    /**
     * 描述 ： 
     * 对应数据库： ->  zh_question.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  zh_question.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 描述 ： 问题编号
     * 对应数据库： ->  zh_question.question_id
     *
     * @mbg.generated
     */
    public Integer getQuestionId() {
        return questionId;
    }

    /**
     * 描述 ： 问题编号
     * 对应数据库： ->  zh_question.question_id
     *
     * @mbg.generated
     */
    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }
}