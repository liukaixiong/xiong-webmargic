package com.service;

import com.enums.SourceEnum;
import com.model.common.RequestTaskModel;
import com.model.common.ResultDTO;

/**
 * 爬取爬虫原则逻辑定义
 *
 * @author Liukx
 * @create 2018-04-04 14:02
 * @email liukx@elab-plus.com
 **/
public interface ICrawlerService<T> {

    /**
     * 获取数据来源,这里会触发一个回调
     *
     * @return
     */
    public SourceEnum getSourceEnum();

    /**
     * 添加爬虫到的数据对象
     *
     * @param requestModel
     */
    public void insertData(T requestModel) throws Exception;

    /**
     * 抓去对象的方法
     *
     * @param requestModel
     * @return
     */
    public ResultDTO crawler(RequestTaskModel requestModel) throws Exception;

}
