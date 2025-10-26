package com.cake.mapper;

import com.cake.entity.OrderDetail;
import com.cake.entity.SaleProduct;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDetailMapper {
    List<SaleProduct> getCategoryRankings(Integer cakecategoryid) ;
    /**
     * 获得排行榜
     * @param categoryId
     * @return
     */

    /**
     * 加入相关的订单详情
     * @param orderDetails
     */
    void create(List<OrderDetail> orderDetails);

    /**
     * 查询订单详情
     * @param orderId
     * @return
     */
    List<OrderDetail> getorderDetail(Long orderId);

    /**
     * 删除订单详情
     * @param orderId
     */
    void cancel(Long orderId);
}
