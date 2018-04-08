package com.crawler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 爬虫任务列表控制类
 *
 * @author Liukx
 * @create 2017-05-18 16:14
 * @email liukx@elab-plus.com
 **/
@Controller
@RequestMapping("/search")
public class ReptilesTaskListController {

    private String page = "/search";

    @RequestMapping(value = "/tt", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String tt() {
        return page + "/tt";
    }

    @RequestMapping(value = "/wbTopic", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String wbTopic() {
        return page + "/weiboTopicList";
    }
}
