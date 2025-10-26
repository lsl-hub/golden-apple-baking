package com.cake.mapper;

import com.cake.dto.ShoppingCartDTO;
import com.cake.entity.ShoppingCart;
import com.cake.vo.ShoppingCartVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShoppingCartMapper {
    /**
     * 获得购物车商品
     * @param shoppingCartDTO
     * @return
     */
     ShoppingCart getProduct(ShoppingCartDTO shoppingCartDTO) ;

    /**
     * 更新购物车商品
     * @param shoppingCartDTO
     */
    void update(ShoppingCartDTO shoppingCartDTO);

    /**
     * 添加到购物车
     * @param shoppingCartDTO
     */
    void insert(ShoppingCartDTO shoppingCartDTO);

    /**
     * 获得购物车列表
     * @param userId
     * @return
     */
    List<ShoppingCartVO> list(Long userId);

    /**
     * 批量删除
     * @param ids
     */
    void BatchDelete(List<Long> ids);

    /**
     * 清空购物车
     */
    void clearCart();

    /**
     * 清空购物车已下单的商品
     * @param productIds
     */
    void deleteCartByProduct(List<Long> productIds);
}
