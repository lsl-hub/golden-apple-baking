package com.cake.mapper;

import com.github.pagehelper.Page;
import com.cake.dto.CakeDTO;
import com.cake.dto.CakePageQueryDTO;
import com.cake.entity.Product;
import com.cake.vo.CakeVO;
import com.cake.vo.TasteVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CakeSelectionMapper {



    /**
     * 分页查询
     * @param cakePageQueryDTO
     * @return
     */
    Page<CakeVO> pageQuery(CakePageQueryDTO cakePageQueryDTO);

    /**
     * 添加蛋糕
     * @param cake
     */
    void add(Product cake);

    /**
     * 根据蛋糕id获得蛋糕详情
     * @param id
     * @return
     */

    CakeVO getById(Long id);

    /**
     * 修改蛋糕信息
     * @param cake
     */
    void updateProduct(Product cake);


    void delete(Long id);


    List<TasteVO> getTasteList();

    /**
     * 删除对应蛋糕的尺寸
     * @param id
     */
    void deleteSize(Long id);

    /**
     * 查询蛋糕
     * @param cakeDTO
     * @return
     */

    Product getCake(CakeDTO cakeDTO);


}
