package com.wenqinghao.orderform.controller;

import com.wenqinghao.orderform.domain.dto.OrderFormDto;
import com.wenqinghao.orderform.domain.entity.OrderForm;
import com.wenqinghao.orderform.domain.vo.OrderAndGoodsVo;
import com.wenqinghao.orderform.service.OrderFormService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderFormController {

    @Resource
    OrderFormService orderFormService;

    @RequestMapping("/getOrdersByUid/{uId}")
    public List<OrderAndGoodsVo> getOrdersByUid(@PathVariable Integer uId){
        List<OrderAndGoodsVo> ordersByUid = orderFormService.getOrdersByUid(uId);
        return ordersByUid;
    }


    @RequestMapping(value = "/newOrder",method = RequestMethod.POST)
    public Integer newOrder(OrderFormDto orderFormDto){
        return orderFormService.newOrder(orderFormDto);
    }



}
