package com.wenqinghao.orderform.mapper;

import com.wenqinghao.orderform.domain.entity.OrderForm;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderFormMapper {

    //通过uId查询订单

    List<OrderForm> getOrdersByUid(@Param("uId") Integer uId);

    //通过订单oId删除订单(假删除)

    Integer deleteOrdersByOid(@Param("oId") Integer oId);


    Integer insertOrder(@Param("orderForm") OrderForm orderForm);

    //通过uId,oStatus订单状态查询订单

    List<OrderForm> getOrdersByUidAndByoStatus(@Param("uId") Integer uId,@Param("oStatus") Integer oStatus);

    //通过uId,evaluateStatus状态查询所有未评论订单

    List<OrderForm> getOrdersByUidAndByEvaluateStatus(@Param("uId") Integer uId);

    //通过订单oId修改订单状态oStatus

    Integer updateoStatusByOId(@Param("oId") Integer oId,@Param("oStatus") Integer oStatus);

    //通过订单oId修改评论状态evaluateStatus

    Integer updateEvaluateStatusByOId(@Param("oId") Integer oId);

}