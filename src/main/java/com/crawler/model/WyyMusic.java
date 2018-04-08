package com.crawler.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "wyyMusic")
public class WyyMusic {

    @Id
    private String mongoId;
     // 
     // 表字段 : wyy_music.id
    private Integer id;

     // 歌曲名称
     // 表字段 : wyy_music.music_name
    private String music_name;

     // 专辑名称
     // 表字段 : wyy_music.music_Album
    private String music_Album;

     // 歌手名称
     // 表字段 : wyy_music.name
    private String name;

     // 
     // 表字段 : wyy_music.comment_count
    private Integer comment_count;

     // 
     // 表字段 : wyy_music.time
    private Date time;

     // 
     // 表字段 : wyy_music.music_id
    @Indexed(unique = true)
    private Integer music_id;

     // 
     // 表字段 : wyy_music.music_url
    private String music_url;

    /**
     * 描述 ： 
     * 对应数据库： ->  wyy_music.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    public String getMongoId() {
        return mongoId;
    }

    public void setMongoId(String mongoId) {
        this.mongoId = mongoId;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  wyy_music.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 描述 ： 歌曲名称
     * 对应数据库： ->  wyy_music.music_name
     *
     * @mbg.generated
     */
    public String getMusic_name() {
        return music_name;
    }

    /**
     * 描述 ： 歌曲名称
     * 对应数据库： ->  wyy_music.music_name
     *
     * @mbg.generated
     */
    public void setMusic_name(String music_name) {
        this.music_name = music_name == null ? null : music_name.trim();
    }

    /**
     * 描述 ： 专辑名称
     * 对应数据库： ->  wyy_music.music_Album
     *
     * @mbg.generated
     */
    public String getMusic_Album() {
        return music_Album;
    }

    /**
     * 描述 ： 专辑名称
     * 对应数据库： ->  wyy_music.music_Album
     *
     * @mbg.generated
     */
    public void setMusic_Album(String music_Album) {
        this.music_Album = music_Album == null ? null : music_Album.trim();
    }

    /**
     * 描述 ： 歌手名称
     * 对应数据库： ->  wyy_music.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * 描述 ： 歌手名称
     * 对应数据库： ->  wyy_music.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  wyy_music.comment_count
     *
     * @mbg.generated
     */
    public Integer getComment_count() {
        return comment_count;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  wyy_music.comment_count
     *
     * @mbg.generated
     */
    public void setComment_count(Integer comment_count) {
        this.comment_count = comment_count;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  wyy_music.time
     *
     * @mbg.generated
     */
    public Date getTime() {
        return time;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  wyy_music.time
     *
     * @mbg.generated
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  wyy_music.music_id
     *
     * @mbg.generated
     */
    public Integer getMusic_id() {
        return music_id;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  wyy_music.music_id
     *
     * @mbg.generated
     */
    public void setMusic_id(Integer music_id) {
        this.music_id = music_id;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  wyy_music.music_url
     *
     * @mbg.generated
     */
    public String getMusic_url() {
        return music_url;
    }

    /**
     * 描述 ： 
     * 对应数据库： ->  wyy_music.music_url
     *
     * @mbg.generated
     */
    public void setMusic_url(String music_url) {
        this.music_url = music_url == null ? null : music_url.trim();
    }
}