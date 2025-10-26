package com.cake.mapper;

import com.cake.entity.Order;
import com.cake.vo.OrderVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    /**
     * 创建订单
     * @param order
     */
    void create(Order order);

    /**
     * 查询订单列表
     * @param order
     * @return
     */
    List<OrderVO> list(Order order);


    /**
     * 更新订单
     * @param order
     */
    void update(Order order);

    /**
     * 得到订单对象
     * @param order
     * @return
     */
    Order get(Order order);

    /**
     * 根据id得到订单对象
     * @param id
     * @return
     */
    Order getById(Long id);
}
