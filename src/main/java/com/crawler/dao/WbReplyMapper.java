package com.crawler.dao;

import com.crawler.model.wb.WbReply;
import com.crawler.model.wb.WbReplyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WbReplyMapper {
    long countByExample(WbReplyExample example);

    int deleteByExample(WbReplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WbReply record);

    int insertSelective(WbReply record);

    List<WbReply> selectByExampleWithBLOBs(WbReplyExample example);

    List<WbReply> selectByExample(WbReplyExample example);

    WbReply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WbReply record, @Param("example") WbReplyExample example);

    int updateByExampleWithBLOBs(@Param("record") WbReply record, @Param("example") WbReplyExample example);

    int updateByExample(@Param("record") WbReply record, @Param("example") WbReplyExample example);

    int updateByPrimaryKeySelective(WbReply record);

    int updateByPrimaryKeyWithBLOBs(WbReply record);

    int updateByPrimaryKey(WbReply record);
}