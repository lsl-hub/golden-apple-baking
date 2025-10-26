package com.cake.service.impl;

import com.github.pagehelper.Page;
import com.cake.context.BaseContext;
import com.cake.dto.DessertDTO;
import com.cake.dto.DessertPageQueryDTO;
import com.cake.entity.Product;
import com.cake.entity.Size;
import com.cake.mapper.DessertMapper;
import com.cake.mapper.SizeMapper;
import com.cake.result.PageResult;
import com.cake.service.DessertService;
import com.cake.vo.DessertVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DessertServiceImpl implements DessertService {
    private final DessertMapper dessertMapper;

    private final SizeMapper sizeMapper;
    /**
     * 添加甜品
     *
     * @param dessertDTO
     */
    @Override
    @Transactional
    public void add(DessertDTO dessertDTO) {
        //现在添加基本信息到商品表
        Product dessert = new Product();
        BeanUtils.copyProperties(dessertDTO,dessert);
        dessert.setCreateTime(LocalDateTime.now());
        dessert.setUpdateTime(LocalDateTime.now());
        dessert.setCreateUser(BaseContext.getCurrentId());
        dessert.setUpdateUser(BaseContext.getCurrentId());
        dessert.setCategoryId(2);
        dessertMapper.add(dessert);

        //给每个尺寸对象设置关联的商品值
        List<Size> sizeList = dessertDTO.getSpecs();
        for (Size size : sizeList) {
            size.setProductId(dessert.getId());
        }
        sizeMapper.batchInsertSpecs(sizeList);

    }

    /**
     * 分页获得所有甜品
     *
     * @param dessertPageQueryDTO
     * @return
     */
    @Override
    public PageResult pageQuery(DessertPageQueryDTO dessertPageQueryDTO) {
//        PageHelper.startPage(dessertPageQueryDTO.getPageNum(),dessertPageQueryDTO.getPageSize());
        //查询甜品的所有信息
        Page<DessertVO> page = dessertMapper.pageQuery(dessertPageQueryDTO);
//        //获得甜品id列表
//        List<Long> dessertIds = page.getResult().stream().map(DessertVO::getId).collect(Collectors.toList());
//        //批量查询规格信息
//        Map<Long, List<Size>> specsMap = sizeMapper.findSizeByProuductIds(dessertIds).stream().collect(Collectors.groupingBy(Size::getProductId));
//        //将规格信息设置到甜品信息中
//        page.getResult().forEach(dessertVO -> dessertVO.setSpecs(specsMap.getOrDefault(dessertVO.getId(), Collections.emptyList())));
        return new PageResult(page.getTotal(),page.getResult());
    }

    /**
     * 更新甜品
     *
     * @param dessertDTO
     */
    @Override
    @Transactional
    public void update(DessertDTO dessertDTO) {
        Product dessert = new Product();
        BeanUtils.copyProperties(dessertDTO,dessert);
        dessert.setUpdateUser(BaseContext.getCurrentId());
        dessert.setUpdateTime(LocalDateTime.now());
        //更新商品表
        dessertMapper.update(dessert);

        //先删除该甜品的所有的尺寸信息
        sizeMapper.deleteSize(dessertDTO.getId());
        //设置商品id
        dessertDTO.getSpecs().get(0).setProductId(dessertDTO.getId());
        //插入尺寸信息
        sizeMapper.batchInsertSpecs(dessertDTO.getSpecs());
    }

    /**
     * 删除甜品
     *
     * @param id
     */
    @Override
    @Transactional
    public void delete(Long id) {
        //删除商品表有关信息
        dessertMapper.delete(id);
        //删除相关尺寸信息
        sizeMapper.deleteSize(id);
    }


}
