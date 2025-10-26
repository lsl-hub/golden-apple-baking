package com.cake.entity;

import lombok.Data;

import java.util.List;
@Data
public class Region {
    private String name;

    //编码
    private String code;
    //级别
    private String level;
    //子级
    private List<Region> children;
}
