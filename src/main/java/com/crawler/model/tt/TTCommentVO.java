package com.crawler.model.tt;

import java.util.List;

/**
 * 头条内容承装容器
 *
 * @author Liukx
 * @create 2018-04-04 16:07
 * @email liukx@elab-plus.com
 **/
public class TTCommentVO {

    private List<TtComment> commentList;

    public List<TtComment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<TtComment> commentList) {
        this.commentList = commentList;
    }
}
