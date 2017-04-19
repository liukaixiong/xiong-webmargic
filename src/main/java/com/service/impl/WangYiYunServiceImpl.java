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
import com.model.common.ResultDTO;
import com.service.IWangYiYunService;
import com.webmargic.WangYiYunProcessor;
import com.webmargic.vo.CommentVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private WyyUserMapper userMapper;

    @Autowired
    private WyyMusicMapper musicMapper;

    @Autowired
    private WyyHotCommentMapper hotCommentMapper;

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
                System.out.println("歌曲信息添加成功~" + musicInsert);
            }
        } catch (Exception e) {
//            return;
        }

        if (vo.getHotComment() != null && vo.getHotComment().size() > 0) {
            for (int i = 0; i < vo.getHotComment().size(); i++) {
                WyyHotComment hotComment = vo.getHotComment().get(i);
                try {
                    int insert = hotCommentMapper.insert(hotComment);
                } catch (Exception e) {
//                    System.out.println("====");
                }
            }
            count.add(vo.getHotComment().size());
        }

        List<WyyComment> comments = vo.getComments();
        if (comments != null && comments.size() > 0) {
            for (int i = 0; i < comments.size(); i++) {
                WyyComment wyyComment = comments.get(i);
                try {
                    commentMapper.insert(wyyComment);
                    System.out.println("添加评论★★★★★第[" + commentCount + "]条★★★★★");
                } catch (Exception e) {
                    if (e instanceof DuplicateKeyException) {
                        return;
                    } else {
                        logger.error("错误异常: " + e.getMessage() + "\t 错误参数:" + JSON.toJSONString(wyyComment));
                    }
                }
            }
            commentCount.add(comments.size());
        }

        if (vo.getUser() != null && vo.getUser().size() > 0) {
            for (int i = 0; i < vo.getUser().size(); i++) {
                WyyUser wyyUser = vo.getUser().get(i);
                try {
                    int insert = userMapper.insert(wyyUser);
                    System.out.println("用户添加成功.");
                } catch (Exception e) {
//                    System.out.println("====");
                }
            }
            userCount.add(vo.getUser().size());
        }
        System.out.println("添加完毕..");
    }


    /**
     * 爬虫启动方法
     */
    public ResultDTO wyyCrawler(String url) {
        Spider.create(new WangYiYunProcessor(this, url)).thread(5).run();
        System.out.println("-------------------------->一共抓取热评 : " + count);
        System.out.println("-------------------------->一个抓取用户 :" + userCount);
        System.out.println("-------------------------->一共抓去歌曲数:" + musicCount);
        System.out.println(" -------------------------->一个抓取评论数: " + userCount);
        return ResultDTO.isOK(null);
    }
}
