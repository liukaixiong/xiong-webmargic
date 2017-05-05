package com.model.wb;

import java.util.ArrayList;
import java.util.List;

/**
 * 微博所有数据封装实体
 *
 * @author Liukx
 * @create 2017-04-25 10:27
 * @email liukx@elab-plus.com
 **/
public class WbInsertModel {

    private WbTopic wbTopic = new WbTopic();

    private List<WbComments> commentsList = new ArrayList<WbComments>();

    private List<WbReply> replyList = new ArrayList<WbReply>();

    public WbTopic getWbTopic() {
        return wbTopic;
    }

    public void setWbTopic(WbTopic wbTopic) {
        this.wbTopic = wbTopic;
    }

    public List<WbComments> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<WbComments> commentsList) {
        this.commentsList = commentsList;
    }

    public List<WbReply> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<WbReply> replyList) {
        this.replyList = replyList;
    }
}
