package com.controller;

import com.model.common.ResultDTO;
import com.model.tt.TtComment;
import com.service.TTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 头条控制器
 *
 * @author Liukx
 * @create 2017-05-18 16:14
 * @email liukx@elab-plus.com
 **/
@Controller
@RequestMapping("/tt")
public class TTController {


    @Autowired
    private TTService ttService;

    @RequestMapping(value = "/search", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ResultDTO search(TtComment model) {
        ResultDTO search = ttService.search(model);
        return search;
    }
}
