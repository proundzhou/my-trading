package com.wenqinghao.orderform.service.impl;

import com.wenqinghao.orderform.domain.entity.OrderForm;
import com.wenqinghao.orderform.domain.vo.OrderAndGoodsVo;
import com.wenqinghao.orderform.domain.vo.OrderGoodsVo;
import com.wenqinghao.orderform.mapper.OrderFormMapper;
import com.wenqinghao.orderform.service.OrderFormService;
import com.wenqinghao.orderform.service.OrderGoodsService;
import com.zhou.goodmanagement.domain.dto.GoodsDto;
import com.zhou.goodmanagement.service.GoodService;
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
        GoodService goodService = new GoodService();
        for (OrderForm o :ordersByUid) {
            Integer oId = o.getOId();
            List<OrderGoodsVo> listGoodsByOId = orderGoodsService.getListGoodsByOId(oId);
            for (OrderGoodsVo goodsVo  : listGoodsByOId){
                Integer gId = goodsVo.getGId();
                GoodsDto goods = goodService.getGoods(gId);
                goodsVo.setGoodsDto(goods);
            }
            OrderAndGoodsVo orderAndGoodsVo = new OrderAndGoodsVo();
            BeanUtils.copyProperties(o,orderAndGoodsVo);
            orderAndGoodsVo.setList(listGoodsByOId);
            orderAndGoodsVos.add(orderAndGoodsVo);
        }
        return orderAndGoodsVos;
    }
}
