package com.zhou.refundaftersele.service;

import com.zhou.refundaftersele.domain.dto.RefundDto;
import com.zhou.refundaftersele.domain.vo.MoneyFlowVo;
import com.zhou.refundaftersele.domain.vo.RefundInfoVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IRefundService {

    MoneyFlowVo getMoneyFlowByRId(Integer rId);

    List<RefundInfoVo> getRefundListByUId(Integer uId);

    String addRefundRecord(MultipartFile[] files, RefundDto refundDto);
}
