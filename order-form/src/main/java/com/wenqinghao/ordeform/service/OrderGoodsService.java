package com.wenqinghao.ordeform.service;

import com.wenqinghao.ordeform.domain.vo.OrderGoodsVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("order-goods")
public interface OrderGoodsService {

    @RequestMapping("/orderGoods/getListGoodsByOId/{oId}")
    List<OrderGoodsVo> getListGoodsByOId(@PathVariable Integer oId);

}
