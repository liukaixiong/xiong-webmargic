package com.model.es;

import java.util.List;

/**
 * es数据封装
 *
 * @author Liukx
 * @create 2017-05-08 16:13
 * @email liukx@elab-plus.com
 **/
public class EsModel {

    //索引
    private String index;
    //类型
    private String type;
    //数据 json
    private List<String> jsonData;

    //分页 当前第几条
    private int from = 0;
    // 每页多少条
    private int size = 10;

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<String> getJsonData() {
        return jsonData;
    }

    public void setJsonData(List<String> jsonData) {
        this.jsonData = jsonData;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
