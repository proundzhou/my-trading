package com.zhou.refundaftersele.domain.vo;

import com.zhou.goodmanagement.domain.dto.GoodsDto;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Pattern;
import java.util.Date;
@Data
@Validated
public class MoneyFlowVo {
    private RefundOrderVo orderVo;

    private GoodsDto goods;

    private String bank;

    @Pattern(regexp = "[0-9]{4}")
    private Integer  rBankCard;
}
