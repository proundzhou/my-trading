package com.zhou.goodmanagement.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GoodsDto {
    private Integer gId;
    private String gName;
    private String specification;
    private Double price;
}
