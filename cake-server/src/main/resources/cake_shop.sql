/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 90100 (9.1.0)
 Source Host           : localhost:3306
 Source Schema         : cake_shop

 Target Server Type    : MySQL
 Target Server Version : 90100 (9.1.0)
 File Encoding         : 65001

 Date: 28/10/2025 09:52:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `consignee` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '收货人',
  `sex` varchar(2) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '性别',
  `phone` varchar(11) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '手机号',
  `province_code` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '省级区划编号',
  `province_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '省级名称',
  `city_code` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '市级区划编号',
  `city_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '市级名称',
  `district_code` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '区级区划编号',
  `district_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '区级名称',
  `detail` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '详细地址',
  `is_default` tinyint(1) NOT NULL DEFAULT 0 COMMENT '默认 0 否 1是',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = '地址簿' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES (5, 1, '周丹', '男', '19878967689', '33', '浙江省', '3302', '宁波市', '330205', '江北区', '78号', 1, '2025-10-11 10:47:57', '2025-10-25 00:39:37');
INSERT INTO `address` VALUES (6, 1, '董静', '男', '18767899876', '14', '山西省', '1403', '阳泉市', '140311', '郊区', '98号', 0, '2025-10-11 11:14:05', '2025-10-25 00:39:35');
INSERT INTO `address` VALUES (7, 1, '静静', '男', '17867899876', '13', '河北省', '1303', '秦皇岛市', '130304', '北戴河区', '56号', 0, '2025-10-25 00:53:36', '2025-10-25 00:53:36');

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品名字',
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品图片',
  `num` int NULL DEFAULT NULL COMMENT '数量',
  `order_id` bigint NULL DEFAULT NULL COMMENT '订单id',
  `product_id` bigint NULL DEFAULT NULL COMMENT '商品id',
  `amount` decimal(10, 2) NOT NULL COMMENT '金额',
  `number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '分量，食用人数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 70 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES (30, '猫咪鱼肉蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/2a5cffe8-91e9-4727-b0d3-18a982eef890.jpg', 2, 22, 194, 158.00, NULL);
INSERT INTO `order_detail` VALUES (31, '双层草莓奶油蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/a0def884-8237-49be-ba05-f2391278f088.jpg', 1, 22, 131, 268.00, NULL);
INSERT INTO `order_detail` VALUES (32, '草莓巧克力蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/0d19863e-6d14-4bca-940a-9e6c80474042.jpg', 1, 22, 132, 178.00, NULL);
INSERT INTO `order_detail` VALUES (33, '香草奶油蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/75820998-631c-4b22-a48f-b2941a558045.jpg', 1, 22, 137, 238.00, NULL);
INSERT INTO `order_detail` VALUES (34, '巧克力马卡龙', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/5b89ea56-fdd6-46f7-9c85-57ccf3761ee5.jpg', 1, 22, 182, 48.00, NULL);
INSERT INTO `order_detail` VALUES (35, '草莓大福', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/f4e29a82-a023-48b3-852d-18bc83062d78.jpg', 1, 22, 183, 78.00, NULL);
INSERT INTO `order_detail` VALUES (36, '奥利奥杯', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/a337037c-861c-4a67-8e98-110776879a08.jpg', 1, 22, 185, 25.00, NULL);
INSERT INTO `order_detail` VALUES (37, '猫咪鱼肉蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/2a5cffe8-91e9-4727-b0d3-18a982eef890.jpg', 1, 22, 194, 118.00, NULL);
INSERT INTO `order_detail` VALUES (38, '宠物蔬菜蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/b965db33-9193-4a1d-a0f5-35427794aeef.jpg', 1, 22, 195, 98.00, NULL);
INSERT INTO `order_detail` VALUES (39, '宠物生日蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/a7c8d2d9-7bac-40c3-915e-5447b06b9b49.jpg', 1, 22, 196, 188.00, NULL);
INSERT INTO `order_detail` VALUES (40, '猫咪鱼肉蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/2a5cffe8-91e9-4727-b0d3-18a982eef890.jpg', 1, 22, 194, 188.00, NULL);
INSERT INTO `order_detail` VALUES (41, '狗狗鸡肉蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/e79ca7ca-232c-464a-ac1b-55d76ef27b1e.jpg', 3, 22, 193, 168.00, NULL);
INSERT INTO `order_detail` VALUES (42, '巧克力熔岩蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/71e98c7e-2326-47f5-9be7-907f8a802d6d.jpg', 3, 22, 136, 158.00, NULL);
INSERT INTO `order_detail` VALUES (43, '芒果慕斯蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/a24aa711-783d-4095-af76-961bbbec7839.jpg', 1, 22, 133, 288.00, NULL);
INSERT INTO `order_detail` VALUES (44, '芒果千层蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/eaad4828-c94f-4a56-a23f-8bd331d2530e.jpg', 3, 22, 134, 198.00, NULL);
INSERT INTO `order_detail` VALUES (45, '草莓巧克力蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/0d19863e-6d14-4bca-940a-9e6c80474042.jpg', 1, 23, 132, 178.00, NULL);
INSERT INTO `order_detail` VALUES (46, '草莓大福', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/f4e29a82-a023-48b3-852d-18bc83062d78.jpg', 1, 24, 183, 78.00, NULL);
INSERT INTO `order_detail` VALUES (47, '双层草莓奶油蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/a0def884-8237-49be-ba05-f2391278f088.jpg', 1, 25, 131, 168.00, NULL);
INSERT INTO `order_detail` VALUES (48, '双层草莓奶油蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/a0def884-8237-49be-ba05-f2391278f088.jpg', 1, 26, 131, 168.00, NULL);
INSERT INTO `order_detail` VALUES (49, '猫咪鱼肉蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/2a5cffe8-91e9-4727-b0d3-18a982eef890.jpg', 1, 27, 194, 158.00, NULL);
INSERT INTO `order_detail` VALUES (50, '草莓巧克力蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/0d19863e-6d14-4bca-940a-9e6c80474042.jpg', 1, 28, 132, 278.00, NULL);
INSERT INTO `order_detail` VALUES (51, '巧克力马卡龙', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/5b89ea56-fdd6-46f7-9c85-57ccf3761ee5.jpg', 1, 29, 182, 48.00, NULL);
INSERT INTO `order_detail` VALUES (52, '提拉米苏', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/234591a7-c738-4caf-94f8-6e3b74a9121a.jpg', 1, 30, 186, 65.00, NULL);
INSERT INTO `order_detail` VALUES (53, '巧克力马卡龙', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/5b89ea56-fdd6-46f7-9c85-57ccf3761ee5.jpg', 1, 31, 182, 48.00, NULL);
INSERT INTO `order_detail` VALUES (54, '宠物蔬菜蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/b965db33-9193-4a1d-a0f5-35427794aeef.jpg', 1, 32, 195, 98.00, NULL);
INSERT INTO `order_detail` VALUES (55, '巧克力马卡龙', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/5b89ea56-fdd6-46f7-9c85-57ccf3761ee5.jpg', 1, 33, 182, 48.00, NULL);
INSERT INTO `order_detail` VALUES (56, '巧克力熔岩蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/71e98c7e-2326-47f5-9be7-907f8a802d6d.jpg', 1, 34, 136, 228.00, NULL);
INSERT INTO `order_detail` VALUES (57, '巧克力马卡龙', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/5b89ea56-fdd6-46f7-9c85-57ccf3761ee5.jpg', 1, 35, 182, 48.00, NULL);
INSERT INTO `order_detail` VALUES (58, '巧克力马卡龙', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/5b89ea56-fdd6-46f7-9c85-57ccf3761ee5.jpg', 1, 36, 182, 48.00, NULL);
INSERT INTO `order_detail` VALUES (59, '奥利奥杯', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/a337037c-861c-4a67-8e98-110776879a08.jpg', 1, 37, 185, 25.00, NULL);
INSERT INTO `order_detail` VALUES (60, '草莓大福', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/f4e29a82-a023-48b3-852d-18bc83062d78.jpg', 1, 38, 183, 78.00, NULL);
INSERT INTO `order_detail` VALUES (61, '巧克力马卡龙', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/5b89ea56-fdd6-46f7-9c85-57ccf3761ee5.jpg', 1, 39, 182, 48.00, NULL);
INSERT INTO `order_detail` VALUES (62, '巧克力熔岩蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/71e98c7e-2326-47f5-9be7-907f8a802d6d.jpg', 1, 40, 136, 158.00, NULL);
INSERT INTO `order_detail` VALUES (63, '水果塔', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/ce1cbb9f-c0da-45a9-8c30-e8e25900e541.jpg', 1, 41, 213, 35.00, NULL);
INSERT INTO `order_detail` VALUES (64, '抹茶生巧克力', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/70c74732-cf79-479f-96cc-c646d6523adf.jpg', 4, 41, 224, 68.00, NULL);
INSERT INTO `order_detail` VALUES (65, '狗狗鸡肉蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/e79ca7ca-232c-464a-ac1b-55d76ef27b1e.jpg', 1, 41, 193, 168.00, NULL);
INSERT INTO `order_detail` VALUES (66, '三文鱼宠物蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/534a694f-8888-43d7-beba-ae30313e8717.jpg', 5, 41, 218, 168.00, NULL);
INSERT INTO `order_detail` VALUES (67, '咖啡核桃蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/4eeab3ef-790f-405b-88e0-b7dae8bfde14.jpg', 2, 42, 209, 158.00, NULL);
INSERT INTO `order_detail` VALUES (68, '草莓巧克力蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/0d19863e-6d14-4bca-940a-9e6c80474042.jpg', 1, 43, 132, 278.00, NULL);
INSERT INTO `order_detail` VALUES (69, '芒果千层蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/eaad4828-c94f-4a56-a23f-8bd331d2530e.jpg', 1, 44, 134, 198.00, NULL);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_no` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '订单号',
  `user_id` bigint NOT NULL COMMENT '下单用户',
  `address_id` bigint NOT NULL COMMENT '地址id',
  `order_time` datetime NOT NULL COMMENT '下单时间',
  `checkout_time` datetime NULL DEFAULT NULL COMMENT '结账时间',
  `pay_status` tinyint NOT NULL DEFAULT 0 COMMENT '支付状态 0未支付 1已支付 2退款',
  `consignee` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '收货人',
  `phone` varchar(11) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '手机号',
  `address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '地址',
  `pay_method` int NULL DEFAULT NULL COMMENT '支付方式 1微信,2支付宝',
  `total_amount` decimal(10, 2) NOT NULL COMMENT '实收金额',
  `remark` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '备注',
  `cancel_reason` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '订单取消原因',
  `cancel_time` datetime NULL DEFAULT NULL COMMENT '订单取消时间',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`, `order_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = '订单表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (22, '202510210056553000', 1, 5, '2025-10-21 00:56:56', '2025-10-21 00:57:02', 1, '周丹', '19878967689', '浙江省宁波市江北区78号', 1, 3603.00, '', NULL, NULL, '2025-10-21 00:56:56', '2025-10-21 00:56:56');
INSERT INTO `orders` VALUES (23, '202510211058571000', 1, 6, '2025-10-21 10:58:57', NULL, 2, '董静', '18767899876', '山西省阳泉市郊区98号', 2, 178.00, '', '信息填写错误', '2025-10-24 21:30:58', '2025-10-21 10:58:57', '2025-10-21 10:58:57');
INSERT INTO `orders` VALUES (24, '202510211129063000', 1, 5, '2025-10-21 11:29:06', NULL, 2, '周丹', '19878967689', '浙江省宁波市江北区78号', 1, 78.00, '', '信息填写错误', '2025-10-24 21:30:53', '2025-10-21 11:29:06', '2025-10-21 11:29:06');
INSERT INTO `orders` VALUES (25, '202510212324456000', 1, 5, '2025-10-21 23:24:46', NULL, 2, '周丹', '19878967689', '浙江省宁波市江北区78号', 1, 168.00, '', '不想买了', '2025-10-24 21:30:46', '2025-10-21 23:24:46', '2025-10-21 23:24:46');
INSERT INTO `orders` VALUES (26, '202510212353172000', 1, 5, '2025-10-21 23:53:17', '2025-10-22 00:37:03', 1, '周丹', '19878967689', '浙江省宁波市江北区78号', 1, 168.00, '', NULL, NULL, '2025-10-21 23:53:17', '2025-10-21 23:53:17');
INSERT INTO `orders` VALUES (27, '202510220038567000', 1, 5, '2025-10-22 00:38:57', '2025-10-22 00:43:30', 1, '周丹', '19878967689', '浙江省宁波市江北区78号', 1, 158.00, '', NULL, NULL, '2025-10-22 00:38:57', '2025-10-22 00:38:57');
INSERT INTO `orders` VALUES (28, '202510220054024000', 1, 5, '2025-10-22 00:54:02', NULL, 2, '周丹', '19878967689', '浙江省宁波市江北区78号', NULL, 278.00, '', '不想买了', '2025-10-24 21:30:39', '2025-10-22 00:54:02', '2025-10-22 00:54:02');
INSERT INTO `orders` VALUES (29, '202510222311293000', 1, 5, '2025-10-22 23:11:29', NULL, 2, '周丹', '19878967689', '浙江省宁波市江北区78号', NULL, 48.00, '', '配送时间不合适', '2025-10-24 21:30:33', '2025-10-22 23:11:29', '2025-10-22 23:11:29');
INSERT INTO `orders` VALUES (30, '202510222320373000', 1, 5, '2025-10-22 23:20:37', '2025-10-23 00:29:53', 1, '周丹', '19878967689', '浙江省宁波市江北区78号', 1, 65.00, '', NULL, NULL, '2025-10-22 23:20:37', '2025-10-22 23:20:37');
INSERT INTO `orders` VALUES (31, '202510230030281000', 1, 5, '2025-10-23 00:30:29', NULL, 2, '周丹', '19878967689', '浙江省宁波市江北区78号', NULL, 48.00, '', '发现更便宜的商品', '2025-10-24 21:29:52', '2025-10-23 00:30:29', '2025-10-23 00:30:29');
INSERT INTO `orders` VALUES (32, '202510230045178000', 1, 5, '2025-10-23 00:45:17', '2025-10-24 17:49:59', 1, '周丹', '19878967689', '浙江省宁波市江北区78号', 1, 98.00, '', NULL, NULL, '2025-10-23 00:45:17', '2025-10-23 00:45:17');
INSERT INTO `orders` VALUES (33, '202510230053097000', 1, 5, '2025-10-23 00:53:09', NULL, 2, '周丹', '19878967689', '浙江省宁波市江北区78号', NULL, 48.00, '', '发现更便宜的商品', '2025-10-23 00:53:20', '2025-10-23 00:53:09', '2025-10-23 00:53:09');
INSERT INTO `orders` VALUES (34, '202510241141432000', 1, 5, '2025-10-24 11:41:43', NULL, 2, '周丹', '19878967689', '浙江省宁波市江北区78号', NULL, 228.00, '', '订单超时，已自动取消', '2025-10-24 11:44:44', '2025-10-24 11:41:43', '2025-10-24 11:41:43');
INSERT INTO `orders` VALUES (35, '202510241144171000', 1, 5, '2025-10-24 11:44:18', NULL, 2, '周丹', '19878967689', '浙江省宁波市江北区78号', NULL, 48.00, '', '订单超时，已自动取消', '2025-10-24 11:44:44', '2025-10-24 11:44:18', '2025-10-24 11:44:18');
INSERT INTO `orders` VALUES (36, '202510241145087000', 1, 5, '2025-10-24 11:45:09', NULL, 2, '周丹', '19878967689', '浙江省宁波市江北区78号', NULL, 48.00, '', '订单超时，已自动取消', '2025-10-24 11:45:19', '2025-10-24 11:45:09', '2025-10-24 11:45:09');
INSERT INTO `orders` VALUES (37, '202510241751187000', 1, 5, '2025-10-24 17:51:19', NULL, 2, '周丹', '19878967689', '浙江省宁波市江北区78号', NULL, 25.00, '', '订单超时，已自动取消', '2025-10-24 17:51:29', '2025-10-24 17:51:19', '2025-10-24 17:51:19');
INSERT INTO `orders` VALUES (38, '202510242202458000', 1, 5, '2025-10-24 22:02:46', '2025-10-24 22:29:30', 1, '周丹', '19878967689', '浙江省宁波市江北区78号', 1, 78.00, '', NULL, NULL, '2025-10-24 22:02:46', '2025-10-24 22:02:46');
INSERT INTO `orders` VALUES (39, '202510242230076000', 1, 5, '2025-10-24 22:30:07', NULL, 2, '周丹', '19878967689', '浙江省宁波市江北区78号', NULL, 48.00, '', '订单超时，已自动取消', '2025-10-24 23:00:07', '2025-10-24 22:30:07', '2025-10-24 22:30:07');
INSERT INTO `orders` VALUES (40, '202510250023205000', 1, 5, '2025-10-25 00:23:20', NULL, 2, '周丹', '19878967689', '浙江省宁波市江北区78号', NULL, 158.00, '', '订单超时，已自动取消', '2025-10-25 00:53:20', '2025-10-25 00:23:20', '2025-10-25 00:23:20');
INSERT INTO `orders` VALUES (41, '202510250038374000', 1, 6, '2025-10-25 00:38:37', '2025-10-25 00:39:08', 1, '董静', '18767899876', '山西省阳泉市郊区98号', 1, 1315.00, '', NULL, NULL, '2025-10-25 00:38:37', '2025-10-25 00:38:37');
INSERT INTO `orders` VALUES (42, '202510250052112000', 1, 5, '2025-10-25 00:52:11', NULL, 2, '周丹', '19878967689', '浙江省宁波市江北区78号', NULL, 316.00, '', '信息填写错误', '2025-10-25 00:52:19', '2025-10-25 00:52:11', '2025-10-25 00:52:11');
INSERT INTO `orders` VALUES (43, '202510250052325000', 1, 5, '2025-10-25 00:52:33', NULL, 2, '周丹', '19878967689', '浙江省宁波市江北区78号', NULL, 278.00, '', '订单超时，已自动取消', '2025-10-25 16:00:37', '2025-10-25 00:52:33', '2025-10-25 00:52:33');
INSERT INTO `orders` VALUES (44, '202510250054065000', 1, 7, '2025-10-25 00:54:07', '2025-10-25 00:54:16', 1, '静静', '17867899876', '河北省秦皇岛市北戴河区56号', 1, 198.00, '', NULL, NULL, '2025-10-25 00:54:07', '2025-10-25 00:54:07');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL COMMENT '商品名称',
  `image` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '商品图片',
  `category_id` int NULL DEFAULT NULL COMMENT '1: 蛋糕 2：甜品 3：宠物蛋糕',
  `taste_id` bigint NULL DEFAULT NULL COMMENT '关联口味id',
  `sweet` int NULL DEFAULT NULL COMMENT '甜度1~5',
  `description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NULL DEFAULT NULL COMMENT '描述',
  `status` int NULL DEFAULT 1 COMMENT '0 停售 1启售',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `create_user` bigint NULL DEFAULT NULL COMMENT '创建人',
  `update_user` bigint NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 230 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_bin COMMENT = '菜品' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (131, '双层草莓奶油蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/a0def884-8237-49be-ba05-f2391278f088.jpg', 1, 1, 4, '双层草莓夹心，奶油香甜不腻', 1, '2025-10-18 17:49:19', '2025-10-21 00:09:49', 1, 1);
INSERT INTO `product` VALUES (132, '草莓巧克力蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/0d19863e-6d14-4bca-940a-9e6c80474042.jpg', 1, 1, 4, '草莓与巧克力的完美结合', 1, '2025-10-18 17:49:19', '2025-10-20 17:09:31', 1, 1);
INSERT INTO `product` VALUES (133, '芒果慕斯蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/a24aa711-783d-4095-af76-961bbbec7839.jpg', 1, 2, 3, '进口芒果制作，口感细腻丝滑', 1, '2025-10-18 17:49:19', '2025-10-20 17:11:20', 1, 1);
INSERT INTO `product` VALUES (134, '芒果千层蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/eaad4828-c94f-4a56-a23f-8bd331d2530e.jpg', 1, 2, 4, '层层芒果夹心，口感丰富', 1, '2025-10-18 17:49:19', '2025-10-20 17:12:37', 1, 1);
INSERT INTO `product` VALUES (135, '黑森林蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/046db345-e502-46eb-99d9-0853c50d4836.jpg', 1, 4, 5, '经典黑森林，巧克力浓郁', 1, '2025-10-18 17:49:19', '2025-10-20 17:53:34', 1, 1);
INSERT INTO `product` VALUES (136, '巧克力熔岩蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/71e98c7e-2326-47f5-9be7-907f8a802d6d.jpg', 1, 4, 5, '爆浆巧克力，温暖治愈', 1, '2025-10-18 17:49:19', '2025-10-20 17:55:10', 1, 1);
INSERT INTO `product` VALUES (137, '香草奶油蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/75820998-631c-4b22-a48f-b2941a558045.jpg', 1, 3, 2, '纯正香草风味，清新不腻', 1, '2025-10-18 17:49:19', '2025-10-20 17:56:11', 1, 1);
INSERT INTO `product` VALUES (138, '奥利奥芝士蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/17398e10-bf2f-4f36-93c0-1e563ba7c7bb.jpg', 1, 6, 4, '奥利奥饼干与芝士的完美融合', 1, '2025-10-18 17:49:19', '2025-10-25 16:39:56', 1, 1);
INSERT INTO `product` VALUES (139, '哈密瓜水果蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/de7ec5e0-5f2c-4151-b858-30cf90b16d82.jpg', 1, 5, 3, '清甜哈密瓜，夏日首选', 1, '2025-10-18 17:49:19', '2025-10-20 17:58:24', 1, 1);
INSERT INTO `product` VALUES (181, '芒果布丁', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/0729ca29-d9d9-4601-ac78-9cc104f8a8f5.jpg', 2, 2, 3, 'Q弹芒果布丁，果肉丰富', 1, '2025-10-18 17:52:06', '2025-10-25 17:56:10', 1, 1);
INSERT INTO `product` VALUES (182, '巧克力马卡龙', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/5b89ea56-fdd6-46f7-9c85-57ccf3761ee5.jpg', 2, 4, 5, '法式马卡龙，外脆内软', 1, '2025-10-18 17:52:06', '2025-10-20 18:14:35', 1, 1);
INSERT INTO `product` VALUES (183, '草莓大福', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/f4e29a82-a023-48b3-852d-18bc83062d78.jpg', 2, 1, 3, '糯米外皮包裹整颗草莓', 1, '2025-10-18 17:52:06', '2025-10-20 18:15:48', 1, 1);
INSERT INTO `product` VALUES (184, '香草泡芙', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/ba4877cb-2cfb-4778-be62-fc35ff815dee.jpg', 2, 3, 4, '酥皮泡芙，香草奶油馅', 1, '2025-10-18 17:52:06', '2025-10-20 23:58:49', 1, 1);
INSERT INTO `product` VALUES (185, '奥利奥杯', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/a337037c-861c-4a67-8e98-110776879a08.jpg', 2, 6, 4, '奥利奥碎与奶油的层次美味', 1, '2025-10-18 17:52:06', '2025-10-21 00:00:00', 1, 1);
INSERT INTO `product` VALUES (186, '提拉米苏', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/234591a7-c738-4caf-94f8-6e3b74a9121a.jpg', 2, 4, 3, '意式经典，咖啡酒香', 1, '2025-10-18 17:52:06', '2025-10-21 00:00:44', 1, 1);
INSERT INTO `product` VALUES (193, '狗狗鸡肉蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/e79ca7ca-232c-464a-ac1b-55d76ef27b1e.jpg', 3, 3, 1, '鸡肉配方，专为爱犬设计', 1, '2025-10-18 17:52:15', '2025-10-21 00:02:14', 1, 1);
INSERT INTO `product` VALUES (194, '猫咪鱼肉蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/2a5cffe8-91e9-4727-b0d3-18a982eef890.jpg', 3, 2, 1, '新鲜鱼肉，猫咪最爱', 1, '2025-10-18 17:52:15', '2025-10-21 00:03:57', 1, 1);
INSERT INTO `product` VALUES (195, '宠物蔬菜蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/b965db33-9193-4a1d-a0f5-35427794aeef.jpg', 3, 5, 1, '多种蔬菜，营养均衡', 1, '2025-10-18 17:52:15', '2025-10-21 00:06:31', 1, 1);
INSERT INTO `product` VALUES (196, '宠物生日蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/a7c8d2d9-7bac-40c3-915e-5447b06b9b49.jpg', 3, 3, 1, '宠物专用生日庆典蛋糕', 1, '2025-10-18 17:52:15', '2025-10-21 00:07:43', 1, 1);
INSERT INTO `product` VALUES (205, '红丝绒蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/dec076c7-f783-496e-89fe-a34229ffbec5.jpg', 1, 4, 4, '经典红丝绒，丝滑奶油奶酪 frosting', 1, '2025-10-24 22:37:15', '2025-10-24 23:04:40', 1, 1);
INSERT INTO `product` VALUES (206, '抹茶慕斯蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/8b7f94a4-2093-47ae-99f0-f46a6fdc7f93.jpg', 1, 5, 2, '日式抹茶风味，清新不腻', 1, '2025-10-24 22:37:15', '2025-10-24 23:04:53', 1, 1);
INSERT INTO `product` VALUES (207, '蓝莓芝士蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/b8b3563c-4828-4ba3-af7a-8687358e4550.jpg', 1, 6, 3, '新鲜蓝莓与芝士的完美结合', 1, '2025-10-24 22:37:15', '2025-10-24 23:05:07', 1, 1);
INSERT INTO `product` VALUES (208, '椰香芒果蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/f89874a3-c783-4b01-8f2f-a9d605a1b6ff.jpg', 1, 2, 3, '热带风情，椰香与芒果的碰撞', 1, '2025-10-24 22:37:15', '2025-10-25 00:37:38', 1, 1);
INSERT INTO `product` VALUES (209, '咖啡核桃蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/4eeab3ef-790f-405b-88e0-b7dae8bfde14.jpg', 1, 4, 3, '香浓咖啡搭配酥脆核桃', 1, '2025-10-24 22:37:15', '2025-10-24 23:05:39', 1, 1);
INSERT INTO `product` VALUES (210, '芝士蛋糕杯', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/58343584-4478-430a-9318-7df810f85242.jpg', 2, 6, 4, '便携芝士蛋糕，随时随地享受', 1, '2025-10-24 22:39:28', '2025-10-24 23:06:27', 1, 1);
INSERT INTO `product` VALUES (211, '抹茶曲奇', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/d718dce2-2385-4dea-aeb1-139e7432508b.jpg', 2, 5, 3, '日式抹茶风味曲奇饼干', 1, '2025-10-24 22:39:28', '2025-10-24 23:06:42', 1, 1);
INSERT INTO `product` VALUES (212, '巧克力布朗尼', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/bdfe824f-b63b-4ee8-b0ac-519d59ad3af9.jpg', 2, 4, 5, '浓郁巧克力，口感绵密', 1, '2025-10-24 22:39:28', '2025-10-24 23:07:03', 1, 1);
INSERT INTO `product` VALUES (213, '水果塔', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/ce1cbb9f-c0da-45a9-8c30-e8e25900e541.jpg', 2, 2, 3, '新鲜水果搭配酥脆塔皮', 1, '2025-10-24 22:39:28', '2025-10-24 23:07:19', 1, 1);
INSERT INTO `product` VALUES (214, '焦糖布丁', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/53d25367-0324-4d01-b9f9-fb06ca4d8140.jpg', 2, 3, 4, '丝滑布丁，焦糖香气浓郁', 1, '2025-10-24 22:39:28', '2025-10-24 23:07:55', 1, 1);
INSERT INTO `product` VALUES (215, '红豆麻薯', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/1c9208a2-47df-476c-90a7-0ed9a283f1a0.jpg', 2, 5, 3, '软糯麻薯包裹香甜红豆', 1, '2025-10-24 22:39:28', '2025-10-24 23:08:08', 1, 1);
INSERT INTO `product` VALUES (216, '柠檬挞', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/e5145a3c-c42e-4686-8569-ad958df4c4f3.jpg', 2, 1, 2, '清新柠檬风味，酸甜可口', 1, '2025-10-24 22:39:28', '2025-10-24 23:08:37', 1, 1);
INSERT INTO `product` VALUES (217, '宠物鸡肉蔬菜蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/f46bb3a9-16e9-430e-a001-984da72b2da1.jpg', 3, 3, 1, '鸡肉与蔬菜的均衡搭配', 1, '2025-10-24 22:42:29', '2025-10-24 23:09:04', 1, 1);
INSERT INTO `product` VALUES (218, '三文鱼宠物蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/534a694f-8888-43d7-beba-ae30313e8717.jpg', 3, 2, 1, '新鲜三文鱼，富含Omega-3', 1, '2025-10-24 22:42:29', '2025-10-24 23:09:15', 1, 1);
INSERT INTO `product` VALUES (219, '牛肉胡萝卜蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/84bf16bb-e128-4a61-b7c7-f6446cee3b04.jpg', 3, 3, 1, '优质牛肉与胡萝卜营养组合', 1, '2025-10-24 22:42:29', '2025-10-24 23:09:26', 1, 1);
INSERT INTO `product` VALUES (220, '鸭肉红薯蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/87310887-7c70-4258-abcf-0f302852a254.jpg', 3, 3, 1, '鸭肉搭配红薯，易消化', 1, '2025-10-24 22:42:29', '2025-10-24 23:09:45', 1, 1);
INSERT INTO `product` VALUES (221, '宠物水果庆典蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/816c282b-2347-4323-b0ba-04b8c1a9f483.jpg', 3, 5, 1, '宠物专用水果配方', 1, '2025-10-24 22:42:29', '2025-10-24 23:09:58', 1, 1);
INSERT INTO `product` VALUES (222, '伯爵奶茶蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/a5bb967d-01bf-433b-94ec-b2b5f6f331f8.jpg', 1, 3, 3, '英式伯爵茶香，搭配丝滑奶茶奶油', 1, '2025-10-24 23:12:27', '2025-10-24 23:24:59', 1, 1);
INSERT INTO `product` VALUES (223, '榴莲千层蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/f574950d-8177-4139-bfeb-83d31586209d.jpg', 1, 2, 4, '泰国金枕榴莲，层层果肉满足', 1, '2025-10-24 23:12:27', '2025-10-24 23:25:13', 1, 1);
INSERT INTO `product` VALUES (224, '抹茶生巧克力', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/70c74732-cf79-479f-96cc-c646d6523adf.jpg', 2, 5, 4, '日式生巧工艺，抹茶香气浓郁', 1, '2025-10-24 23:13:45', '2025-10-25 21:55:23', 1, 1);
INSERT INTO `product` VALUES (225, '芒果雪媚娘', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/c9bcfd40-b5b3-4014-b02c-e98ff94ee773.jpg', 2, 2, 3, 'Q弹冰皮包裹新鲜芒果粒', 1, '2025-10-24 23:13:45', '2025-10-24 23:26:50', 1, 1);
INSERT INTO `product` VALUES (226, '海盐焦糖泡芙', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/49caf9e7-4ef7-4038-b597-bf1e41eff194.jpg', 2, 4, 4, '酥脆泡芙，海盐焦糖内馅', 1, '2025-10-24 23:13:45', '2025-10-24 23:27:03', 1, 1);
INSERT INTO `product` VALUES (227, '宠物三文鱼芝士蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/7e595384-a297-4fa1-9d2c-34b8b1dc872a.jpg', 3, 2, 1, '三文鱼搭配芝士，宠物最爱', 1, '2025-10-24 23:13:45', '2025-10-24 23:27:30', 1, 1);
INSERT INTO `product` VALUES (228, '鸡肉南瓜宠物蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/2d03ccdf-a84f-4a32-bb49-32a500b5283b.jpg', 3, 3, 1, '鸡肉与南瓜，营养易消化', 1, '2025-10-24 23:13:45', '2025-10-24 23:27:39', 1, 1);
INSERT INTO `product` VALUES (229, '宠物混合莓果蛋糕', 'https://lsl-bucket.oss-cn-guangzhou.aliyuncs.com/fe62cab0-d069-4293-9b63-b92866dc496a.jpg', 3, 5, 1, '多种莓果，富含维生素', 1, '2025-10-24 23:13:45', '2025-10-24 23:27:58', 1, 1);

-- ----------------------------
-- Table structure for shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE `shopping_cart`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品图片',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `product_id` bigint NOT NULL COMMENT '商品id',
  `num` int NULL DEFAULT NULL COMMENT '商品数量',
  `number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '分量，食用人数',
  `amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '金额',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 80 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shopping_cart
-- ----------------------------

-- ----------------------------
-- Table structure for size
-- ----------------------------
DROP TABLE IF EXISTS `size`;
CREATE TABLE `size`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `product_id` bigint NOT NULL COMMENT '关联的商品id',
  `number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '建议食用人数',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品价格',
  `length` double NULL DEFAULT NULL COMMENT '商品的长度',
  `width` double NULL DEFAULT NULL COMMENT '商品的宽度',
  `weight` double NULL DEFAULT NULL COMMENT '商品的重量',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改日期',
  `create_user` bigint NULL DEFAULT NULL COMMENT '添加用户',
  `update_user` bigint NULL DEFAULT NULL COMMENT '更新用户',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 588 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of size
-- ----------------------------
INSERT INTO `size` VALUES (391, 132, '1-2人', 178.00, 15, 15, 520, '2025-10-20 17:09:32', '2025-10-20 17:09:32', 1, 1);
INSERT INTO `size` VALUES (392, 132, '3-4人', 278.00, 18, 18, 820, '2025-10-20 17:09:32', '2025-10-20 17:09:32', 1, 1);
INSERT INTO `size` VALUES (393, 132, '5-6人', 378.00, 20, 20, 1220, '2025-10-20 17:09:32', '2025-10-20 17:09:32', 1, 1);
INSERT INTO `size` VALUES (394, 133, '1-2人', 188.00, 15, 15, 480, '2025-10-20 17:11:20', '2025-10-20 17:11:20', 1, 1);
INSERT INTO `size` VALUES (395, 133, '3-4人', 288.00, 18, 18, 780, '2025-10-20 17:11:20', '2025-10-20 17:11:20', 1, 1);
INSERT INTO `size` VALUES (396, 133, '5-6人', 388.00, 20, 20, 1180, '2025-10-20 17:11:20', '2025-10-20 17:11:20', 1, 1);
INSERT INTO `size` VALUES (397, 134, '1-2人', 198.00, 15, 15, 460, '2025-10-20 17:12:37', '2025-10-20 17:12:37', 1, 1);
INSERT INTO `size` VALUES (398, 134, '3-4人', 298.00, 18, 18, 760, '2025-10-20 17:12:37', '2025-10-20 17:12:37', 1, 1);
INSERT INTO `size` VALUES (399, 134, '5-6人', 398.00, 20, 20, 1160, '2025-10-20 17:12:37', '2025-10-20 17:12:37', 1, 1);
INSERT INTO `size` VALUES (400, 135, '1-2人', 208.00, 15, 15, 580, '2025-10-20 17:53:34', '2025-10-20 17:53:34', 1, 1);
INSERT INTO `size` VALUES (401, 135, '3-4人', 308.00, 18, 18, 880, '2025-10-20 17:53:34', '2025-10-20 17:53:34', 1, 1);
INSERT INTO `size` VALUES (402, 135, '5-6人', 408.00, 20, 20, 1280, '2025-10-20 17:53:34', '2025-10-20 17:53:34', 1, 1);
INSERT INTO `size` VALUES (403, 136, '1-2人', 158.00, 12, 12, 350, '2025-10-20 17:55:10', '2025-10-20 17:55:10', 1, 1);
INSERT INTO `size` VALUES (404, 136, '3-4人', 228.00, 15, 15, 550, '2025-10-20 17:55:10', '2025-10-20 17:55:10', 1, 1);
INSERT INTO `size` VALUES (405, 136, '5-6人', 298.00, 18, 18, 850, '2025-10-20 17:55:10', '2025-10-20 17:55:10', 1, 1);
INSERT INTO `size` VALUES (406, 137, '1-2人', 138.00, 15, 15, 450, '2025-10-20 17:56:11', '2025-10-20 17:56:11', 1, 1);
INSERT INTO `size` VALUES (407, 137, '3-4人', 238.00, 18, 18, 750, '2025-10-20 17:56:11', '2025-10-20 17:56:11', 1, 1);
INSERT INTO `size` VALUES (408, 137, '5-6人', 338.00, 20, 20, 1150, '2025-10-20 17:56:11', '2025-10-20 17:56:11', 1, 1);
INSERT INTO `size` VALUES (415, 139, '1-2人', 148.00, 15, 15, 480, '2025-10-20 17:58:24', '2025-10-20 17:58:24', 1, 1);
INSERT INTO `size` VALUES (416, 139, '3-4人', 248.00, 18, 18, 780, '2025-10-20 17:58:24', '2025-10-20 17:58:24', 1, 1);
INSERT INTO `size` VALUES (417, 139, '5-6人', 348.00, 20, 20, 1180, '2025-10-20 17:58:24', '2025-10-20 17:58:24', 1, 1);
INSERT INTO `size` VALUES (425, 182, '4个装', 48.00, 0, 0, 150, NULL, NULL, NULL, NULL);
INSERT INTO `size` VALUES (426, 183, '6个装', 78.00, 0, 0, 540, NULL, NULL, NULL, NULL);
INSERT INTO `size` VALUES (427, 184, '9个装', 92.00, 0, 0, 660, NULL, NULL, NULL, NULL);
INSERT INTO `size` VALUES (428, 185, '1杯', 25.00, 0, 0, 180, NULL, NULL, NULL, NULL);
INSERT INTO `size` VALUES (429, 186, '2人份', 65.00, 15, 15, 450, NULL, NULL, NULL, NULL);
INSERT INTO `size` VALUES (430, 193, '小型犬', 128.00, 12, 12, 400, '2025-10-21 00:02:14', '2025-10-21 00:02:14', 1, 1);
INSERT INTO `size` VALUES (431, 193, '中型犬', 168.00, 15, 15, 600, '2025-10-21 00:02:14', '2025-10-21 00:02:14', 1, 1);
INSERT INTO `size` VALUES (432, 193, '大型犬', 198.00, 18, 18, 800, '2025-10-21 00:02:14', '2025-10-21 00:02:14', 1, 1);
INSERT INTO `size` VALUES (433, 194, '标准款', 118.00, 10, 10, 350, '2025-10-21 00:03:57', '2025-10-21 00:03:57', 1, 1);
INSERT INTO `size` VALUES (434, 194, '加大款', 158.00, 13, 13, 500, '2025-10-21 00:03:57', '2025-10-21 00:03:57', 1, 1);
INSERT INTO `size` VALUES (435, 194, '豪华款', 188.00, 15, 15, 650, '2025-10-21 00:03:57', '2025-10-21 00:03:57', 1, 1);
INSERT INTO `size` VALUES (436, 195, '小型宠物', 98.00, 10, 10, 300, '2025-10-21 00:06:31', '2025-10-21 00:06:31', 1, 1);
INSERT INTO `size` VALUES (437, 195, '中型宠物', 138.00, 13, 13, 450, '2025-10-21 00:06:31', '2025-10-21 00:06:31', 1, 1);
INSERT INTO `size` VALUES (438, 195, '大型宠物', 178.00, 15, 15, 600, '2025-10-21 00:06:31', '2025-10-21 00:06:31', 1, 1);
INSERT INTO `size` VALUES (439, 196, '小型宠物', 148.00, 12, 12, 380, '2025-10-21 00:07:43', '2025-10-21 00:07:43', 1, 1);
INSERT INTO `size` VALUES (440, 196, '中型宠物', 188.00, 15, 15, 580, '2025-10-21 00:07:43', '2025-10-21 00:07:43', 1, 1);
INSERT INTO `size` VALUES (441, 196, '大型宠物', 228.00, 18, 18, 780, '2025-10-21 00:07:43', '2025-10-21 00:07:43', 1, 1);
INSERT INTO `size` VALUES (442, 131, '1-2人', 168.00, 15, 15, 550, '2025-10-21 00:09:49', '2025-10-21 00:09:49', 1, 1);
INSERT INTO `size` VALUES (443, 131, '3-4人', 268.00, 18, 18, 850, '2025-10-21 00:09:49', '2025-10-21 00:09:49', 1, 1);
INSERT INTO `size` VALUES (444, 131, '5-6人', 368.00, 20, 20, 1250, '2025-10-21 00:09:49', '2025-10-21 00:09:49', 1, 1);
INSERT INTO `size` VALUES (504, 205, '1-2人', 188.00, 15, 15, 500, '2025-10-24 23:04:40', '2025-10-24 23:04:40', 1, 1);
INSERT INTO `size` VALUES (505, 205, '3-4人', 288.00, 18, 18, 800, '2025-10-24 23:04:40', '2025-10-24 23:04:40', 1, 1);
INSERT INTO `size` VALUES (506, 205, '5-6人', 388.00, 20, 20, 1200, '2025-10-24 23:04:40', '2025-10-24 23:04:40', 1, 1);
INSERT INTO `size` VALUES (507, 206, '1-2人', 198.00, 15, 15, 480, '2025-10-24 23:04:53', '2025-10-24 23:04:53', 1, 1);
INSERT INTO `size` VALUES (508, 206, '3-4人', 298.00, 18, 18, 780, '2025-10-24 23:04:53', '2025-10-24 23:04:53', 1, 1);
INSERT INTO `size` VALUES (509, 206, '5-6人', 398.00, 20, 20, 1180, '2025-10-24 23:04:53', '2025-10-24 23:04:53', 1, 1);
INSERT INTO `size` VALUES (510, 207, '1-2人', 178.00, 15, 15, 520, '2025-10-24 23:05:07', '2025-10-24 23:05:07', 1, 1);
INSERT INTO `size` VALUES (511, 207, '3-4人', 278.00, 18, 18, 820, '2025-10-24 23:05:07', '2025-10-24 23:05:07', 1, 1);
INSERT INTO `size` VALUES (512, 207, '5-6人', 378.00, 20, 20, 1220, '2025-10-24 23:05:07', '2025-10-24 23:05:07', 1, 1);
INSERT INTO `size` VALUES (516, 209, '1-2人', 158.00, 15, 15, 510, '2025-10-24 23:05:39', '2025-10-24 23:05:39', 1, 1);
INSERT INTO `size` VALUES (517, 209, '3-4人', 258.00, 18, 18, 810, '2025-10-24 23:05:39', '2025-10-24 23:05:39', 1, 1);
INSERT INTO `size` VALUES (518, 209, '5-6人', 358.00, 20, 20, 1210, '2025-10-24 23:05:39', '2025-10-24 23:05:39', 1, 1);
INSERT INTO `size` VALUES (519, 210, '1杯', 28.00, 0, 0, 150, NULL, NULL, NULL, NULL);
INSERT INTO `size` VALUES (520, 211, '6片装', 45.00, 0, 0, 200, NULL, NULL, NULL, NULL);
INSERT INTO `size` VALUES (521, 212, '4块装', 58.00, 0, 0, 300, NULL, NULL, NULL, NULL);
INSERT INTO `size` VALUES (522, 213, '1个', 35.00, 0, 0, 180, NULL, NULL, NULL, NULL);
INSERT INTO `size` VALUES (523, 214, '1杯', 32.00, 0, 0, 160, NULL, NULL, NULL, NULL);
INSERT INTO `size` VALUES (524, 215, '4个装', 42.00, 0, 0, 220, NULL, NULL, NULL, NULL);
INSERT INTO `size` VALUES (525, 216, '1个', 38.00, 0, 0, 190, NULL, NULL, NULL, NULL);
INSERT INTO `size` VALUES (526, 217, '小型宠物', 108.00, 10, 10, 350, '2025-10-24 23:09:04', '2025-10-24 23:09:04', 1, 1);
INSERT INTO `size` VALUES (527, 217, '中型宠物', 148.00, 13, 13, 500, '2025-10-24 23:09:04', '2025-10-24 23:09:04', 1, 1);
INSERT INTO `size` VALUES (528, 217, '大型宠物', 188.00, 15, 15, 650, '2025-10-24 23:09:04', '2025-10-24 23:09:04', 1, 1);
INSERT INTO `size` VALUES (529, 218, '小型宠物', 128.00, 10, 10, 320, '2025-10-24 23:09:15', '2025-10-24 23:09:15', 1, 1);
INSERT INTO `size` VALUES (530, 218, '中型宠物', 168.00, 13, 13, 480, '2025-10-24 23:09:15', '2025-10-24 23:09:15', 1, 1);
INSERT INTO `size` VALUES (531, 218, '大型宠物', 208.00, 15, 15, 620, '2025-10-24 23:09:15', '2025-10-24 23:09:15', 1, 1);
INSERT INTO `size` VALUES (532, 219, '小型宠物', 118.00, 10, 10, 380, '2025-10-24 23:09:26', '2025-10-24 23:09:26', 1, 1);
INSERT INTO `size` VALUES (533, 219, '中型宠物', 158.00, 13, 13, 550, '2025-10-24 23:09:26', '2025-10-24 23:09:26', 1, 1);
INSERT INTO `size` VALUES (534, 219, '大型宠物', 198.00, 15, 15, 700, '2025-10-24 23:09:26', '2025-10-24 23:09:26', 1, 1);
INSERT INTO `size` VALUES (535, 220, '小型宠物', 98.00, 10, 10, 330, '2025-10-24 23:09:45', '2025-10-24 23:09:45', 1, 1);
INSERT INTO `size` VALUES (536, 220, '中型宠物', 138.00, 13, 13, 490, '2025-10-24 23:09:45', '2025-10-24 23:09:45', 1, 1);
INSERT INTO `size` VALUES (537, 220, '大型宠物', 178.00, 15, 15, 640, '2025-10-24 23:09:45', '2025-10-24 23:09:45', 1, 1);
INSERT INTO `size` VALUES (541, 221, '小型宠物', 138.00, 12, 12, 400, '2025-10-24 23:09:58', '2025-10-24 23:09:58', 1, 1);
INSERT INTO `size` VALUES (542, 221, '中型宠物', 178.00, 15, 15, 600, '2025-10-24 23:09:58', '2025-10-24 23:09:58', 1, 1);
INSERT INTO `size` VALUES (543, 221, '大型宠物', 218.00, 18, 18, 800, '2025-10-24 23:09:58', '2025-10-24 23:09:58', 1, 1);
INSERT INTO `size` VALUES (562, 222, '1-2人', 198.00, 15, 15, 520, '2025-10-24 23:25:00', '2025-10-24 23:25:00', 1, 1);
INSERT INTO `size` VALUES (563, 222, '3-4人', 298.00, 18, 18, 820, '2025-10-24 23:25:00', '2025-10-24 23:25:00', 1, 1);
INSERT INTO `size` VALUES (564, 222, '5-6人', 398.00, 20, 20, 1220, '2025-10-24 23:25:00', '2025-10-24 23:25:00', 1, 1);
INSERT INTO `size` VALUES (565, 223, '1-2人', 228.00, 15, 15, 550, '2025-10-24 23:25:13', '2025-10-24 23:25:13', 1, 1);
INSERT INTO `size` VALUES (566, 223, '3-4人', 328.00, 18, 18, 850, '2025-10-24 23:25:13', '2025-10-24 23:25:13', 1, 1);
INSERT INTO `size` VALUES (567, 223, '5-6人', 428.00, 20, 20, 1250, '2025-10-24 23:25:13', '2025-10-24 23:25:13', 1, 1);
INSERT INTO `size` VALUES (569, 225, '4个装', 52.00, 0, 0, 240, NULL, NULL, NULL, NULL);
INSERT INTO `size` VALUES (570, 226, '6个装', 48.00, 0, 0, 280, NULL, NULL, NULL, NULL);
INSERT INTO `size` VALUES (571, 227, '小型宠物', 138.00, 10, 10, 320, '2025-10-24 23:27:30', '2025-10-24 23:27:30', 1, 1);
INSERT INTO `size` VALUES (572, 227, '中型宠物', 178.00, 13, 13, 480, '2025-10-24 23:27:30', '2025-10-24 23:27:30', 1, 1);
INSERT INTO `size` VALUES (573, 227, '大型宠物', 218.00, 15, 15, 620, '2025-10-24 23:27:30', '2025-10-24 23:27:30', 1, 1);
INSERT INTO `size` VALUES (574, 228, '小型宠物', 118.00, 10, 10, 350, '2025-10-24 23:27:39', '2025-10-24 23:27:39', 1, 1);
INSERT INTO `size` VALUES (575, 228, '中型宠物', 158.00, 13, 13, 520, '2025-10-24 23:27:39', '2025-10-24 23:27:39', 1, 1);
INSERT INTO `size` VALUES (576, 228, '大型宠物', 198.00, 15, 15, 680, '2025-10-24 23:27:39', '2025-10-24 23:27:39', 1, 1);
INSERT INTO `size` VALUES (577, 229, '小型宠物', 128.00, 10, 10, 300, '2025-10-24 23:27:58', '2025-10-24 23:27:58', 1, 1);
INSERT INTO `size` VALUES (578, 229, '中型宠物', 168.00, 13, 13, 460, '2025-10-24 23:27:58', '2025-10-24 23:27:58', 1, 1);
INSERT INTO `size` VALUES (579, 229, '大型宠物', 208.00, 15, 15, 600, '2025-10-24 23:27:58', '2025-10-24 23:27:58', 1, 1);
INSERT INTO `size` VALUES (580, 208, '1-2人', 168.00, 15, 15, 490, '2025-10-25 00:37:38', '2025-10-25 00:37:38', 1, 1);
INSERT INTO `size` VALUES (581, 208, '3-4人', 268.00, 18, 18, 790, '2025-10-25 00:37:38', '2025-10-25 00:37:38', 1, 1);
INSERT INTO `size` VALUES (582, 208, '5-6人', 368.00, 20, 20, 1190, '2025-10-25 00:37:38', '2025-10-25 00:37:38', 1, 1);
INSERT INTO `size` VALUES (583, 138, '1-2人', 168.00, 15, 15, 520, '2025-10-25 16:39:56', '2025-10-25 16:39:56', 1, 1);
INSERT INTO `size` VALUES (584, 138, '4-5人', 368.00, 18, 18, 820, '2025-10-25 16:39:56', '2025-10-25 16:39:56', 1, 1);
INSERT INTO `size` VALUES (585, 138, '7-8人', 568.00, 20, 20, 1220, '2025-10-25 16:39:56', '2025-10-25 16:39:56', 1, 1);
INSERT INTO `size` VALUES (586, 181, '4个装', 68.00, 0, 0, 400, NULL, NULL, NULL, NULL);
INSERT INTO `size` VALUES (587, 224, '8粒装', 68.00, 0, 0, 180, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for taste
-- ----------------------------
DROP TABLE IF EXISTS `taste`;
CREATE TABLE `taste`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `flavor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '口味',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of taste
-- ----------------------------
INSERT INTO `taste` VALUES (1, '草莓');
INSERT INTO `taste` VALUES (2, '芒果');
INSERT INTO `taste` VALUES (3, '香草');
INSERT INTO `taste` VALUES (4, '巧克力');
INSERT INTO `taste` VALUES (5, '哈密瓜');
INSERT INTO `taste` VALUES (6, '奥利奥');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名称',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `amount` decimal(10, 2) NOT NULL COMMENT '用户余额',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', 86944.00);
INSERT INTO `user` VALUES (2, NULL, '132321', 96487.00);
INSERT INTO `user` VALUES (3, NULL, '78987', 96487.00);
INSERT INTO `user` VALUES (4, 'lsjfuiehfgu', '465482', 96487.00);
INSERT INTO `user` VALUES (5, 'lsjfuiehf', '465482', 96487.00);
INSERT INTO `user` VALUES (6, 'lsjfui', '465482', 96487.00);
INSERT INTO `user` VALUES (7, 'lsjf', '465482', 96487.00);
INSERT INTO `user` VALUES (8, 'ehtrjd', '132456', 96487.00);
INSERT INTO `user` VALUES (9, 'cdsfe', '178954', 96487.00);
INSERT INTO `user` VALUES (10, '765', '04452d9cec10c02ac3407ce6c4caefdd', 10000000.00);
INSERT INTO `user` VALUES (11, '765', '04452d9cec10c02ac3407ce6c4caefdd', 10000000.00);
INSERT INTO `user` VALUES (12, '765', '04452d9cec10c02ac3407ce6c4caefdd', 10000000.00);
INSERT INTO `user` VALUES (13, '765', '04452d9cec10c02ac3407ce6c4caefdd', 10000000.00);
INSERT INTO `user` VALUES (14, '765', '04452d9cec10c02ac3407ce6c4caefdd', 10000000.00);
INSERT INTO `user` VALUES (15, 'dhjsh', 'c9d5efdd71424fc48e4ecf2bdcc9fa2a', 10000000.00);
INSERT INTO `user` VALUES (16, 'dhjsh', '462678e0be7a2145a1040862b0e359d8', 10000000.00);
INSERT INTO `user` VALUES (17, 'dbdhs', 'a53fb24b242df9f2689150250aefc507', 10000000.00);
INSERT INTO `user` VALUES (18, 'hdsg', 'b5d1f7f771842b02a275d2800fa4a7da', 10000000.00);
INSERT INTO `user` VALUES (19, 'hhhhhh', 'a63d6b2a927de87ad1506b5351fe7d76', 10000000.00);
INSERT INTO `user` VALUES (20, 'hhhhds', '6474aa78544181d78cd2612faf16a336', 10000000.00);
INSERT INTO `user` VALUES (21, 'hdgsbbbbb', 'cf5b556dba671451882addb45ac2ce66', 10000000.00);

SET FOREIGN_KEY_CHECKS = 1;
