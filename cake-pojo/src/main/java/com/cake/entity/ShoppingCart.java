package com.cake.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 购物车
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id; // 主键
    private String name; // 商品名称
    private String image; // 商品图片
    private Long userId; // 用户id
    private Long productId; // 商品id
    private Integer num; // 商品数量
    private String number; // 分量，食用人数
    private BigDecimal nowAmount; //现在价格
    private BigDecimal amount; // 金额
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
}
