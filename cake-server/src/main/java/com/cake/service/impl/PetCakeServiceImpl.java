package com.cake.service.impl;

import com.github.pagehelper.Page;
import com.cake.context.BaseContext;
import com.cake.dto.PetCakeDTO;
import com.cake.dto.PetPageQueryDTO;
import com.cake.dto.UpdatePetCakeDTO;
import com.cake.entity.PetCake;
import com.cake.entity.Product;
import com.cake.entity.Size;
import com.cake.entity.UpdatePetCake;
import com.cake.mapper.PetCakeMapper;
import com.cake.mapper.SizeMapper;
import com.cake.result.PageResult;
import com.cake.service.PetCakeService;
import com.cake.vo.PetVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PetCakeServiceImpl implements PetCakeService {
    private final PetCakeMapper petCakeMapper;
    private final SizeMapper sizeMapper;
    /**
     * 分页查询
     *
     * @param petPageQueryDTO
     * @return
     */
    @Override
    public PageResult PageQuery(PetPageQueryDTO petPageQueryDTO) {
//        PageHelper.startPage(petPageQueryDTO.getPageNum(),petPageQueryDTO.getPageSize());
        //查询宠物蛋糕的基本信息
        Page<PetVO> page = petCakeMapper.PageQuery();
//        //判断是否为空
//        if (page == null || page.getResult() == null || page.getResult().isEmpty()) {
//            return new PageResult(page.getTotal(), Collections.emptyList());
//        }
//        //获得宠物蛋糕的id列表
//        List<Long> petIds = page.getResult().stream().map(PetVO::getId).collect(Collectors.toList());
//        //批量查询规格信息
//        Map<Long, List<Size>> petSize = sizeMapper.findSizeByProuductIds(petIds).stream().collect(Collectors.groupingBy(Size::getProductId));
//
//        //将规格信息设置到甜品信息中
//        page.getResult().forEach(petVO -> petVO.setSpecs(petSize.getOrDefault(petVO.getId(), Collections.emptyList())));

        return new PageResult(page.getTotal(),page.getResult());
    }

    /**
     * 根据宠物蛋糕id查询蛋糕信息
     *
     * @param id
     * @return
     */
    @Override
    public PetVO getById(Long id) {
        //获得宠物蛋糕基本信息
        Product petCake =  petCakeMapper.getById(id);
        List<Long> idList = new ArrayList<>();
        idList.add(petCake.getId());
        //查询相关的规格信息
        List<Size> specsList = sizeMapper.findSizeByProuductIds(idList);
        PetVO petVO = new PetVO();
        //复制属性值
        BeanUtils.copyProperties(petCake,petVO);
        petVO.setSpecs(specsList);
        return petVO;
    }

    /**
     * 添加宠物蛋糕
     *
     * @param petCakeDTO
     */
    @Override
    @Transactional
    public void add(PetCakeDTO petCakeDTO) {
        PetCake petCake = new PetCake();
        BeanUtils.copyProperties(petCakeDTO,petCake);
        petCake.setCreateTime(LocalDateTime.now());
        petCake.setCreateUser(BaseContext.getCurrentId());
        petCake.setUpdateTime(LocalDateTime.now());
        petCake.setUpdateUser(BaseContext.getCurrentId());

        //设置蛋糕基本信息
        petCakeMapper.add(petCake);

        petCake.getSpecs().get(0).setProductId(petCake.getId());
        //设置规格信息
        sizeMapper.batchInsertSpecs(petCake.getSpecs());
    }

    /**
     * 更新宠物蛋糕
     *
     * @param updatePetCakeDTO
     */
    @Override
    @Transactional
    public void update(UpdatePetCakeDTO updatePetCakeDTO) {
        UpdatePetCake petCake = new UpdatePetCake();
        BeanUtils.copyProperties(updatePetCakeDTO,petCake);
        petCake.setUpdateTime(LocalDateTime.now());
        petCake.setUpdateUser(BaseContext.getCurrentId());
        petCakeMapper.update(petCake);

    }

    /**
     * 删除宠物蛋糕
     *
     * @param id
     */
    @Override
    @Transactional
    public void delete(Long id) {
        //删除基本信息
        petCakeMapper.delete(id);
        //删除规格信息
        sizeMapper.deleteSize(id);
    }
}
