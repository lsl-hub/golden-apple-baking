package com.cake.service.impl;

import com.cake.context.BaseContext;
import com.cake.dto.ShoppingCartDTO;
import com.cake.entity.ShoppingCart;
import com.cake.mapper.ShoppingCartMapper;
import com.cake.mapper.SizeMapper;
import com.cake.service.ShoppingCartService;
import com.cake.vo.ShoppingCartVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartMapper shoppingCartMapper;
    private final SizeMapper sizeMapper;
    /**
     * 添加到购物车
     *
     * @param shoppingCartDTO
     */
    @Override
    @Transactional
    public void add(ShoppingCartDTO shoppingCartDTO) {
        shoppingCartDTO.setUserId(BaseContext.getCurrentId());

        //检查购物车有没有该商品
        ShoppingCart shoppingCart = shoppingCartMapper.getProduct(shoppingCartDTO);

        if(shoppingCart != null){
            //直接更新
            shoppingCartDTO.setId(shoppingCart.getId());
            shoppingCartDTO.setUpdateTime(LocalDateTime.now());
//            shoppingCartDTO.setNum(shoppingCartDTO);
            shoppingCartMapper.update(shoppingCartDTO);
        }else {
            //直接插入
            shoppingCartDTO.setCreateTime(LocalDateTime.now());
            shoppingCartDTO.setUpdateTime(LocalDateTime.now());
            shoppingCartMapper.insert(shoppingCartDTO);
        }
    }

    /**
     * 获得购物车列表
     *
     * @return
     */
    @Override
    public List<ShoppingCartVO> list() {
        //获得当前用户的id
        Long userId = BaseContext.getCurrentId();
        List<ShoppingCartVO>  shoppingCartVOList = shoppingCartMapper.list(userId);
        //查询现在价格
        for (ShoppingCartVO shoppingCartVO : shoppingCartVOList) {
            BigDecimal nowAmount = sizeMapper.getPrice(shoppingCartVO);
            shoppingCartVO.setNowAmount(nowAmount);
        }
        return shoppingCartVOList;
    }

    /**
     * 更新数量
     *
     * @param shoppingCartDTO
     */
    @Override
    public void update(ShoppingCartDTO shoppingCartDTO) {
        shoppingCartMapper.update(shoppingCartDTO);
    }

    /**
     * 删除购物车的某一项
     *
     * @param id
     */
    @Override
    public void delete(Long id) {
        List<Long> idList = new ArrayList<>();
        idList.add(id);
        shoppingCartMapper.BatchDelete(idList);
    }

    /**
     * 批量删除
     *
     * @param ids
     */
    @Override
    public void batchRemove(List<Long> ids) {
        shoppingCartMapper.BatchDelete(ids);
    }

    /**
     * 清空购物车
     */
    @Override
    public void clearCart() {
        shoppingCartMapper.clearCart();
    }
}
