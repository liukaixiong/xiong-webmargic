package com.service.impl;

import com.dao.WbCommentsMapper;
import com.dao.WbReplyMapper;
import com.dao.WbTopicMapper;
import com.enums.SourceEnum;
import com.model.common.RequestTaskModel;
import com.model.common.ResultDTO;
import com.model.wb.WbComments;
import com.model.wb.WbInsertModel;
import com.model.wb.WbReply;
import com.model.wb.WbTopic;
import com.service.ICrawlerService;
import com.webmargic.WeiBoProcessor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
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
@Primary
@Service("weiBoService")
public class WeiBoServiceImpl implements ICrawlerService<WbInsertModel> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WbCommentsMapper commentsMapper;

    @Autowired
    private WbReplyMapper replyMapper;

    @Autowired
    private WbTopicMapper topicMapper;

    @Value("${weibo.username}")
    private String username;

    @Value("${weibo.password}")
    private String password;


//    public ResultDTO getSingeCommentsList(String url) throws Exception {
//        Spider.create(new WeiBoProcessor(this, url + "?type=comment")).thread(5).run();
//        return ResultDTO.isOK(null);
//    }


    @Override
    public SourceEnum getSourceEnum() {
        return SourceEnum.WEIBO;
    }

    public ResultDTO crawler(RequestTaskModel requestModel) throws Exception {
        Spider.create(new WeiBoProcessor(this, requestModel, username, password)).thread(5).run();
        return ResultDTO.isOK(null);
    }


    public void insertData(WbInsertModel model) throws Exception {

        insertTopic(model);

        if (insertCommentsList(model)) {
            return;
        }

        if (insertReply(model)) {
            return;
        }

        logger.info("  本次消息添加完毕 .. 话题 - " + model.getWbTopic().getTopicId());
    }

    /**
     * 添加回复
     *
     * @param model
     * @return
     */
    private boolean insertReply(WbInsertModel model) {
        List<WbReply> replyList = model.getReplyList();
        if (replyList.size() > 0) {
            int count = 0;
            for (int i = 0; i < replyList.size(); i++) {
                WbReply wbReply = replyList.get(i);
                try {
                    int replyResult = replyMapper.insert(wbReply);
                    if (replyResult > 0) {
                        count++;
                    }
                } catch (Exception e) {
                    if (e instanceof DuplicateKeyException) {
                        return true;
                    } else {
                        System.out.println("添加回复出错~");
                        e.printStackTrace();
                    }
                }
            }
            logger.info("回复添加成功 本次一共添加 [" + replyList.size() + "] 成功 [" + count + "] 条");
        }
        return false;
    }

    /**
     * 添加评论集合
     *
     * @param model
     * @return
     */
    private boolean insertCommentsList(WbInsertModel model) {
        // 添加评论
        List<WbComments> commentsList = model.getCommentsList();
        if (commentsList.size() > 0) {
            int count = 0;
            for (int i = 0; i < commentsList.size(); i++) {
                WbComments wbComments = commentsList.get(i);
                try {
                    int insert = commentsMapper.insert(wbComments);
                    if (insert > 0) {
                        count++;
                    }
                } catch (Exception e) {
                    if (e instanceof DuplicateKeyException) {
                        return true;
                    } else {
                        System.out.println("添加评论出错~");
                        e.printStackTrace();
                    }
                }
            }
            logger.info("评论添加成功 本次一共添加 [" + commentsList.size() + "] 成功 [" + count + "] 条");
        }
        return false;
    }

    /**
     * 添加话题
     *
     * @param model
     */
    private void insertTopic(WbInsertModel model) {
        // 添加话题
        WbTopic wbTopic = model.getWbTopic();
        if (model.getWbTopic() != null && StringUtils.isNotBlank(model.getWbTopic().getContent())) {
            int topicResult = topicMapper.insert(wbTopic);
            if (topicResult > 0) {
                logger.info("话题创建成功 来自[" + wbTopic.getUsername() + "] 发表的 [" + wbTopic.getContent() + "] .. 数据库生成编号 [" + topicResult + "]");
            }
        }
    }
}
