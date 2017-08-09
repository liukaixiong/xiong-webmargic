package com.dao;

import com.model.tt.TtComment;
import com.model.tt.TtCommentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TtCommentMapper {
    long countByExample(TtCommentExample example);

    int deleteByExample(TtCommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TtComment record);

    int insertSelective(TtComment record);

    List<TtComment> selectByExample(TtCommentExample example);

    TtComment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TtComment record, @Param("example") TtCommentExample example);

    int updateByExample(@Param("record") TtComment record, @Param("example") TtCommentExample example);

    int updateByPrimaryKeySelective(TtComment record);

    int updateByPrimaryKey(TtComment record);
}