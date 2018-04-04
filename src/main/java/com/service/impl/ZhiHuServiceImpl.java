package com.service.impl;

import com.dao.ZhAnswerCommentsMapper;
import com.dao.ZhAnswerMapper;
import com.dao.ZhQuestionMapper;
import com.dao.ZhUserMapper;
import com.model.common.RequestTaskModel;
import com.model.common.ResultDTO;
import com.model.zh.*;
import com.service.ZhiHuService;
import com.webmargic.ZhiHuProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Spider;

import java.util.List;

/**
 * 知乎抓取数据业务层实现类
 *
 * @author Liukx
 * @create 2017-04-19 10:47
 * @email liukx@elab-plus.com
 **/
@Service("zhiHuService")
public class ZhiHuServiceImpl implements ZhiHuService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ZhAnswerCommentsMapper answerCommentsMapper;

    @Autowired
    private ZhAnswerMapper answerMapper;

    @Autowired
    private ZhQuestionMapper questionMapper;

    @Autowired
    private ZhUserMapper userMapper;

    /**
     * 添加数据
     *
     * @param requestModel
     */
    public void insertData(ZhRequestModel requestModel) {
        logger.info(" 开始添加数据 ... ");
        // 添加问题
        ZhQuestion question = requestModel.getQuestion();
        try {
            int insert = questionMapper.insert(question);
            logger.info("知乎 _ 添加问题成功 : " + question.getTitle());
        } catch (Exception e) {
            if (e instanceof DuplicateKeyException) {
                return;
            } else {
                System.out.println(" 添加提问失败!!");
                e.printStackTrace();
            }
        }

        // 添加答题内容
        List<ZhAnswer> answerList = requestModel.getAnswerList();
        if (answerList.size() > 0) {
            int successCount = 0;
            for (int i = 0; i < answerList.size(); i++) {
                ZhAnswer answer = answerList.get(i);
                try {
                    int insert1 = answerMapper.insert(answer);
                    if (insert1 > 0) {
                        successCount++;
                    }
                } catch (Exception e) {
                    if (e instanceof DuplicateKeyException) {
                        return;
                    } else {
                        System.out.println("添加答题出错!!!");
                        e.printStackTrace();
                    }
                }
            }
            logger.info("知乎 _ 添加答题成功 :  本次一个添加答题 [" + answerList.size() + "] 个 _ 最终 成功 [" + successCount + "]");
        }

        // 添加评论内容
        List<ZhAnswerComments> commentsList = requestModel.getCommentsList();
        if (commentsList.size() > 0) {
            int successCount = 0;
            for (int i = 0; i < commentsList.size(); i++) {
                ZhAnswerComments comments = commentsList.get(i);
                try {
                    int insert = answerCommentsMapper.insert(comments);
                    if (insert > 0) {
                        successCount++;
                    }
                } catch (Exception e) {
                    if (e instanceof DuplicateKeyException) {
                        return;
                    } else {
                        System.out.println("添加评论出错~");
                        e.printStackTrace();
                    }
                }
            }
            logger.info("知乎 _ 添加评论成功 :  本次一共添加 [" + commentsList.size() + "] 个 _ 最终 成功 [" + successCount + "]");
        }

        // 添加用户信息
        List<ZhUser> userList = requestModel.getUserList();
        if (userList.size() > 0) {
            int successCount = 0;
            for (int i = 0; i < userList.size(); i++) {
                ZhUser user = userList.get(i);
                try {
                    int insert = userMapper.insert(user);
                    if (insert > 0) {
                        successCount++;
                    }
                } catch (Exception e) {
                    if (e instanceof DuplicateKeyException) {
                        return;
                    } else {
                        System.out.println("添加用户出错~");
                        e.printStackTrace();
                    }
                }
            }
            logger.info("知乎 _ 添加用户成功 :  本次一共添加 [" + userList.size() + "] 个 _ 最终 成功 [" + successCount + "]");
        }
        logger.info("★★★★★★★★★知乎数据添加成功★★★★★★★★★★★");
    }

    public ResultDTO crawler(RequestTaskModel requestModel) {
        Spider.create(new ZhiHuProcessor(this, requestModel)).thread(10).run();
        return ResultDTO.isOK(null);
    }
}
