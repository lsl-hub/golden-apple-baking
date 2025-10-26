package com.cake.vo;

import com.cake.entity.Size;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PetVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;                  // 主键
    private String name;              // 蛋糕名称
    private Long tasteId;             //口味
    private Integer categoryId;        //分类id
    private String image;             // 蛋糕图片
    private Integer sweet;            // 甜度 1~5
    private String description;   //描述
    //尺寸列表
    private List<Size> specs;

}
