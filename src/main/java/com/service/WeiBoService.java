package com.service;

import com.model.common.ResultDTO;
import com.model.wb.WbInsertModel;
import com.model.weibo.WeiBoCommentsModel;

/**
 * 微博API请求
 *
 * @author Liukx
 * @create 2017-04-24 13:45
 * @email liukx@elab-plus.com
 **/
public interface WeiBoService {

    /**
     * 获取微博话题的所有评论
     *
     * @param commentsModel
     * @return
     */
    public ResultDTO getPageAllCommentList(WeiBoCommentsModel commentsModel);

    public ResultDTO getSingeCommentsList(String url) throws Exception;

    public void insertData(WbInsertModel model) throws Exception;

}
