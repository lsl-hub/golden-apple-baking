package com.cake.mapper;

import com.cake.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SearchProductMapper {
    /**
     * 搜索商品
     * @param name
     * @return
     */
    List<Product> searchProduct(String name);

    /**
     * 更新商品
     * @param product
     */
    void update(Product product);
}
