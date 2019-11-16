package com.zhou.refundaftersele.controller;

import com.zhou.refundaftersele.domain.dto.RefundDto;
import com.zhou.refundaftersele.domain.vo.MoneyFlowVo;
import com.zhou.refundaftersele.domain.vo.RefundDetailVo;
import com.zhou.refundaftersele.domain.vo.RefundInfoVo;
import com.zhou.refundaftersele.service.IFileUploadService;
import com.zhou.refundaftersele.service.IRefundService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/refund")
public class RefundController {
    @Resource
    IRefundService refundService;


    @RequestMapping(value = "/addRefund",method = RequestMethod.POST)
    private String addRefund(@RequestParam("img") MultipartFile[] files,  RefundDto refundDto){
        return refundService.addRefundRecord(files,refundDto);
    }

    @RequestMapping(value = "/moneyFlow",method = RequestMethod.POST)
    private MoneyFlowVo MoneyFlow(Integer rId){
        MoneyFlowVo views = refundService.getMoneyFlowByRId(rId);
        return views;
    }

    @RequestMapping(value = "/myRefundList",method = RequestMethod.POST)
    private List<RefundInfoVo> MyRefundList(Integer uId){
        return refundService.getRefundListByUId(uId);
    }


}
