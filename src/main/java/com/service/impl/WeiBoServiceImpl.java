package com.service.impl;

import com.dao.WbCommentsMapper;
import com.dao.WbReplyMapper;
import com.dao.WbTopicMapper;
import com.model.common.ResultDTO;
import com.model.wb.WbComments;
import com.model.wb.WbInsertModel;
import com.model.wb.WbReply;
import com.model.wb.WbTopic;
import com.model.weibo.WeiBoCommentsModel;
import com.service.WeiBoService;
import com.webmargic.WeiBoProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Spider;

import java.util.List;

/**
 * 获取微博API数据
 *
 * @author Liukx
 * @create 2017-04-24 13:50
 * @email liukx@elab-plus.com
 **/
@Service("weiBoService")
public class WeiBoServiceImpl implements WeiBoService {

    @Autowired
    private WbCommentsMapper commentsMapper;

    @Autowired
    private WbReplyMapper replyMapper;

    @Autowired
    private WbTopicMapper topicMapper;

    public ResultDTO getPageAllCommentList(WeiBoCommentsModel commentsModel) {
        return ResultDTO.isOK(null);
    }

    public ResultDTO getSingeCommentsList(String url) throws Exception {
        Spider.create(new WeiBoProcessor(this, url + "?type=comment")).thread(5).run();
        return ResultDTO.isOK(null);
    }

    public void insertData(WbInsertModel model) throws Exception {
        // 添加话题
        WbTopic wbTopic = model.getWbTopic();
        int topicResult = topicMapper.insert(wbTopic);

        // 添加评论
        List<WbComments> commentsList = model.getCommentsList();
        if (commentsList.size() > 0) {
            for (int i = 0; i < commentsList.size(); i++) {
                WbComments wbComments = commentsList.get(i);
                try {
                    int insert = commentsMapper.insert(wbComments);
                } catch (Exception e) {
                    if (e instanceof DuplicateKeyException) {
                        return;
                    } else {
                        System.out.println("添加评论出错~");
                        e.printStackTrace();
                    }
                }
            }
        }

        List<WbReply> replyList = model.getReplyList();
        if (replyList.size() > 0) {
            for (int i = 0; i < replyList.size(); i++) {
                WbReply wbReply = replyList.get(i);
                try {
                    int replyResult = replyMapper.insert(wbReply);
                } catch (Exception e) {
                    if (e instanceof DuplicateKeyException) {
                        return;
                    } else {
                        System.out.println("添加回复出错~");
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println("★★★★★★★★★★★★★★★★★★★添加成功★★★★★★★★★★★★★★★★★★★★");
    }
}
