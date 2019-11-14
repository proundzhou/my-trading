package com.zhou.refundaftersele.controller;

import com.zhou.refundaftersele.domain.vo.MoneyFlowVo;
import com.zhou.refundaftersele.service.IRefundService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/refund")
public class RefundController {
    @Resource
    IRefundService refundService;

    @RequestMapping(value = "/money_flow",method = RequestMethod.POST)
    private MoneyFlowVo MoneyFlow(Integer rId){
        MoneyFlowVo views = refundService.getMoneyFlowByRId(rId);
        return views;
    }


}
