package com.crawler.dao;

import com.crawler.model.wb.WbComments;
import com.crawler.model.wb.WbCommentsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WbCommentsMapper {
    long countByExample(WbCommentsExample example);

    int deleteByExample(WbCommentsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WbComments record);

    int insertSelective(WbComments record);

    List<WbComments> selectByExampleWithBLOBs(WbCommentsExample example);

    List<WbComments> selectByExample(WbCommentsExample example);

    WbComments selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WbComments record, @Param("example") WbCommentsExample example);

    int updateByExampleWithBLOBs(@Param("record") WbComments record, @Param("example") WbCommentsExample example);

    int updateByExample(@Param("record") WbComments record, @Param("example") WbCommentsExample example);

    int updateByPrimaryKeySelective(WbComments record);

    int updateByPrimaryKeyWithBLOBs(WbComments record);

    int updateByPrimaryKey(WbComments record);
}