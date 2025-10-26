package com.cake.service;

import com.cake.dto.PetCakeDTO;
import com.cake.dto.PetPageQueryDTO;
import com.cake.dto.UpdatePetCakeDTO;
import com.cake.result.PageResult;
import com.cake.vo.PetVO;

public interface PetCakeService {
    /**
     * 分页查询
     * @param petPageQueryDTO
     * @return
     */
    PageResult PageQuery(PetPageQueryDTO petPageQueryDTO);

    /**
     * 根据宠物蛋糕id查询蛋糕信息
     * @param id
     * @return
     */
    PetVO getById(Long id);

    /**
     * 添加宠物蛋糕
     * @param petCakeDTO
     */
    void add(PetCakeDTO petCakeDTO);

    /**
     * 更新宠物蛋糕
     * @param updatePetCakeDTO
     */
    void update(UpdatePetCakeDTO updatePetCakeDTO);

    /**
     * 删除宠物蛋糕
     * @param id
     */
    void delete(Long id);
}
