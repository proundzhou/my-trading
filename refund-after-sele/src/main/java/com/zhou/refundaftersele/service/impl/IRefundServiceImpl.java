package com.zhou.refundaftersele.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.zhou.goodmanagement.domain.dto.GoodsDto;
import com.zhou.goodmanagement.service.GoodService;
import com.zhou.refundaftersele.domain.dto.AliBankInfo;
import com.zhou.refundaftersele.domain.dto.OrderMapDto;
import com.zhou.refundaftersele.domain.dto.RefundDto;
import com.zhou.refundaftersele.domain.entity.RefundOrder;
import com.zhou.refundaftersele.domain.vo.MoneyFlowVo;
import com.zhou.refundaftersele.domain.vo.RefundInfoVo;
import com.zhou.refundaftersele.domain.vo.RefundOrderVo;
import com.zhou.refundaftersele.mapper.RefundOrderMapper;
import com.zhou.refundaftersele.service.IFileUploadService;
import com.zhou.refundaftersele.service.IOrderDetailService;
import com.zhou.refundaftersele.service.IRefundService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class IRefundServiceImpl implements IRefundService {

    @Resource
    RefundOrderMapper refundOrderMapper;

    @Resource
    IFileUploadService fileUploadService;

    @Resource
    IOrderDetailService orderDetailService;

    @Override
    public MoneyFlowVo getMoneyFlowByRId(Integer rId) {
        MoneyFlowVo moneyFlowVo = new MoneyFlowVo();
        /*获取退款信息*/
        RefundOrder refundOrder = refundOrderMapper.selectByPrimaryKey(rId);
        log.info(refundOrder.toString());
        RefundOrderVo orderVo = new RefundOrderVo();

        /*设置编号,时间，退款状态，金额,*/
        BeanUtils.copyProperties(refundOrder, orderVo);

        /*获取银行卡数据*/
        Integer rBankCard = refundOrder.getRBankCard();

        //向ali接口发送请求
        String bankInfoJson = null;
        URI uri = URI.create("https://ccdcapi.alipay.com/validateAndCacheCardInfo.json?cardBinCheck=true&cardNo=" + rBankCard.toString());
        try {
            URL url = uri.toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(HttpMethod.POST.name());
            connection.setDoOutput(true);
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            bankInfoJson = reader.readLine();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*请求出错检测*/
        if (bankInfoJson == null) {
            log.info("ali银行信息接口出错");
            return null;
        }

        //解析返回的json字符串
        Object bankInfoObject = JSONObject.parse(bankInfoJson);
        AliBankInfo bankInfo = new AliBankInfo();
        BeanUtils.copyProperties(bankInfoObject, bankInfo);
        if (bankInfo.getStat() != "ok" || !bankInfo.getValidated()) {
            log.info("银行卡号出错");
        }
        //写入银行卡号数据
        moneyFlowVo.setBank(bankInfo.getBank());
        moneyFlowVo.setRBankCard(rBankCard % 10000);

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

        for (RefundOrder refund : refundOrders) {
            RefundInfoVo refundInfoVo = new RefundInfoVo();
            RefundOrderVo refundOrderVo = new RefundOrderVo();

            //获取退款业务信息
            BeanUtils.copyProperties(refund, refundOrderVo);
            refundInfoVo.setRefundOrderVo(refundOrderVo);

            //获取退款商品信息
            //GoodsDto goodstrue = goodService.getGoods(refundOrder.getGId());
            GoodsDto goods = goodService.getGoods(1);
            refundInfoVo.setGoodsDto(goods);

            //获取退款项购买信息,调用服务输入订单id，商品Id，返回订单金额
            Double spend = orderDetailService.getSpend(new OrderMapDto(refund.getOId(), refund.getGId()));
            refundInfoVo.setSpend(spend);

            //添加进列表
            RefundInfoVos.add(refundInfoVo);
        }

        return RefundInfoVos;
    }

    @Override
    public String addRefundRecord(MultipartFile[] files, RefundDto refundDto) {

        RefundOrder refundOrder = new RefundOrder();
        //生成分布式ID（仅作演示用）
        long timeMillis = System.currentTimeMillis();
        refundOrder.setRId((int) timeMillis);
        //记录退款信息
        BeanUtils.copyProperties(refundDto, refundOrder);
        //存储退款凭证图片，记录图片路径
        String path = fileUploadService.ImgUpload(files);
        refundOrder.setRImg(path);
        //银行卡号不知从何而来
        //插入记录
        Integer insert = refundOrderMapper.insert(refundOrder);
        if (insert > 0) {
            //向商户端发送退款消息
            return "success";
        }
        return "failed";
    }
}
