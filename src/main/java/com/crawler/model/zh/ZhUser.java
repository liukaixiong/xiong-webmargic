package com.crawler.model.zh;

import java.util.Date;

public class ZhUser {
     // 
     // 表字段 : zh_user.id
    private Integer id;

     // 用户编号
     // 表字段 : zh_user.user_id
    private String userId;

     // 用户token
     // 表字段 : zh_user.url_token
    private String urlToken;

     // 用户昵称
     // 表字段 : zh_user.name
    private String name;

     // 用户性别
     // 表字段 : zh_user.gender
    private Integer gender;

     // 头像
     // 表字段 : zh_user.avatar_url
    private String avatarUrl;

     // 格言
     // 表字段 : zh_user.headline
    private String headline;

     // 类型
     // 表字段 : zh_user.type
    private String type;

     // 头像模版
     // 表字段 : zh_user.avatar_url_template
    private String avatarUrlTemplate;

     // 是否关注
     // 表字段 : zh_user.is_followed
    private String isFollowed;

     // 是否广告商
     // 表字段 : zh_user.is_advertiser
    private String isAdvertiser;

     // 是否是机构认证
     // 表字段 : zh_user.is_org
    private String isOrg;

     // 是否关注
     // 表字段 : zh_user.is_following
    private String isFollowing;

     // 用户类型
     // 表字段 : zh_user.user_type
    private String userType;

     // 系统时间
     // 表字段 : zh_user.system_time
    private Date systemTime;

    /**
     * 描述 ： 
     * 对应数据库： ->  zh_user.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  zh_user.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 描述 ： 用户编号
     * 对应数据库： ->  zh_user.user_id
     *
     * @mbg.generated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 描述 ： 用户编号
     * 对应数据库： ->  zh_user.user_id
     *
     * @mbg.generated
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 描述 ： 用户token
     * 对应数据库： ->  zh_user.url_token
     *
     * @mbg.generated
     */
    public String getUrlToken() {
        return urlToken;
    }

    /**
     * 描述 ： 用户token
     * 对应数据库： ->  zh_user.url_token
     *
     * @mbg.generated
     */
    public void setUrlToken(String urlToken) {
        this.urlToken = urlToken == null ? null : urlToken.trim();
    }

    /**
     * 描述 ： 用户昵称
     * 对应数据库： ->  zh_user.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * 描述 ： 用户昵称
     * 对应数据库： ->  zh_user.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 描述 ： 用户性别
     * 对应数据库： ->  zh_user.gender
     *
     * @mbg.generated
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 描述 ： 用户性别
     * 对应数据库： ->  zh_user.gender
     *
     * @mbg.generated
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 描述 ： 头像
     * 对应数据库： ->  zh_user.avatar_url
     *
     * @mbg.generated
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * 描述 ： 头像
     * 对应数据库： ->  zh_user.avatar_url
     *
     * @mbg.generated
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    /**
     * 描述 ： 格言
     * 对应数据库： ->  zh_user.headline
     *
     * @mbg.generated
     */
    public String getHeadline() {
        return headline;
    }

    /**
     * 描述 ： 格言
     * 对应数据库： ->  zh_user.headline
     *
     * @mbg.generated
     */
    public void setHeadline(String headline) {
        this.headline = headline == null ? null : headline.trim();
    }

    /**
     * 描述 ： 类型
     * 对应数据库： ->  zh_user.type
     *
     * @mbg.generated
     */
    public String getType() {
        return type;
    }

    /**
     * 描述 ： 类型
     * 对应数据库： ->  zh_user.type
     *
     * @mbg.generated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 描述 ： 头像模版
     * 对应数据库： ->  zh_user.avatar_url_template
     *
     * @mbg.generated
     */
    public String getAvatarUrlTemplate() {
        return avatarUrlTemplate;
    }

    /**
     * 描述 ： 头像模版
     * 对应数据库： ->  zh_user.avatar_url_template
     *
     * @mbg.generated
     */
    public void setAvatarUrlTemplate(String avatarUrlTemplate) {
        this.avatarUrlTemplate = avatarUrlTemplate == null ? null : avatarUrlTemplate.trim();
    }

    /**
     * 描述 ： 是否关注
     * 对应数据库： ->  zh_user.is_followed
     *
     * @mbg.generated
     */
    public String getIsFollowed() {
        return isFollowed;
    }

    /**
     * 描述 ： 是否关注
     * 对应数据库： ->  zh_user.is_followed
     *
     * @mbg.generated
     */
    public void setIsFollowed(String isFollowed) {
        this.isFollowed = isFollowed == null ? null : isFollowed.trim();
    }

    /**
     * 描述 ： 是否广告商
     * 对应数据库： ->  zh_user.is_advertiser
     *
     * @mbg.generated
     */
    public String getIsAdvertiser() {
        return isAdvertiser;
    }

    /**
     * 描述 ： 是否广告商
     * 对应数据库： ->  zh_user.is_advertiser
     *
     * @mbg.generated
     */
    public void setIsAdvertiser(String isAdvertiser) {
        this.isAdvertiser = isAdvertiser == null ? null : isAdvertiser.trim();
    }

    /**
     * 描述 ： 是否是机构认证
     * 对应数据库： ->  zh_user.is_org
     *
     * @mbg.generated
     */
    public String getIsOrg() {
        return isOrg;
    }

    /**
     * 描述 ： 是否是机构认证
     * 对应数据库： ->  zh_user.is_org
     *
     * @mbg.generated
     */
    public void setIsOrg(String isOrg) {
        this.isOrg = isOrg == null ? null : isOrg.trim();
    }

    /**
     * 描述 ： 是否关注
     * 对应数据库： ->  zh_user.is_following
     *
     * @mbg.generated
     */
    public String getIsFollowing() {
        return isFollowing;
    }

    /**
     * 描述 ： 是否关注
     * 对应数据库： ->  zh_user.is_following
     *
     * @mbg.generated
     */
    public void setIsFollowing(String isFollowing) {
        this.isFollowing = isFollowing == null ? null : isFollowing.trim();
    }

    /**
     * 描述 ： 用户类型
     * 对应数据库： ->  zh_user.user_type
     *
     * @mbg.generated
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 描述 ： 用户类型
     * 对应数据库： ->  zh_user.user_type
     *
     * @mbg.generated
     */
    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    /**
     * 描述 ： 系统时间
     * 对应数据库： ->  zh_user.system_time
     *
     * @mbg.generated
     */
    public Date getSystemTime() {
        return systemTime;
    }

    /**
     * 描述 ： 系统时间
     * 对应数据库： ->  zh_user.system_time
     *
     * @mbg.generated
     */
    public void setSystemTime(Date systemTime) {
        this.systemTime = systemTime;
    }
}