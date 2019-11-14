package com.zhou.refundaftersele.domain.entity;

import java.util.Date;
import lombok.Data;

@Data
public class RefundOrder {
    /**
     * 退款情况Id
     */
    private Integer rId;

    /**
     * 用户Id
     */
    private Integer uId;

    /**
     * 订单id
     */
    private Integer oId;

    /**
     * 商品id
     */
    private Integer gId;

    /**
     * 退款类型
     */
    private String rType;

    /**
     * 退款原因
     */
    private String rReason;

    /**
     * 退款金额
     */
    private Integer rMoney;

    /**
     * 退款说明
     */
    private String rExplain;

    /**
     * 银行卡号
     */
    private Integer rBankCard;

    /**
     * 图片地址，仅记录到文件夹
     */
    private String rImg;

    /**
     * 交易状态，正在申请退款(40),退款成功(45)
     */
    private Byte rStatus;

    /**
     * 退款创建时间
     */
    private Date rCreateTime;

    /**
     * 钱款去向，卖家退款（0）银行（1）退款成功（2）
     */
    private Byte moneyFlow;
}