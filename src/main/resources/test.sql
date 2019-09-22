/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : 127.0.0.1:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 22/09/2019 11:36:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 53514 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'frank', 'as', 1);
INSERT INTO `user` VALUES (2, 'jeck', '3412341234', 0);
INSERT INTO `user` VALUES (1224, 'asdff', '9877856', 25);
INSERT INTO `user` VALUES (1225, 'mark', '856', 15);
INSERT INTO `user` VALUES (1230, 'salary', '3412341234', 0);
INSERT INTO `user` VALUES (1231, '李丽', '12345', 18);
INSERT INTO `user` VALUES (1234, 'salary', '776', 34);
INSERT INTO `user` VALUES (1235, 'salary', '776', 34);
INSERT INTO `user` VALUES (1262, 'admin', '12', 12);
INSERT INTO `user` VALUES (1263, 'admin', '12', 12);
INSERT INTO `user` VALUES (1271, 'admin', '12', 12);
INSERT INTO `user` VALUES (1272, 'hello', '12', 12);
INSERT INTO `user` VALUES (1276, 'admin', '12', 12);
INSERT INTO `user` VALUES (53508, 'frank', 'root', 23);
INSERT INTO `user` VALUES (53509, 'frank', 'as', 12);
INSERT INTO `user` VALUES (53510, 'frank', 'as', 1);
INSERT INTO `user` VALUES (53511, 'frank', 'as', 1);
INSERT INTO `user` VALUES (53512, 'dasd', 'cxas', 43);
INSERT INTO `user` VALUES (53513, 'dasd', 'cxas', 43);

SET FOREIGN_KEY_CHECKS = 1;
