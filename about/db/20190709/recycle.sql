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

 Date: 09/07/2019 17:26:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名称',
  `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '说明',
  `name_english` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名称（英文）',
  `note_english` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '说明（英文）',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图标',
  `icon_full` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图标大图',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '液体垃圾', '液体垃圾', 'Liquid Waste', 'Liquid waste is commonly found both in households as well as in industries. This waste includes dirty water, organic liquids, wash water, waste detergents and even rainwater.', NULL, NULL);
INSERT INTO `category` VALUES (2, '有害垃圾', '那些易燃的，有毒的，腐蚀性的，放射性的，都属于危险垃圾。这些垃圾既污染环境，对人体也有害，所以回收处理时一定要格外注意。', 'Hazardous Waste', 'Hazardous waste includes all types of rubbish that are flammable, toxic, corrosive and reactive. These items can harm you as well as the environment and must be disposed of correctly.', NULL, NULL);
INSERT INTO `category` VALUES (4, '固体垃圾', '包括塑料，纸张，易拉罐和金属，陶瓷和玻璃等几类。', 'Solid Rubbish', 'Solid rubbish can include a variety of items found in your household along with commercial and industrial locations. Solid rubbish is commonly broken down into the following types: plastic waste, paper waste, tins and metals, ceramics and glass.', NULL, NULL);
INSERT INTO `category` VALUES (5, '有机垃圾', '很多有机垃圾都来自家庭日常，比如食物残余，植物垃圾，肥料，腐肉等等都属于有机垃圾。时间长了，有机垃圾会产生甲烷（易燃易爆气体），所以有机垃圾绝对不能跟其他垃圾一并丢弃。', 'Organic Waste', 'Organic waste is another common household. All food waste, garden waste, manure and rotten meat are classified as organic waste. Over time, organic waste causes the production of methane, so it must never be simply discarded with general waste.', NULL, NULL);
INSERT INTO `category` VALUES (6, '可回收垃圾', '那些可以重复再利用的，都可以称为可回收垃圾，比如纸张，金属，家具，还有一些有机垃圾都可以回收再利用。', 'Recyclable Rubbish', 'Recyclable rubbish includes all waste items that can be converted into products that can be used again. Solid items such as paper, metals, furniture and organic waste can all be recycled.', NULL, NULL);

-- ----------------------------
-- Table structure for daily_necessities
-- ----------------------------
DROP TABLE IF EXISTS `daily_necessities`;
CREATE TABLE `daily_necessities`  (
  `id` bigint(20) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名称',
  `name_english` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名称_英文',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述',
  `description_english` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述英文',
  `approach` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '处理方法',
  `properties` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性质',
  `approach_english` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '处理方法_英文',
  `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '注释',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图片地址，注意可以扩展成多图形式，用图片表一对多',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '常见生活用品' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for laws_regulation
-- ----------------------------
DROP TABLE IF EXISTS `laws_regulation`;
CREATE TABLE `laws_regulation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名称',
  `summary` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '摘要',
  `publish_time` datetime(0) NULL DEFAULT NULL COMMENT '发布时间',
  `correction_time` datetime(0) NULL DEFAULT NULL COMMENT '修正时间',
  `effective_time` datetime(0) NULL DEFAULT NULL COMMENT '生效时间',
  `area_code` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '适用地区编码',
  `area_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '适用地区名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '法律法规' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of laws_regulation
-- ----------------------------
INSERT INTO `laws_regulation` VALUES (1, '《中华人民共和国环境保护法》', '1989年12月26日公布并实施的《中华人民共和国环境保护法》是环境保护方面的基本法，其中第四章“防治环境污染和其他公害”专门规定了防治包括城市垃圾在内的污染物对环境的污染，是城市垃圾管理及污染防治其他立法的基础，但该法中对于城市生活垃圾分类并无具体规定。', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `laws_regulation` VALUES (2, '《中华人民共和国固体废物污染环境防治法》', '（2004年修订）（以下简称《固体废物污染环境防治法》）\r\n\r\n《固体废物污染环境防治法》是中国防治固体废物污染的单行法，该法第三章第三节为“生活垃圾污染环境的防治”，其中第四十二条中做出了对城市生活垃圾分类的规定：“对城市生活垃圾应当及时清运，逐步做到分类收集和运输，并积极开展合理利用和实施无害化处置。', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `laws_regulation` VALUES (3, '《城市市容和环境卫生管理条例》', '国务院1992年颁布的《城市市容和环境卫生管理条例》是系统地对城市固体废物进行管理的法令，其中第二十八条规定：“对城市生活废弃物应当逐步做到分类收集、运输和处理。”', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `laws_regulation` VALUES (4, '《城市生活垃圾管理办法》', '（2007年）\r\n　　\r\n2007年4月建设部颁布了《城市生活垃圾管理办法》，随着经济水平的不断提高，新的城市生活垃圾管理存在的问题日益突出，迫使相关部门对此做出相应措施，其中对于垃圾分类有了较详细的规定。第三章第十五条规定：“城市生活垃圾应当逐步实行分类投放、收集和运输。具体办法，由直辖市、市、县人民政府建设（环境卫生）主管部门根据国家标准和本地区实际制定。”第十六条第二款规定：“城市生活垃圾实行分类收集的地区，单位和个人应当按照规定的分类要求，将生活垃圾装入相应的垃圾袋内，投入指定的垃圾容器或者收集场所。”\r\n', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `laws_regulation` VALUES (5, NULL, '城市生活垃圾分类是指按照城市生活垃圾的不同性质、不同处置方式的要求，从垃圾产生的源头上将垃圾分类后收集、储存及运输，它是城市生活垃圾处理体系中的一个关键环节。通过垃圾分类，可有效地实现废弃物的重新利用和最大程度的废品回收，为先进的垃圾处理方式的应用奠定基础，为垃圾处理实现减量化、资源化、无害化目标创造良好条件。目前西方发达国家普遍采用垃圾分类的方法，垃圾分类的法律体系相对完善。而中国城市生活垃圾分类处于起步阶段，现存的相关法律体系不健全，大部分城市还是实行垃圾混合收集的方式，这些给资源回收及处理带来极大困难，也给环境污染的治理提出了巨大挑战。', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for refuse_classification
-- ----------------------------
DROP TABLE IF EXISTS `refuse_classification`;
CREATE TABLE `refuse_classification`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '垃圾分类' ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 'NO0001', '可回收物', 'Recyclable Rubbish', 1, NULL, 1, 1, '/recyclableRubbish', NULL, '那些可以重复再利用的，都可以称为可回收垃圾，比如纸张，金属，家具，还有一些有机垃圾都可以回收再利用。', 1, NULL, '2019-07-09 17:18:19');
INSERT INTO `sys_menu` VALUES (2, 'NO0002', '有害垃圾', 'Hazardous Waste', 2, NULL, 1, 1, '/recyclableRubbish', NULL, '那些易燃的，有毒的，腐蚀性的，放射性的，都属于危险垃圾。这些垃圾既污染环境，对人体也有害，所以回收处理时一定要格外注意。', 1, NULL, '2019-07-09 17:18:19');
INSERT INTO `sys_menu` VALUES (3, 'NO0003', '有机垃圾', 'Recyclable Rubbish', 3, NULL, 1, 1, '/recyclableRubbish', NULL, 'bbish', 1, NULL, '2019-07-09 17:18:19');
INSERT INTO `sys_menu` VALUES (4, 'NO0004', '其他垃圾(固体垃圾)', 'Organic Waste', 4, NULL, 1, 1, '/recyclableRubbish', NULL, '很多有机垃圾都来自家庭日常，比如食物残余，植物垃圾，肥料，腐肉等等都属于有机垃圾。时间长了，有机垃圾会产生甲烷（易燃易爆气体），所以有机垃圾绝对不能跟其他垃圾一并丢弃。', 1, NULL, '2019-07-09 17:18:19');
INSERT INTO `sys_menu` VALUES (5, 'NO0005', '其他垃圾(液体垃圾)', 'Liquid Waste', 5, NULL, 1, 1, '/recyclableRubbish', NULL, 'Liquid waste is commonly found both in households as well as in industries. This waste includes dirty water, organic liquids, wash water, waste detergents and even rainwater.', 1, NULL, '2019-07-09 17:18:19');

SET FOREIGN_KEY_CHECKS = 1;
