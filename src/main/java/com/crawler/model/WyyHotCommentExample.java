package com.crawler.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WyyHotCommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WyyHotCommentExample() {
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

        public Criteria andMusic_idIsNull() {
            addCriterion("music_id is null");
            return (Criteria) this;
        }

        public Criteria andMusic_idIsNotNull() {
            addCriterion("music_id is not null");
            return (Criteria) this;
        }

        public Criteria andMusic_idEqualTo(Integer value) {
            addCriterion("music_id =", value, "music_id");
            return (Criteria) this;
        }

        public Criteria andMusic_idNotEqualTo(Integer value) {
            addCriterion("music_id <>", value, "music_id");
            return (Criteria) this;
        }

        public Criteria andMusic_idGreaterThan(Integer value) {
            addCriterion("music_id >", value, "music_id");
            return (Criteria) this;
        }

        public Criteria andMusic_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("music_id >=", value, "music_id");
            return (Criteria) this;
        }

        public Criteria andMusic_idLessThan(Integer value) {
            addCriterion("music_id <", value, "music_id");
            return (Criteria) this;
        }

        public Criteria andMusic_idLessThanOrEqualTo(Integer value) {
            addCriterion("music_id <=", value, "music_id");
            return (Criteria) this;
        }

        public Criteria andMusic_idIn(List<Integer> values) {
            addCriterion("music_id in", values, "music_id");
            return (Criteria) this;
        }

        public Criteria andMusic_idNotIn(List<Integer> values) {
            addCriterion("music_id not in", values, "music_id");
            return (Criteria) this;
        }

        public Criteria andMusic_idBetween(Integer value1, Integer value2) {
            addCriterion("music_id between", value1, value2, "music_id");
            return (Criteria) this;
        }

        public Criteria andMusic_idNotBetween(Integer value1, Integer value2) {
            addCriterion("music_id not between", value1, value2, "music_id");
            return (Criteria) this;
        }

        public Criteria andMusic_urlIsNull() {
            addCriterion("music_url is null");
            return (Criteria) this;
        }

        public Criteria andMusic_urlIsNotNull() {
            addCriterion("music_url is not null");
            return (Criteria) this;
        }

        public Criteria andMusic_urlEqualTo(String value) {
            addCriterion("music_url =", value, "music_url");
            return (Criteria) this;
        }

        public Criteria andMusic_urlNotEqualTo(String value) {
            addCriterion("music_url <>", value, "music_url");
            return (Criteria) this;
        }

        public Criteria andMusic_urlGreaterThan(String value) {
            addCriterion("music_url >", value, "music_url");
            return (Criteria) this;
        }

        public Criteria andMusic_urlGreaterThanOrEqualTo(String value) {
            addCriterion("music_url >=", value, "music_url");
            return (Criteria) this;
        }

        public Criteria andMusic_urlLessThan(String value) {
            addCriterion("music_url <", value, "music_url");
            return (Criteria) this;
        }

        public Criteria andMusic_urlLessThanOrEqualTo(String value) {
            addCriterion("music_url <=", value, "music_url");
            return (Criteria) this;
        }

        public Criteria andMusic_urlLike(String value) {
            addCriterion("music_url like", value, "music_url");
            return (Criteria) this;
        }

        public Criteria andMusic_urlNotLike(String value) {
            addCriterion("music_url not like", value, "music_url");
            return (Criteria) this;
        }

        public Criteria andMusic_urlIn(List<String> values) {
            addCriterion("music_url in", values, "music_url");
            return (Criteria) this;
        }

        public Criteria andMusic_urlNotIn(List<String> values) {
            addCriterion("music_url not in", values, "music_url");
            return (Criteria) this;
        }

        public Criteria andMusic_urlBetween(String value1, String value2) {
            addCriterion("music_url between", value1, value2, "music_url");
            return (Criteria) this;
        }

        public Criteria andMusic_urlNotBetween(String value1, String value2) {
            addCriterion("music_url not between", value1, value2, "music_url");
            return (Criteria) this;
        }

        public Criteria andComment_idIsNull() {
            addCriterion("comment_id is null");
            return (Criteria) this;
        }

        public Criteria andComment_idIsNotNull() {
            addCriterion("comment_id is not null");
            return (Criteria) this;
        }

        public Criteria andComment_idEqualTo(Integer value) {
            addCriterion("comment_id =", value, "comment_id");
            return (Criteria) this;
        }

        public Criteria andComment_idNotEqualTo(Integer value) {
            addCriterion("comment_id <>", value, "comment_id");
            return (Criteria) this;
        }

        public Criteria andComment_idGreaterThan(Integer value) {
            addCriterion("comment_id >", value, "comment_id");
            return (Criteria) this;
        }

        public Criteria andComment_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_id >=", value, "comment_id");
            return (Criteria) this;
        }

        public Criteria andComment_idLessThan(Integer value) {
            addCriterion("comment_id <", value, "comment_id");
            return (Criteria) this;
        }

        public Criteria andComment_idLessThanOrEqualTo(Integer value) {
            addCriterion("comment_id <=", value, "comment_id");
            return (Criteria) this;
        }

        public Criteria andComment_idIn(List<Integer> values) {
            addCriterion("comment_id in", values, "comment_id");
            return (Criteria) this;
        }

        public Criteria andComment_idNotIn(List<Integer> values) {
            addCriterion("comment_id not in", values, "comment_id");
            return (Criteria) this;
        }

        public Criteria andComment_idBetween(Integer value1, Integer value2) {
            addCriterion("comment_id between", value1, value2, "comment_id");
            return (Criteria) this;
        }

        public Criteria andComment_idNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_id not between", value1, value2, "comment_id");
            return (Criteria) this;
        }

        public Criteria andUser_idIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUser_idIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUser_idEqualTo(Integer value) {
            addCriterion("user_id =", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThan(Integer value) {
            addCriterion("user_id >", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThan(Integer value) {
            addCriterion("user_id <", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idIn(List<Integer> values) {
            addCriterion("user_id in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andLike_countIsNull() {
            addCriterion("like_count is null");
            return (Criteria) this;
        }

        public Criteria andLike_countIsNotNull() {
            addCriterion("like_count is not null");
            return (Criteria) this;
        }

        public Criteria andLike_countEqualTo(Integer value) {
            addCriterion("like_count =", value, "like_count");
            return (Criteria) this;
        }

        public Criteria andLike_countNotEqualTo(Integer value) {
            addCriterion("like_count <>", value, "like_count");
            return (Criteria) this;
        }

        public Criteria andLike_countGreaterThan(Integer value) {
            addCriterion("like_count >", value, "like_count");
            return (Criteria) this;
        }

        public Criteria andLike_countGreaterThanOrEqualTo(Integer value) {
            addCriterion("like_count >=", value, "like_count");
            return (Criteria) this;
        }

        public Criteria andLike_countLessThan(Integer value) {
            addCriterion("like_count <", value, "like_count");
            return (Criteria) this;
        }

        public Criteria andLike_countLessThanOrEqualTo(Integer value) {
            addCriterion("like_count <=", value, "like_count");
            return (Criteria) this;
        }

        public Criteria andLike_countIn(List<Integer> values) {
            addCriterion("like_count in", values, "like_count");
            return (Criteria) this;
        }

        public Criteria andLike_countNotIn(List<Integer> values) {
            addCriterion("like_count not in", values, "like_count");
            return (Criteria) this;
        }

        public Criteria andLike_countBetween(Integer value1, Integer value2) {
            addCriterion("like_count between", value1, value2, "like_count");
            return (Criteria) this;
        }

        public Criteria andLike_countNotBetween(Integer value1, Integer value2) {
            addCriterion("like_count not between", value1, value2, "like_count");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andComment_timeIsNull() {
            addCriterion("comment_time is null");
            return (Criteria) this;
        }

        public Criteria andComment_timeIsNotNull() {
            addCriterion("comment_time is not null");
            return (Criteria) this;
        }

        public Criteria andComment_timeEqualTo(Date value) {
            addCriterion("comment_time =", value, "comment_time");
            return (Criteria) this;
        }

        public Criteria andComment_timeNotEqualTo(Date value) {
            addCriterion("comment_time <>", value, "comment_time");
            return (Criteria) this;
        }

        public Criteria andComment_timeGreaterThan(Date value) {
            addCriterion("comment_time >", value, "comment_time");
            return (Criteria) this;
        }

        public Criteria andComment_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("comment_time >=", value, "comment_time");
            return (Criteria) this;
        }

        public Criteria andComment_timeLessThan(Date value) {
            addCriterion("comment_time <", value, "comment_time");
            return (Criteria) this;
        }

        public Criteria andComment_timeLessThanOrEqualTo(Date value) {
            addCriterion("comment_time <=", value, "comment_time");
            return (Criteria) this;
        }

        public Criteria andComment_timeIn(List<Date> values) {
            addCriterion("comment_time in", values, "comment_time");
            return (Criteria) this;
        }

        public Criteria andComment_timeNotIn(List<Date> values) {
            addCriterion("comment_time not in", values, "comment_time");
            return (Criteria) this;
        }

        public Criteria andComment_timeBetween(Date value1, Date value2) {
            addCriterion("comment_time between", value1, value2, "comment_time");
            return (Criteria) this;
        }

        public Criteria andComment_timeNotBetween(Date value1, Date value2) {
            addCriterion("comment_time not between", value1, value2, "comment_time");
            return (Criteria) this;
        }

        public Criteria andLikedIsNull() {
            addCriterion("liked is null");
            return (Criteria) this;
        }

        public Criteria andLikedIsNotNull() {
            addCriterion("liked is not null");
            return (Criteria) this;
        }

        public Criteria andLikedEqualTo(String value) {
            addCriterion("liked =", value, "liked");
            return (Criteria) this;
        }

        public Criteria andLikedNotEqualTo(String value) {
            addCriterion("liked <>", value, "liked");
            return (Criteria) this;
        }

        public Criteria andLikedGreaterThan(String value) {
            addCriterion("liked >", value, "liked");
            return (Criteria) this;
        }

        public Criteria andLikedGreaterThanOrEqualTo(String value) {
            addCriterion("liked >=", value, "liked");
            return (Criteria) this;
        }

        public Criteria andLikedLessThan(String value) {
            addCriterion("liked <", value, "liked");
            return (Criteria) this;
        }

        public Criteria andLikedLessThanOrEqualTo(String value) {
            addCriterion("liked <=", value, "liked");
            return (Criteria) this;
        }

        public Criteria andLikedLike(String value) {
            addCriterion("liked like", value, "liked");
            return (Criteria) this;
        }

        public Criteria andLikedNotLike(String value) {
            addCriterion("liked not like", value, "liked");
            return (Criteria) this;
        }

        public Criteria andLikedIn(List<String> values) {
            addCriterion("liked in", values, "liked");
            return (Criteria) this;
        }

        public Criteria andLikedNotIn(List<String> values) {
            addCriterion("liked not in", values, "liked");
            return (Criteria) this;
        }

        public Criteria andLikedBetween(String value1, String value2) {
            addCriterion("liked between", value1, value2, "liked");
            return (Criteria) this;
        }

        public Criteria andLikedNotBetween(String value1, String value2) {
            addCriterion("liked not between", value1, value2, "liked");
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