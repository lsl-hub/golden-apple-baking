package com.cake.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetUser implements Serializable {

    private static final long serialVersionUID = 1L;
    //姓名
    private String name;

    //余额
    private BigDecimal amount;


}
