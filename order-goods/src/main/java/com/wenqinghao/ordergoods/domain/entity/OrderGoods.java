package com.wenqinghao.ordergoods.domain.entity;

import lombok.Data;

@Data
public class OrderGoods {
    /**
    * 订单id
    */
    private Integer oId;

    /**
    * 商品id
    */
    private Integer gId;

    /**
    * 商品数量
    */
    private Integer quantity;

    /**
     * 总计金额
     */
    private double oSpend;
}