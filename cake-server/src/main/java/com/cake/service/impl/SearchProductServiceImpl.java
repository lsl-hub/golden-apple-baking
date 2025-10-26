package com.cake.service.impl;

import com.cake.context.BaseContext;
import com.cake.dto.ProductDTO;
import com.cake.entity.Product;
import com.cake.entity.Size;
import com.cake.mapper.SearchProductMapper;
import com.cake.mapper.SizeMapper;
import com.cake.service.SearchProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchProductServiceImpl implements SearchProductService {
    private final SearchProductMapper searchProductMapper;
    private final SizeMapper sizeMapper;
    /**
     * 搜索商品
     *
     * @param name
     * @return
     */
    @Override
    public List<Product> searchProduct(String name) {
        //查询基本信息
        List<Product> productList =  searchProductMapper.searchProduct(name);
        for (Product product : productList) {
            //查询规格信息
            List<Size> specs = sizeMapper.findSizeByProuductId(product.getId());
            product.setSpecs(specs);
        }
        return productList;

    }

    /**
     * 更新商品
     *
     * @param productDTO
     */
    @Override
    @Transactional
    public void update(ProductDTO productDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(productDTO,product);
        product.setUpdateUser(BaseContext.getCurrentId());
        product.setUpdateTime(LocalDateTime.now());
        //更新基本信息
        searchProductMapper.update(product);
        //删除尺寸
        sizeMapper.deleteSize(product.getId());
        //添加尺寸
        sizeMapper.batchInsertSpecs(product.getSpecs());
    }
}
