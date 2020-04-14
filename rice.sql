/*
Navicat MySQL Data Transfer

Source Server         : riceOrdering
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : rice

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2020-04-14 17:22:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `house_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('3', 'oYj2g4sE13SOPl4XPlDqctH2ki4M', 'cj', '先生', '13254848877', '四川省宜宾市叙州区蜀南大道南段', 'c-427');

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('admin', '123', '1');

-- ----------------------------
-- Table structure for business
-- ----------------------------
DROP TABLE IF EXISTS `business`;
CREATE TABLE `business` (
  `business_id` int(11) NOT NULL AUTO_INCREMENT,
  `business_name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `activity` varchar(255) DEFAULT NULL,
  `delivery_time` varchar(255) DEFAULT NULL,
  `delivery_scope` int(255) DEFAULT NULL,
  `chart_1` varchar(50) DEFAULT NULL,
  `chart_2` varchar(50) DEFAULT NULL,
  `chart_3` varchar(50) DEFAULT NULL,
  `business_license` varchar(255) DEFAULT NULL,
  `start_delivery` int(255) DEFAULT NULL,
  `delivery_fee` int(255) DEFAULT NULL,
  `delivery_service` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `pack_fee` decimal(10,2) DEFAULT NULL,
  `service_time` int(11) DEFAULT NULL,
  `business_status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`business_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of business
-- ----------------------------
INSERT INTO `business` VALUES ('1', '天天饭店', '钱文琦文', '配送时间：早上9：00--12：00   下午14：00--19：00', '9:00--18:00', '4000', '/photos/腊斯克.jpg', '/photos/小票模板.png', '/photos/青椒肉丝.jpg', '/photos/小票模板.png', '11', '1', '自家', '123654874564', '0.50', '30', '0');

-- ----------------------------
-- Table structure for category_food
-- ----------------------------
DROP TABLE IF EXISTS `category_food`;
CREATE TABLE `category_food` (
  `sort` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(255) NOT NULL,
  `selected` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`sort`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category_food
-- ----------------------------
INSERT INTO `category_food` VALUES ('1', '炒饭', '0');
INSERT INTO `category_food` VALUES ('2', '炒菜', '0');
INSERT INTO `category_food` VALUES ('3', '面条', '0');
INSERT INTO `category_food` VALUES ('4', '盖饭', '0');

-- ----------------------------
-- Table structure for food
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food` (
  `food_name` varchar(255) NOT NULL,
  `category` varchar(255) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `describ` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pack_fee` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of food
-- ----------------------------
INSERT INTO `food` VALUES ('青椒肉丝', '盖饭', '20.00', '好吃', '/photos/青椒肉丝.jpg', '1', '1');

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `order_id` varchar(255) NOT NULL,
  `food_name` varchar(255) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `num` int(11) NOT NULL,
  `food_icon` varchar(255) NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES ('120041315252222302', '青椒肉丝', '20.00', '1', '/photos/青椒肉丝.jpg');
INSERT INTO `order_detail` VALUES ('120041315263434558', '青椒肉丝', '20.00', '1', '/photos/青椒肉丝.jpg');
INSERT INTO `order_detail` VALUES ('120041315290808740', '青椒肉丝', '20.00', '1', '/photos/青椒肉丝.jpg');

-- ----------------------------
-- Table structure for order_food
-- ----------------------------
DROP TABLE IF EXISTS `order_food`;
CREATE TABLE `order_food` (
  `order_id` varchar(255) NOT NULL,
  `order_state` varchar(255) NOT NULL DEFAULT '待配送',
  `user_name` varchar(255) NOT NULL,
  `telephone` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `total_price` decimal(10,2) NOT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `tableware_quantity` varchar(50) NOT NULL,
  `delivery_time` varchar(255) NOT NULL,
  `order_time` varchar(255) NOT NULL,
  `pack_fee` int(11) DEFAULT NULL,
  `delivery_fee` int(11) DEFAULT NULL,
  `actual_pay` decimal(10,0) DEFAULT NULL,
  `openid` varchar(255) DEFAULT NULL,
  `food_num` int(11) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_food
-- ----------------------------
INSERT INTO `order_food` VALUES ('120041315290808740', '已配送', 'cj', '15651615132', '四川省宜宾市叙州区蜀南大道南段', '20.00', '多点辣', '无需餐具', '2020年04月13日 15:59', '2020年04月13日 15:29', '1', '1', '22', 'oYj2g4sE13SOPl4XPlDqctH2ki4M', '1', '先生');

-- ----------------------------
-- Table structure for printernew
-- ----------------------------
DROP TABLE IF EXISTS `printernew`;
CREATE TABLE `printernew` (
  `id` int(11) NOT NULL,
  `deviceidID` varchar(255) DEFAULT NULL,
  `devicesecret` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of printernew
-- ----------------------------
INSERT INTO `printernew` VALUES ('1', '23123123112', '321321121');
