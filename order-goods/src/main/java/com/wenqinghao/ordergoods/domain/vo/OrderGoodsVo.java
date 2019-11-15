package com.wenqinghao.ordergoods.domain.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderGoodsVo implements Serializable {
    private Integer gId;
    private Integer quantity;
    private double oSpend;
}
