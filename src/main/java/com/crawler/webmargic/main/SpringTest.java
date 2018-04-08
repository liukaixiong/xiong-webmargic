package com.crawler.webmargic.main;

import com.crawler.service.TaskUrlListService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Liukx
 * @create 2017-05-22 15:14
 * @email liukx@elab-plus.com
 **/
public class SpringTest {
    public static void main(String[] args) throws Exception {
        String[] xml = new String[]{"classpath:root-context.xml"};
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xml);
        TaskUrlListService taskUrlListService = (TaskUrlListService) applicationContext.getBean("taskUrlListService");
        taskUrlListService.runTask();
    }
}
