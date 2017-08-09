package com.service;/**
 * Created by liukx on 2017/4/19.
 */

import com.model.common.RequestTaskModel;
import com.model.common.ResultDTO;
import com.model.zh.ZhRequestModel;

/**
 * 知乎爬虫抓取业务层
 *
 * @author Liukx
 * @create 2017-04-19 10:45
 * @email liukx@elab-plus.com
 **/
public interface ZhiHuService {
    /**
     * 添加爬虫到的数据对象
     *
     * @param requestModel
     */
    public void insertData(ZhRequestModel requestModel);

    /**
     * 知乎抓去对象
     *
     * @param requestModel 请求任务实体
     * @return
     */
    public ResultDTO crawler(RequestTaskModel requestModel);
}
