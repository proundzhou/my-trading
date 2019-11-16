package com.wenqinghao.orderform.domain.enmu;

public enum OrderStatus {

    //买家未付款
    UNPAID(0),

    //买家已付款,卖家待发货
    id_Not_Send (1),

    // 卖家已发货
    Send_Out(5),

    //买家未收货
    Not_Received(15),

    //买家收货
    Received(20),

    //交易成功(25)
    Deal(25),

    //交易关闭(30)
    Close(30),

    //正在申请退款(40)
    Refunding(40),

    //退款成功(45)
    Refunded(45);

    public int code;
    OrderStatus(int code){
        this.code = code;
    }
    public int getCode(){
        return this.code;
    }

}
