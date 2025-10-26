package com.cake.service;

import com.cake.dto.ProductDTO;
import com.cake.entity.Product;

import java.util.List;

public interface SearchProductService {
    /**
     * 搜索商品
     * @param name
     * @return
     */
    List<Product> searchProduct(String name);

    /**
     * 更新商品
     * @param productDTO
     */
    void update(ProductDTO productDTO);
}
