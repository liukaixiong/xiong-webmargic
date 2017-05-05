package com.dao.mongodb;

import com.dao.WyyCommentMapper;
import com.model.WyyComment;
import com.model.WyyCommentExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * mongodb操作
 *
 * @author Liukx
 * @create 2017-05-02 16:47
 * @email liukx@elab-plus.com
 **/
@Repository("wyyMongoDb")
public class WyyMongoDBImpl implements WyyCommentMapper {

    @Autowired
    private MongoTemplate mongoTemplate;

    public long countByExample(WyyCommentExample example) {
        return 0;
    }

    public int deleteByExample(WyyCommentExample example) {
        return 0;
    }

    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    public int insert(WyyComment record) {
        mongoTemplate.insert(record);
        return 1;
    }

    public int insertSelective(WyyComment record) {
        return 0;
    }

    public List<WyyComment> selectByExample(WyyCommentExample example) {
        return null;
    }

    public WyyComment selectByPrimaryKey(Integer id) {
        return null;
    }

    public int updateByExampleSelective(@Param("record") WyyComment record, @Param("example") WyyCommentExample example) {
        return 0;
    }

    public int updateByExample(@Param("record") WyyComment record, @Param("example") WyyCommentExample example) {
        return 0;
    }

    public int updateByPrimaryKeySelective(WyyComment record) {
        return 0;
    }

    public int updateByPrimaryKey(WyyComment record) {
        return 0;
    }
}
