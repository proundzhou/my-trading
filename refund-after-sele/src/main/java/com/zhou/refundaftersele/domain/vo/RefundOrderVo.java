package com.zhou.refundaftersele.domain.vo;

import com.zhou.goodmanagement.domain.dto.GoodsDto;
import lombok.Data;

import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
public class RefundOrderVo {
    private Integer rId;

    private Integer rMoney;

    private Date rCreateTime;

    private Byte moneyFlow;
}
