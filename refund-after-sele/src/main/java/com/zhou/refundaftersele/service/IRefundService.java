package com.zhou.refundaftersele.service;

import com.zhou.refundaftersele.domain.vo.MoneyFlowVo;

import java.util.List;

public interface IRefundService {
    MoneyFlowVo getMoneyFlowByRId(Integer rId);
}
