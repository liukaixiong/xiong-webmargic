package com.crawler.model.common;

/**
 * @author Liukx
 * @create 2017-06-06 16:09
 * @email liukx@elab-plus.com
 **/
public class SearchModel {

    private Integer pageNo = 1;

    private Integer pageSize = 20;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
