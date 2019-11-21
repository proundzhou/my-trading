package com.wqh.expressapi.express.controller;

import com.alibaba.fastjson.JSONObject;
import com.wqh.expressapi.express.dto.ExpressInfoReqBody;
import com.wqh.expressapi.express.dto.ExpressListReqBody;
import com.wqh.expressapi.express.service.ExpressService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author wen
 * 17:46
 */
@RestController
public class ExpressController {
    @Resource
    ExpressService expressService;

    @PostMapping(value = "getExpressList")
    public JSONObject getExpressList(@RequestBody ExpressListReqBody reqBody) {
        JSONObject jsonObject = null;
        try {
            jsonObject = expressService.getExpressList(reqBody);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 快递物流节点跟踪
     */
    @PostMapping(value = "getExpressInfo")
    public JSONObject getExpressInfo(@RequestBody ExpressInfoReqBody reqBody) {
        JSONObject jsonObject = null;
        try {
            jsonObject = expressService.getExpressInfo(reqBody);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     *单号查快递公司名
     */
    @GetMapping(value = "fetchCom")
    public JSONObject fetchCom(@RequestParam(value = "nu",required = false) String nu) {
        JSONObject jsonObject = null;
        try {
            jsonObject = expressService.fetchCom(nu);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

}

