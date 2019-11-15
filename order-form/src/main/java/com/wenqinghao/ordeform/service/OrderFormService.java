package com.wenqinghao.ordeform.service;



import com.wenqinghao.ordeform.domain.vo.OrderAndGoodsVo;

import java.util.List;

public interface OrderFormService {

    List<OrderAndGoodsVo> getOrdersByUid(Integer uId);
}
