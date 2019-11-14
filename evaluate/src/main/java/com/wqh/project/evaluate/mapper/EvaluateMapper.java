package com.wqh.project.evaluate.mapper;

import com.wqh.project.evaluate.domain.entity.Evaluate;

/**
*   @author  wen
*   11:51
*/
public interface EvaluateMapper {
    int deleteByPrimaryKey(Integer eId);

    int insert(Evaluate record);

    int insertSelective(Evaluate record);

    Evaluate selectByPrimaryKey(Integer eId);

    int updateByPrimaryKeySelective(Evaluate record);

    int updateByPrimaryKey(Evaluate record);
}