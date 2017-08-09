package com.service.impl;

import com.alibaba.fastjson.JSON;
import com.dao.WyyCommentMapper;
import com.dao.WyyHotCommentMapper;
import com.dao.WyyMusicMapper;
import com.dao.WyyUserMapper;
import com.model.WyyComment;
import com.model.WyyHotComment;
import com.model.WyyMusic;
import com.model.WyyUser;
import com.model.common.RequestTaskModel;
import com.model.common.ResultDTO;
import com.service.IWangYiYunService;
import com.webmargic.WangYiYunProcessor;
import com.webmargic.vo.CommentVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Spider;

import java.util.List;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author Liukx
 * @create 2017-03-28 14:48
 * @email liukx@elab-plus.com
 **/
@Service("wangYiYunService")
public class WangYiYunServiceImpl implements IWangYiYunService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    //    @Qualifier("wyyUserMongoDBDao")
    @Qualifier("wyyUserMapper")
    @Autowired
    private WyyUserMapper userMapper;

    //    @Qualifier("wyyMongoDBMusicDao")
    @Qualifier("wyyMusicMapper")
    @Autowired
    private WyyMusicMapper musicMapper;

    //    @Qualifier("wyyMongoDBHotCommentDao")
    @Qualifier("wyyHotCommentMapper")
    @Autowired
    private WyyHotCommentMapper hotCommentMapper;

    //    @Qualifier("wyyMongoDb")
    @Qualifier("wyyCommentMapper")
    @Autowired
    private WyyCommentMapper commentMapper;

    // 热评总抓取数
    private LongAdder count = new LongAdder();
    // 用户总抓取数
    private LongAdder userCount = new LongAdder();
    // 歌曲抓去总数
    private LongAdder musicCount = new LongAdder();
    // 评论抓取总数
    private LongAdder commentCount = new LongAdder();

//    @Autowired
//    private EsClient esClient;

    /**
     * 添加评论以及歌曲信息
     *
     * @param vo
     */
    public void insertMusic(CommentVO vo) {
        WyyMusic music = vo.getMusic();
        int musicInsert = 0;
        try {
            if (music != null) {
                musicInsert = musicMapper.insert(music);
                musicCount.increment();
                logger.info("歌曲信息添加成功~" + musicInsert);
            }
        } catch (Exception e) {
            if (e instanceof DuplicateKeyException) {
                return;
            } else {
                logger.error("错误异常: " + e.getMessage() + "\t 错误参数:" + JSON.toJSONString(music));
            }
        }

        if (vo.getHotComment() != null && vo.getHotComment().size() > 0) {
            int successCount = 0;
            for (int i = 0; i < vo.getHotComment().size(); i++) {
                WyyHotComment hotComment = vo.getHotComment().get(i);
                try {
                    int insert = hotCommentMapper.insert(hotComment);
                    if (insert > 0) {
                        successCount++;
                    }
                } catch (Exception e) {
                    if (e instanceof DuplicateKeyException) {
                        return;
                    } else {
                        logger.error("错误异常: " + e.getMessage() + "\t 错误参数:" + JSON.toJSONString(hotComment));
                    }
                }
            }
            count.add(vo.getHotComment().size());
            logger.info("热评 添加成功 本次一共添加 [" + vo.getHotComment().size() + "]  成功 [" + successCount + "]");
        }

        List<WyyComment> comments = vo.getComments();
        if (comments != null && comments.size() > 0) {
            int successCount = 0;
            for (int i = 0; i < comments.size(); i++) {
                WyyComment wyyComment = comments.get(i);
                try {
                    int insert = commentMapper.insert(wyyComment);
                    if (insert > 0) {
                        successCount++;
                    }
//                    System.out.println("添加评论★★★★★第[" + commentCount + "]条★★★★★");
                } catch (Exception e) {
                    if (e instanceof DuplicateKeyException) {
                        return;
                    } else {
                        logger.error("错误异常: " + e.getMessage() + "\t 错误参数:" + JSON.toJSONString(wyyComment));
                    }
                }
            }
            commentCount.add(comments.size());
            logger.info("评论 添加成功 本次一共添加 [" + vo.getComments().size() + "]  成功 [" + successCount + "]");
        }

        if (vo.getUser() != null && vo.getUser().size() > 0) {
            int successCount = 0;
            for (int i = 0; i < vo.getUser().size(); i++) {
                WyyUser wyyUser = vo.getUser().get(i);
                try {
                    int insert = userMapper.insert(wyyUser);
                    if (insert > 0) {
                        successCount++;
                    }
                } catch (Exception e) {
                    if (e instanceof DuplicateKeyException) {
                        return;
                    } else {
                        logger.error("错误异常: " + e.getMessage() + "\t 错误参数:" + JSON.toJSONString(wyyUser));
                    }
                }
            }
            userCount.add(vo.getUser().size());
            logger.info("网易云用户 添加成功 本次一共添加 [" + vo.getUser().size() + "]  成功 [" + successCount + "]");

        }
        logger.info(" 网易云  数据  添加完毕..");
    }


    public ResultDTO crawler(RequestTaskModel requestModel) {
        Spider.create(new WangYiYunProcessor(this, requestModel)).thread(5).run();
        System.out.println("-------------------------->一共抓取热评 : " + count);
        System.out.println("-------------------------->一个抓取用户 :" + userCount);
        System.out.println("-------------------------->一共抓去歌曲数:" + musicCount);
        System.out.println(" -------------------------->一个抓取评论数: " + userCount);
        count.reset();
        userCount.reset();
        musicCount.reset();
        userCount.reset();
        return ResultDTO.isOK(null);
    }
}
