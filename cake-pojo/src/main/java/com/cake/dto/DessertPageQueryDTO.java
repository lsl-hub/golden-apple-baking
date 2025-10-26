package com.cake.dto;

import lombok.Data;

@Data
public class DessertPageQueryDTO {
    //页码
    private int pageNum;
    //每页大小
    private int pageSize;
}
