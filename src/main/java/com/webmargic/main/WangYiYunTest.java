package com.webmargic.main;

import com.model.common.RequestTaskModel;
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
        // 1. 周杰伦歌曲评论地址:http://music.163.com/artist?id=6452
        String[] xml = new String[]{"classpath:root-context.xml"};
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xml);
        IWangYiYunService wangYiYunService = (IWangYiYunService) applicationContext.getBean("wangYiYunService");
        Long start = System.currentTimeMillis();
        RequestTaskModel model = new RequestTaskModel();
        // 注意连接是否是https类型的, 目前只支持http:
        model.setUrl("http://music.163.com/song?id=27566765");
//        model.setKeyword("夜的钢琴曲");
        wangYiYunService.crawler(model);
        Long end = System.currentTimeMillis();
        System.out.println(" -----------------------耗时---------------------" + (end - start));
//        MongoTemplate mongoTemplate = (MongoTemplate) applicationContext.getBean("mongoTemplate");
//        WyyComment wyyComment = new WyyComment();
//        wyyComment.setLiked("100");
//        wyyComment.setContent("測試的");
//        wyyComment.setId(0);
//        String jsonString = JSON.toJSONString(wyyComment);
//
//        JSONObject jsonObject = JSON.parseObject(jsonString);
//        mongoTemplate.insert(jsonObject,"wyyComment");
//        Long start = System.currentTimeMillis();
//        Query query = new Query();
//        query.addCriteria(Criteria.where("like_count").gt(1));
//        List<WyyComment> commentList = mongoTemplate.find(query, WyyComment.class);
//        List<WyyComment> all = mongoTemplate.findAll(WyyComment.class);
//        System.out.println("一共耗时:" + (System.currentTimeMillis() - start) + " 数据大小 - " + commentList.size());
    }
}
