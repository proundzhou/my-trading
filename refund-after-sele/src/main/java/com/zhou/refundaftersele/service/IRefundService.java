package com.zhou.refundaftersele.service;

import com.zhou.refundaftersele.domain.vo.MoneyFlowVo;
import com.zhou.refundaftersele.domain.vo.RefundInfoVo;

import java.util.List;

public interface IRefundService {

    MoneyFlowVo getMoneyFlowByRId(Integer rId);

    List<RefundInfoVo> getRefundListByUId(Integer uId);

}
