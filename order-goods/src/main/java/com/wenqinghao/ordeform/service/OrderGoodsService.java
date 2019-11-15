package com.wenqinghao.ordeform.service;


import com.wenqinghao.ordeform.domain.vo.OrderGoodsVo;

import java.util.List;

public interface OrderGoodsService {
    List<OrderGoodsVo> getListGoodsByOId(Integer oId);
}

