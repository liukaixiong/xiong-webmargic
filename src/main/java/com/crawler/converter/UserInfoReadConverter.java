package com.crawler.converter;

import com.crawler.model.WyyComment;
import com.mongodb.DBObject;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 读取数据时 , 将DBObject转换成userinfo
 * 1. 适用场景
 * ★ 大数据量的情况下,可能反射会特别耗时,这时候采用手动赋值的方式可以加快获取对象的时间
 *
 * @Description:
 * @Author: Liukx on 2017/4/28 - 14:37
 */
@Component
public class UserInfoReadConverter implements Converter<DBObject, WyyComment> {

    public WyyComment convert(DBObject source) {
        WyyComment p = new WyyComment();
        p.setContent(source.get("content").toString());
        p.setLike_count((Integer) source.get("like_count"));
        p.setComment_id((Integer) source.get("comment_id"));
        p.setLiked(source.get("liked").toString());
        p.setMusic_id((Integer) source.get("music_id"));
        p.setUser_id((Integer) source.get("user_id"));
        p.setComment_time((Date)source.get("comment_time"));
        p.setMusic_url(source.get("music_url").toString());
//        System.out.println("数据读取转换成功~");
        return p;
    }

}