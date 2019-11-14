package com.zhou.refundaftersele.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zhou.goodmanagement.domain.dto.GoodsDto;
import com.zhou.goodmanagement.service.GoodService;
import com.zhou.refundaftersele.domain.dto.AliBankInfo;
import com.zhou.refundaftersele.domain.entity.RefundOrder;
import com.zhou.refundaftersele.domain.vo.MoneyFlowVo;
import com.zhou.refundaftersele.domain.vo.RefundInfoVo;
import com.zhou.refundaftersele.domain.vo.RefundOrderVo;
import com.zhou.refundaftersele.mapper.RefundOrderMapper;
import com.zhou.refundaftersele.service.IOrderService;
import com.zhou.refundaftersele.service.IRefundService;
import jdk.nashorn.internal.ir.CallNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class IRefundServiceImpl implements IRefundService {

    @Resource
    RefundOrderMapper refundOrderMapper;

    @Resource
    IOrderService orderService;

    @Resource
    private RestTemplate restTemplate;

    @Override
    public MoneyFlowVo getMoneyFlowByRId(Integer rId) {
        MoneyFlowVo moneyFlowVo = new MoneyFlowVo();
        /*获取退款信息*/
        RefundOrder refundOrder = refundOrderMapper.selectByPrimaryKey(rId);
        RefundOrderVo orderVo = new RefundOrderVo();

        /*设置编号,时间，退款状态，金额,*/
        BeanUtils.copyProperties(refundOrder,orderVo);

        /*获取银行卡数据*/
        Integer rBankCard = refundOrder.getRBankCard();
        String url = "https://ccdcapi.alipay.com/validateAndCacheCardInfo.json?cardBinCheck=true&cardNo=";
        String bankInfoJson = restTemplate.getForObject(url + rBankCard.toString(), String.class);
        AliBankInfo bankInfo = (AliBankInfo)JSONObject.parse(bankInfoJson);
        if(bankInfo.getStat()!="ok" || !bankInfo.getValidated()){
            log.info("银行卡号出错");
        }
        moneyFlowVo.setBank(bankInfo.getBank());
        moneyFlowVo.setRBankCard(rBankCard%10000);

        /*假商品数据来源*/
        GoodService goodService = new GoodService();
        //GoodsDto goodstrue = goodService.getGoods(refundOrder.getGId());
        GoodsDto goods = goodService.getGoods(1);
        moneyFlowVo.setGoods(goods);

        return moneyFlowVo;
    }

    @Override
    public List<RefundInfoVo> getRefundListByUId(Integer uId) {
        List<RefundOrder> refundOrders = refundOrderMapper.selectByUId(uId);
        ArrayList<RefundInfoVo> RefundInfoVos = new ArrayList<>();


        /*假商品数据来源*/
        GoodService goodService = new GoodService();

        for (RefundOrder refund:refundOrders) {
            RefundInfoVo refundInfoVo = new RefundInfoVo();
            RefundOrderVo refundOrderVo = new RefundOrderVo();

            //获取退款业务信息
            BeanUtils.copyProperties(refund,refundOrderVo);
            refundInfoVo.setRefundOrderVo(refundOrderVo);

            //获取退款商品信息
            //GoodsDto goodstrue = goodService.getGoods(refundOrder.getGId());
            GoodsDto goods = goodService.getGoods(1);
            refundInfoVo.setGoodsDto(goods);

            //获取退款项购买信息,调用服务输入订单id，商品Id，返回订单金额
            Double spend = orderService.getSpend(refund.getOId(),refund.getGId());
            refundInfoVo.setSpend(spend);

            //添加进列表
            RefundInfoVos.add(refundInfoVo);
        }

        return RefundInfoVos;
    }
}
