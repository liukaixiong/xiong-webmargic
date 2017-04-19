package com.webmargic.main;

import com.service.ZhiHuService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 知乎main方法测试
 *
 * @author Liukx
 * @create 2017-03-30 17:01
 * @email liukx@elab-plus.com
 **/
public class ZhiHuTest {

    public static void main(String[] args) {
        // 1. 周杰伦歌曲评论地址:http://music.163.com/artist?id=6452
        String[] xml = new String[]{"classpath:root-context.xml"};
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xml);
        ZhiHuService zhiHuService = (ZhiHuService) applicationContext.getBean("zhiHuService");
        zhiHuService.zhCrawler("周杰伦");
    }
}
