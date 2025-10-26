package com.cake.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SaleProduct {
    private Long id;//商品id
    private String name;//名字
    private String image;//图片
    private BigDecimal price;//价格
    private Integer salesCount;//出售数量
}
