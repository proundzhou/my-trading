package com.wqh.project.evaluate.domain.dto;

import lombok.Data;

/**
 * @author wen
 * 20:00
 */
@Data
public class CommentDto {
    private int uId;
    private int gId;
    private int type;
    private String context;
}
