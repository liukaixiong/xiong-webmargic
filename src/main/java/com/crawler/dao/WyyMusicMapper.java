package com.crawler.dao;

import com.crawler.model.WyyMusic;
import com.crawler.model.WyyMusicExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WyyMusicMapper {
    long countByExample(WyyMusicExample example);

    int deleteByExample(WyyMusicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WyyMusic record);

    int insertSelective(WyyMusic record);

    List<WyyMusic> selectByExample(WyyMusicExample example);

    WyyMusic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WyyMusic record, @Param("example") WyyMusicExample example);

    int updateByExample(@Param("record") WyyMusic record, @Param("example") WyyMusicExample example);

    int updateByPrimaryKeySelective(WyyMusic record);

    int updateByPrimaryKey(WyyMusic record);
}