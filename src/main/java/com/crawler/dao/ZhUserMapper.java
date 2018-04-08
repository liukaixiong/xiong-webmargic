package com.crawler.dao;

import com.crawler.model.zh.ZhUser;
import com.crawler.model.zh.ZhUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZhUserMapper {
    long countByExample(ZhUserExample example);

    int deleteByExample(ZhUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ZhUser record);

    int insertSelective(ZhUser record);

    List<ZhUser> selectByExample(ZhUserExample example);

    ZhUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ZhUser record, @Param("example") ZhUserExample example);

    int updateByExample(@Param("record") ZhUser record, @Param("example") ZhUserExample example);

    int updateByPrimaryKeySelective(ZhUser record);

    int updateByPrimaryKey(ZhUser record);
}