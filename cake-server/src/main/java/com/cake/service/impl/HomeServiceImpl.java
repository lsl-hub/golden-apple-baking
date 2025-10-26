package com.cake.service.impl;

import com.cake.entity.SaleProduct;
import com.cake.mapper.*;
import com.cake.service.HomeService;
import com.cake.vo.CategoryRankingVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeServiceImpl implements HomeService {

    private static final Integer  CAKECATEGORYID = 1;//甄选蛋糕id
    private  static final Integer DESSERTCATEGORYID = 2;//甜品id
    private static final Integer PETCAKECATEGORYID = 3;//宠物蛋糕id

    private static final String SELECTIONCAKE = "蛋糕甄选";

    private static final String DESSERT = "甜品系列";

    private static final String PETCAKE = "宠物蛋糕";

    private final HomeMapper homeMapper;

    private final CakeSelectionMapper cakeSelectionMapper;
    private final DessertMapper dessertMapper;
    private final PetCakeMapper petCakeMapper;
    private final OrderDetailMapper orderDetailMapper;

    /**
     * 获得排行榜
     *
     * @return
     */
    @Override
    public List<CategoryRankingVO> getCategoryRankings() {
        List<CategoryRankingVO>  categoryRankingVOS = new ArrayList<>();
        //甄选蛋糕
        //获得前三名
        List<SaleProduct> selectionCake = orderDetailMapper.getCategoryRankings(CAKECATEGORYID);
        CategoryRankingVO cakeRankingVO = new CategoryRankingVO();
        //设置分类的名字
        cakeRankingVO.setCategoryName(SELECTIONCAKE);
        //设置前三名
        cakeRankingVO.setProducts(selectionCake);
        //设置分类id
        cakeRankingVO.setCategoryId(CAKECATEGORYID);
        //添加到列表
        categoryRankingVOS.add(cakeRankingVO);

        //甜品
        List<SaleProduct> dessert = orderDetailMapper.getCategoryRankings(DESSERTCATEGORYID);
        CategoryRankingVO dessertRankingVO = new CategoryRankingVO();
        dessertRankingVO.setCategoryName(DESSERT);
        dessertRankingVO.setProducts(dessert);
        dessertRankingVO.setCategoryId(DESSERTCATEGORYID);
        categoryRankingVOS.add(dessertRankingVO);

        //宠物蛋糕
        List<SaleProduct> petCake = orderDetailMapper.getCategoryRankings(PETCAKECATEGORYID);
        CategoryRankingVO petRankingVO = new CategoryRankingVO();
        petRankingVO.setCategoryName(PETCAKE);
        petRankingVO.setProducts(petCake);
        petRankingVO.setCategoryId(PETCAKECATEGORYID);
        categoryRankingVOS.add(petRankingVO);

        return categoryRankingVOS;

    }
}
