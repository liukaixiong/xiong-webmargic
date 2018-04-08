package com.crawler.service;

import com.crawler.model.common.ResultDTO;

/**
 * 爬虫任务列表业务处理
 *
 * @author Liukx
 * @create 2017-05-18 16:19
 * @email liukx@elab-plus.com
 **/
public interface TaskUrlListService {
    /**
     * 启动爬虫任务类 - 把状态为未跑过的内容重新跑一遍
     *
     * @return
     */
    ResultDTO runTask() throws Exception;

    /**
     * 获取邮件中的白名单邮件,并解析成任务存入数据库
     *
     * @return
     * @throws Exception
     */
    ResultDTO saveEmailTask() throws Exception;
}
