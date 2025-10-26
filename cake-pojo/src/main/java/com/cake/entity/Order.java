package com.cake.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 订单
 */
@Data
public class Order  {


    /**
     * 支付状态 0未支付 1已支付 2退款
     */
    public static final Integer UN_PAID = 0;
    public static final Integer PAID = 1;
    public static final Integer REFUND = 2;


        /**
         * 主键ID
         */
        private Long id;

        /**
         * 订单号
         */

        private String orderNo;

        /**
         * 下单用户ID
         */
        private Long userId;

        /**
         * 地址ID
         */
        private Long addressId;

        /**
         * 下单时间
         */
        private LocalDateTime orderTime;

        /**
         * 结账时间
         */
        private LocalDateTime checkoutTime;

        /**
         * 支付方式：1-微信，2-支付宝
         */
        private Integer payMethod;

        /**
         * 支付状态：0-未支付，1-已支付，2-退款
         */

        private Integer payStatus;

        /**
         * 实收金额
         */

        private BigDecimal totalAmount;

        /**
         * 备注
         */

        private String remark;

        /**
         * 手机号
         */

        private String phone;

        /**
         * 收货人
         */
        private String consignee;

        /**
         * 订单取消原因
         */

        private String cancelReason;

        /**
         * 订单取消时间
         */

        private LocalDateTime cancelTime;

        /**
         * 创建时间
         */

        private LocalDateTime createTime;

        /**
         * 更新时间
         */

        private LocalDateTime updateTime;

        /**
         * 地址详情（完整地址）
         */

        private String address;

    /**
     * 订单详情
     */
    private List<OrderDetail> orderDetails;



}
