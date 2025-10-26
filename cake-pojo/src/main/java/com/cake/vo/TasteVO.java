package com.cake.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class TasteVO implements Serializable {
    private static final long serialVersionUID = 1L;
    //主键
    private Long id;

    //口味
    private String flavor;
}
