package com.cake.mapper;

import com.github.pagehelper.Page;
import com.cake.dto.DessertPageQueryDTO;
import com.cake.entity.Product;
import com.cake.vo.DessertVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DessertMapper {
    /**
     * 添加甜品
     * @param dessert
     */
    void add(Product dessert);

    /**
     * 分页查询
     * @param dessertPageQueryDTO
     * @return
     */
    Page<DessertVO> pageQuery(DessertPageQueryDTO dessertPageQueryDTO);

    /**
     * 更新甜品
     * @param dessert
     */
    void update(Product dessert);

    /**
     * 删除甜品
     * @param id
     */
    void delete(Long id);
}
