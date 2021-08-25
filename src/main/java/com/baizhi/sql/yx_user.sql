/*
 Navicat Premium Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 50550
 Source Host           : 127.0.0.1:3306
 Source Schema         : 2009yingx

 Target Server Type    : MySQL
 Target Server Version : 50550
 File Encoding         : 65001

 Date: 25/08/2021 13:56:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for yx_user
-- ----------------------------
DROP TABLE IF EXISTS `yx_user`;
CREATE TABLE `yx_user`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sign` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `head_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wechat` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of yx_user
-- ----------------------------
INSERT INTO `yx_user` VALUES ('1', '小黑', '111111', 'lalala2222', '1.jpg', '123', '123', '1', '2021-03-25 08:00:00', '男', '新疆');
INSERT INTO `yx_user` VALUES ('3', '测试', '测试', '测试', 'http://yingxs-2009.oss-cn-beijing.aliyuncs.com/photo/1616136872519-4.jpg', '12', '12', '1', '2021-04-16 14:54:32', '女', '河北');
INSERT INTO `yx_user` VALUES ('4', 'admin', '111111', '蓝色汽车', 'http://yingxs-2009.oss-cn-beijing.aliyuncs.com/photo/1616136623182-9.jpg', '15236674712', '15236674712', '0', '2021-05-14 14:50:23', '男', '河南');
INSERT INTO `yx_user` VALUES ('5', '21', '12', '12', 'http://yingxs-2009.oss-cn-beijing.aliyuncs.com/photo/1616403447881-9.jpg', '12', '12', '0', '2021-05-21 16:57:27', '女', '河南');
INSERT INTO `yx_user` VALUES ('6', 'xiaohei', '111111', '阿斯顿撒多', 'http://yingxs-2009.oss-cn-beijing.aliyuncs.com/photo/1616137062368-2.jpg', '15236674712', '15236674712', '1', '2021-01-26 14:57:42', '男', '湖北');
INSERT INTO `yx_user` VALUES ('7', 'guest', '111111', '阿斯顿撒多ssss', 'http://yingxs-2009.oss-cn-beijing.aliyuncs.com/photo/1616136641269-11.jpg', '15236674712', '15236674712', '0', '2021-01-18 08:00:00', '女', '云南');

SET FOREIGN_KEY_CHECKS = 1;
