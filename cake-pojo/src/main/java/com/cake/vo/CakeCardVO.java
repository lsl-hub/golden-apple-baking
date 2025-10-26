package com.cake.vo;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class CakeCardVO {
    //蛋糕id
    private Long id;

    //蛋糕名称
    private String name;

    //蛋糕价格
    private BigDecimal price;

    //蛋糕重量
    private Double weight;

    //图片
    private String image;

}
