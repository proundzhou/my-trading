package com.wenqinghao.ordeform.domain.entity;

import java.util.Date;
import lombok.Data;

@Data
public class OrderForm {
    /**
    * 订单Id
    */
    private Integer oId;

    /**
    * 用户Id
    */
    private Integer uId;

    /**
    * 买家未付款(0),	买家已付款,卖家待发货(1),
卖家已发货(5) ,	买家未收货(15),	买家确认收(20),
交易成功(25),		交易关闭(30),		正在申请退款(40),		退款成功(45)
    */
    private Integer oStatus;

    /**
    * 收货人地址
    */
    private String oConsigneeInfo;

    /**
    * 订单创建时间
    */
    private Date oCreateTime;

    /**
    * 订单完成时间
    */
    private Date oFinshTime;

    /**
    * 快递单号
    */
    private Integer oExpressNumber;

    /**
    * 评论状态:已评论(1),未评论(0)
    */
    private Integer evaluateStatus;

    /**
    * 逻辑存在(1),逻辑删除(0)
    */
    private Integer isDelete;
}