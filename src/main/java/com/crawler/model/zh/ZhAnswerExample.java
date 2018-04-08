package com.crawler.model.zh;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZhAnswerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZhAnswerExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAnswerIdIsNull() {
            addCriterion("answer_id is null");
            return (Criteria) this;
        }

        public Criteria andAnswerIdIsNotNull() {
            addCriterion("answer_id is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerIdEqualTo(Integer value) {
            addCriterion("answer_id =", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdNotEqualTo(Integer value) {
            addCriterion("answer_id <>", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdGreaterThan(Integer value) {
            addCriterion("answer_id >", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("answer_id >=", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdLessThan(Integer value) {
            addCriterion("answer_id <", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdLessThanOrEqualTo(Integer value) {
            addCriterion("answer_id <=", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdIn(List<Integer> values) {
            addCriterion("answer_id in", values, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdNotIn(List<Integer> values) {
            addCriterion("answer_id not in", values, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdBetween(Integer value1, Integer value2) {
            addCriterion("answer_id between", value1, value2, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("answer_id not between", value1, value2, "answerId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdIsNull() {
            addCriterion("question_id is null");
            return (Criteria) this;
        }

        public Criteria andQuestionIdIsNotNull() {
            addCriterion("question_id is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionIdEqualTo(Integer value) {
            addCriterion("question_id =", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotEqualTo(Integer value) {
            addCriterion("question_id <>", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdGreaterThan(Integer value) {
            addCriterion("question_id >", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("question_id >=", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdLessThan(Integer value) {
            addCriterion("question_id <", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdLessThanOrEqualTo(Integer value) {
            addCriterion("question_id <=", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdIn(List<Integer> values) {
            addCriterion("question_id in", values, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotIn(List<Integer> values) {
            addCriterion("question_id not in", values, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdBetween(Integer value1, Integer value2) {
            addCriterion("question_id between", value1, value2, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("question_id not between", value1, value2, "questionId");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andVoteupCountIsNull() {
            addCriterion("voteup_count is null");
            return (Criteria) this;
        }

        public Criteria andVoteupCountIsNotNull() {
            addCriterion("voteup_count is not null");
            return (Criteria) this;
        }

        public Criteria andVoteupCountEqualTo(Integer value) {
            addCriterion("voteup_count =", value, "voteupCount");
            return (Criteria) this;
        }

        public Criteria andVoteupCountNotEqualTo(Integer value) {
            addCriterion("voteup_count <>", value, "voteupCount");
            return (Criteria) this;
        }

        public Criteria andVoteupCountGreaterThan(Integer value) {
            addCriterion("voteup_count >", value, "voteupCount");
            return (Criteria) this;
        }

        public Criteria andVoteupCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("voteup_count >=", value, "voteupCount");
            return (Criteria) this;
        }

        public Criteria andVoteupCountLessThan(Integer value) {
            addCriterion("voteup_count <", value, "voteupCount");
            return (Criteria) this;
        }

        public Criteria andVoteupCountLessThanOrEqualTo(Integer value) {
            addCriterion("voteup_count <=", value, "voteupCount");
            return (Criteria) this;
        }

        public Criteria andVoteupCountIn(List<Integer> values) {
            addCriterion("voteup_count in", values, "voteupCount");
            return (Criteria) this;
        }

        public Criteria andVoteupCountNotIn(List<Integer> values) {
            addCriterion("voteup_count not in", values, "voteupCount");
            return (Criteria) this;
        }

        public Criteria andVoteupCountBetween(Integer value1, Integer value2) {
            addCriterion("voteup_count between", value1, value2, "voteupCount");
            return (Criteria) this;
        }

        public Criteria andVoteupCountNotBetween(Integer value1, Integer value2) {
            addCriterion("voteup_count not between", value1, value2, "voteupCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountIsNull() {
            addCriterion("comment_count is null");
            return (Criteria) this;
        }

        public Criteria andCommentCountIsNotNull() {
            addCriterion("comment_count is not null");
            return (Criteria) this;
        }

        public Criteria andCommentCountEqualTo(Integer value) {
            addCriterion("comment_count =", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotEqualTo(Integer value) {
            addCriterion("comment_count <>", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountGreaterThan(Integer value) {
            addCriterion("comment_count >", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_count >=", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountLessThan(Integer value) {
            addCriterion("comment_count <", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountLessThanOrEqualTo(Integer value) {
            addCriterion("comment_count <=", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountIn(List<Integer> values) {
            addCriterion("comment_count in", values, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotIn(List<Integer> values) {
            addCriterion("comment_count not in", values, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountBetween(Integer value1, Integer value2) {
            addCriterion("comment_count between", value1, value2, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_count not between", value1, value2, "commentCount");
            return (Criteria) this;
        }

        public Criteria andExcerptIsNull() {
            addCriterion("excerpt is null");
            return (Criteria) this;
        }

        public Criteria andExcerptIsNotNull() {
            addCriterion("excerpt is not null");
            return (Criteria) this;
        }

        public Criteria andExcerptEqualTo(String value) {
            addCriterion("excerpt =", value, "excerpt");
            return (Criteria) this;
        }

        public Criteria andExcerptNotEqualTo(String value) {
            addCriterion("excerpt <>", value, "excerpt");
            return (Criteria) this;
        }

        public Criteria andExcerptGreaterThan(String value) {
            addCriterion("excerpt >", value, "excerpt");
            return (Criteria) this;
        }

        public Criteria andExcerptGreaterThanOrEqualTo(String value) {
            addCriterion("excerpt >=", value, "excerpt");
            return (Criteria) this;
        }

        public Criteria andExcerptLessThan(String value) {
            addCriterion("excerpt <", value, "excerpt");
            return (Criteria) this;
        }

        public Criteria andExcerptLessThanOrEqualTo(String value) {
            addCriterion("excerpt <=", value, "excerpt");
            return (Criteria) this;
        }

        public Criteria andExcerptLike(String value) {
            addCriterion("excerpt like", value, "excerpt");
            return (Criteria) this;
        }

        public Criteria andExcerptNotLike(String value) {
            addCriterion("excerpt not like", value, "excerpt");
            return (Criteria) this;
        }

        public Criteria andExcerptIn(List<String> values) {
            addCriterion("excerpt in", values, "excerpt");
            return (Criteria) this;
        }

        public Criteria andExcerptNotIn(List<String> values) {
            addCriterion("excerpt not in", values, "excerpt");
            return (Criteria) this;
        }

        public Criteria andExcerptBetween(String value1, String value2) {
            addCriterion("excerpt between", value1, value2, "excerpt");
            return (Criteria) this;
        }

        public Criteria andExcerptNotBetween(String value1, String value2) {
            addCriterion("excerpt not between", value1, value2, "excerpt");
            return (Criteria) this;
        }

        public Criteria andIsCopyableIsNull() {
            addCriterion("is_copyable is null");
            return (Criteria) this;
        }

        public Criteria andIsCopyableIsNotNull() {
            addCriterion("is_copyable is not null");
            return (Criteria) this;
        }

        public Criteria andIsCopyableEqualTo(String value) {
            addCriterion("is_copyable =", value, "isCopyable");
            return (Criteria) this;
        }

        public Criteria andIsCopyableNotEqualTo(String value) {
            addCriterion("is_copyable <>", value, "isCopyable");
            return (Criteria) this;
        }

        public Criteria andIsCopyableGreaterThan(String value) {
            addCriterion("is_copyable >", value, "isCopyable");
            return (Criteria) this;
        }

        public Criteria andIsCopyableGreaterThanOrEqualTo(String value) {
            addCriterion("is_copyable >=", value, "isCopyable");
            return (Criteria) this;
        }

        public Criteria andIsCopyableLessThan(String value) {
            addCriterion("is_copyable <", value, "isCopyable");
            return (Criteria) this;
        }

        public Criteria andIsCopyableLessThanOrEqualTo(String value) {
            addCriterion("is_copyable <=", value, "isCopyable");
            return (Criteria) this;
        }

        public Criteria andIsCopyableLike(String value) {
            addCriterion("is_copyable like", value, "isCopyable");
            return (Criteria) this;
        }

        public Criteria andIsCopyableNotLike(String value) {
            addCriterion("is_copyable not like", value, "isCopyable");
            return (Criteria) this;
        }

        public Criteria andIsCopyableIn(List<String> values) {
            addCriterion("is_copyable in", values, "isCopyable");
            return (Criteria) this;
        }

        public Criteria andIsCopyableNotIn(List<String> values) {
            addCriterion("is_copyable not in", values, "isCopyable");
            return (Criteria) this;
        }

        public Criteria andIsCopyableBetween(String value1, String value2) {
            addCriterion("is_copyable between", value1, value2, "isCopyable");
            return (Criteria) this;
        }

        public Criteria andIsCopyableNotBetween(String value1, String value2) {
            addCriterion("is_copyable not between", value1, value2, "isCopyable");
            return (Criteria) this;
        }

        public Criteria andThanksCountIsNull() {
            addCriterion("thanks_count is null");
            return (Criteria) this;
        }

        public Criteria andThanksCountIsNotNull() {
            addCriterion("thanks_count is not null");
            return (Criteria) this;
        }

        public Criteria andThanksCountEqualTo(Integer value) {
            addCriterion("thanks_count =", value, "thanksCount");
            return (Criteria) this;
        }

        public Criteria andThanksCountNotEqualTo(Integer value) {
            addCriterion("thanks_count <>", value, "thanksCount");
            return (Criteria) this;
        }

        public Criteria andThanksCountGreaterThan(Integer value) {
            addCriterion("thanks_count >", value, "thanksCount");
            return (Criteria) this;
        }

        public Criteria andThanksCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("thanks_count >=", value, "thanksCount");
            return (Criteria) this;
        }

        public Criteria andThanksCountLessThan(Integer value) {
            addCriterion("thanks_count <", value, "thanksCount");
            return (Criteria) this;
        }

        public Criteria andThanksCountLessThanOrEqualTo(Integer value) {
            addCriterion("thanks_count <=", value, "thanksCount");
            return (Criteria) this;
        }

        public Criteria andThanksCountIn(List<Integer> values) {
            addCriterion("thanks_count in", values, "thanksCount");
            return (Criteria) this;
        }

        public Criteria andThanksCountNotIn(List<Integer> values) {
            addCriterion("thanks_count not in", values, "thanksCount");
            return (Criteria) this;
        }

        public Criteria andThanksCountBetween(Integer value1, Integer value2) {
            addCriterion("thanks_count between", value1, value2, "thanksCount");
            return (Criteria) this;
        }

        public Criteria andThanksCountNotBetween(Integer value1, Integer value2) {
            addCriterion("thanks_count not between", value1, value2, "thanksCount");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNull() {
            addCriterion("updated_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNotNull() {
            addCriterion("updated_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeEqualTo(Date value) {
            addCriterion("updated_time =", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotEqualTo(Date value) {
            addCriterion("updated_time <>", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThan(Date value) {
            addCriterion("updated_time >", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_time >=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThan(Date value) {
            addCriterion("updated_time <", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("updated_time <=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIn(List<Date> values) {
            addCriterion("updated_time in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotIn(List<Date> values) {
            addCriterion("updated_time not in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeBetween(Date value1, Date value2) {
            addCriterion("updated_time between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("updated_time not between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andSystemTimeIsNull() {
            addCriterion("system_time is null");
            return (Criteria) this;
        }

        public Criteria andSystemTimeIsNotNull() {
            addCriterion("system_time is not null");
            return (Criteria) this;
        }

        public Criteria andSystemTimeEqualTo(Date value) {
            addCriterion("system_time =", value, "systemTime");
            return (Criteria) this;
        }

        public Criteria andSystemTimeNotEqualTo(Date value) {
            addCriterion("system_time <>", value, "systemTime");
            return (Criteria) this;
        }

        public Criteria andSystemTimeGreaterThan(Date value) {
            addCriterion("system_time >", value, "systemTime");
            return (Criteria) this;
        }

        public Criteria andSystemTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("system_time >=", value, "systemTime");
            return (Criteria) this;
        }

        public Criteria andSystemTimeLessThan(Date value) {
            addCriterion("system_time <", value, "systemTime");
            return (Criteria) this;
        }

        public Criteria andSystemTimeLessThanOrEqualTo(Date value) {
            addCriterion("system_time <=", value, "systemTime");
            return (Criteria) this;
        }

        public Criteria andSystemTimeIn(List<Date> values) {
            addCriterion("system_time in", values, "systemTime");
            return (Criteria) this;
        }

        public Criteria andSystemTimeNotIn(List<Date> values) {
            addCriterion("system_time not in", values, "systemTime");
            return (Criteria) this;
        }

        public Criteria andSystemTimeBetween(Date value1, Date value2) {
            addCriterion("system_time between", value1, value2, "systemTime");
            return (Criteria) this;
        }

        public Criteria andSystemTimeNotBetween(Date value1, Date value2) {
            addCriterion("system_time not between", value1, value2, "systemTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}