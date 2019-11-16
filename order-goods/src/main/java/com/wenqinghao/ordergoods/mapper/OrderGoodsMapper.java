package com.wenqinghao.ordergoods.mapper;

import com.wenqinghao.ordergoods.domain.dto.OrderGoodsDto;
import com.wenqinghao.ordergoods.domain.entity.OrderGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderGoodsMapper {
    List<OrderGoods> getListGoodsByOId(@Param("oId") Integer oId);

    Double selectSpend(@Param("oId")Integer oId, @Param("gId") Integer gId);

    Integer insertOrderGoods(List<OrderGoodsDto> goods);
}