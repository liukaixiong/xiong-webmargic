package com.crawler.model.common;

/**
 * 爬虫请求入参实体
 *
 * @author Liukx
 * @create 2017-05-18 16:36
 * @email liukx@elab-plus.com
 **/
public class RequestTaskModel {

    //指定路径爬取
    private String url;

    //关键字爬取
    private String keyword;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
