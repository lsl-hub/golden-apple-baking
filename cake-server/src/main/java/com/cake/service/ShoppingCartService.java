package com.cake.service;

import com.cake.dto.ShoppingCartDTO;
import com.cake.vo.ShoppingCartVO;

import java.util.List;

public interface ShoppingCartService {
    /**
     * 添加到购物车
     * @param shoppingCartDTO
     */
    void add(ShoppingCartDTO shoppingCartDTO);

    /**
     * 获得购物车列表
     * @return
     */
    List<ShoppingCartVO> list();

    /**
     * 更新数量
     * @param shoppingCartDTO
     */
    void update(ShoppingCartDTO shoppingCartDTO);

    /**
     * 删除购物车的某一项
     * @param id
     */
    void delete(Long id);

    /**
     * 批量删除
     * @param ids
     */
    void batchRemove(List<Long> ids);

    /**
     * 清空购物车
     */
    void clearCart();

}
