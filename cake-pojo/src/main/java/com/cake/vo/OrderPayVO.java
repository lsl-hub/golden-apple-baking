package com.cake.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderPayVO {
    private Long id;
    /**
     * 订单号
     */

    private String orderNo;
    /**
     * 实收金额
     */

    private BigDecimal totalAmount;
}
