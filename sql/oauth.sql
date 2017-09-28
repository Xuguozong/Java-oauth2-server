/*
Navicat MySQL Data Transfer

Source Server         : 118
Source Server Version : 50717
Source Host           : 192.168.1.118:3306
Source Database       : oauth

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-09-28 14:34:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_access_token
-- ----------------------------
DROP TABLE IF EXISTS `t_access_token`;
CREATE TABLE `t_access_token` (
  `auth_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `token` varchar(100) NOT NULL,
  `expires_in` bigint(20) NOT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`auth_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_access_token
-- ----------------------------
INSERT INTO `t_access_token` VALUES ('1', '1', 'i-qEAtagWk9fXmvZFDxEGnd2aV7D_w9TqYBd_nlwMAuCT6GnXCkQoVlfRSLSUcibLsSAp8QHsToJI1ev', '31200', '2017-09-28 10:46:57');

-- ----------------------------
-- Table structure for t_auth_info
-- ----------------------------
DROP TABLE IF EXISTS `t_auth_info`;
CREATE TABLE `t_auth_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `client_id` varchar(100) NOT NULL,
  `scope` varchar(50) DEFAULT NULL,
  `refresh_token` varchar(100) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `redirecr_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_auth_info
-- ----------------------------
INSERT INTO `t_auth_info` VALUES ('1', '1', 'H6JL-cyC0GH4qi1E-0BTw5YZSXGOXBBQwYY17O9aeJgmR01HMLkRTjgUPglpc0CE7O9ELe49CBQEI-r4', null, 'i-qEAtagWk9fXmvZFDxEGnd2aV7D_w9TqYBd_nlwMAuCT6GnXCkQoVlfRSLSUcibLsSAp8QHsToJI1ev', null, null);

-- ----------------------------
-- Table structure for t_credential
-- ----------------------------
DROP TABLE IF EXISTS `t_credential`;
CREATE TABLE `t_credential` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `client_id` varchar(100) NOT NULL,
  `client_secret` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_credential
-- ----------------------------
INSERT INTO `t_credential` VALUES ('1', '1', 'H6JL-cyC0GH4qi1E-0BTw5YZSXGOXBBQwYY17O9aeJgmR01HMLkRTjgUPglpc0CE7O9ELe49CBQEI-r4', 'U-a9xe3yLHo44y0Pk851CzYtGoFHWjXnWSr_1BG6sWZDlM_uIUtsGbtK1iSitaSrm2VKB7nSm7K0XJsJ');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
