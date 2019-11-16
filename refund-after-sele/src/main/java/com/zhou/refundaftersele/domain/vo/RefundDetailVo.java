package com.zhou.refundaftersele.domain.vo;


import lombok.Data;

import java.util.Date;

@Data
public class RefundDetailVo {
    //退款编号
    private Integer rId;

    //商品id，前端不使用
    private Integer gId;

    //退款金额
    private Integer rMoney;

    //申请时间
    private Date rCreateTime;

    //钱款流向
    private Byte moneyFlow;

    //退款状态
    private Byte rStatus;
}
