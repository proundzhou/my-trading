package com.zhou.refundaftersele.domain.vo;



import com.zhou.goodmanagement.domain.dto.GoodsDto;
import lombok.Data;

@Data
public class RefundInfoVo {

    private RefundDetailVo refundDetailVo;

    private GoodsDto goodsDto;

    private Double spend;


}
