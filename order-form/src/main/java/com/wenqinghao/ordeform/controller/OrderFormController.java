package com.wenqinghao.ordeform.controller;

import com.wenqinghao.ordeform.domain.vo.OrderAndGoodsVo;
import com.wenqinghao.ordeform.service.OrderFormService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
