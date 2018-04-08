package com.crawler.webmargic.main;

import com.crawler.model.common.RequestTaskModel;
import com.crawler.service.ICrawlerService;
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
        String[] xml = new String[]{"classpath:root-context.xml"};
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xml);
        ICrawlerService weiBoService = (ICrawlerService) applicationContext.getBean("weiBoService");
        RequestTaskModel requestTaskModel = new RequestTaskModel();
        //https://m.weibo.cn/status/4109269282436009?retcode=6102
        //https://m.weibo.cn/status/4115633706470272?from=1075295010&wm=4209_8001&featurecode=newtitle

        //给前任留一句最想说的话
        //https://m.weibo.cn/status/3899084307582165?sourceType=qq&from=1076095010&wm=20005_0002&featurecode=newtitle
        requestTaskModel.setUrl("https://m.weibo.cn/status/4225057305805866?retcode=6102");
        weiBoService.crawler(requestTaskModel);
//        weiBoService.getSingeCommentsList("http://weibo.com/1713926427/EEKG7olMY");
    }
}
