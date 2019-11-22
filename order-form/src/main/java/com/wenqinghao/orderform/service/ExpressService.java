package com.wenqinghao.orderform.service;

import com.alibaba.fastjson.JSONObject;
import com.wenqinghao.orderform.domain.dto.ExpressInfoReqBody;
import com.wenqinghao.orderform.domain.dto.ExpressListReqBody;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

/**
 * @author wangqingqiu
 * @date 2019/11/22 0022 下午 5:12
 */
@FeignClient("wqh-api-center")
public interface ExpressService {
    /**
     * 快递公司查询
     *
     * @param reqBody
     * @return
     */
    @RequestMapping("getExpressList")
    JSONObject getExpressList(ExpressListReqBody reqBody) throws IOException;

    /**
     * 快递物流节点跟踪
     *
     * @param reqBody
     * @return
     * @throws IOException
     */
    @RequestMapping("getExpressInfo")
    JSONObject getExpressInfo(ExpressInfoReqBody reqBody) throws Exception;

    /**
     * 单号查快递公司名
     *
     * @param nu
     * @return
     */
    @RequestMapping("fetchCom")
    JSONObject fetchCom(@Param("nu") String nu);
}
