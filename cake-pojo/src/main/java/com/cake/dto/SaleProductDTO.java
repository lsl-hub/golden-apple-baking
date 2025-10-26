package com.cake.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SaleProductDTO {
    private Long id;//商品id
    private String name;//名字
    private String image;//图片
    private BigDecimal price;//价格
    private Integer salesCount;//出售数量
}
