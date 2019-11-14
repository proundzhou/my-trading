package com.zhou.refundaftersele.service.impl;

import com.zhou.refundaftersele.domain.dto.OrderMapDto;
import com.zhou.refundaftersele.service.IOrderService;
import org.springframework.stereotype.Service;

@Service
public class IOrderServiceImpl implements IOrderService {
    @Override
    public Double getSpend(OrderMapDto orderMapDto) {
        return 123.1;
    }
}
