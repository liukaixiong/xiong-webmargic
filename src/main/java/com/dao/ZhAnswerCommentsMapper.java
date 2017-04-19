package com.dao;

import com.model.zh.ZhAnswerComments;
import com.model.zh.ZhAnswerCommentsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZhAnswerCommentsMapper {
    long countByExample(ZhAnswerCommentsExample example);

    int deleteByExample(ZhAnswerCommentsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ZhAnswerComments record);

    int insertSelective(ZhAnswerComments record);

    List<ZhAnswerComments> selectByExampleWithBLOBs(ZhAnswerCommentsExample example);

    List<ZhAnswerComments> selectByExample(ZhAnswerCommentsExample example);

    ZhAnswerComments selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ZhAnswerComments record, @Param("example") ZhAnswerCommentsExample example);

    int updateByExampleWithBLOBs(@Param("record") ZhAnswerComments record, @Param("example") ZhAnswerCommentsExample example);

    int updateByExample(@Param("record") ZhAnswerComments record, @Param("example") ZhAnswerCommentsExample example);

    int updateByPrimaryKeySelective(ZhAnswerComments record);

    int updateByPrimaryKeyWithBLOBs(ZhAnswerComments record);

    int updateByPrimaryKey(ZhAnswerComments record);
}