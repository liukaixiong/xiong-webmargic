package com.webmargic.main;

import com.service.WeiBoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 知乎main方法测试
 *
 * @author Liukx
 * @create 2017-03-30 17:01
 * @email liukx@elab-plus.com
 **/
public class WeiBoTest {

    public static void main(String[] args) throws Exception {
        // 1. 周杰伦歌曲评论地址:http://music.163.com/artist?id=6452
        String[] xml = new String[]{"classpath:root-context.xml"};
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xml);
        WeiBoService weiBoService = (WeiBoService) applicationContext.getBean("weiBoService");
        weiBoService.getSingeCommentsList("http://weibo.com/1713926427/EEKG7olMY");
    }
}
