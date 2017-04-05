package com.webmargic;

import com.service.IWangYiYunService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Liukx
 * @create 2017-03-30 17:01
 * @email liukx@elab-plus.com
 **/
public class WangYiYunTest {

    public static void main(String[] args) {
        String [] xml = new String []{"classpath:root-context.xml"};
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xml);
        IWangYiYunService wangYiYunService = (IWangYiYunService) applicationContext.getBean("wangYiYunService");
        wangYiYunService.crawler();
    }
}
