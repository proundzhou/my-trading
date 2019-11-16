package com.wenqinghao.orderform.domain.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
public class OrderAndGoodsVo implements Serializable {
    private Integer oId;
    private Integer oStatus;
    private String oConsigneeInfo;
    private Date oCreateTime;
    private List<OrderGoodsVo> list;
}