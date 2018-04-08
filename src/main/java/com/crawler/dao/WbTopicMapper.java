package com.crawler.dao;

import com.crawler.model.wb.WbTopic;
import com.crawler.model.wb.WbTopicExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WbTopicMapper {
    long countByExample(WbTopicExample example);

    int deleteByExample(WbTopicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WbTopic record);

    int insertSelective(WbTopic record);

    List<WbTopic> selectByExampleWithBLOBs(WbTopicExample example);

    List<WbTopic> selectByExample(WbTopicExample example);

    WbTopic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WbTopic record, @Param("example") WbTopicExample example);

    int updateByExampleWithBLOBs(@Param("record") WbTopic record, @Param("example") WbTopicExample example);

    int updateByExample(@Param("record") WbTopic record, @Param("example") WbTopicExample example);

    int updateByPrimaryKeySelective(WbTopic record);

    int updateByPrimaryKeyWithBLOBs(WbTopic record);

    int updateByPrimaryKey(WbTopic record);
}