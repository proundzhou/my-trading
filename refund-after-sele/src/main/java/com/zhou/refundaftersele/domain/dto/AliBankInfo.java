package com.zhou.refundaftersele.domain.dto;

import lombok.Data;

@Data
public class AliBankInfo {
    private String cardType;
    private String bank;
    private String key;
    private Message[] messages;
    private Boolean validated;
    private String stat;

    private class Message{
        String errorCodes;
        String name;

    }

}
