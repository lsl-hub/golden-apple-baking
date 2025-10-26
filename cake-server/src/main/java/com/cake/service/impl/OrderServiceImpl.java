package com.cake.service.impl;

import com.cake.constant.MessageConstant;
import com.cake.context.BaseContext;
import com.cake.dto.OrderDTO;
import com.cake.dto.OrdersCancelDTO;
import com.cake.dto.OrdersPaymentDTO;
import com.cake.entity.Order;
import com.cake.entity.OrderDetail;
import com.cake.entity.User;
import com.cake.exception.InsufficientAmount;
import com.cake.exception.PasswordErrorException;
import com.cake.mapper.OrderDetailMapper;
import com.cake.mapper.OrderMapper;
import com.cake.mapper.ShoppingCartMapper;
import com.cake.mapper.UserMapper;
import com.cake.service.OrderService;
import com.cake.vo.OrderPayVO;
import com.cake.vo.OrderVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {
    private final OrderMapper orderMapper;

    private final OrderDetailMapper orderDetailMapper;

    private final ShoppingCartMapper shoppingCartMapper;

    private final UserMapper userMapper;

    private final OrderMQService orderMQService;

    /**
     * 创建订单
     *
     * @param orderDTO
     */
    @Override
    @Transactional
    public OrderPayVO create(OrderDTO orderDTO) {
        //设置属性值
        Order order = new Order();
        BeanUtils.copyProperties(orderDTO,order);
        order.setUserId(BaseContext.getCurrentId());
        order.setOrderTime(LocalDateTime.now());
        order.setCreateTime(LocalDateTime.now());
        order.setPayStatus(Order.UN_PAID);
        order.setUpdateTime(LocalDateTime.now());
        //生成订单号
        String orderNo = generateOrderNo();
        order.setOrderNo(orderNo);
        //创建订单
        orderMapper.create(order);

        // 发送延迟消息
        long delayTime = 1800000; //30分钟
        orderMQService.sendOrderDelayMessage(order.getId(), delayTime);

        //加入相关的订单详情
        List<OrderDetail> orderDetails = orderDTO.getOrderDetails();
        //设置订单id
        orderDetails.forEach(orderDetail -> orderDetail.setOrderId(order.getId()));
        orderDetailMapper.create(orderDetails);

        //提取商品id
        List<Long> productIds = new ArrayList<>();
        for (OrderDetail orderDetail : orderDetails) {
            productIds.add(orderDetail.getProductId());
        }

        //清空购物车已下单的商品
        shoppingCartMapper.deleteCartByProduct(productIds);

        //返回数据
        OrderPayVO orderPayVO = new OrderPayVO();
        orderPayVO.setId(order.getId());
        orderPayVO.setOrderNo(order.getOrderNo());
        orderPayVO.setTotalAmount(order.getTotalAmount());

        return orderPayVO;

    }

    /**
     * 查询订单列表
     *
     * @return
     */
    @Override
    public List<OrderVO> list(Order order) {
        //获得用户id
        Long userId = BaseContext.getCurrentId();
        order.setUserId(userId);
        //查询订单信息
        List<OrderVO> orders = orderMapper.list(order);

        //查询订单详情
        for (OrderVO orderVO : orders) {
            List<OrderDetail> orderDetails =  orderDetailMapper.getorderDetail(orderVO.getId());
            orderVO.setOrderDetails(orderDetails);
        }

        return orders;
    }

    /**
     * 取消订单
     *
     * @param ordersCancelDTO
     */
    @Override
    @Transactional
    public void cancel(OrdersCancelDTO ordersCancelDTO) {
        //创建订单对象
        Order order = new Order();
        order.setId(ordersCancelDTO.getId());
        order.setUpdateTime(LocalDateTime.now());
        //改为已取消的状态
        order.setPayStatus(Order.REFUND);
        order.setCancelReason(ordersCancelDTO.getCancelReason());
        order.setCancelTime(LocalDateTime.now());
        orderMapper.update(order);
    }

    /**
     * 支付订单
     *
     * @param ordersPaymentDTO
     */
    @Override
    public void pay(OrdersPaymentDTO ordersPaymentDTO) throws InsufficientAmount {

        //根据用户id获得余额
        Long userId = BaseContext.getCurrentId();
        User user = userMapper.getAmount(userId);

        String passwordMd5 = DigestUtils.md5DigestAsHex(ordersPaymentDTO.getPassword().getBytes());
        //判断密码是否正确
        if(!passwordMd5.equals(user.getPassword())){
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }
        //判断余额
        if(user.getAmount().compareTo(ordersPaymentDTO.getTotalAmount()) < 0){
            throw  new InsufficientAmount(MessageConstant.INSUFFICIENT_AMOUNT);

        }
        //更新订单
        Order order = new Order();
        order.setId(ordersPaymentDTO.getId());
        order.setUpdateTime(LocalDateTime.now());
        order.setCheckoutTime(LocalDateTime.now());
        order.setPayMethod(ordersPaymentDTO.getPayMethod());
        order.setPayStatus(Order.PAID);
        orderMapper.update(order);

        //扣除余额
        user.setAmount(user.getAmount().subtract(ordersPaymentDTO.getTotalAmount()));
        userMapper.update(user);

    }

    /**
     * 处理超时订单
     *
     * @param ordersCancelDTO
     */
    @Override
    public void cancelOrder(OrdersCancelDTO ordersCancelDTO) {
        //检查这个订单是否已经支付
        Order currentOrder = orderMapper.getById(ordersCancelDTO.getId());
        if(currentOrder != null && currentOrder.getPayStatus() == Order.UN_PAID){
            Order order = new Order();
            order.setCancelTime(LocalDateTime.now());
            order.setUpdateTime(LocalDateTime.now());
            //改为已取消的状态
            order.setPayStatus(Order.REFUND);
            order.setId(ordersCancelDTO.getId());

            order.setCancelReason(MessageConstant.ORDER_TIMED_OUT);

            orderMapper.update(order);
        }

    }

    private String generateOrderNo(){
        //时间格式
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String timeStr = LocalDateTime.now().format(pattern);
        //生成随机数
        String ranStr = String.valueOf((int) (Math.random() * 9 + 1) * 1000);
        return timeStr+ranStr;
    }
}
