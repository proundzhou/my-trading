package com.wqh.expressapi.express.service;

import com.alibaba.fastjson.JSONObject;
import com.wqh.expressapi.express.dto.ExpressInfoReqBody;
import com.wqh.expressapi.express.dto.ExpressListReqBody;

import java.io.IOException;

/**
 * @author wen
 * 17:51
 */
public interface ExpressService {
    /**
     * 快递公司查询
     *
     * @param reqBody
     * @return
     */
    JSONObject getExpressList(ExpressListReqBody reqBody) throws IOException;

    /**
     * 快递物流节点跟踪
     *
     * @param reqBody
     * @return
     * @throws IOException
     */
    JSONObject getExpressInfo(ExpressInfoReqBody reqBody) throws Exception;

    /**
     * 单号查快递公司名
     *
     * @param nu
     * @return
     */
    JSONObject fetchCom(String nu);

}
