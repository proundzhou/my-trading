package com.wenqinghao.orderform.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class OrderGoodsDto implements Serializable {

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
