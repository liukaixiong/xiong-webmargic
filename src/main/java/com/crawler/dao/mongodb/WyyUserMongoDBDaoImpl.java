package com.crawler.dao.mongodb;

import com.crawler.dao.WyyUserMapper;
import com.crawler.model.WyyUser;
import com.crawler.model.WyyUserExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

//@Repository("wyyUserMongoDBDao")
public class WyyUserMongoDBDaoImpl implements WyyUserMapper {
    @Autowired
    private MongoTemplate mongoTemplate;

    public long countByExample(WyyUserExample example) {
        return 0;
    }

    public int deleteByExample(WyyUserExample example) {
        return 0;
    }


    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }


    public int insert(WyyUser record) {
        mongoTemplate.insert(record);
        return 1;
    }


    public int insertSelective(WyyUser record) {
        return 0;
    }


    public List<WyyUser> selectByExample(WyyUserExample example) {
        return null;
    }


    public WyyUser selectByPrimaryKey(Integer id) {
        return null;
    }


    public int updateByExampleSelective(@Param("record") WyyUser record, @Param("example") WyyUserExample example) {
        return 0;
    }


    public int updateByExample(@Param("record") WyyUser record, @Param("example") WyyUserExample example) {
        return 0;
    }


    public int updateByPrimaryKeySelective(WyyUser record) {
        return 0;
    }


    public int updateByPrimaryKey(WyyUser record) {
        return 0;
    }
}