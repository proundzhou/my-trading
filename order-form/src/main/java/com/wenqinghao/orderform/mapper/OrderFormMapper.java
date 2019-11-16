package com.wenqinghao.orderform.mapper;

import com.wenqinghao.orderform.domain.entity.OrderForm;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderFormMapper {

    //通过uId查询订单

    List<OrderForm> getOrdersByUid(@Param("uId") Integer uId);

    //通过订单oId删除订单(假删除)

    Integer deleteOrdersByOid(Integer oId);


    Integer insertOrder(@Param("orderForm") OrderForm orderForm);
}