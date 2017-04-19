package com.controller;

import com.model.common.ResultDTO;
import com.service.IWangYiYunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Liukx
 * @create 2017-03-28 14:46
 * @email liukx@elab-plus.com
 **/
@Controller
@RequestMapping("/")
public class WangYiYunController {

    @Autowired
    private IWangYiYunService wangYiYunService;

    @RequestMapping(value = "/wyy", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ResultDTO insertEvaluate(String url) {
        ResultDTO resultDTO = wangYiYunService.wyyCrawler(url);
        return resultDTO;
    }


}
