package com.wenqinghao.orderform.service;

import com.wenqinghao.orderform.domain.dto.OrderGoodsDto;

import java.util.List;

public interface IGoodService {
    String reduceGoods(List<OrderGoodsDto> goods);
}
