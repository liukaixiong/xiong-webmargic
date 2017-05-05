package com.model.weibo;

/**
 * 微博评论请求数据
 *
 * @author Liukx
 * @create 2017-04-24 13:47
 * @email liukx@elab-plus.com
 **/
public class WeiBoCommentsModel {

    //话题编号
    private String id;
    //排序方式
    private Integer sort;
    //用户cookie
    private String cookie;


    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
