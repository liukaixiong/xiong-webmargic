package com.dao;

import com.model.task.TaskUrlList;
import com.model.task.TaskUrlListExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskUrlListMapper {
    long countByExample(TaskUrlListExample example);

    int deleteByExample(TaskUrlListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TaskUrlList record);

    int insertSelective(TaskUrlList record);

    List<TaskUrlList> selectByExample(TaskUrlListExample example);

    TaskUrlList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TaskUrlList record, @Param("example") TaskUrlListExample example);

    int updateByExample(@Param("record") TaskUrlList record, @Param("example") TaskUrlListExample example);

    int updateByPrimaryKeySelective(TaskUrlList record);

    int updateByPrimaryKey(TaskUrlList record);
}