package com.dao;

import com.model.WyyUser;
import com.model.WyyUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WyyUserMapper {
    long countByExample(WyyUserExample example);

    int deleteByExample(WyyUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WyyUser record);

    int insertSelective(WyyUser record);

    List<WyyUser> selectByExample(WyyUserExample example);

    WyyUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WyyUser record, @Param("example") WyyUserExample example);

    int updateByExample(@Param("record") WyyUser record, @Param("example") WyyUserExample example);

    int updateByPrimaryKeySelective(WyyUser record);

    int updateByPrimaryKey(WyyUser record);
}