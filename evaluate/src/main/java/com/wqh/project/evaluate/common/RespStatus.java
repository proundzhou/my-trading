package com.wqh.project.evaluate.common;

/**
 * @author wen
 * 13:23
 */
public enum  RespStatus {
    SUCCESS(1000),ERROR(2000);
    private int value;

    RespStatus(int value){
        this.value = value;
    }

    private int getStatus(){
        return value;
    }
}
