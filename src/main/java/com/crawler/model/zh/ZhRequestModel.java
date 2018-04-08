package com.crawler.model.zh;

import java.util.ArrayList;
import java.util.List;

/**
 * 知乎信息封装
 *
 * @author Liukx
 * @create 2017-04-18 13:20
 * @email liukx@elab-plus.com
 **/
public class ZhRequestModel {
    // 答题集合
    private List<ZhAnswer> answerList = new ArrayList<>();
    // 答题评论集合
    private List<ZhAnswerComments> commentsList = new ArrayList<>();
    // 用户集合
    private List<ZhUser> userList = new ArrayList<>();
    // 问题集合
    private ZhQuestion question = new ZhQuestion();

    public List<ZhAnswer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<ZhAnswer> answerList) {
        this.answerList = answerList;
    }

    public List<ZhAnswerComments> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<ZhAnswerComments> commentsList) {
        this.commentsList = commentsList;
    }

    public List<ZhUser> getUserList() {
        return userList;
    }

    public void setUserList(List<ZhUser> userList) {
        this.userList = userList;
    }

    public ZhQuestion getQuestion() {
        return question;
    }

    public void setQuestion(ZhQuestion question) {
        this.question = question;
    }
}
