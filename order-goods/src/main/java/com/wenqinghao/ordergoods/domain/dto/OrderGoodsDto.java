package com.wenqinghao.ordeform.domain.dto;

import lombok.Data;

@Data
public class OrderGoodsDto {
    /**
     * 订单id
     */
    private Integer oId;

    /**
     * 商品id
     */
    private Integer gId;
}
