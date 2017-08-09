package com.webmargic.vo.wyy;

/**
 * 关键字查询
 *
 * @author Liukx
 * @create 2017-05-19 15:36
 * @email liukx@elab-plus.com
 **/
public class KeywordModel {

    // 关键字高亮结束
    private String hlpretag = "";

    // 关键字高亮开始
    private String hlposttag = "";

    //查询关键字
    private String s;

    //搜索类型
    // 1. 歌曲 100.歌手 10.专辑. 1000 歌单  1002 歌手 1004 mv 1006 歌词 1009 主播电台
    private String type;

    // 起始值
    private int offset = 0;

    // 是否最大值
    private boolean total;

    // 每页大小
    private int limit;

    public String getHlpretag() {
        return hlpretag;
    }

    public void setHlpretag(String hlpretag) {
        this.hlpretag = hlpretag;
    }

    public String getHlposttag() {
        return hlposttag;
    }

    public void setHlposttag(String hlposttag) {
        this.hlposttag = hlposttag;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isTotal() {
        return total;
    }

    public void setTotal(boolean total) {
        this.total = total;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
