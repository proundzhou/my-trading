package com.wqh.project.evaluate.domain.entity;

import java.util.Date;
import lombok.Data;

/**
*   @author  wen
*   11:51
*/
@Data
public class Evaluate {
    private Integer eId;

    private Integer uId;

    private Integer gId;

    private String context;

    private String eImg;

    private Byte eType;

    private Date eCreateTime;

    private Byte isDelete;
}