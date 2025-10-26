package com.cake.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Size implements Serializable {
    private static final long serialVersionUID = 1L;
    //主键
    private Long id;
    //关联的商品id
    private Long productId;
    //规格
    private String number;
    //价格
    private BigDecimal price;
    //长度
    private Double length;
    //宽度
    private Double width;
    //重量
    private Double weight;
    //创建日期
    private LocalDateTime createTime;
    //更新日期
    private LocalDateTime updateTime;
    //创建用户
    private Long createUser;
    //更新用户
    private Long updateUser;
}
