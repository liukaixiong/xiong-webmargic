package com.controller;

import com.model.common.ResultDTO;
import com.service.ZhiHuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 知乎跑批入口
 *
 * @author Liukx
 * @create 2017-03-28 14:46
 * @email liukx@elab-plus.com
 **/
@Controller
@RequestMapping("/zhihu")
public class ZhiHuController {

    @Autowired
    private ZhiHuService zhiHuService;

    @RequestMapping(value = "/search", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ResultDTO insertEvaluate(@RequestParam("q") String search) {
//        ResultDTO resultDTO = zhiHuService.zhCrawler(search);
        return null;
    }


}
