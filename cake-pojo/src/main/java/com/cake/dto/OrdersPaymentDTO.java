package com.cake.dto;

import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class OrdersPaymentDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;

    //付款方式
    private Integer payMethod;

    //密码
    private String password;

    private BigDecimal totalAmount;

}
