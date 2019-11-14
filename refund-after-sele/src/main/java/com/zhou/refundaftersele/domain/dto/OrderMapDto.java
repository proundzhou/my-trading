package com.zhou.refundaftersele.domain.dto;

import lombok.Data;

@Data
public class OrderMapDto {
    private Integer oId;
    private Integer gId;

    public OrderMapDto() {
    }

    public OrderMapDto(Integer oId, Integer gId) {
        this.oId = oId;
        this.gId = gId;
    }
}
