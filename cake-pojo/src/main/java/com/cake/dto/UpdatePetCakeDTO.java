package com.cake.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdatePetCakeDTO {

    private Long id;                // 商品ID
    private String name;            // 商品名称
    private String image;           // 商品图片
    private Integer categoryId;     // 分类ID (1:蛋糕 2:甜品 3:宠物蛋糕)
    private String description;     // 描述
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
    private Long createUser;        // 创建人
    private Long updateUser;        // 修改人


}
