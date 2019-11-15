package com.wenqinghao.ordeform.domain.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderGoodsVo implements Serializable {
    private Integer gId;
    private Integer quantity;
}
