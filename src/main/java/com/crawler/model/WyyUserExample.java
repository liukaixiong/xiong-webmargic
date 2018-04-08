package com.crawler.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WyyUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WyyUserExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andNike_nameIsNull() {
            addCriterion("nike_name is null");
            return (Criteria) this;
        }

        public Criteria andNike_nameIsNotNull() {
            addCriterion("nike_name is not null");
            return (Criteria) this;
        }

        public Criteria andNike_nameEqualTo(String value) {
            addCriterion("nike_name =", value, "nike_name");
            return (Criteria) this;
        }

        public Criteria andNike_nameNotEqualTo(String value) {
            addCriterion("nike_name <>", value, "nike_name");
            return (Criteria) this;
        }

        public Criteria andNike_nameGreaterThan(String value) {
            addCriterion("nike_name >", value, "nike_name");
            return (Criteria) this;
        }

        public Criteria andNike_nameGreaterThanOrEqualTo(String value) {
            addCriterion("nike_name >=", value, "nike_name");
            return (Criteria) this;
        }

        public Criteria andNike_nameLessThan(String value) {
            addCriterion("nike_name <", value, "nike_name");
            return (Criteria) this;
        }

        public Criteria andNike_nameLessThanOrEqualTo(String value) {
            addCriterion("nike_name <=", value, "nike_name");
            return (Criteria) this;
        }

        public Criteria andNike_nameLike(String value) {
            addCriterion("nike_name like", value, "nike_name");
            return (Criteria) this;
        }

        public Criteria andNike_nameNotLike(String value) {
            addCriterion("nike_name not like", value, "nike_name");
            return (Criteria) this;
        }

        public Criteria andNike_nameIn(List<String> values) {
            addCriterion("nike_name in", values, "nike_name");
            return (Criteria) this;
        }

        public Criteria andNike_nameNotIn(List<String> values) {
            addCriterion("nike_name not in", values, "nike_name");
            return (Criteria) this;
        }

        public Criteria andNike_nameBetween(String value1, String value2) {
            addCriterion("nike_name between", value1, value2, "nike_name");
            return (Criteria) this;
        }

        public Criteria andNike_nameNotBetween(String value1, String value2) {
            addCriterion("nike_name not between", value1, value2, "nike_name");
            return (Criteria) this;
        }

        public Criteria andUser_urlIsNull() {
            addCriterion("user_url is null");
            return (Criteria) this;
        }

        public Criteria andUser_urlIsNotNull() {
            addCriterion("user_url is not null");
            return (Criteria) this;
        }

        public Criteria andUser_urlEqualTo(String value) {
            addCriterion("user_url =", value, "user_url");
            return (Criteria) this;
        }

        public Criteria andUser_urlNotEqualTo(String value) {
            addCriterion("user_url <>", value, "user_url");
            return (Criteria) this;
        }

        public Criteria andUser_urlGreaterThan(String value) {
            addCriterion("user_url >", value, "user_url");
            return (Criteria) this;
        }

        public Criteria andUser_urlGreaterThanOrEqualTo(String value) {
            addCriterion("user_url >=", value, "user_url");
            return (Criteria) this;
        }

        public Criteria andUser_urlLessThan(String value) {
            addCriterion("user_url <", value, "user_url");
            return (Criteria) this;
        }

        public Criteria andUser_urlLessThanOrEqualTo(String value) {
            addCriterion("user_url <=", value, "user_url");
            return (Criteria) this;
        }

        public Criteria andUser_urlLike(String value) {
            addCriterion("user_url like", value, "user_url");
            return (Criteria) this;
        }

        public Criteria andUser_urlNotLike(String value) {
            addCriterion("user_url not like", value, "user_url");
            return (Criteria) this;
        }

        public Criteria andUser_urlIn(List<String> values) {
            addCriterion("user_url in", values, "user_url");
            return (Criteria) this;
        }

        public Criteria andUser_urlNotIn(List<String> values) {
            addCriterion("user_url not in", values, "user_url");
            return (Criteria) this;
        }

        public Criteria andUser_urlBetween(String value1, String value2) {
            addCriterion("user_url between", value1, value2, "user_url");
            return (Criteria) this;
        }

        public Criteria andUser_urlNotBetween(String value1, String value2) {
            addCriterion("user_url not between", value1, value2, "user_url");
            return (Criteria) this;
        }

        public Criteria andVip_typeIsNull() {
            addCriterion("vip_type is null");
            return (Criteria) this;
        }

        public Criteria andVip_typeIsNotNull() {
            addCriterion("vip_type is not null");
            return (Criteria) this;
        }

        public Criteria andVip_typeEqualTo(Integer value) {
            addCriterion("vip_type =", value, "vip_type");
            return (Criteria) this;
        }

        public Criteria andVip_typeNotEqualTo(Integer value) {
            addCriterion("vip_type <>", value, "vip_type");
            return (Criteria) this;
        }

        public Criteria andVip_typeGreaterThan(Integer value) {
            addCriterion("vip_type >", value, "vip_type");
            return (Criteria) this;
        }

        public Criteria andVip_typeGreaterThanOrEqualTo(Integer value) {
            addCriterion("vip_type >=", value, "vip_type");
            return (Criteria) this;
        }

        public Criteria andVip_typeLessThan(Integer value) {
            addCriterion("vip_type <", value, "vip_type");
            return (Criteria) this;
        }

        public Criteria andVip_typeLessThanOrEqualTo(Integer value) {
            addCriterion("vip_type <=", value, "vip_type");
            return (Criteria) this;
        }

        public Criteria andVip_typeIn(List<Integer> values) {
            addCriterion("vip_type in", values, "vip_type");
            return (Criteria) this;
        }

        public Criteria andVip_typeNotIn(List<Integer> values) {
            addCriterion("vip_type not in", values, "vip_type");
            return (Criteria) this;
        }

        public Criteria andVip_typeBetween(Integer value1, Integer value2) {
            addCriterion("vip_type between", value1, value2, "vip_type");
            return (Criteria) this;
        }

        public Criteria andVip_typeNotBetween(Integer value1, Integer value2) {
            addCriterion("vip_type not between", value1, value2, "vip_type");
            return (Criteria) this;
        }

        public Criteria andAuth_statusIsNull() {
            addCriterion("auth_status is null");
            return (Criteria) this;
        }

        public Criteria andAuth_statusIsNotNull() {
            addCriterion("auth_status is not null");
            return (Criteria) this;
        }

        public Criteria andAuth_statusEqualTo(Integer value) {
            addCriterion("auth_status =", value, "auth_status");
            return (Criteria) this;
        }

        public Criteria andAuth_statusNotEqualTo(Integer value) {
            addCriterion("auth_status <>", value, "auth_status");
            return (Criteria) this;
        }

        public Criteria andAuth_statusGreaterThan(Integer value) {
            addCriterion("auth_status >", value, "auth_status");
            return (Criteria) this;
        }

        public Criteria andAuth_statusGreaterThanOrEqualTo(Integer value) {
            addCriterion("auth_status >=", value, "auth_status");
            return (Criteria) this;
        }

        public Criteria andAuth_statusLessThan(Integer value) {
            addCriterion("auth_status <", value, "auth_status");
            return (Criteria) this;
        }

        public Criteria andAuth_statusLessThanOrEqualTo(Integer value) {
            addCriterion("auth_status <=", value, "auth_status");
            return (Criteria) this;
        }

        public Criteria andAuth_statusIn(List<Integer> values) {
            addCriterion("auth_status in", values, "auth_status");
            return (Criteria) this;
        }

        public Criteria andAuth_statusNotIn(List<Integer> values) {
            addCriterion("auth_status not in", values, "auth_status");
            return (Criteria) this;
        }

        public Criteria andAuth_statusBetween(Integer value1, Integer value2) {
            addCriterion("auth_status between", value1, value2, "auth_status");
            return (Criteria) this;
        }

        public Criteria andAuth_statusNotBetween(Integer value1, Integer value2) {
            addCriterion("auth_status not between", value1, value2, "auth_status");
            return (Criteria) this;
        }

        public Criteria andRemark_nameIsNull() {
            addCriterion("remark_name is null");
            return (Criteria) this;
        }

        public Criteria andRemark_nameIsNotNull() {
            addCriterion("remark_name is not null");
            return (Criteria) this;
        }

        public Criteria andRemark_nameEqualTo(String value) {
            addCriterion("remark_name =", value, "remark_name");
            return (Criteria) this;
        }

        public Criteria andRemark_nameNotEqualTo(String value) {
            addCriterion("remark_name <>", value, "remark_name");
            return (Criteria) this;
        }

        public Criteria andRemark_nameGreaterThan(String value) {
            addCriterion("remark_name >", value, "remark_name");
            return (Criteria) this;
        }

        public Criteria andRemark_nameGreaterThanOrEqualTo(String value) {
            addCriterion("remark_name >=", value, "remark_name");
            return (Criteria) this;
        }

        public Criteria andRemark_nameLessThan(String value) {
            addCriterion("remark_name <", value, "remark_name");
            return (Criteria) this;
        }

        public Criteria andRemark_nameLessThanOrEqualTo(String value) {
            addCriterion("remark_name <=", value, "remark_name");
            return (Criteria) this;
        }

        public Criteria andRemark_nameLike(String value) {
            addCriterion("remark_name like", value, "remark_name");
            return (Criteria) this;
        }

        public Criteria andRemark_nameNotLike(String value) {
            addCriterion("remark_name not like", value, "remark_name");
            return (Criteria) this;
        }

        public Criteria andRemark_nameIn(List<String> values) {
            addCriterion("remark_name in", values, "remark_name");
            return (Criteria) this;
        }

        public Criteria andRemark_nameNotIn(List<String> values) {
            addCriterion("remark_name not in", values, "remark_name");
            return (Criteria) this;
        }

        public Criteria andRemark_nameBetween(String value1, String value2) {
            addCriterion("remark_name between", value1, value2, "remark_name");
            return (Criteria) this;
        }

        public Criteria andRemark_nameNotBetween(String value1, String value2) {
            addCriterion("remark_name not between", value1, value2, "remark_name");
            return (Criteria) this;
        }

        public Criteria andExpert_tagsIsNull() {
            addCriterion("expert_tags is null");
            return (Criteria) this;
        }

        public Criteria andExpert_tagsIsNotNull() {
            addCriterion("expert_tags is not null");
            return (Criteria) this;
        }

        public Criteria andExpert_tagsEqualTo(String value) {
            addCriterion("expert_tags =", value, "expert_tags");
            return (Criteria) this;
        }

        public Criteria andExpert_tagsNotEqualTo(String value) {
            addCriterion("expert_tags <>", value, "expert_tags");
            return (Criteria) this;
        }

        public Criteria andExpert_tagsGreaterThan(String value) {
            addCriterion("expert_tags >", value, "expert_tags");
            return (Criteria) this;
        }

        public Criteria andExpert_tagsGreaterThanOrEqualTo(String value) {
            addCriterion("expert_tags >=", value, "expert_tags");
            return (Criteria) this;
        }

        public Criteria andExpert_tagsLessThan(String value) {
            addCriterion("expert_tags <", value, "expert_tags");
            return (Criteria) this;
        }

        public Criteria andExpert_tagsLessThanOrEqualTo(String value) {
            addCriterion("expert_tags <=", value, "expert_tags");
            return (Criteria) this;
        }

        public Criteria andExpert_tagsLike(String value) {
            addCriterion("expert_tags like", value, "expert_tags");
            return (Criteria) this;
        }

        public Criteria andExpert_tagsNotLike(String value) {
            addCriterion("expert_tags not like", value, "expert_tags");
            return (Criteria) this;
        }

        public Criteria andExpert_tagsIn(List<String> values) {
            addCriterion("expert_tags in", values, "expert_tags");
            return (Criteria) this;
        }

        public Criteria andExpert_tagsNotIn(List<String> values) {
            addCriterion("expert_tags not in", values, "expert_tags");
            return (Criteria) this;
        }

        public Criteria andExpert_tagsBetween(String value1, String value2) {
            addCriterion("expert_tags between", value1, value2, "expert_tags");
            return (Criteria) this;
        }

        public Criteria andExpert_tagsNotBetween(String value1, String value2) {
            addCriterion("expert_tags not between", value1, value2, "expert_tags");
            return (Criteria) this;
        }

        public Criteria andUser_typeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUser_typeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUser_typeEqualTo(Integer value) {
            addCriterion("user_type =", value, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeNotEqualTo(Integer value) {
            addCriterion("user_type <>", value, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeGreaterThan(Integer value) {
            addCriterion("user_type >", value, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_type >=", value, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeLessThan(Integer value) {
            addCriterion("user_type <", value, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeLessThanOrEqualTo(Integer value) {
            addCriterion("user_type <=", value, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeIn(List<Integer> values) {
            addCriterion("user_type in", values, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeNotIn(List<Integer> values) {
            addCriterion("user_type not in", values, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeBetween(Integer value1, Integer value2) {
            addCriterion("user_type between", value1, value2, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeNotBetween(Integer value1, Integer value2) {
            addCriterion("user_type not between", value1, value2, "user_type");
            return (Criteria) this;
        }

        public Criteria andCreate_dateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreate_dateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreate_dateEqualTo(Date value) {
            addCriterion("create_date =", value, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateGreaterThan(Date value) {
            addCriterion("create_date >", value, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateLessThan(Date value) {
            addCriterion("create_date <", value, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateIn(List<Date> values) {
            addCriterion("create_date in", values, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "create_date");
            return (Criteria) this;
        }

        public Criteria andHead_urlIsNull() {
            addCriterion("head_url is null");
            return (Criteria) this;
        }

        public Criteria andHead_urlIsNotNull() {
            addCriterion("head_url is not null");
            return (Criteria) this;
        }

        public Criteria andHead_urlEqualTo(String value) {
            addCriterion("head_url =", value, "head_url");
            return (Criteria) this;
        }

        public Criteria andHead_urlNotEqualTo(String value) {
            addCriterion("head_url <>", value, "head_url");
            return (Criteria) this;
        }

        public Criteria andHead_urlGreaterThan(String value) {
            addCriterion("head_url >", value, "head_url");
            return (Criteria) this;
        }

        public Criteria andHead_urlGreaterThanOrEqualTo(String value) {
            addCriterion("head_url >=", value, "head_url");
            return (Criteria) this;
        }

        public Criteria andHead_urlLessThan(String value) {
            addCriterion("head_url <", value, "head_url");
            return (Criteria) this;
        }

        public Criteria andHead_urlLessThanOrEqualTo(String value) {
            addCriterion("head_url <=", value, "head_url");
            return (Criteria) this;
        }

        public Criteria andHead_urlLike(String value) {
            addCriterion("head_url like", value, "head_url");
            return (Criteria) this;
        }

        public Criteria andHead_urlNotLike(String value) {
            addCriterion("head_url not like", value, "head_url");
            return (Criteria) this;
        }

        public Criteria andHead_urlIn(List<String> values) {
            addCriterion("head_url in", values, "head_url");
            return (Criteria) this;
        }

        public Criteria andHead_urlNotIn(List<String> values) {
            addCriterion("head_url not in", values, "head_url");
            return (Criteria) this;
        }

        public Criteria andHead_urlBetween(String value1, String value2) {
            addCriterion("head_url between", value1, value2, "head_url");
            return (Criteria) this;
        }

        public Criteria andHead_urlNotBetween(String value1, String value2) {
            addCriterion("head_url not between", value1, value2, "head_url");
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