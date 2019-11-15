package com.wenqinghao.ordergoods.service.impl;

import com.wenqinghao.ordergoods.domain.entity.OrderGoods;
import com.wenqinghao.ordergoods.domain.vo.OrderGoodsVo;

import com.wenqinghao.ordergoods.mapper.OrderGoodsMapper;
import com.wenqinghao.ordergoods.service.OrderGoodsService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderGoodsServiceImpl implements OrderGoodsService {

    @Resource
    OrderGoodsMapper orderGoodsMapper;
    
    @Override
    public List<OrderGoodsVo> getListGoodsByOId(Integer oId) {
        List<OrderGoods> listGoodsByOId = orderGoodsMapper.getListGoodsByOId(oId);
        List<OrderGoodsVo> orderGoodsVos = new ArrayList<>();
        for (OrderGoods o:listGoodsByOId) {
            OrderGoodsVo orderGoodsVo = new OrderGoodsVo();
            BeanUtils.copyProperties(o,orderGoodsVo);
            orderGoodsVos.add(orderGoodsVo);
        }
        return orderGoodsVos;
    }

    @Override
    public Double getSpendByOIdAndGId(Integer oId, Integer gId) {
        return orderGoodsMapper.selectSpend(oId,gId);

    }
}
