package com.crawler.service.impl;

import com.crawler.dao.TaskUrlListMapper;
import com.crawler.model.common.RequestTaskModel;
import com.crawler.model.common.ResultDTO;
import com.crawler.model.task.TaskUrlList;
import com.crawler.model.task.TaskUrlListExample;
import com.crawler.service.ICrawlerService;
import com.crawler.service.TaskUrlListService;
import com.crawler.utils.BaseConstans;
import com.crawler.utils.IMapReceiveMail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 爬虫任务列表执行类
 *
 * @author Liukx
 * @create 2017-05-18 16:21
 * @email liukx@elab-plus.com
 **/
@Service("taskUrlListService")
public class TaskUrlListServiceImpl implements TaskUrlListService {

    private Logger logger = LoggerFactory.getLogger(TaskUrlListServiceImpl.class);

    @Autowired
    private TaskUrlListMapper mapper;

    @Autowired
    private ICrawlerService zhiHuService;

    @Qualifier("weiBoService")
    @Autowired
    private ICrawlerService wangYiYunService;

    @Autowired
    private ICrawlerService ttService;

    @Qualifier("weiBoService")
    @Autowired
    private ICrawlerService weiBoService;

    @Override
    public ResultDTO runTask() throws Exception {
        // 1 开始执行未完成的任务
        TaskUrlListExample example = new TaskUrlListExample();
        example.createCriteria().andStatusEqualTo(0);
        // 获取未完成的任务集合
        List<TaskUrlList> taskUrlLists = mapper.selectByExample(example);

        for (int i = 0; i < taskUrlLists.size(); i++) {
            TaskUrlList taskUrlList = taskUrlLists.get(i);
            String type = taskUrlList.getType();
            RequestTaskModel request = new RequestTaskModel();
            Integer searchType = taskUrlList.getSearchType();
            if (BaseConstans.search_type_url.equals(searchType)) {
                request.setUrl(taskUrlList.getSearchKeyword());
            } else if (BaseConstans.search_type_keyword.equals(searchType)) {
                request.setKeyword(taskUrlList.getSearchKeyword());
            } else {
                logger.error("错误的类型! ----> " + searchType);
            }
            ResultDTO res = null;
            logger.info(" 开始执行第 [" + i + "] 个任务 任务内容:" + taskUrlList.getSearchKeyword());

            if (BaseConstans.weibo_type.equals(type)) {
                res = weiBoService.crawler(request);
            } else if (BaseConstans.tt_type.equals(type)) {
                res = ttService.crawler(request);
            } else if (BaseConstans.wyy_type.equals(type)) {
                res = wangYiYunService.crawler(request);
            } else if (BaseConstans.zh_type.equals(type)) {
                res = zhiHuService.crawler(request);
            }

            int status = 0;
            if (res.isSuccess()) {
                status = BaseConstans.status_synchro_ok;
            } else {
                status = BaseConstans.status_synchro_no;
            }
            taskUrlList.setStatus(1);
            int result = mapper.updateByPrimaryKey(taskUrlList);
            logger.info("第[" + i + "]个任务结束 主键为:" + taskUrlList.getId() + " \t  同步状态 : " + status + " \t 修改结果 : " + result);
        }
        return ResultDTO.isOK(" 同步 [" + taskUrlLists.size() + "] 条");
    }


    /**
     * 类型分类
     *
     * @param type
     */
    private ResultDTO typeClassification(String type, String url) {
        ResultDTO resultDTO = null;
        RequestTaskModel model = new RequestTaskModel();
        if (BaseConstans.weibo_type.equals(type)) {
            logger.info(" 执行任务分类 - 微博 开始执行 ...");
        } else if (BaseConstans.wyy_type.equals(type)) {
//            resultDTO = wangYiYunService.crawler(url);
        } else if (BaseConstans.zh_type.equals(type)) {
//            zhiHuService.zhCrawler()
        }
        return null;
    }

    public ResultDTO saveEmailTask() throws Exception {
        logger.info("开始扫描邮件内容是否有任务存在!");
        IMapReceiveMail receiveMail = new IMapReceiveMail();
        List<TaskUrlList> taskList = receiveMail.receive();
        int count = 0;
        if (taskList != null && taskList.size() > 0) {
            for (int i = 0; i < taskList.size(); i++) {
                TaskUrlList taskUrlList = taskList.get(i);
                int insert = mapper.insert(taskUrlList);
                if (insert > 0) {
                    count++;
                }
            }
        }
        logger.info("结束扫描邮件内容 一共扫描到任务 [" + count + "] 个");
        return ResultDTO.isOK("一共成功条数 : [" + count + "]");
    }
}
