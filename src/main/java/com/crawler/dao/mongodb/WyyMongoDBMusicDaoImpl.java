package com.crawler.dao.mongodb;

import com.crawler.dao.WyyMusicMapper;
import com.crawler.model.WyyMusic;
import com.crawler.model.WyyMusicExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

//@Repository("wyyMongoDBMusicDao")
public class WyyMongoDBMusicDaoImpl implements WyyMusicMapper {
    @Autowired
    private MongoTemplate mongoTemplate;

    public long countByExample(WyyMusicExample example) {
        return 0;
    }


    public int deleteByExample(WyyMusicExample example) {
        return 0;
    }


    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }


    public int insert(WyyMusic record) {
        mongoTemplate.insert(record);
        return 1;
    }


    public int insertSelective(WyyMusic record) {
        return 0;
    }


    public List<WyyMusic> selectByExample(WyyMusicExample example) {
        return null;
    }


    public WyyMusic selectByPrimaryKey(Integer id) {
        return null;
    }


    public int updateByExampleSelective(@Param("record") WyyMusic record, @Param("example") WyyMusicExample example) {
        return 0;
    }


    public int updateByExample(@Param("record") WyyMusic record, @Param("example") WyyMusicExample example) {
        return 0;
    }


    public int updateByPrimaryKeySelective(WyyMusic record) {
        return 0;
    }


    public int updateByPrimaryKey(WyyMusic record) {
        return 0;
    }
}