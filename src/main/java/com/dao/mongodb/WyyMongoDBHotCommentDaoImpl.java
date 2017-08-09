package com.dao.mongodb;

import com.dao.WyyHotCommentMapper;
import com.model.WyyHotComment;
import com.model.WyyHotCommentExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

/**
 * 网易云mongdb热评存储
 *
 * @author Liukx
 * @create 2017-05-05 14:16
 * @email liukx@elab-plus.com
 **/
//@Repository("wyyMongoDBHotCommentDao")
public class WyyMongoDBHotCommentDaoImpl implements WyyHotCommentMapper {
    @Autowired
    private MongoTemplate mongoTemplate;

    public long countByExample(WyyHotCommentExample example) {
        return 0;
    }

    public int deleteByExample(WyyHotCommentExample example) {
        return 0;
    }

    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    public int insert(WyyHotComment record) {
        mongoTemplate.insert(record);
        return 1;
    }

    public int insertSelective(WyyHotComment record) {
        return 0;
    }

    public List<WyyHotComment> selectByExample(WyyHotCommentExample example) {
        return null;
    }

    public WyyHotComment selectByPrimaryKey(Integer id) {
        return null;
    }


    public int updateByExampleSelective(@Param("record") WyyHotComment record, @Param("example") WyyHotCommentExample example) {
        return 0;
    }


    public int updateByExample(@Param("record") WyyHotComment record, @Param("example") WyyHotCommentExample example) {
        return 0;
    }


    public int updateByPrimaryKeySelective(WyyHotComment record) {
        return 0;
    }


    public int updateByPrimaryKey(WyyHotComment record) {
        return 0;
    }
}
