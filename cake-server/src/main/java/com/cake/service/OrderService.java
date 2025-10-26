package com.cake.service;

import com.cake.dto.OrderDTO;
import com.cake.dto.OrdersCancelDTO;
import com.cake.dto.OrdersPaymentDTO;
import com.cake.entity.Order;
import com.cake.exception.InsufficientAmount;
import com.cake.vo.OrderPayVO;
import com.cake.vo.OrderVO;

import java.util.List;

public interface OrderService {
    /**
     * 创建订单
     * @param orderDTO
     */
    OrderPayVO create(OrderDTO orderDTO);

    /**
     * 查询订单列表
     * @return
     */
    List<OrderVO> list(Order order);

    /**
     * 取消订单
     * @param ordersCancelDTO
     */
    void cancel(OrdersCancelDTO ordersCancelDTO);

    /**
     * 支付订单
     * @param ordersPaymentDTO
     */
    void pay(OrdersPaymentDTO ordersPaymentDTO) throws InsufficientAmount;

    /**
     * 处理超时订单
     * @param ordersCancelDTO
     */
    void cancelOrder(OrdersCancelDTO ordersCancelDTO);
}
