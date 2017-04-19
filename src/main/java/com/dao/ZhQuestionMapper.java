package com.dao;

import com.model.zh.ZhQuestion;
import com.model.zh.ZhQuestionExample;
import com.model.zh.ZhQuestionKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZhQuestionMapper {
    long countByExample(ZhQuestionExample example);

    int deleteByExample(ZhQuestionExample example);

    int deleteByPrimaryKey(ZhQuestionKey key);

    int insert(ZhQuestion record);

    int insertSelective(ZhQuestion record);

    List<ZhQuestion> selectByExampleWithBLOBs(ZhQuestionExample example);

    List<ZhQuestion> selectByExample(ZhQuestionExample example);

    ZhQuestion selectByPrimaryKey(ZhQuestionKey key);

    int updateByExampleSelective(@Param("record") ZhQuestion record, @Param("example") ZhQuestionExample example);

    int updateByExampleWithBLOBs(@Param("record") ZhQuestion record, @Param("example") ZhQuestionExample example);

    int updateByExample(@Param("record") ZhQuestion record, @Param("example") ZhQuestionExample example);

    int updateByPrimaryKeySelective(ZhQuestion record);

    int updateByPrimaryKeyWithBLOBs(ZhQuestion record);

    int updateByPrimaryKey(ZhQuestion record);
}