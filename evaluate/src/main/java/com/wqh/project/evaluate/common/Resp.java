package com.wqh.project.evaluate.common;

import lombok.Builder;
import lombok.Data;

/**
 * @author wen
 * 13:14
 */
@Data
@Builder
public class Resp<T> {
    private String msg;
    private int status;
    private T data;
}
