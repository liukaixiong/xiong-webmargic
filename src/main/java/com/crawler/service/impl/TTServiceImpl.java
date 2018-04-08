package com.crawler.service.impl;

import com.alibaba.fastjson.JSON;
import com.crawler.dao.TtCommentMapper;
import com.crawler.enums.SourceEnum;
import com.crawler.model.common.RequestTaskModel;
import com.crawler.model.common.ResultDTO;
import com.crawler.model.tt.TTCommentVO;
import com.crawler.model.tt.TtComment;
import com.crawler.model.tt.TtCommentExample;
import com.crawler.service.ICrawlerService;
import com.crawler.webmargic.TTProcessor;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Spider;

import java.util.List;

/**
 * 今日头条业务类爬取
 *
 * @author Liukx
 * @create 2017-05-18 14:56
 * @email liukx@elab-plus.com
 **/
@Service("ttService")
public class TTServiceImpl implements ICrawlerService<TTCommentVO> {

    private Logger logger = LoggerFactory.getLogger(TTServiceImpl.class);

    @Autowired
    private TtCommentMapper mapper;

    @Override
    public SourceEnum getSourceEnum() {
        return SourceEnum.TOUTIAO;
    }

    public void insertData(TTCommentVO requestModel) {
        int count = 0;
        List<TtComment> commentList = requestModel.getCommentList();
        if (commentList.size() > 0) {
            for (int i = 0; i < commentList.size(); i++) {
                TtComment ttComment = commentList.get(i);
                try {
                    int insert = mapper.insert(ttComment);
                    if (insert > 0) {
                        count++;
                    }
                } catch (Exception e) {
                    if (e instanceof DuplicateKeyException) {
                        logger.info("遇到重复数据_____结束添加.." + ttComment.getCommentId() + " -> " + ttComment.getText());
//                        return;
                        continue;
                    } else {
                        logger.error("错误异常: " + e.getMessage() + "\t 错误参数:" + JSON.toJSONString(ttComment));
                    }
                }
            }
        }
        logger.info("头条评论 一共[" + commentList.size() + "]  成功 -> " + count);
    }

    public ResultDTO crawler(RequestTaskModel requestModel) {
        Spider.create(new TTProcessor(this, requestModel)).addUrl(requestModel.getUrl()).thread(5).run();
        return ResultDTO.isNo(null);
    }

    /**
     * 根绝查询条件查询指定内容
     *
     * @param model 查询条件实体
     * @return
     */
    public ResultDTO search(TtComment model) {
        // 判断
        TtCommentExample example = new TtCommentExample();
        TtCommentExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause(" like_count desc ");
        //如果标题编号不为空
        if (StringUtils.isNotBlank(model.getTopicId())) {
            criteria.andTopicIdEqualTo(model.getTopicId());
        }

        //标题
        if (StringUtils.isNotBlank(model.getTitle())) {
            criteria.andTitleLike(model.getTitle() + "%");
        }

        // 点赞数大于
        if (model.getLikeMin() != null) {
            criteria.andLikeCountGreaterThan(Integer.valueOf(model.getLikeMin()));
        }

        // 点赞数小于
        if (StringUtils.isNotBlank(model.getLikeMax())) {
            criteria.andLikeCountLessThan(Integer.valueOf(model.getLikeMax()));
        }

        //定义分页
        PageHelper.startPage(model.getPageNo(), model.getPageSize());

        List<TtComment> ttComments = mapper.selectByExample(example);

        PageInfo page = new PageInfo(ttComments);

        return ResultDTO.isOK(page);
    }
}
