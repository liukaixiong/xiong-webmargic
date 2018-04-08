package com.crawler.model.zh;

public class ZhAnswerKey {
     // 
     // 表字段 : zh_answer.id
    private Integer id;

     // 答题编号
     // 表字段 : zh_answer.answer_id
    private Integer answerId;

    /**
     * 描述 ： 
     * 对应数据库： ->  zh_answer.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  zh_answer.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 描述 ： 答题编号
     * 对应数据库： ->  zh_answer.answer_id
     *
     * @mbg.generated
     */
    public Integer getAnswerId() {
        return answerId;
    }

    /**
     * 描述 ： 答题编号
     * 对应数据库： ->  zh_answer.answer_id
     *
     * @mbg.generated
     */
    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }
}