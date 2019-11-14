package com.example.logisticsmanagement.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.security.Timestamp;
@Data
public class LogisticsDetailsDto {

    private String expressNumber;
    private String timestamp;
    private String Address;

}
