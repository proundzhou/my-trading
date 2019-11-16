package com.wenqinghao.orderform.service;

import com.wenqinghao.orderform.domain.dto.OrderFormDto;
import com.wenqinghao.orderform.domain.entity.OrderForm;
import com.wenqinghao.orderform.domain.vo.OrderAndGoodsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderFormService {

    List<OrderAndGoodsVo> getOrdersByUid(Integer uId);

    Integer newOrder(OrderFormDto orderFormDto);

    String deleteOrdersByOid(Integer oId);

    List<OrderAndGoodsVo> getOrdersByUidAndByoStatus(Integer uId,Integer oStatus);

    List<OrderAndGoodsVo> getOrdersByUidAndByEvaluateStatus(Integer uId);

    String updateoStatusByOId(Integer uId,Integer oStatus);

    String updateEvaluateStatusByOId(Integer oId);
}
