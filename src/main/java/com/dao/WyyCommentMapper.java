package com.dao;

import com.model.WyyComment;
import com.model.WyyCommentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WyyCommentMapper {
    long countByExample(WyyCommentExample example);

    int deleteByExample(WyyCommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WyyComment record);

    int insertSelective(WyyComment record);

    List<WyyComment> selectByExample(WyyCommentExample example);

    WyyComment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WyyComment record, @Param("example") WyyCommentExample example);

    int updateByExample(@Param("record") WyyComment record, @Param("example") WyyCommentExample example);

    int updateByPrimaryKeySelective(WyyComment record);

    int updateByPrimaryKey(WyyComment record);
}