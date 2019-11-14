package com.zhou.refundaftersele.service;

import com.zhou.refundaftersele.domain.dto.OrderMapDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient("order-management")
public interface IOrderService {

    //@RequestMapping(value = "/order/orderDetailInfo",method = RequestMethod.POST)
    Double getSpend(/*@RequestBody*/ OrderMapDto orderMapDto);

}
