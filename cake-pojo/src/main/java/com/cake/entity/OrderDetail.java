package com.cake.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单明细
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
        主键
     */
    private Long id;

    /**
     * 商品名字
     */
    private String name;

    /**
     * 商品图片
     */
    private String image;

    /**
     * 分量，食用人数
     */
    private String number;

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 数量
     */

    private Integer num;
}
