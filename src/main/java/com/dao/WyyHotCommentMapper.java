package com.dao;

import com.model.WyyHotComment;
import com.model.WyyHotCommentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WyyHotCommentMapper {
    long countByExample(WyyHotCommentExample example);

    int deleteByExample(WyyHotCommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WyyHotComment record);

    int insertSelective(WyyHotComment record);

    List<WyyHotComment> selectByExample(WyyHotCommentExample example);

    WyyHotComment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WyyHotComment record, @Param("example") WyyHotCommentExample example);

    int updateByExample(@Param("record") WyyHotComment record, @Param("example") WyyHotCommentExample example);

    int updateByPrimaryKeySelective(WyyHotComment record);

    int updateByPrimaryKey(WyyHotComment record);
}