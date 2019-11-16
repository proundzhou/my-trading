package com.wenqinghao.orderform.domain.vo;

import com.zhou.goodmanagement.domain.dto.GoodsDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class OrderGoodsVo implements Serializable {
    private Integer gId;
    private Integer quantity;
    private Double OSpend;
    private GoodsDto goodsDto;
}
