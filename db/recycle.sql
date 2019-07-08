/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : 127.0.0.1:3306
 Source Schema         : recycle

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 08/07/2019 17:48:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `code` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '编码（备用）',
  `name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名中文称',
  `name_english` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '英文名称',
  `sort` smallint(4) NOT NULL COMMENT '排序用权重（数字小的在前面）',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父级id',
  `level` smallint(4) NOT NULL DEFAULT 1 COMMENT '级别，1=第一级，2=第二级，，，',
  `state` smallint(4) NOT NULL DEFAULT 0 COMMENT '状态，暂时规划true=非0/false=0',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单URL地址',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'icon地址',
  `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `system_id` bigint(20) NULL DEFAULT NULL COMMENT '适用系统的id（备用）',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_date` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `inx_name`(`name`) USING BTREE COMMENT '名称索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 'SN001', '首页', 'home', 1, NULL, 1, 1, '/home', NULL, 'for test', NULL, '2019-07-08 17:47:43', '2019-07-08 17:47:43');
INSERT INTO `sys_menu` VALUES (2, 'SN001', '页2', '22', 1, NULL, 1, 1, '/home2', NULL, 'for test', NULL, '2019-07-08 17:47:43', '2019-07-08 17:47:43');

SET FOREIGN_KEY_CHECKS = 1;
