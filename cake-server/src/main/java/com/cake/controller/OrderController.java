package com.cake.controller;

import com.cake.dto.OrderDTO;
import com.cake.dto.OrdersCancelDTO;
import com.cake.dto.OrdersPaymentDTO;
import com.cake.entity.Order;
import com.cake.exception.InsufficientAmount;
import com.cake.result.Result;
import com.cake.service.OrderService;
import com.cake.vo.OrderPayVO;
import com.cake.vo.OrderVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@Slf4j
@Api(tags = "订单相关接口")
public class OrderController {
    private final OrderService orderService;
    @PutMapping("/create")
    @ApiOperation("创建订单")
    public Result<OrderPayVO> create(@RequestBody OrderDTO orderDTO){

        OrderPayVO orderPayVO = orderService.create(orderDTO);
        return Result.success(orderPayVO);
    }

    @GetMapping("/list")
    @ApiOperation("查询订单列表")
    public Result<List<OrderVO>> list(Order order){
        log.info("订单信息：{}",order);
        List<OrderVO> orderVOList =  orderService.list(order);
        return Result.success(orderVOList);
    }

    @PostMapping("/cancel")
    @ApiOperation("取消订单")
    public Result cancel(@RequestBody OrdersCancelDTO ordersCancelDTO){
        orderService.cancel(ordersCancelDTO);
        return Result.success();
    }

    @PostMapping("/pay")
    @ApiOperation("支付订单")
    public Result pay(@RequestBody OrdersPaymentDTO ordersPaymentDTO) throws InsufficientAmount {
        orderService.pay(ordersPaymentDTO);
        return Result.success();
    }
}
