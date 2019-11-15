package com.wenqinghao.ordeform.mapper;

import com.wenqinghao.ordeform.domain.entity.OrderGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderGoodsMapper {
    List<OrderGoods> getListGoodsByOId(@Param("oId") Integer oId);
}