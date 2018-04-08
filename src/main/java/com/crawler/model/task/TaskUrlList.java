package com.crawler.model.task;

import java.util.Date;

public class TaskUrlList {
     // 
     // 表字段 : task_url_list.id
    private Integer id;

     // 查询关键
     // 表字段 : task_url_list.search_keyword
    private String searchKeyword;

     // 查询类型 0 网址 1 关键字
     // 表字段 : task_url_list.search_type
    private Integer searchType;

     // 网址类型 1 微博 2网易云 3知乎 4头条
     // 表字段 : task_url_list.type
    private String type;

     // 网址标题
     // 表字段 : task_url_list.title
    private String title;

     // 状态 0 未爬取 1已爬取 2爬取失败
     // 表字段 : task_url_list.status
    private Integer status;

     // 创建时间
     // 表字段 : task_url_list.time
    private Date time;

     // 爬取时间
     // 表字段 : task_url_list.update_time
    private Date updateTime;

    /**
     * 描述 ： 
     * 对应数据库： ->  task_url_list.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  task_url_list.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 描述 ： 查询关键
     * 对应数据库： ->  task_url_list.search_keyword
     *
     * @mbg.generated
     */
    public String getSearchKeyword() {
        return searchKeyword;
    }

    /**
     * 描述 ： 查询关键
     * 对应数据库： ->  task_url_list.search_keyword
     *
     * @mbg.generated
     */
    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword == null ? null : searchKeyword.trim();
    }

    /**
     * 描述 ： 查询类型 0 网址 1 关键字
     * 对应数据库： ->  task_url_list.search_type
     *
     * @mbg.generated
     */
    public Integer getSearchType() {
        return searchType;
    }

    /**
     * 描述 ： 查询类型 0 网址 1 关键字
     * 对应数据库： ->  task_url_list.search_type
     *
     * @mbg.generated
     */
    public void setSearchType(Integer searchType) {
        this.searchType = searchType;
    }

    /**
     * 描述 ： 网址类型 1 微博 2网易云 3知乎 4头条
     * 对应数据库： ->  task_url_list.type
     *
     * @mbg.generated
     */
    public String getType() {
        return type;
    }

    /**
     * 描述 ： 网址类型 1 微博 2网易云 3知乎 4头条
     * 对应数据库： ->  task_url_list.type
     *
     * @mbg.generated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 描述 ： 网址标题
     * 对应数据库： ->  task_url_list.title
     *
     * @mbg.generated
     */
    public String getTitle() {
        return title;
    }

    /**
     * 描述 ： 网址标题
     * 对应数据库： ->  task_url_list.title
     *
     * @mbg.generated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 描述 ： 状态 0 未爬取 1已爬取 2爬取失败
     * 对应数据库： ->  task_url_list.status
     *
     * @mbg.generated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 描述 ： 状态 0 未爬取 1已爬取 2爬取失败
     * 对应数据库： ->  task_url_list.status
     *
     * @mbg.generated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 描述 ： 创建时间
     * 对应数据库： ->  task_url_list.time
     *
     * @mbg.generated
     */
    public Date getTime() {
        return time;
    }

    /**
     * 描述 ： 创建时间
     * 对应数据库： ->  task_url_list.time
     *
     * @mbg.generated
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 描述 ： 爬取时间
     * 对应数据库： ->  task_url_list.update_time
     *
     * @mbg.generated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 描述 ： 爬取时间
     * 对应数据库： ->  task_url_list.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}