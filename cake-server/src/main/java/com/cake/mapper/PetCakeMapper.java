package com.cake.mapper;

import com.github.pagehelper.Page;
import com.cake.entity.PetCake;
import com.cake.entity.Product;
import com.cake.entity.UpdatePetCake;
import com.cake.vo.PetVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PetCakeMapper {


    /**
     * 分页查询
     * @return
     */
    Page<PetVO> PageQuery();

    /**
     * 根据宠物蛋糕id查询蛋糕信息
     * @param id
     * @return
     */
    Product getById(Long id);

    /**
     * 添加宠物蛋糕
     * @param petCake
     */
    void add(PetCake petCake);

    /**
     * 更新宠物蛋糕
     * @param petCake
     */
    void update(UpdatePetCake petCake);

    /**
     * 删除宠物蛋糕
     * @param id
     */
    void delete(Long id);
}
