package com.cake.service;

import com.cake.dto.CakeDTO;
import com.cake.dto.CakePageQueryDTO;
import com.cake.exception.ProductAlreadyExists;
import com.cake.result.PageResult;
import com.cake.vo.CakeVO;
import com.cake.vo.TasteVO;

import java.util.List;

public interface CakeSelectionService {


    /**
     * 添加蛋糕
     * @param cakeDTO
     */
    void add(CakeDTO cakeDTO) throws ProductAlreadyExists;

    /**
     * 根据蛋糕id获得蛋糕详情
     * @param id
     * @return
     */
    CakeVO getById(Long id);

    /**
     * 修改蛋糕信息
     * @param cakeDTO
     */
    void update(CakeDTO cakeDTO);

    /**
     * 分页查询
     * @param cakePageQueryDTO
     * @return
     */
    PageResult pageQuery(CakePageQueryDTO cakePageQueryDTO);

    /**
     * 删除蛋糕
     * @param id
     */
    void delete(Long id);

    /**
     * 获得口味列表
     * @return
     */
    List<TasteVO> getTasteList();

}
