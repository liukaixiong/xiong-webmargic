package com.crawler.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "wyyUser")
public class WyyUser {
    @Id
    private String mongoId;
    //
    // 表字段 : wyy_user.id
    private Integer id;

    //
    // 表字段 : wyy_user.userid
    @Indexed(unique = true)
    private Integer userid;

    // 用户名称
    // 表字段 : wyy_user.nike_name
    private String nike_name;

    // 用户主页
    // 表字段 : wyy_user.user_url
    private String user_url;

    // vip类型
    // 表字段 : wyy_user.vip_type
    private Integer vip_type;

    // 用户状态
    // 表字段 : wyy_user.auth_status
    private Integer auth_status;

    // 名称描述
    // 表字段 : wyy_user.remark_name
    private String remark_name;

    // 标签
    // 表字段 : wyy_user.expert_tags
    private String expert_tags;

    // 用户类型
    // 表字段 : wyy_user.user_type
    private Integer user_type;

    //
    // 表字段 : wyy_user.create_date
    private Date create_date;

    // 头像
    // 表字段 : wyy_user.head_url
    private String head_url;

    public String getMongoId() {
        return mongoId;
    }

    public void setMongoId(String mongoId) {
        this.mongoId = mongoId;
    }

    /**
     * 描述 ：
     * 对应数据库： ->  wyy_user.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * 描述 ：
     * 对应数据库： ->  wyy_user.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 描述 ：
     * 对应数据库： ->  wyy_user.userid
     *
     * @mbg.generated
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * 描述 ：
     * 对应数据库： ->  wyy_user.userid
     *
     * @mbg.generated
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * 描述 ： 用户名称
     * 对应数据库： ->  wyy_user.nike_name
     *
     * @mbg.generated
     */
    public String getNike_name() {
        return nike_name;
    }

    /**
     * 描述 ： 用户名称
     * 对应数据库： ->  wyy_user.nike_name
     *
     * @mbg.generated
     */
    public void setNike_name(String nike_name) {
        this.nike_name = nike_name == null ? null : nike_name.trim();
    }

    /**
     * 描述 ： 用户主页
     * 对应数据库： ->  wyy_user.user_url
     *
     * @mbg.generated
     */
    public String getUser_url() {
        return user_url;
    }

    /**
     * 描述 ： 用户主页
     * 对应数据库： ->  wyy_user.user_url
     *
     * @mbg.generated
     */
    public void setUser_url(String user_url) {
        this.user_url = user_url == null ? null : user_url.trim();
    }

    /**
     * 描述 ： vip类型
     * 对应数据库： ->  wyy_user.vip_type
     *
     * @mbg.generated
     */
    public Integer getVip_type() {
        return vip_type;
    }

    /**
     * 描述 ： vip类型
     * 对应数据库： ->  wyy_user.vip_type
     *
     * @mbg.generated
     */
    public void setVip_type(Integer vip_type) {
        this.vip_type = vip_type;
    }

    /**
     * 描述 ： 用户状态
     * 对应数据库： ->  wyy_user.auth_status
     *
     * @mbg.generated
     */
    public Integer getAuth_status() {
        return auth_status;
    }

    /**
     * 描述 ： 用户状态
     * 对应数据库： ->  wyy_user.auth_status
     *
     * @mbg.generated
     */
    public void setAuth_status(Integer auth_status) {
        this.auth_status = auth_status;
    }

    /**
     * 描述 ： 名称描述
     * 对应数据库： ->  wyy_user.remark_name
     *
     * @mbg.generated
     */
    public String getRemark_name() {
        return remark_name;
    }

    /**
     * 描述 ： 名称描述
     * 对应数据库： ->  wyy_user.remark_name
     *
     * @mbg.generated
     */
    public void setRemark_name(String remark_name) {
        this.remark_name = remark_name == null ? null : remark_name.trim();
    }

    /**
     * 描述 ： 标签
     * 对应数据库： ->  wyy_user.expert_tags
     *
     * @mbg.generated
     */
    public String getExpert_tags() {
        return expert_tags;
    }

    /**
     * 描述 ： 标签
     * 对应数据库： ->  wyy_user.expert_tags
     *
     * @mbg.generated
     */
    public void setExpert_tags(String expert_tags) {
        this.expert_tags = expert_tags == null ? null : expert_tags.trim();
    }

    /**
     * 描述 ： 用户类型
     * 对应数据库： ->  wyy_user.user_type
     *
     * @mbg.generated
     */
    public Integer getUser_type() {
        return user_type;
    }

    /**
     * 描述 ： 用户类型
     * 对应数据库： ->  wyy_user.user_type
     *
     * @mbg.generated
     */
    public void setUser_type(Integer user_type) {
        this.user_type = user_type;
    }

    /**
     * 描述 ：
     * 对应数据库： ->  wyy_user.create_date
     *
     * @mbg.generated
     */
    public Date getCreate_date() {
        return create_date;
    }

    /**
     * 描述 ：
     * 对应数据库： ->  wyy_user.create_date
     *
     * @mbg.generated
     */
    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    /**
     * 描述 ： 头像
     * 对应数据库： ->  wyy_user.head_url
     *
     * @mbg.generated
     */
    public String getHead_url() {
        return head_url;
    }

    /**
     * 描述 ： 头像
     * 对应数据库： ->  wyy_user.head_url
     *
     * @mbg.generated
     */
    public void setHead_url(String head_url) {
        this.head_url = head_url == null ? null : head_url.trim();
    }
}