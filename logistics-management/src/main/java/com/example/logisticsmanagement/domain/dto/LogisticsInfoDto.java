package com.example.logisticsmanagement.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LogisticsInfoDto {

    private String expressNumber;
    private String company;
    private String postman;
    /*
    * 0 等待揽收
    * 1 揽件
    * 2 到达某地...
    * 3 正在派件
    * 4 已签收
    * */
    private Integer status;
    private String signer;
    private String description;


}
