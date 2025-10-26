package com.cake.entity;


import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Product {

    private Long id;                // 商品ID
    private String name;            // 商品名称
    private String image;           // 商品图片
    private Integer categoryId;     // 分类ID (1:蛋糕 2:甜品 3:宠物蛋糕)
    private Long tasteId;           // 关联口味ID
    private Integer sweet;          // 甜度1~5
    private String description;     // 描述
    private Integer status;         // 状态 (0停售 1启售)
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
    private Long createUser;        // 创建人
    private Long updateUser;        // 修改人

    private List<Size> specs;


}
