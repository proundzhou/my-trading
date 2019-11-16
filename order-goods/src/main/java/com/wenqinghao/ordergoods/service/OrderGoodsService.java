package com.wenqinghao.ordergoods.service;


import com.wenqinghao.ordergoods.domain.dto.OrderGoodsDto;
import com.wenqinghao.ordergoods.domain.vo.OrderGoodsVo;

import java.util.List;

public interface OrderGoodsService {
    List<OrderGoodsVo> getListGoodsByOId(Integer oId);

    Double getSpendByOIdAndGId(Integer oId, Integer gId);

    String addOrderGoods(List<OrderGoodsDto> goods);
}

