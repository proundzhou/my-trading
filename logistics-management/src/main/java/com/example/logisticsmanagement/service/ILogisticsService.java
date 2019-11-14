package com.example.logisticsmanagement.service;

import com.example.logisticsmanagement.domain.dto.LogisticsDetailsDto;
import com.example.logisticsmanagement.domain.dto.LogisticsInfoDto;

public class ILogisticsService {

    private LogisticsInfoDto getLogisticsInfo(){
        return LogisticsInfoDto.builder()
                .expressNumber("123456789666")
                .company("东哥快递")
                .postman("强东")
                .status(3)
                .signer("")
                .description("快递员正在为您派送")
                .build();
    }

    private LogisticsDetailsDto getLogisticsDetails(){
        LogisticsDetailsDto logisticsDetailsDto = new LogisticsDetailsDto();
        logisticsDetailsDto.setAddress("明尼苏达");
        logisticsDetailsDto.setExpressNumber("123456789666");
        logisticsDetailsDto.setTimestamp("2019.11.14.12:00");
        return logisticsDetailsDto;
    }




}
