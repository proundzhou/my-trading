package com.wenqinghao.ordergoods.controller;

import com.wenqinghao.ordergoods.domain.vo.OrderGoodsVo;
import com.wenqinghao.ordergoods.service.OrderGoodsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/orderGoods")
public class OrderGoodsController {

    @Resource
    OrderGoodsService orderGoodsService;

    @RequestMapping("/getListGoodsByOId/{oId}")
    public List<OrderGoodsVo> getListGoodsByOId(@PathVariable Integer oId){
        List<OrderGoodsVo> listGoodsByOId = orderGoodsService.getListGoodsByOId(oId);
        return listGoodsByOId;
    }
}
