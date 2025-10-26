package com.cake.dto;

import com.cake.entity.Size;
import lombok.Data;

import java.util.List;

@Data
public class DessertDTO {
    // 主键
    private Long id;

    // 蛋糕名称
    private String name;

    //口味id
    private Long tasteId;

    //分类id
    private Integer categoryId;

    // 蛋糕图片
    private String image;

    // 甜度 1~5
    private Integer sweet;

    //描述
    private String description;

    //尺寸列表
    private List<Size> specs;
}
