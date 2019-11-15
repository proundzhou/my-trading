package com.wenqinghao.orderform.service;

import com.wenqinghao.orderform.domain.vo.OrderAndGoodsVo;

import java.util.List;

public interface OrderFormService {

    List<OrderAndGoodsVo> getOrdersByUid(Integer uId);
}
