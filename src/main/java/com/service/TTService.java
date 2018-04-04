package com.service;

import com.model.common.RequestTaskModel;
import com.model.common.ResultDTO;
import com.model.tt.TTCommentVO;
import com.model.tt.TtComment;

/**
 * 今日头条 爬虫存储 业务类
 *
 * @author Liukx
 * @create 2017-04-19 10:45
 * @email liukx@elab-plus.com
 **/
public interface TTService {
    /**
     * 添加爬虫到的数据对象
     *
     * @param requestModel
     */
    public void insertData(TTCommentVO requestModel);

    /**
     * 爬虫爬取对象
     *
     * @param requestModel
     * @return
     */
    public ResultDTO crawler(RequestTaskModel requestModel);

    /**
     * 根据查询条件查询对应的内容
     *
     * @param model 查询条件实体
     * @return
     */
    public ResultDTO search(TtComment model);

}
