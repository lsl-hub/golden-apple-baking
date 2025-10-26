package com.cake.service;

import com.cake.vo.CategoryRankingVO;

import java.util.List;

public interface HomeService {

    /**
     * 获得排行榜
     * @return
     */
    List<CategoryRankingVO> getCategoryRankings();


}
