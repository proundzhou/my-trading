package com.wenqinghao.ordeform.service.impl;

import com.wenqinghao.ordeform.domain.entity.OrderGoods;
import com.wenqinghao.ordeform.domain.vo.OrderGoodsVo;

import com.wenqinghao.ordeform.mapper.OrderGoodsMapper;
import com.wenqinghao.ordeform.service.OrderGoodsService;
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
}
