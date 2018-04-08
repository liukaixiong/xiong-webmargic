package com.crawler.model.zh;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZhUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZhUserExample() {
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

        public Criteria andUrlTokenIsNull() {
            addCriterion("url_token is null");
            return (Criteria) this;
        }

        public Criteria andUrlTokenIsNotNull() {
            addCriterion("url_token is not null");
            return (Criteria) this;
        }

        public Criteria andUrlTokenEqualTo(String value) {
            addCriterion("url_token =", value, "urlToken");
            return (Criteria) this;
        }

        public Criteria andUrlTokenNotEqualTo(String value) {
            addCriterion("url_token <>", value, "urlToken");
            return (Criteria) this;
        }

        public Criteria andUrlTokenGreaterThan(String value) {
            addCriterion("url_token >", value, "urlToken");
            return (Criteria) this;
        }

        public Criteria andUrlTokenGreaterThanOrEqualTo(String value) {
            addCriterion("url_token >=", value, "urlToken");
            return (Criteria) this;
        }

        public Criteria andUrlTokenLessThan(String value) {
            addCriterion("url_token <", value, "urlToken");
            return (Criteria) this;
        }

        public Criteria andUrlTokenLessThanOrEqualTo(String value) {
            addCriterion("url_token <=", value, "urlToken");
            return (Criteria) this;
        }

        public Criteria andUrlTokenLike(String value) {
            addCriterion("url_token like", value, "urlToken");
            return (Criteria) this;
        }

        public Criteria andUrlTokenNotLike(String value) {
            addCriterion("url_token not like", value, "urlToken");
            return (Criteria) this;
        }

        public Criteria andUrlTokenIn(List<String> values) {
            addCriterion("url_token in", values, "urlToken");
            return (Criteria) this;
        }

        public Criteria andUrlTokenNotIn(List<String> values) {
            addCriterion("url_token not in", values, "urlToken");
            return (Criteria) this;
        }

        public Criteria andUrlTokenBetween(String value1, String value2) {
            addCriterion("url_token between", value1, value2, "urlToken");
            return (Criteria) this;
        }

        public Criteria andUrlTokenNotBetween(String value1, String value2) {
            addCriterion("url_token not between", value1, value2, "urlToken");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Integer value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Integer value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Integer value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Integer value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Integer value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Integer value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Integer> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Integer> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Integer value1, Integer value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Integer value1, Integer value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlIsNull() {
            addCriterion("avatar_url is null");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlIsNotNull() {
            addCriterion("avatar_url is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlEqualTo(String value) {
            addCriterion("avatar_url =", value, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlNotEqualTo(String value) {
            addCriterion("avatar_url <>", value, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlGreaterThan(String value) {
            addCriterion("avatar_url >", value, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlGreaterThanOrEqualTo(String value) {
            addCriterion("avatar_url >=", value, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlLessThan(String value) {
            addCriterion("avatar_url <", value, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlLessThanOrEqualTo(String value) {
            addCriterion("avatar_url <=", value, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlLike(String value) {
            addCriterion("avatar_url like", value, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlNotLike(String value) {
            addCriterion("avatar_url not like", value, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlIn(List<String> values) {
            addCriterion("avatar_url in", values, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlNotIn(List<String> values) {
            addCriterion("avatar_url not in", values, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlBetween(String value1, String value2) {
            addCriterion("avatar_url between", value1, value2, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlNotBetween(String value1, String value2) {
            addCriterion("avatar_url not between", value1, value2, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andHeadlineIsNull() {
            addCriterion("headline is null");
            return (Criteria) this;
        }

        public Criteria andHeadlineIsNotNull() {
            addCriterion("headline is not null");
            return (Criteria) this;
        }

        public Criteria andHeadlineEqualTo(String value) {
            addCriterion("headline =", value, "headline");
            return (Criteria) this;
        }

        public Criteria andHeadlineNotEqualTo(String value) {
            addCriterion("headline <>", value, "headline");
            return (Criteria) this;
        }

        public Criteria andHeadlineGreaterThan(String value) {
            addCriterion("headline >", value, "headline");
            return (Criteria) this;
        }

        public Criteria andHeadlineGreaterThanOrEqualTo(String value) {
            addCriterion("headline >=", value, "headline");
            return (Criteria) this;
        }

        public Criteria andHeadlineLessThan(String value) {
            addCriterion("headline <", value, "headline");
            return (Criteria) this;
        }

        public Criteria andHeadlineLessThanOrEqualTo(String value) {
            addCriterion("headline <=", value, "headline");
            return (Criteria) this;
        }

        public Criteria andHeadlineLike(String value) {
            addCriterion("headline like", value, "headline");
            return (Criteria) this;
        }

        public Criteria andHeadlineNotLike(String value) {
            addCriterion("headline not like", value, "headline");
            return (Criteria) this;
        }

        public Criteria andHeadlineIn(List<String> values) {
            addCriterion("headline in", values, "headline");
            return (Criteria) this;
        }

        public Criteria andHeadlineNotIn(List<String> values) {
            addCriterion("headline not in", values, "headline");
            return (Criteria) this;
        }

        public Criteria andHeadlineBetween(String value1, String value2) {
            addCriterion("headline between", value1, value2, "headline");
            return (Criteria) this;
        }

        public Criteria andHeadlineNotBetween(String value1, String value2) {
            addCriterion("headline not between", value1, value2, "headline");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlTemplateIsNull() {
            addCriterion("avatar_url_template is null");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlTemplateIsNotNull() {
            addCriterion("avatar_url_template is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlTemplateEqualTo(String value) {
            addCriterion("avatar_url_template =", value, "avatarUrlTemplate");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlTemplateNotEqualTo(String value) {
            addCriterion("avatar_url_template <>", value, "avatarUrlTemplate");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlTemplateGreaterThan(String value) {
            addCriterion("avatar_url_template >", value, "avatarUrlTemplate");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlTemplateGreaterThanOrEqualTo(String value) {
            addCriterion("avatar_url_template >=", value, "avatarUrlTemplate");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlTemplateLessThan(String value) {
            addCriterion("avatar_url_template <", value, "avatarUrlTemplate");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlTemplateLessThanOrEqualTo(String value) {
            addCriterion("avatar_url_template <=", value, "avatarUrlTemplate");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlTemplateLike(String value) {
            addCriterion("avatar_url_template like", value, "avatarUrlTemplate");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlTemplateNotLike(String value) {
            addCriterion("avatar_url_template not like", value, "avatarUrlTemplate");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlTemplateIn(List<String> values) {
            addCriterion("avatar_url_template in", values, "avatarUrlTemplate");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlTemplateNotIn(List<String> values) {
            addCriterion("avatar_url_template not in", values, "avatarUrlTemplate");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlTemplateBetween(String value1, String value2) {
            addCriterion("avatar_url_template between", value1, value2, "avatarUrlTemplate");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlTemplateNotBetween(String value1, String value2) {
            addCriterion("avatar_url_template not between", value1, value2, "avatarUrlTemplate");
            return (Criteria) this;
        }

        public Criteria andIsFollowedIsNull() {
            addCriterion("is_followed is null");
            return (Criteria) this;
        }

        public Criteria andIsFollowedIsNotNull() {
            addCriterion("is_followed is not null");
            return (Criteria) this;
        }

        public Criteria andIsFollowedEqualTo(String value) {
            addCriterion("is_followed =", value, "isFollowed");
            return (Criteria) this;
        }

        public Criteria andIsFollowedNotEqualTo(String value) {
            addCriterion("is_followed <>", value, "isFollowed");
            return (Criteria) this;
        }

        public Criteria andIsFollowedGreaterThan(String value) {
            addCriterion("is_followed >", value, "isFollowed");
            return (Criteria) this;
        }

        public Criteria andIsFollowedGreaterThanOrEqualTo(String value) {
            addCriterion("is_followed >=", value, "isFollowed");
            return (Criteria) this;
        }

        public Criteria andIsFollowedLessThan(String value) {
            addCriterion("is_followed <", value, "isFollowed");
            return (Criteria) this;
        }

        public Criteria andIsFollowedLessThanOrEqualTo(String value) {
            addCriterion("is_followed <=", value, "isFollowed");
            return (Criteria) this;
        }

        public Criteria andIsFollowedLike(String value) {
            addCriterion("is_followed like", value, "isFollowed");
            return (Criteria) this;
        }

        public Criteria andIsFollowedNotLike(String value) {
            addCriterion("is_followed not like", value, "isFollowed");
            return (Criteria) this;
        }

        public Criteria andIsFollowedIn(List<String> values) {
            addCriterion("is_followed in", values, "isFollowed");
            return (Criteria) this;
        }

        public Criteria andIsFollowedNotIn(List<String> values) {
            addCriterion("is_followed not in", values, "isFollowed");
            return (Criteria) this;
        }

        public Criteria andIsFollowedBetween(String value1, String value2) {
            addCriterion("is_followed between", value1, value2, "isFollowed");
            return (Criteria) this;
        }

        public Criteria andIsFollowedNotBetween(String value1, String value2) {
            addCriterion("is_followed not between", value1, value2, "isFollowed");
            return (Criteria) this;
        }

        public Criteria andIsAdvertiserIsNull() {
            addCriterion("is_advertiser is null");
            return (Criteria) this;
        }

        public Criteria andIsAdvertiserIsNotNull() {
            addCriterion("is_advertiser is not null");
            return (Criteria) this;
        }

        public Criteria andIsAdvertiserEqualTo(String value) {
            addCriterion("is_advertiser =", value, "isAdvertiser");
            return (Criteria) this;
        }

        public Criteria andIsAdvertiserNotEqualTo(String value) {
            addCriterion("is_advertiser <>", value, "isAdvertiser");
            return (Criteria) this;
        }

        public Criteria andIsAdvertiserGreaterThan(String value) {
            addCriterion("is_advertiser >", value, "isAdvertiser");
            return (Criteria) this;
        }

        public Criteria andIsAdvertiserGreaterThanOrEqualTo(String value) {
            addCriterion("is_advertiser >=", value, "isAdvertiser");
            return (Criteria) this;
        }

        public Criteria andIsAdvertiserLessThan(String value) {
            addCriterion("is_advertiser <", value, "isAdvertiser");
            return (Criteria) this;
        }

        public Criteria andIsAdvertiserLessThanOrEqualTo(String value) {
            addCriterion("is_advertiser <=", value, "isAdvertiser");
            return (Criteria) this;
        }

        public Criteria andIsAdvertiserLike(String value) {
            addCriterion("is_advertiser like", value, "isAdvertiser");
            return (Criteria) this;
        }

        public Criteria andIsAdvertiserNotLike(String value) {
            addCriterion("is_advertiser not like", value, "isAdvertiser");
            return (Criteria) this;
        }

        public Criteria andIsAdvertiserIn(List<String> values) {
            addCriterion("is_advertiser in", values, "isAdvertiser");
            return (Criteria) this;
        }

        public Criteria andIsAdvertiserNotIn(List<String> values) {
            addCriterion("is_advertiser not in", values, "isAdvertiser");
            return (Criteria) this;
        }

        public Criteria andIsAdvertiserBetween(String value1, String value2) {
            addCriterion("is_advertiser between", value1, value2, "isAdvertiser");
            return (Criteria) this;
        }

        public Criteria andIsAdvertiserNotBetween(String value1, String value2) {
            addCriterion("is_advertiser not between", value1, value2, "isAdvertiser");
            return (Criteria) this;
        }

        public Criteria andIsOrgIsNull() {
            addCriterion("is_org is null");
            return (Criteria) this;
        }

        public Criteria andIsOrgIsNotNull() {
            addCriterion("is_org is not null");
            return (Criteria) this;
        }

        public Criteria andIsOrgEqualTo(String value) {
            addCriterion("is_org =", value, "isOrg");
            return (Criteria) this;
        }

        public Criteria andIsOrgNotEqualTo(String value) {
            addCriterion("is_org <>", value, "isOrg");
            return (Criteria) this;
        }

        public Criteria andIsOrgGreaterThan(String value) {
            addCriterion("is_org >", value, "isOrg");
            return (Criteria) this;
        }

        public Criteria andIsOrgGreaterThanOrEqualTo(String value) {
            addCriterion("is_org >=", value, "isOrg");
            return (Criteria) this;
        }

        public Criteria andIsOrgLessThan(String value) {
            addCriterion("is_org <", value, "isOrg");
            return (Criteria) this;
        }

        public Criteria andIsOrgLessThanOrEqualTo(String value) {
            addCriterion("is_org <=", value, "isOrg");
            return (Criteria) this;
        }

        public Criteria andIsOrgLike(String value) {
            addCriterion("is_org like", value, "isOrg");
            return (Criteria) this;
        }

        public Criteria andIsOrgNotLike(String value) {
            addCriterion("is_org not like", value, "isOrg");
            return (Criteria) this;
        }

        public Criteria andIsOrgIn(List<String> values) {
            addCriterion("is_org in", values, "isOrg");
            return (Criteria) this;
        }

        public Criteria andIsOrgNotIn(List<String> values) {
            addCriterion("is_org not in", values, "isOrg");
            return (Criteria) this;
        }

        public Criteria andIsOrgBetween(String value1, String value2) {
            addCriterion("is_org between", value1, value2, "isOrg");
            return (Criteria) this;
        }

        public Criteria andIsOrgNotBetween(String value1, String value2) {
            addCriterion("is_org not between", value1, value2, "isOrg");
            return (Criteria) this;
        }

        public Criteria andIsFollowingIsNull() {
            addCriterion("is_following is null");
            return (Criteria) this;
        }

        public Criteria andIsFollowingIsNotNull() {
            addCriterion("is_following is not null");
            return (Criteria) this;
        }

        public Criteria andIsFollowingEqualTo(String value) {
            addCriterion("is_following =", value, "isFollowing");
            return (Criteria) this;
        }

        public Criteria andIsFollowingNotEqualTo(String value) {
            addCriterion("is_following <>", value, "isFollowing");
            return (Criteria) this;
        }

        public Criteria andIsFollowingGreaterThan(String value) {
            addCriterion("is_following >", value, "isFollowing");
            return (Criteria) this;
        }

        public Criteria andIsFollowingGreaterThanOrEqualTo(String value) {
            addCriterion("is_following >=", value, "isFollowing");
            return (Criteria) this;
        }

        public Criteria andIsFollowingLessThan(String value) {
            addCriterion("is_following <", value, "isFollowing");
            return (Criteria) this;
        }

        public Criteria andIsFollowingLessThanOrEqualTo(String value) {
            addCriterion("is_following <=", value, "isFollowing");
            return (Criteria) this;
        }

        public Criteria andIsFollowingLike(String value) {
            addCriterion("is_following like", value, "isFollowing");
            return (Criteria) this;
        }

        public Criteria andIsFollowingNotLike(String value) {
            addCriterion("is_following not like", value, "isFollowing");
            return (Criteria) this;
        }

        public Criteria andIsFollowingIn(List<String> values) {
            addCriterion("is_following in", values, "isFollowing");
            return (Criteria) this;
        }

        public Criteria andIsFollowingNotIn(List<String> values) {
            addCriterion("is_following not in", values, "isFollowing");
            return (Criteria) this;
        }

        public Criteria andIsFollowingBetween(String value1, String value2) {
            addCriterion("is_following between", value1, value2, "isFollowing");
            return (Criteria) this;
        }

        public Criteria andIsFollowingNotBetween(String value1, String value2) {
            addCriterion("is_following not between", value1, value2, "isFollowing");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(String value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(String value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(String value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(String value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(String value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(String value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLike(String value) {
            addCriterion("user_type like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotLike(String value) {
            addCriterion("user_type not like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<String> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<String> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(String value1, String value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(String value1, String value2) {
            addCriterion("user_type not between", value1, value2, "userType");
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