package com.crawler.service.impl;

import com.crawler.dao.ZhAnswerCommentsMapper;
import com.crawler.dao.ZhAnswerMapper;
import com.crawler.dao.ZhQuestionMapper;
import com.crawler.dao.ZhUserMapper;
import com.crawler.enums.SourceEnum;
import com.crawler.model.common.RequestTaskModel;
import com.crawler.model.common.ResultDTO;
import com.crawler.model.zh.*;
import com.crawler.service.ICrawlerService;
import com.crawler.webmargic.ZhiHuProcessor;
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
public class ZhiHuServiceImpl implements ICrawlerService<ZhRequestModel> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ZhAnswerCommentsMapper answerCommentsMapper;

    @Autowired
    private ZhAnswerMapper answerMapper;

    @Autowired
    private ZhQuestionMapper questionMapper;

    @Autowired
    private ZhUserMapper userMapper;

    @Override
    public SourceEnum getSourceEnum() {
        return SourceEnum.ZHIHU;
    }

    /**
     * 添加数据
     *
     * @param requestModel
     */
    public void insertData(ZhRequestModel requestModel) {
        logger.info(" 开始添加数据 ... ");

        if (insertQuestions(requestModel)) {
            return;
        }

        if (insertAnswer(requestModel)) {
            return;
        }

        if (insertComments(requestModel)) {
            return;
        }

        if (insertUser(requestModel)) {
            return;
        }

        logger.info("★★★★★★★★★知乎数据添加成功★★★★★★★★★★★");
    }

    private boolean insertUser(ZhRequestModel requestModel) {
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
                        logger.error("存在重复用户! 用户编号 : " + user.getUserId() + " 名称 : " + user.getName());
                        return true;
                    } else {
                        System.out.println("添加用户出错~");
                        e.printStackTrace();
                    }
                }
            }
            logger.info("知乎 _ 添加用户成功 :  本次一共添加 [" + userList.size() + "] 个 _ 最终 成功 [" + successCount + "]");
        }
        return false;
    }

    private boolean insertComments(ZhRequestModel requestModel) {
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
                        logger.error("存在重复评论! 评论编号 : " + comments.getAnswerId() + " 内容 : " + comments.getContent());
                        return true;
                    } else {
                        System.out.println("添加评论出错~");
                        e.printStackTrace();
                    }
                }
            }
            logger.info("知乎 _ 添加评论成功 :  本次一共添加 [" + commentsList.size() + "] 个 _ 最终 成功 [" + successCount + "]");
        }
        return false;
    }

    private boolean insertAnswer(ZhRequestModel requestModel) {
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
                        logger.error("存在重复答案! 答案编号 : " + answer.getAnswerId() + " 标题 : " + answer.getTitle());
                        return true;
                    } else {
                        System.out.println("添加答题出错!!!");
                        e.printStackTrace();
                    }
                }
            }
            logger.info("知乎 _ 添加答题成功 :  本次一个添加答题 [" + answerList.size() + "] 个 _ 最终 成功 [" + successCount + "]");
        }
        return false;
    }

    private boolean insertQuestions(ZhRequestModel requestModel) {
        // 添加问题
        ZhQuestion question = requestModel.getQuestion();
        try {
            int insert = questionMapper.insert(question);
            logger.info("知乎 _ 添加问题成功 : " + question.getTitle());
        } catch (Exception e) {
            if (e instanceof DuplicateKeyException) {
                logger.error("存在重复问题! 问题编号 : " + question.getQuestionId() + " 标题 : " + question.getTitle());
                return true;
            } else {
                System.out.println(" 添加提问失败!!");
                e.printStackTrace();
            }
        }
        return false;
    }

    public ResultDTO crawler(RequestTaskModel requestModel) {
        Spider.create(new ZhiHuProcessor(this, requestModel)).addUrl(requestModel.getUrl()).thread(10).run();
        return ResultDTO.isOK(null);
    }
}
