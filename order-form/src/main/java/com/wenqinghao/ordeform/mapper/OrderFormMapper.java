package com.wenqinghao.ordeform.mapper;

import com.wenqinghao.ordeform.domain.entity.OrderForm;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderFormMapper {

    //通过uId查询订单

    List<OrderForm> getOrdersByUid(@Param("uId") Integer uId);

}