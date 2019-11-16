package com.wenqinghao.orderform.service;

import com.wenqinghao.orderform.domain.dto.OrderGoodsDto;
import com.wenqinghao.orderform.domain.vo.OrderGoodsVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("order-goods")
public interface OrderGoodsService {

    @RequestMapping("/orderGoods/getListGoodsByOId/{oId}")
    List<OrderGoodsVo> getListGoodsByOId(@PathVariable Integer oId);

    @RequestMapping(value="/orderGoods/addOrderGoods",method = RequestMethod.POST)
    String addOrderGoods(@RequestBody List<OrderGoodsDto> goods);
}
