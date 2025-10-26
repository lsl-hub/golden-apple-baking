package com.cake.vo;

import com.cake.entity.SaleProduct;
import lombok.Data;

import java.util.List;

@Data
public class CategoryRankingVO {
    private Integer categoryId;//分类id
    private String categoryName;//分类名字
    private List<SaleProduct> products;
}
