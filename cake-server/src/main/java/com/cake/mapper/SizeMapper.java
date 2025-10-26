package com.cake.mapper;

import com.cake.entity.Size;
import com.cake.vo.ShoppingCartVO;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface SizeMapper {
    /**
     * 获得蛋糕对应的尺寸信息
     * @param cakeIds
     * @return
     */
    List<Size> findSizeByProuductIds(List<Long> cakeIds);

    /**
     * 批量插入
     * @param specs
     */
    void batchInsertSpecs(List<Size> specs);

    /**
     * 删除尺寸信息
     * @param productId
     */
    void deleteSize(Long productId);

    /**
     *
     * 查询现在的价格
     * @param shoppingCartVO
     * @return
     */

    BigDecimal getPrice(ShoppingCartVO shoppingCartVO);



    /**
     * 单个id查询
     */
    List<Size> findSizeByProuductId(Long id);

}
