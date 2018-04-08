package com.crawler.service;

import com.crawler.model.common.RequestTaskModel;
import com.crawler.model.common.ResultDTO;
import com.crawler.model.wb.WbInsertModel;

/**
 * 微博API请求
 *
 * @author Liukx
 * @create 2017-04-24 13:45
 * @email liukx@elab-plus.com
 **/
public interface WeiBoService {


    /**
     * 插入微博数据
     *
     * @param model
     * @throws Exception
     */
    public void insertData(WbInsertModel model) throws Exception;

    /**
     * 爬虫爬取对象
     *
     * @param requestModel
     * @return
     */
    public ResultDTO crawler(RequestTaskModel requestModel) throws Exception;

}
