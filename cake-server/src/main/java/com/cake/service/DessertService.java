package com.cake.service;

import com.cake.dto.DessertDTO;
import com.cake.dto.DessertPageQueryDTO;
import com.cake.result.PageResult;

public interface DessertService {
    /**
     * 添加甜品
     * @param dessertDTO
     */
    void add(DessertDTO dessertDTO);

    /**
     * 分页获得所有甜品
     * @param dessertPageQueryDTO
     * @return
     */
    PageResult pageQuery(DessertPageQueryDTO dessertPageQueryDTO);

    /**
     * 更新甜品
     * @param dessertDTO
     */
    void update(DessertDTO dessertDTO);

    /**
     * 删除甜品
     * @param id
     */
    void delete(Long id);
}
