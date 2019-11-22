package com.wenqinghao.orderform.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.wenqinghao.orderform.domain.dto.OrderFormDto;
import com.wenqinghao.orderform.domain.dto.OrderGoodsDto;
import com.wenqinghao.orderform.domain.entity.OrderForm;
import com.wenqinghao.orderform.domain.vo.OrderAndGoodsVo;
import com.wenqinghao.orderform.domain.vo.OrderGoodsVo;
import com.wenqinghao.orderform.mapper.OrderFormMapper;
import com.wenqinghao.orderform.service.ExpressService;
import com.wenqinghao.orderform.service.OrderFormService;
import com.wenqinghao.orderform.service.OrderGoodsService;
import com.zhou.goodmanagement.domain.dto.GoodsDto;
import com.zhou.goodmanagement.service.GoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
public class OrderServiceImpl implements OrderFormService {

    @Resource
    OrderFormMapper orderFormMapper;

    @Resource
    OrderGoodsService orderGoodsService;

    @Resource
    ExpressService expressService;

    @Override
    public List<OrderAndGoodsVo> getOrdersByUid(Integer uId) {
        List<OrderForm> ordersByUid = orderFormMapper.getOrdersByUid(uId);
        List<OrderAndGoodsVo> orderAndGoodsVos = new ArrayList<>();
        GoodService goodService = new GoodService();
        for (OrderForm o :ordersByUid) {
            List<OrderGoodsVo> listGoodsByOId = orderGoodsService.getListGoodsByOId(o.getOId());
            for (OrderGoodsVo goodsVo  : listGoodsByOId){
                Integer gId = goodsVo.getGId();
                GoodsDto goods = goodService.getGoods(gId);
                goodsVo.setGoodsDto(goods);
            }
            OrderAndGoodsVo orderAndGoodsVo = new OrderAndGoodsVo();
            BeanUtils.copyProperties(o,orderAndGoodsVo);
            orderAndGoodsVo.setList(listGoodsByOId);
            orderAndGoodsVos.add(orderAndGoodsVo);
            Integer oExpressNumber = o.getOExpressNumber();
            String s = oExpressNumber.toString();
            JSONObject jsonObject = expressService.fetchCom(s);
            orderAndGoodsVo.setJsonObject(jsonObject);
        }
        return orderAndGoodsVos;
    }


    @Override
    public Integer newOrder(OrderFormDto orderFormDto) {
        /*===============分布式事务=============*/
        //分布式生成唯一订单号
        long Id = System.currentTimeMillis();
        /*大转小，数据丢失，仅作演示*/
        Integer oId = (int) Id;

        //提取商品情况
        List<OrderGoodsDto> goods = orderFormDto.getGoods();
        //调用商品服务检查商品是否有库存，修改商品信息，使用事务，一次改多行商品库存记录
        //生成关联表
        for (OrderGoodsDto orderGoods : goods
             ) {
            orderGoods.setOId(oId);
        }
        String result2 = orderGoodsService.addOrderGoods(goods);
        //假设商品库存有，建立订单
        OrderForm orderForm = new OrderForm();
        orderForm.setOId(oId);
        orderForm.setUId(orderFormDto.getUId());
        orderForm.setOSpend(orderFormDto.getOSpend());
        orderForm.setOConsigneeInfo(orderFormDto.getOConsigneeInfo());
        Integer count = orderFormMapper.insertOrder(orderForm);
        if(count>0){
            log.info("订单生成成功");
        }

        
        return oId;
    }

    @Override
    public String deleteOrdersByOid(Integer oId) {
        Integer integer = orderFormMapper.deleteOrdersByOid(oId);
        if (integer > 0){
            return "删除订单成功";
        }
        return "删除订单失败";
    }

    @Override
    public List<OrderAndGoodsVo> getOrdersByUidAndByoStatus(Integer uId, Integer oStatus) {
        List<OrderForm> ordersByUidAndByOId = orderFormMapper.getOrdersByUidAndByoStatus(uId, oStatus);
        List<OrderAndGoodsVo> orderAndGoodsVos = new ArrayList<>();
        GoodService goodService = new GoodService();
        for (OrderForm o :ordersByUidAndByOId) {
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

    @Override
    public List<OrderAndGoodsVo> getOrdersByUidAndByEvaluateStatus(Integer uId) {
        List<OrderForm> ordersByUidAndByOId = orderFormMapper.getOrdersByUidAndByEvaluateStatus(uId);
        List<OrderAndGoodsVo> orderAndGoodsVos = new ArrayList<>();
        GoodService goodService = new GoodService();
        for (OrderForm o :ordersByUidAndByOId) {
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

    @Override
    public String updateoStatusByOId(Integer uId, Integer oStatus) {
        Integer integer = orderFormMapper.updateoStatusByOId(uId, oStatus);
        if (integer > 0){
            return "修改成功";
        }
        return "修改失败";
    }

    @Override
    public String updateEvaluateStatusByOId(Integer oId) {
        Integer integer = orderFormMapper.updateEvaluateStatusByOId(oId);
        if (integer > 0){
            return "修改成功";
        }
        return "修改失败";
    }
}
