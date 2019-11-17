package com.wqh.project.picturecenter.domain.dto;

import lombok.Data;

@Data
public class RefundDto {

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


}
