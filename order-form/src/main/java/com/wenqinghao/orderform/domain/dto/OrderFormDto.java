package com.wenqinghao.orderform.domain.dto;

import com.wenqinghao.ordergoods.domain.entity.OrderGoods;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class OrderFormDto implements Serializable {

    /**
     * 用户Id
     */
    private Integer uId;
    /**
     * 商品信息列表
     */
    List<OrderGoodsDto> goods;
    /**
     * 收货人地址
     */
    String oConsigneeInfo;
    /**
     * 总计金额
     */
    Double oSpend;



}
