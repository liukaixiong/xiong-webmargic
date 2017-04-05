package com.controller;

import com.service.IWangYiYunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Liukx
 * @create 2017-03-28 14:46
 * @email liukx@elab-plus.com
 **/
@Controller
@RequestMapping("/")
public class WangYiYunController {

    @Autowired
    private IWangYiYunService demoService;



}
