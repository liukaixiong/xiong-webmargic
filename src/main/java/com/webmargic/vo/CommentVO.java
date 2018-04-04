package com.webmargic.vo;

import com.model.WyyComment;
import com.model.WyyHotComment;
import com.model.WyyMusic;
import com.model.WyyUser;

import java.util.List;

/**
 * 装载爬虫数据对象
 *
 * @author Liukx
 * @create 2017-03-30 15:46
 * @email liukx@elab-plus.com
 **/
public class CommentVO {
    private List<WyyUser> user;
    private List<WyyHotComment> hotComment;
    private WyyMusic music;
    private List<WyyComment> comments;

    public List<WyyComment> getComments() {
        return comments;
    }

    public void setComments(List<WyyComment> comments) {
        this.comments = comments;
    }

    public List<WyyUser> getUser() {
        return user;
    }

    public void setUser(List<WyyUser> user) {
        this.user = user;
    }

    public List<WyyHotComment> getHotComment() {
        return hotComment;
    }

    public void setHotComment(List<WyyHotComment> hotComment) {
        this.hotComment = hotComment;
    }

    public WyyMusic getMusic() {
        return music;
    }

    public void setMusic(WyyMusic music) {
        this.music = music;
    }

    @Override
    public String toString() {
        return "CommentVO{" +
                "user=" + user +
                ", hotComment=" + hotComment +
                ", music=" + music +
                ", comments=" + comments +
                '}';
    }
}
