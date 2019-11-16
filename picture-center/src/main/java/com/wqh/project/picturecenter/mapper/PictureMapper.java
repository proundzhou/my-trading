package com.wqh.project.picturecenter.mapper;

import com.wqh.project.picturecenter.domain.entity.Picture;

/**
*   @author  wen
*   19:53
*/
public interface PictureMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(Picture record);

    int insertSelective(Picture record);

    Picture selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(Picture record);

    int updateByPrimaryKey(Picture record);
}