package com.cake.dto;

import lombok.Data;

@Data
public class CakePageQueryDTO {
    //页码数
    private Integer pageNum;
    //分页尺寸
    private Integer pageSize;
    //口味
    private Long tasteId;
    //食用人数
    private String number;

}
