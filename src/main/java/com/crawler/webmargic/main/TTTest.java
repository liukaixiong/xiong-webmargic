package com.crawler.webmargic.main;

import com.crawler.model.common.RequestTaskModel;
import com.crawler.service.ICrawlerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 头条测试
 *
 * @author Liukx
 * @create 2017-05-23 15:07
 * @email liukx@elab-plus.com
 **/
public class TTTest {

    public static void main(String[] args) throws Exception {
        String[] xml = new String[]{"classpath:root-context.xml"};
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xml);
        ICrawlerService ttService = (ICrawlerService) applicationContext.getBean("ttService");
        RequestTaskModel requestTaskModel = new RequestTaskModel();
        //http://m.toutiao.org/group/6408716317448454401/?iid=10702191108&app=news_article&tt_from=mobile_qq&utm_source=mobile_qq&utm_medium=toutiao_android&utm_campaign=client_share
        //https://m.toutiao.com/group/6428059260302688513/?iid=10702191108&app=news_article&tt_from=mobile_qq&utm_source=mobile_qq&utm_medium=toutiao_android&utm_campaign=client_share
        requestTaskModel.setUrl("http://www.toutiao.com/a6540546348108743181/");
        ttService.crawler(requestTaskModel);

    }
}
