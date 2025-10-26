package com.cake.dto;

import com.cake.entity.SaleProduct;
import lombok.Data;

import java.util.List;

@Data
public class CategoryRankingDTO {
    private Long categoryId;//分类id
    private String categoryName;//分类名字
    private List<SaleProduct> products;
}
