package com.dao;

import com.model.zh.ZhAnswer;
import com.model.zh.ZhAnswerExample;
import com.model.zh.ZhAnswerKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZhAnswerMapper {
    long countByExample(ZhAnswerExample example);

    int deleteByExample(ZhAnswerExample example);

    int deleteByPrimaryKey(ZhAnswerKey key);

    int insert(ZhAnswer record);

    int insertSelective(ZhAnswer record);

    List<ZhAnswer> selectByExampleWithBLOBs(ZhAnswerExample example);

    List<ZhAnswer> selectByExample(ZhAnswerExample example);

    ZhAnswer selectByPrimaryKey(ZhAnswerKey key);

    int updateByExampleSelective(@Param("record") ZhAnswer record, @Param("example") ZhAnswerExample example);

    int updateByExampleWithBLOBs(@Param("record") ZhAnswer record, @Param("example") ZhAnswerExample example);

    int updateByExample(@Param("record") ZhAnswer record, @Param("example") ZhAnswerExample example);

    int updateByPrimaryKeySelective(ZhAnswer record);

    int updateByPrimaryKeyWithBLOBs(ZhAnswer record);

    int updateByPrimaryKey(ZhAnswer record);
}