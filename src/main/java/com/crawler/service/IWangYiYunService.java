package com.crawler.service;

import com.crawler.model.common.RequestTaskModel;
import com.crawler.model.common.ResultDTO;
import com.crawler.webmargic.vo.CommentVO;

/**
 * @author Liukx
 * @create 2017-03-28 14:48
 * @email liukx@elab-plus.com
 **/
public interface IWangYiYunService {
    public void insertMusic(CommentVO vo);

    /**
     * 爬虫爬取对象
     *
     * @param requestModel
     * @return
     */
    public ResultDTO crawler(RequestTaskModel requestModel);

}
