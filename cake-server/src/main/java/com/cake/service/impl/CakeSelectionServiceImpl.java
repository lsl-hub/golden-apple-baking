package com.cake.service.impl;

import com.github.pagehelper.Page;
import com.cake.constant.MessageConstant;
import com.cake.context.BaseContext;
import com.cake.dto.CakeDTO;
import com.cake.dto.CakePageQueryDTO;
import com.cake.entity.Product;
import com.cake.entity.Size;
import com.cake.exception.ProductAlreadyExists;
import com.cake.mapper.CakeSelectionMapper;
import com.cake.mapper.SizeMapper;
import com.cake.result.PageResult;
import com.cake.service.CakeSelectionService;
import com.cake.vo.CakeVO;
import com.cake.vo.TasteVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CakeSelectionServiceImpl implements CakeSelectionService {
    private final CakeSelectionMapper cakeSelectionMapper;

    private final SizeMapper sizeMapper;


    /**
     * 分页查询
     *
     * @param cakePageQueryDTO
     * @return
     */
    @Override
    public PageResult pageQuery(CakePageQueryDTO cakePageQueryDTO) {

//        PageHelper.startPage(cakePageQueryDTO.getPageNum(), cakePageQueryDTO.getPageSize(),true);

        Page<CakeVO> page  = cakeSelectionMapper.pageQuery(cakePageQueryDTO);

        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 删除蛋糕
     *
     * @param id
     */
    @Override
    public void delete(Long id) {
        //删除商品表信息
        cakeSelectionMapper.delete(id);

        //删除关联的尺寸表信息
        sizeMapper.deleteSize(id);
    }

    /**
     * 获得口味列表
     *
     * @return
     */
    @Override
    public List<TasteVO> getTasteList() {
        List<TasteVO> tasteVOList = cakeSelectionMapper.getTasteList();
        return tasteVOList;
    }

    /**
     * 添加蛋糕
     *
     * @param cakeDTO
     */
    @Override
    @Transactional
    public void add(CakeDTO cakeDTO) throws ProductAlreadyExists {
        //判断商品是否存在
        Product product = cakeSelectionMapper.getCake(cakeDTO);
        if(product != null){
            throw new ProductAlreadyExists(MessageConstant.PRODUCT_ALREADY_EXISTS);
        }
        Product cake = new Product();
        BeanUtils.copyProperties(cakeDTO,cake);

        //设置时间和用户
        cake.setCreateTime(LocalDateTime.now());
        cake.setUpdateTime(LocalDateTime.now());
        cake.setCreateUser(BaseContext.getCurrentId());
        cake.setUpdateUser(BaseContext.getCurrentId());

        //添加基本信息
        cakeSelectionMapper.add(cake);

        //获得商品id
        Long cakeId = cake.getId();
        List<Size> sizeList = cakeDTO.getSpecs();

        //给每个尺寸对象设置商品id
        for (Size size : sizeList) {
            size.setProductId(cakeId);
            size.setCreateTime(LocalDateTime.now());
            size.setUpdateTime(LocalDateTime.now());
            size.setCreateUser(BaseContext.getCurrentId());
            size.setUpdateUser(BaseContext.getCurrentId());
        }


        //添加尺寸信息
        sizeMapper.batchInsertSpecs(sizeList);
    }

    /**
     * 根据蛋糕id获得蛋糕详情
     *
     * @param id
     * @return
     */
    @Override
    public CakeVO getById(Long id) {
        CakeVO cakeVO = cakeSelectionMapper.getById(id);
        List<Long> cakeId = new ArrayList<>();
        cakeId.add(id);
        List<Size> sizeList = sizeMapper.findSizeByProuductIds(cakeId);
        cakeVO.setSpecs(sizeList);
        return cakeVO;
    }

    /**
     * 修改蛋糕信息
     *
     * @param cakeDTO
     */
    @Override
    @Transactional
    public void update(CakeDTO cakeDTO) {
        Product cake = new Product();
        BeanUtils.copyProperties(cakeDTO,cake);
        cake.setUpdateTime(LocalDateTime.now());
        cake.setUpdateUser(BaseContext.getCurrentId());
        //更新 基本信息
        cakeSelectionMapper.updateProduct(cake);


    }

}
