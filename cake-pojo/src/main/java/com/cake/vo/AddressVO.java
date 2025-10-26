package com.cake.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddressVO {
    /**
     * 主键ID
     */

    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 收货人
     */
    private String consignee;

    /**
     * 性别（0-未知，1-男，2-女）
     */
    private String sex;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 省级编号
     */
   private String provinceCode;
    /**
     * 省级名称
     */
    private String provinceName;

    private String cityCode;

    /**
     * 市级名称
     */
    private String cityName;

    private String districtCode;
    /**
     * 区级名称
     */
    private String districtName;

    /**
     * 详细地址
     */
    private String detail;

    /**
     * 是否默认地址（0-否，1-是）
     */
    private Integer isDefault;

    /**
     * 创建时间
     */

    private LocalDateTime createTime;

    /**
     * 更新时间
     */

    private LocalDateTime updateTime;
}
