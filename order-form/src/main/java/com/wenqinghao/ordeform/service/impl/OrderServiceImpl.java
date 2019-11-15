package com.wenqinghao.ordeform.service.impl;

import com.wenqinghao.ordeform.domain.entity.OrderForm;
import com.wenqinghao.ordeform.domain.vo.OrderAndGoodsVo;
import com.wenqinghao.ordeform.domain.vo.OrderGoodsVo;
import com.wenqinghao.ordeform.mapper.OrderFormMapper;
import com.wenqinghao.ordeform.service.OrderFormService;
import com.wenqinghao.ordeform.service.OrderGoodsService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderFormService {

    @Resource
    OrderFormMapper orderFormMapper;

    @Resource
    OrderGoodsService orderGoodsService;

    @Override
    public List<OrderAndGoodsVo> getOrdersByUid(Integer uId) {
        List<OrderForm> ordersByUid = orderFormMapper.getOrdersByUid(uId);
        List<OrderAndGoodsVo> orderAndGoodsVos = new ArrayList<>();
        for (OrderForm o :ordersByUid) {
            Integer oId = o.getOId();
            List<OrderGoodsVo> listGoodsByOId = orderGoodsService.getListGoodsByOId(oId);
            OrderAndGoodsVo orderAndGoodsVo = new OrderAndGoodsVo();
            BeanUtils.copyProperties(o,orderAndGoodsVo);
            orderAndGoodsVo.setList(listGoodsByOId);
            orderAndGoodsVos.add(orderAndGoodsVo);
        }
        return orderAndGoodsVos;
    }
}
