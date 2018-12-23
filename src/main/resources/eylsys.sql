/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : eylsys

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2018-12-23 11:04:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account_info
-- ----------------------------
DROP TABLE IF EXISTS `account_info`;
CREATE TABLE `account_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `day` date DEFAULT NULL,
  `man_count` int(10) DEFAULT NULL,
  `order_count` int(11) DEFAULT NULL,
  `order_money` double DEFAULT NULL,
  `cash_count` double DEFAULT NULL,
  `checkin_count` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account_info
-- ----------------------------

-- ----------------------------
-- Table structure for account_room
-- ----------------------------
DROP TABLE IF EXISTS `account_room`;
CREATE TABLE `account_room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `room_type_id` int(11) DEFAULT NULL COMMENT '房间类型id',
  `day` date DEFAULT NULL COMMENT '时间',
  `filled_num` int(11) DEFAULT NULL COMMENT '入住房间数',
  `unfilled_num` int(11) DEFAULT NULL COMMENT '未入住房间数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account_room
-- ----------------------------

-- ----------------------------
-- Table structure for check_info
-- ----------------------------
DROP TABLE IF EXISTS `check_info`;
CREATE TABLE `check_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stay_id` int(11) DEFAULT NULL,
  `due_money` double DEFAULT NULL,
  `order_money` double DEFAULT NULL,
  `discount_type` varchar(20) DEFAULT NULL,
  `discount_rate` double DEFAULT NULL,
  `paid_up_money` double DEFAULT NULL,
  `check_date` datetime DEFAULT NULL,
  `operator` varchar(20) DEFAULT NULL,
  `createdTime` datetime DEFAULT NULL,
  `modifiedTime` datetime DEFAULT NULL,
  `cash_pledge` double DEFAULT NULL,
  `late_arrival_need_pay` double DEFAULT NULL,
  `early_leave-need_pay` double DEFAULT NULL,
  `stay_day_need_pay` double DEFAULT NULL,
  `late_arrival_day` int(20) DEFAULT NULL,
  `early_leave_day` int(20) DEFAULT NULL,
  `stay_day` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `check_info_ibfk_1` FOREIGN KEY (`id`) REFERENCES `stay_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of check_info
-- ----------------------------
INSERT INTO `check_info` VALUES ('1', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for customer_card_type
-- ----------------------------
DROP TABLE IF EXISTS `customer_card_type`;
CREATE TABLE `customer_card_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `card_type` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer_card_type
-- ----------------------------
INSERT INTO `customer_card_type` VALUES ('1', '身份证');
INSERT INTO `customer_card_type` VALUES ('2', '护照');

-- ----------------------------
-- Table structure for customer_info
-- ----------------------------
DROP TABLE IF EXISTS `customer_info`;
CREATE TABLE `customer_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(20) DEFAULT NULL,
  `gender` char(2) DEFAULT NULL,
  `vip_level` int(10) DEFAULT NULL COMMENT 'null表示不是vip,4,5,6,7为等级',
  `country` varchar(50) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `card_type_id` int(20) DEFAULT NULL,
  `card_num` varchar(20) DEFAULT NULL,
  `operator` varchar(20) DEFAULT NULL,
  `createdTime` datetime DEFAULT NULL,
  `modifiedTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer_info
-- ----------------------------
INSERT INTO `customer_info` VALUES ('1', '李菲菲', '女', '2', '中国', '13036985274', '1', '4566887992545', '54654', '2018-12-27 09:02:38', '2018-12-20 09:02:42');
INSERT INTO `customer_info` VALUES ('2', '刘帅帅', '男', null, '越南', '17025689345', '2', '54661646456', '465464', '2018-12-26 09:02:46', '2018-12-20 09:02:50');
INSERT INTO `customer_info` VALUES ('3', '刘帅帅', null, null, null, '17025657899', null, null, null, null, null);

-- ----------------------------
-- Table structure for customer_type
-- ----------------------------
DROP TABLE IF EXISTS `customer_type`;
CREATE TABLE `customer_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_type` varchar(20) DEFAULT NULL COMMENT '顾客类型',
  `discount_per` double DEFAULT NULL COMMENT '打折比例',
  `late_arrive_per` double DEFAULT NULL COMMENT '晚到收费比例',
  `early_leave_per` double DEFAULT NULL COMMENT '提前离开收费比例',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer_type
-- ----------------------------
INSERT INTO `customer_type` VALUES ('1', '散户', '1', '1', '1');
INSERT INTO `customer_type` VALUES ('2', '组团', '0.9', '1', '1');
INSERT INTO `customer_type` VALUES ('3', '政府', '0.8', '0.9', '0.8');
INSERT INTO `customer_type` VALUES ('4', 'VIP1', '0.85', '0.8', '0.8');
INSERT INTO `customer_type` VALUES ('5', 'VIP2', '0.8', '0.7', '0.6');
INSERT INTO `customer_type` VALUES ('6', 'VIP3', '0.75', '0.7', '0.5');
INSERT INTO `customer_type` VALUES ('7', 'VIP4', '0.7', '0.6', '0.4');

-- ----------------------------
-- Table structure for july_price
-- ----------------------------
DROP TABLE IF EXISTS `july_price`;
CREATE TABLE `july_price` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `day` datetime DEFAULT NULL COMMENT '当天日期',
  `price_std` int(11) DEFAULT NULL COMMENT '每日基准价格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of july_price
-- ----------------------------
INSERT INTO `july_price` VALUES ('1', '2018-12-02 12:00:00', '200');
INSERT INTO `july_price` VALUES ('2', '2018-12-03 12:00:00', '201');
INSERT INTO `july_price` VALUES ('3', '2018-12-04 12:00:00', '202');
INSERT INTO `july_price` VALUES ('4', '2018-12-05 12:00:00', '204');
INSERT INTO `july_price` VALUES ('5', '2018-12-06 12:00:00', '210');
INSERT INTO `july_price` VALUES ('6', '2018-12-07 12:00:00', '205');
INSERT INTO `july_price` VALUES ('7', '2018-12-08 12:00:00', '220');
INSERT INTO `july_price` VALUES ('8', '2018-12-09 12:00:00', '270');
INSERT INTO `july_price` VALUES ('9', '2018-12-10 12:00:00', '230');
INSERT INTO `july_price` VALUES ('10', '2018-12-11 12:00:00', '250');
INSERT INTO `july_price` VALUES ('11', '2018-12-12 12:00:00', '215');
INSERT INTO `july_price` VALUES ('12', '2018-12-13 12:00:00', '221');
INSERT INTO `july_price` VALUES ('13', '2018-12-14 12:00:00', '223');
INSERT INTO `july_price` VALUES ('14', '2018-12-15 12:00:00', '225');
INSERT INTO `july_price` VALUES ('15', '2018-12-16 12:00:00', '276');
INSERT INTO `july_price` VALUES ('16', '2018-12-17 12:00:00', '277');
INSERT INTO `july_price` VALUES ('17', '2018-12-18 12:00:00', '256');
INSERT INTO `july_price` VALUES ('18', '2018-12-19 12:00:00', '248');
INSERT INTO `july_price` VALUES ('19', '2018-12-20 12:00:00', '498');
INSERT INTO `july_price` VALUES ('20', '2018-12-21 12:00:00', '487');
INSERT INTO `july_price` VALUES ('21', '2018-12-22 12:00:00', '126');
INSERT INTO `july_price` VALUES ('22', '2018-12-23 12:00:00', '489');
INSERT INTO `july_price` VALUES ('23', '2018-12-24 12:00:00', '551');
INSERT INTO `july_price` VALUES ('24', '2018-12-25 12:00:00', '125');
INSERT INTO `july_price` VALUES ('25', '2018-12-26 12:00:00', '260');
INSERT INTO `july_price` VALUES ('26', '2018-12-27 12:00:00', '270');
INSERT INTO `july_price` VALUES ('27', '2018-12-28 12:00:00', '280');
INSERT INTO `july_price` VALUES ('28', '2018-12-29 12:00:00', '290');
INSERT INTO `july_price` VALUES ('29', '2018-12-30 12:00:00', '310');
INSERT INTO `july_price` VALUES ('30', '2018-12-31 12:00:00', '321');
INSERT INTO `july_price` VALUES ('31', '2019-01-01 12:00:00', '322');
INSERT INTO `july_price` VALUES ('32', '2019-01-02 12:00:00', '235');
INSERT INTO `july_price` VALUES ('33', '2019-01-03 12:00:00', '445');
INSERT INTO `july_price` VALUES ('34', '2019-01-04 12:00:00', '440');
INSERT INTO `july_price` VALUES ('35', '2019-01-04 12:00:00', '450');

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `room_id` int(11) DEFAULT NULL COMMENT '房间编号',
  `customer_id` int(2) DEFAULT NULL COMMENT '客户姓名',
  `checkin_date` datetime DEFAULT NULL COMMENT '预订入住时间',
  `checkout_date` datetime DEFAULT NULL COMMENT '预订离店时间',
  `customer_type` varchar(20) DEFAULT NULL COMMENT '顾客类型',
  `order_stat_id` int(11) DEFAULT NULL COMMENT '订单状态',
  `order_money` float DEFAULT NULL COMMENT '预订金额',
  `operator` varchar(20) DEFAULT NULL,
  `createdTime` datetime DEFAULT NULL,
  `modifiedTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES ('1', '1', '2', '2018-12-25 12:00:00', '2018-12-28 12:00:00', '1', '1', '200', 'zha', '2018-12-28 08:57:50', '2018-12-29 08:57:54');
INSERT INTO `order_info` VALUES ('2', '2', '1', '2018-12-04 12:00:00', '2018-12-15 12:00:00', '1', '1', '200', '的好方法', '2018-12-20 08:57:58', '2018-12-27 08:58:01');
INSERT INTO `order_info` VALUES ('3', '2', '1', '2018-12-21 12:00:00', '2018-12-22 12:00:00', '1', '0', null, null, null, null);
INSERT INTO `order_info` VALUES ('4', '1', '1', '2018-12-21 12:00:00', '2019-01-03 12:00:00', '1', '1', '200', null, null, null);
INSERT INTO `order_info` VALUES ('5', '2', '1', '2018-12-26 12:00:00', '2018-12-27 12:00:00', null, '0', '200', null, null, null);

-- ----------------------------
-- Table structure for order_stat
-- ----------------------------
DROP TABLE IF EXISTS `order_stat`;
CREATE TABLE `order_stat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_stat` varchar(10) DEFAULT NULL COMMENT '订单状态类别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_stat
-- ----------------------------
INSERT INTO `order_stat` VALUES ('1', '已预订');
INSERT INTO `order_stat` VALUES ('2', '已取消');

-- ----------------------------
-- Table structure for room_info
-- ----------------------------
DROP TABLE IF EXISTS `room_info`;
CREATE TABLE `room_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rt_id` int(11) DEFAULT NULL,
  `room_name` varchar(20) DEFAULT NULL,
  `room_add` varchar(20) DEFAULT NULL,
  `bed_num` int(11) DEFAULT NULL,
  `stat_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room_info
-- ----------------------------
INSERT INTO `room_info` VALUES ('1', '1', '1101', '1楼', '1', '1');
INSERT INTO `room_info` VALUES ('2', '2', '2202', '2楼', '1', '2');
INSERT INTO `room_info` VALUES ('3', '3', '3303', '3楼', '1', '3');
INSERT INTO `room_info` VALUES ('4', '4', '1101', '2', '1', '3');

-- ----------------------------
-- Table structure for room_stat
-- ----------------------------
DROP TABLE IF EXISTS `room_stat`;
CREATE TABLE `room_stat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stat` varchar(20) DEFAULT NULL COMMENT '房间状态',
  `createdTime` datetime DEFAULT NULL,
  `modifiedTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room_stat
-- ----------------------------
INSERT INTO `room_stat` VALUES ('1', '空闲', null, null);
INSERT INTO `room_stat` VALUES ('2', '已入住', null, null);
INSERT INTO `room_stat` VALUES ('3', '已预订', null, null);

-- ----------------------------
-- Table structure for room_type
-- ----------------------------
DROP TABLE IF EXISTS `room_type`;
CREATE TABLE `room_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rt_name` varchar(20) NOT NULL,
  `price_up` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room_type
-- ----------------------------
INSERT INTO `room_type` VALUES ('1', '高级大床房', '1.1');
INSERT INTO `room_type` VALUES ('2', '豪华套房', '1.5');
INSERT INTO `room_type` VALUES ('3', '总统套房', '2');
INSERT INTO `room_type` VALUES ('4', '行政房', '2.1');
INSERT INTO `room_type` VALUES ('5', '豪华双床房', '10');

-- ----------------------------
-- Table structure for stay_info
-- ----------------------------
DROP TABLE IF EXISTS `stay_info`;
CREATE TABLE `stay_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL,
  `room_id` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `stay_date` datetime DEFAULT NULL,
  `stay_day_count` int(11) DEFAULT NULL,
  `stay_man_count` int(11) DEFAULT NULL,
  `cash` float DEFAULT NULL,
  `leave_date` datetime DEFAULT NULL,
  `is_checkout` int(11) DEFAULT NULL,
  `operator` varchar(20) DEFAULT NULL,
  `createdTime` datetime DEFAULT NULL,
  `modifiedTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stay_info
-- ----------------------------
INSERT INTO `stay_info` VALUES ('1', '1', '1', '2', '2018-12-26 08:55:01', null, null, null, '2018-12-27 09:44:26', '0', '', null, null);
INSERT INTO `stay_info` VALUES ('2', '2', '2', '1', '2018-12-04 08:55:30', null, null, null, '2018-12-15 08:55:56', '0', null, null, null);
INSERT INTO `stay_info` VALUES ('3', '3', '2', '1', '2018-12-21 09:40:59', null, null, null, '2018-12-22 09:41:04', '0', null, null, null);
INSERT INTO `stay_info` VALUES ('4', '4', '1', '1', '2018-12-21 10:12:24', null, null, null, '2018-12-26 10:12:26', '0', null, null, null);
INSERT INTO `stay_info` VALUES ('5', '5', '2', '1', '2018-12-20 10:13:19', null, null, null, null, '0', null, null, null);
INSERT INTO `stay_info` VALUES ('6', '6', '2', '2', '2018-12-22 10:13:53', null, null, null, '2018-12-25 10:13:56', '0', null, null, null);

-- ----------------------------
-- Table structure for sys_configs
-- ----------------------------
DROP TABLE IF EXISTS `sys_configs`;
CREATE TABLE `sys_configs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '参数名',
  `value` varchar(50) DEFAULT NULL COMMENT '参数值',
  `note` varchar(100) DEFAULT NULL COMMENT '备注',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='配置管理';

-- ----------------------------
-- Records of sys_configs
-- ----------------------------
INSERT INTO `sys_configs` VALUES ('4', 'uploadPath', '/upload/images', '上传路径', '2018-04-22 17:39:55', '2018-04-22 17:39:55', null, null);
INSERT INTO `sys_configs` VALUES ('5', 'downloadPath', '/downloads/', '文件下载路径', '2018-04-22 17:40:41', '2018-04-22 17:40:41', null, null);
INSERT INTO `sys_configs` VALUES ('6', '555', '100', 'aaa', '2018-05-28 12:40:27', '2018-05-28 12:40:27', null, null);
INSERT INTO `sys_configs` VALUES ('7', 'p1', 'v1', 'wqe', '2018-06-05 08:44:17', '2018-06-05 08:44:17', null, null);
INSERT INTO `sys_configs` VALUES ('8', 'p2', 'v2', 'ppp', '2018-06-05 13:07:52', '2018-06-05 13:07:52', null, null);
INSERT INTO `sys_configs` VALUES ('9', 'aaaaaaaa1', 'aa', 'aa', '2018-06-05 19:01:56', '2018-06-05 19:01:56', null, null);
INSERT INTO `sys_configs` VALUES ('10', 'd', 'spring-boot-02-quickstart', 'sd', '2018-06-05 19:02:50', '2018-06-05 19:02:50', null, null);
INSERT INTO `sys_configs` VALUES ('11', 'ddd', 'sdfasdf', 'sadf', '2018-06-05 19:40:03', '2018-06-05 19:40:03', null, null);
INSERT INTO `sys_configs` VALUES ('12', '数据库端口', '3306', '数据库监听端口', '2018-06-05 19:43:37', '2018-10-29 12:09:36', null, null);
INSERT INTO `sys_configs` VALUES ('13', '端口', '8080', '服务器端口', '2018-06-05 22:36:47', '2018-10-29 12:09:06', null, null);

-- ----------------------------
-- Table structure for sys_depts
-- ----------------------------
DROP TABLE IF EXISTS `sys_depts`;
CREATE TABLE `sys_depts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '资源名称',
  `parentId` int(11) DEFAULT NULL COMMENT '上级部门',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `note` varchar(100) DEFAULT NULL COMMENT '备注',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='部门管理';

-- ----------------------------
-- Records of sys_depts
-- ----------------------------
INSERT INTO `sys_depts` VALUES ('2', '产品部', null, '1', '负责产品设计及研发', '2018-04-19 18:59:09', '2018-10-29 12:21:55', 'admin', null);
INSERT INTO `sys_depts` VALUES ('3', '计调部', null, '2', '负责计划安排', '2018-04-19 19:15:05', '2018-10-29 12:22:52', null, null);
INSERT INTO `sys_depts` VALUES ('5', 'dept-a-001', '2', '1', '111111', '2018-07-08 23:42:01', '2018-07-08 23:45:32', null, null);

-- ----------------------------
-- Table structure for sys_dicts
-- ----------------------------
DROP TABLE IF EXISTS `sys_dicts`;
CREATE TABLE `sys_dicts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '名字',
  `type` varchar(20) DEFAULT NULL COMMENT '类型',
  `code` varchar(20) DEFAULT NULL COMMENT '字典码',
  `value` varchar(100) DEFAULT NULL COMMENT '字典值',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `valid` tinyint(4) DEFAULT '1' COMMENT '有效',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典管理';

-- ----------------------------
-- Records of sys_dicts
-- ----------------------------

-- ----------------------------
-- Table structure for sys_logs
-- ----------------------------
DROP TABLE IF EXISTS `sys_logs`;
CREATE TABLE `sys_logs` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8 COMMENT='系统日志';

-- ----------------------------
-- Records of sys_logs
-- ----------------------------
INSERT INTO `sys_logs` VALUES ('9', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '3', '0:0:0:0:0:0:0:1', '2018-04-17 19:53:38');
INSERT INTO `sys_logs` VALUES ('10', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '2', '0:0:0:0:0:0:0:1', '2018-04-17 19:54:05');
INSERT INTO `sys_logs` VALUES ('11', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '1', '0:0:0:0:0:0:0:1', '2018-04-17 19:54:36');
INSERT INTO `sys_logs` VALUES ('12', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '155', '0:0:0:0:0:0:0:1', '2018-04-18 15:14:44');
INSERT INTO `sys_logs` VALUES ('13', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '165', '0:0:0:0:0:0:0:1', '2018-04-19 18:52:35');
INSERT INTO `sys_logs` VALUES ('14', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '75', '0:0:0:0:0:0:0:1', '2018-04-19 19:10:36');
INSERT INTO `sys_logs` VALUES ('15', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '69', '0:0:0:0:0:0:0:1', '2018-04-19 19:12:46');
INSERT INTO `sys_logs` VALUES ('16', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '187', '0:0:0:0:0:0:0:1', '2018-04-19 23:27:14');
INSERT INTO `sys_logs` VALUES ('17', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '103', '0:0:0:0:0:0:0:1', '2018-04-20 13:11:37');
INSERT INTO `sys_logs` VALUES ('18', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '85', '0:0:0:0:0:0:0:1', '2018-04-20 13:55:04');
INSERT INTO `sys_logs` VALUES ('19', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '89', '0:0:0:0:0:0:0:1', '2018-04-20 13:57:12');
INSERT INTO `sys_logs` VALUES ('20', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '69', '0:0:0:0:0:0:0:1', '2018-04-20 13:58:32');
INSERT INTO `sys_logs` VALUES ('21', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '291', '0:0:0:0:0:0:0:1', '2018-04-20 15:22:55');
INSERT INTO `sys_logs` VALUES ('22', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '158', '0:0:0:0:0:0:0:1', '2018-04-22 16:20:56');
INSERT INTO `sys_logs` VALUES ('23', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '94', '0:0:0:0:0:0:0:1', '2018-04-22 17:05:34');
INSERT INTO `sys_logs` VALUES ('24', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '138', '0:0:0:0:0:0:0:1', '2018-04-22 17:20:32');
INSERT INTO `sys_logs` VALUES ('25', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '124', '0:0:0:0:0:0:0:1', '2018-04-22 17:24:12');
INSERT INTO `sys_logs` VALUES ('26', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '75', '0:0:0:0:0:0:0:1', '2018-04-22 17:31:51');
INSERT INTO `sys_logs` VALUES ('27', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '148', '0:0:0:0:0:0:0:1', '2018-04-22 17:33:25');
INSERT INTO `sys_logs` VALUES ('28', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '69', '0:0:0:0:0:0:0:1', '2018-04-22 17:39:26');
INSERT INTO `sys_logs` VALUES ('29', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '120', '0:0:0:0:0:0:0:1', '2018-04-22 19:10:28');
INSERT INTO `sys_logs` VALUES ('30', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '104', '0:0:0:0:0:0:0:1', '2018-04-22 19:23:56');
INSERT INTO `sys_logs` VALUES ('31', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '79', '0:0:0:0:0:0:0:1', '2018-04-22 19:42:40');
INSERT INTO `sys_logs` VALUES ('32', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '71', '0:0:0:0:0:0:0:1', '2018-04-22 19:58:49');
INSERT INTO `sys_logs` VALUES ('33', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '201', '0:0:0:0:0:0:0:1', '2018-04-22 20:02:01');
INSERT INTO `sys_logs` VALUES ('34', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '119', '0:0:0:0:0:0:0:1', '2018-04-22 20:26:31');
INSERT INTO `sys_logs` VALUES ('35', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '131', '0:0:0:0:0:0:0:1', '2018-04-22 20:58:21');
INSERT INTO `sys_logs` VALUES ('36', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '9', '192.168.43.1', '2018-04-22 21:32:25');
INSERT INTO `sys_logs` VALUES ('37', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '6', '192.168.43.183', '2018-04-22 21:34:40');
INSERT INTO `sys_logs` VALUES ('38', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '4', '192.168.43.211', '2018-04-22 22:10:04');
INSERT INTO `sys_logs` VALUES ('39', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '71', '0:0:0:0:0:0:0:1', '2018-04-23 08:47:21');
INSERT INTO `sys_logs` VALUES ('40', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '4', '0:0:0:0:0:0:0:1', '2018-04-23 18:22:51');
INSERT INTO `sys_logs` VALUES ('41', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '133', '0:0:0:0:0:0:0:1', '2018-04-28 17:51:31');
INSERT INTO `sys_logs` VALUES ('42', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '185', '0:0:0:0:0:0:0:1', '2018-05-15 23:22:01');
INSERT INTO `sys_logs` VALUES ('43', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '114', '0:0:0:0:0:0:0:1', '2018-05-16 09:55:16');
INSERT INTO `sys_logs` VALUES ('44', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '184', '0:0:0:0:0:0:0:1', '2018-05-20 08:05:15');
INSERT INTO `sys_logs` VALUES ('45', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '254', '172.20.10.1', '2018-05-27 10:22:56');
INSERT INTO `sys_logs` VALUES ('46', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin \"', '8', '172.20.10.9', '2018-05-27 10:22:58');
INSERT INTO `sys_logs` VALUES ('47', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '9', '172.20.10.11', '2018-05-27 10:23:18');
INSERT INTO `sys_logs` VALUES ('48', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '5', '172.20.10.14', '2018-05-27 10:23:25');
INSERT INTO `sys_logs` VALUES ('49', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin \"', '5', '172.20.10.9', '2018-05-27 10:23:36');
INSERT INTO `sys_logs` VALUES ('50', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '102858', '192.168.152.1', '2018-05-27 11:42:19');
INSERT INTO `sys_logs` VALUES ('51', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '5496830', '192.168.152.1', '2018-05-27 13:14:26');
INSERT INTO `sys_logs` VALUES ('52', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '100', '0:0:0:0:0:0:0:1', '2018-05-28 12:40:09');
INSERT INTO `sys_logs` VALUES ('53', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '187', '0:0:0:0:0:0:0:1', '2018-05-31 19:43:43');
INSERT INTO `sys_logs` VALUES ('54', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '454942', '0:0:0:0:0:0:0:1', '2018-05-31 19:53:32');
INSERT INTO `sys_logs` VALUES ('55', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '220', '0:0:0:0:0:0:0:1', '2018-06-04 13:01:37');
INSERT INTO `sys_logs` VALUES ('56', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '4208', '0:0:0:0:0:0:0:1', '2018-06-04 13:43:18');
INSERT INTO `sys_logs` VALUES ('57', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '139', '0:0:0:0:0:0:0:1', '2018-06-04 13:54:55');
INSERT INTO `sys_logs` VALUES ('58', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '200', '0:0:0:0:0:0:0:1', '2018-06-05 08:42:41');
INSERT INTO `sys_logs` VALUES ('59', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '182', '0:0:0:0:0:0:0:1', '2018-06-05 13:10:56');
INSERT INTO `sys_logs` VALUES ('60', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '139', '0:0:0:0:0:0:0:1', '2018-06-05 13:16:21');
INSERT INTO `sys_logs` VALUES ('61', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '5', '0:0:0:0:0:0:0:1', '2018-06-05 13:17:07');
INSERT INTO `sys_logs` VALUES ('62', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '186', '0:0:0:0:0:0:0:1', '2018-06-05 13:19:22');
INSERT INTO `sys_logs` VALUES ('63', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '139', '0:0:0:0:0:0:0:1', '2018-06-05 13:33:09');
INSERT INTO `sys_logs` VALUES ('64', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '146', '0:0:0:0:0:0:0:1', '2018-06-05 18:47:17');
INSERT INTO `sys_logs` VALUES ('65', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '79', '0:0:0:0:0:0:0:1', '2018-06-05 18:59:03');
INSERT INTO `sys_logs` VALUES ('66', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '65', '0:0:0:0:0:0:0:1', '2018-06-05 19:24:08');
INSERT INTO `sys_logs` VALUES ('67', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '70', '0:0:0:0:0:0:0:1', '2018-06-05 19:24:56');
INSERT INTO `sys_logs` VALUES ('68', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '87', '0:0:0:0:0:0:0:1', '2018-06-05 19:39:55');
INSERT INTO `sys_logs` VALUES ('69', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '71', '0:0:0:0:0:0:0:1', '2018-06-05 19:43:30');
INSERT INTO `sys_logs` VALUES ('70', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '71', '0:0:0:0:0:0:0:1', '2018-06-05 19:51:27');
INSERT INTO `sys_logs` VALUES ('71', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '196', '0:0:0:0:0:0:0:1', '2018-06-05 22:29:07');
INSERT INTO `sys_logs` VALUES ('72', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '161', '0:0:0:0:0:0:0:1', '2018-06-05 22:32:27');
INSERT INTO `sys_logs` VALUES ('73', 'admin', '登陆操作', 'com.jt.sys.service.impl.SysUserServiceImpl.login()', '\"admin\"', '4', '0:0:0:0:0:0:0:1', '2018-06-05 22:36:33');
INSERT INTO `sys_logs` VALUES ('74', 'admin', '分页查询配置信息', 'com.jt.sys.service.impl.SysConfigServiceImpl.findPageObjects', '[null,1]', '33', '0:0:0:0:0:0:0:1', '2018-07-11 19:00:43');
INSERT INTO `sys_logs` VALUES ('75', 'admin', '分页查询配置信息', 'com.jt.sys.service.impl.SysConfigServiceImpl.findPageObjects', '[null,1]', '10', '0:0:0:0:0:0:0:1', '2018-07-11 19:00:52');
INSERT INTO `sys_logs` VALUES ('76', 'admin', '分页查询配置信息', 'com.jt.sys.service.impl.SysConfigServiceImpl.findPageObjects', '[null,1]', '183', '0:0:0:0:0:0:0:1', '2018-08-15 18:38:22');
INSERT INTO `sys_logs` VALUES ('77', 'admin', null, 'com.jt.sys.service.impl.SysRoleServiceImpl.findPageObjects', '[null, 1]', '147', '0:0:0:0:0:0:0:1', null);
INSERT INTO `sys_logs` VALUES ('78', 'admin', null, 'com.jt.sys.service.impl.SysRoleServiceImpl.findPageObjects', '[null, 1]', '5', '0:0:0:0:0:0:0:1', null);
INSERT INTO `sys_logs` VALUES ('79', 'admin', null, 'com.jt.sys.service.impl.SysRoleServiceImpl.findPageObjects', '[null, 1]', '7', '0:0:0:0:0:0:0:1', null);
INSERT INTO `sys_logs` VALUES ('80', 'admin', null, 'com.jt.sys.service.impl.SysRoleServiceImpl.findPageObjects', '[null, 1]', '6', '0:0:0:0:0:0:0:1', null);

-- ----------------------------
-- Table structure for sys_menus
-- ----------------------------
DROP TABLE IF EXISTS `sys_menus`;
CREATE TABLE `sys_menus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '资源名称',
  `url` varchar(200) DEFAULT NULL COMMENT '资源URL',
  `type` int(11) DEFAULT NULL COMMENT '类型     1：菜单   2：按钮',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `note` varchar(100) DEFAULT NULL COMMENT '备注',
  `parentId` int(11) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `permission` varchar(500) DEFAULT NULL COMMENT '授权(如：user:create)',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=135 DEFAULT CHARSET=utf8 COMMENT='资源管理';

-- ----------------------------
-- Records of sys_menus
-- ----------------------------
INSERT INTO `sys_menus` VALUES ('8', '系统管理', '请求路径', '1', '8', null, null, 'sys:list', '2017-07-12 15:15:59', '2017-07-21 11:16:00', 'admin', 'admin');
INSERT INTO `sys_menus` VALUES ('24', '配置管理', 'config/doFindPageObjects.do', '1', '24', null, '8', 'sys:config:view', '2017-07-12 15:15:59', '2018-10-29 12:15:19', 'admin', null);
INSERT INTO `sys_menus` VALUES ('25', '日志管理', 'log/doFindPageObject.do', '1', '25', null, '8', 'sys:log:view', '2017-07-12 15:15:59', '2018-10-29 12:15:48', 'admin', null);
INSERT INTO `sys_menus` VALUES ('45', '用户管理', 'user/doUserListUI.do', '1', '45', null, '8', 'sys:user:view', '2017-07-12 15:15:59', '2018-10-29 12:16:41', 'admin', null);
INSERT INTO `sys_menus` VALUES ('46', '菜单管理', 'menu/doMenuListUI.do', '1', '46', null, '8', 'sys:menu:view', '2017-07-12 15:15:59', '2018-10-29 12:17:01', 'admin', null);
INSERT INTO `sys_menus` VALUES ('47', '角色管理', 'role/doRoleListUI.do', '1', '47', null, '8', 'sys:role:view', '2017-07-12 15:15:59', '2018-10-29 12:17:46', 'admin', null);
INSERT INTO `sys_menus` VALUES ('48', '组织管理', 'dept/doFindPageObjects.do', '1', '48', null, '8', 'sys:org:view', '2017-07-12 15:15:59', '2018-10-29 12:16:20', 'admin', null);
INSERT INTO `sys_menus` VALUES ('115', '查看', '', '2', '1', null, '46', 'sys:menu:view', '2017-07-13 16:33:41', '2017-07-21 11:09:05', null, null);
INSERT INTO `sys_menus` VALUES ('116', '新增', '', '2', '2', null, '46', 'sys:menu:add', '2017-07-13 16:34:02', '2017-07-21 11:09:22', null, null);
INSERT INTO `sys_menus` VALUES ('117', '修改', '', '2', '3', null, '46', 'sys:menu:update', '2017-07-13 16:34:25', '2017-07-21 11:09:45', null, null);
INSERT INTO `sys_menus` VALUES ('118', '删除', '', '2', '4', null, '46', 'sys:menu:delete', '2017-07-13 16:34:46', '2017-07-21 11:10:12', null, null);
INSERT INTO `sys_menus` VALUES ('119', '查看', '', '2', '1', null, '45', 'sys:user:view', '2017-07-13 16:35:05', '2017-07-21 11:12:46', null, null);
INSERT INTO `sys_menus` VALUES ('120', '查看', '', '2', '1', null, '47', 'sys:role:view', '2017-07-13 16:35:26', '2017-07-21 11:13:43', null, null);
INSERT INTO `sys_menus` VALUES ('126', '新增', '', '2', '2', null, '45', 'sys:user:add', '2017-07-21 11:11:34', '2017-07-21 11:11:34', null, null);
INSERT INTO `sys_menus` VALUES ('127', '修改', '', '2', '3', null, '45', 'sys:user:update', '2017-07-21 11:11:56', '2017-07-21 11:11:56', null, null);
INSERT INTO `sys_menus` VALUES ('128', '新增', '', '2', '2', null, '47', 'sys:role:add', '2017-07-21 11:14:24', '2017-07-21 11:14:24', null, null);
INSERT INTO `sys_menus` VALUES ('129', '修改', '', '2', '3', null, '47', 'sys:role:update', '2017-07-21 11:14:48', '2017-07-21 11:14:48', null, null);
INSERT INTO `sys_menus` VALUES ('130', '删除', '', '2', '4', null, '47', 'sys:role:delete', '2017-07-21 11:15:09', '2017-07-21 11:15:09', null, null);
INSERT INTO `sys_menus` VALUES ('131', '禁用启用', 'user/doValidById.do', '1', '111111', null, '45', 'sys:user:valid', '2018-07-18 19:24:48', '2018-07-18 19:24:48', null, null);
INSERT INTO `sys_menus` VALUES ('132', '日志删除', 'log/doDeleteObject.do', '2', '10', null, '25', 'sys:log:delete', '2018-10-29 12:18:42', '2018-10-29 12:18:42', null, null);
INSERT INTO `sys_menus` VALUES ('133', '添加配置', 'config/doSaveObject.do', '1', '2', null, '24', 'sys:config:save', '2018-10-29 12:20:07', '2018-10-29 12:20:07', null, null);
INSERT INTO `sys_menus` VALUES ('134', '添加配置', 'config/doSaveObject.do', '1', '2', null, '24', 'sys:config:save', '2018-10-29 12:20:08', '2018-10-29 12:20:08', null, null);

-- ----------------------------
-- Table structure for sys_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles`;
CREATE TABLE `sys_roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_roles
-- ----------------------------
INSERT INTO `sys_roles` VALUES ('46', '软件工程师', '负责软件设计与研发', '2018-07-06 19:25:36', '2018-11-13 08:25:29', null, null);
INSERT INTO `sys_roles` VALUES ('47', '系统管理员', '系统管理员。。。。。。。。', '2018-07-18 19:23:11', '2018-11-13 08:24:25', null, null);

-- ----------------------------
-- Table structure for sys_role_menus
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menus`;
CREATE TABLE `sys_role_menus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  `menu_id` int(11) DEFAULT NULL COMMENT 'ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1391 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Records of sys_role_menus
-- ----------------------------
INSERT INTO `sys_role_menus` VALUES ('1232', '1', '8');
INSERT INTO `sys_role_menus` VALUES ('1233', '1', '24');
INSERT INTO `sys_role_menus` VALUES ('1234', '1', '25');
INSERT INTO `sys_role_menus` VALUES ('1235', '1', '45');
INSERT INTO `sys_role_menus` VALUES ('1236', '1', '119');
INSERT INTO `sys_role_menus` VALUES ('1237', '1', '126');
INSERT INTO `sys_role_menus` VALUES ('1238', '1', '127');
INSERT INTO `sys_role_menus` VALUES ('1239', '1', '46');
INSERT INTO `sys_role_menus` VALUES ('1240', '1', '115');
INSERT INTO `sys_role_menus` VALUES ('1241', '1', '116');
INSERT INTO `sys_role_menus` VALUES ('1242', '1', '117');
INSERT INTO `sys_role_menus` VALUES ('1243', '1', '118');
INSERT INTO `sys_role_menus` VALUES ('1244', '1', '47');
INSERT INTO `sys_role_menus` VALUES ('1245', '1', '120');
INSERT INTO `sys_role_menus` VALUES ('1246', '1', '128');
INSERT INTO `sys_role_menus` VALUES ('1247', '1', '129');
INSERT INTO `sys_role_menus` VALUES ('1248', '1', '130');
INSERT INTO `sys_role_menus` VALUES ('1249', '1', '48');
INSERT INTO `sys_role_menus` VALUES ('1352', '47', '8');
INSERT INTO `sys_role_menus` VALUES ('1353', '47', '24');
INSERT INTO `sys_role_menus` VALUES ('1354', '47', '133');
INSERT INTO `sys_role_menus` VALUES ('1355', '47', '134');
INSERT INTO `sys_role_menus` VALUES ('1356', '47', '25');
INSERT INTO `sys_role_menus` VALUES ('1357', '47', '132');
INSERT INTO `sys_role_menus` VALUES ('1358', '47', '45');
INSERT INTO `sys_role_menus` VALUES ('1359', '47', '119');
INSERT INTO `sys_role_menus` VALUES ('1360', '47', '126');
INSERT INTO `sys_role_menus` VALUES ('1361', '47', '127');
INSERT INTO `sys_role_menus` VALUES ('1362', '47', '131');
INSERT INTO `sys_role_menus` VALUES ('1363', '47', '46');
INSERT INTO `sys_role_menus` VALUES ('1364', '47', '115');
INSERT INTO `sys_role_menus` VALUES ('1365', '47', '116');
INSERT INTO `sys_role_menus` VALUES ('1366', '47', '117');
INSERT INTO `sys_role_menus` VALUES ('1367', '47', '118');
INSERT INTO `sys_role_menus` VALUES ('1368', '47', '47');
INSERT INTO `sys_role_menus` VALUES ('1369', '47', '120');
INSERT INTO `sys_role_menus` VALUES ('1370', '47', '128');
INSERT INTO `sys_role_menus` VALUES ('1371', '47', '129');
INSERT INTO `sys_role_menus` VALUES ('1372', '47', '130');
INSERT INTO `sys_role_menus` VALUES ('1373', '47', '48');
INSERT INTO `sys_role_menus` VALUES ('1374', '46', '8');
INSERT INTO `sys_role_menus` VALUES ('1375', '46', '24');
INSERT INTO `sys_role_menus` VALUES ('1376', '46', '45');
INSERT INTO `sys_role_menus` VALUES ('1377', '46', '119');
INSERT INTO `sys_role_menus` VALUES ('1378', '46', '126');
INSERT INTO `sys_role_menus` VALUES ('1379', '46', '127');
INSERT INTO `sys_role_menus` VALUES ('1380', '46', '46');
INSERT INTO `sys_role_menus` VALUES ('1381', '46', '115');
INSERT INTO `sys_role_menus` VALUES ('1382', '46', '116');
INSERT INTO `sys_role_menus` VALUES ('1383', '46', '117');
INSERT INTO `sys_role_menus` VALUES ('1384', '46', '118');
INSERT INTO `sys_role_menus` VALUES ('1385', '46', '47');
INSERT INTO `sys_role_menus` VALUES ('1386', '46', '120');
INSERT INTO `sys_role_menus` VALUES ('1387', '46', '128');
INSERT INTO `sys_role_menus` VALUES ('1388', '46', '129');
INSERT INTO `sys_role_menus` VALUES ('1389', '46', '130');
INSERT INTO `sys_role_menus` VALUES ('1390', '46', '48');

-- ----------------------------
-- Table structure for sys_users
-- ----------------------------
DROP TABLE IF EXISTS `sys_users`;
CREATE TABLE `sys_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(50) DEFAULT NULL COMMENT '盐  密码加密时前缀，使加密后的值不同',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `valid` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常  默认值 ：1',
  `deptId` int(11) DEFAULT NULL,
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of sys_users
-- ----------------------------
INSERT INTO `sys_users` VALUES ('1', 'admin', '4ebd394fbd25e495e0753a7dc9889a8e', '7adb778c-e7d3-4dd3-a3c5-5f80a158006d', 'admin@t.cn', '13624356789', '1', '3', null, '2018-07-18 19:23:31', null, 'admin');
INSERT INTO `sys_users` VALUES ('2', 'zhangli', 'bdcf69375bdb532e50279b91eb00940d', '5e7cbd36-e897-4951-b42b-19809caf3caa', 'zhangli@t.cn', '13678909876', '0', '3', '2017-07-18 10:01:51', '2018-04-22 20:49:19', null, 'admin');
INSERT INTO `sys_users` VALUES ('3', 'wangke', 'c5dc32ec66041aeddf432b3146bd2257', '5e3e1475-1ea9-4a6a-976e-b07545827139', 'wangke@t.cn', '18678900987', '1', '3', '2017-07-18 11:40:53', '2018-11-13 08:24:45', null, null);
INSERT INTO `sys_users` VALUES ('4', 'zhangql', '+HBpqtPuj9KLBIpneR5X0A==', 'ed487fac-9952-45c9-acaa-21dab9c689cc', 'zhangql@t.cn', '13678909876', '1', '2', '2017-07-18 12:17:30', '2018-07-18 19:27:14', null, 'admin');
INSERT INTO `sys_users` VALUES ('5', 'fanwei', '1acab7425d6dfae670f26bd160518902', '34fbedb2-e135-4f8d-b595-24360edc348d', 'fanwei@t.cn', '13876545678', '0', '3', '2017-07-20 17:03:22', '2018-07-18 19:27:07', null, 'admin');
INSERT INTO `sys_users` VALUES ('6', 'wumei', '431ebdcccf3404787a144f9ba669a8e2', '8a14f46f-7a17-4dfe-85ab-08e63cb618ce', 'wumei@t.cn', '13567898765', '1', '2', '2017-07-21 10:57:40', '2018-04-22 20:46:49', null, null);
INSERT INTO `sys_users` VALUES ('7', 'user-003', '689c673a0d8bda7ee795dd45a126ae96', '3faa1d2b-a99f-4ffb-9d29-0e71563258af', 't@t.com', '123', '1', '3', '2018-01-12 23:19:58', '2018-04-22 20:46:07', null, 'admin');
INSERT INTO `sys_users` VALUES ('9', 'user-002', 'e10adc3949ba59abbe56e057f20f883e', null, 't@t.com', '123', '1', '3', '2018-01-12 23:20:31', '2018-04-22 20:45:55', null, null);
INSERT INTO `sys_users` VALUES ('12', 'user-001', '5bf6593afd106aa544000d559f0c2241', '9528e727-2901-4746-8558-9010d9607da2', 't@t.com', '123', '1', '3', '2018-01-13 01:48:32', '2018-04-22 20:45:37', null, null);
INSERT INTO `sys_users` VALUES ('13', 'user-c', '2630d8bd50c76abf001a9daceeae97e6', '30fff766-e245-4a93-9f5e-6eb2c2cec494', 't@t.com', '123456', '0', '3', '2018-01-13 02:01:56', '2018-04-22 20:43:58', null, 'admin');
INSERT INTO `sys_users` VALUES ('15', 'user-b', '2ce586af95c6431112092f653659c85f', 'eaedbaee-d760-40e4-b71e-ccecf01b6187', 't@t.com', '123456', '1', '3', '2018-01-13 02:02:06', '2018-04-22 20:54:10', null, 'admin');
INSERT INTO `sys_users` VALUES ('16', 'user-a', '710058cf374a38d76510d009f63bf28d', 'e8e35b96-bbdd-4090-81ee-b71a36141760', '1@t.com', '121212', null, '2', '2018-04-22 19:43:11', '2018-04-22 20:54:02', null, null);
INSERT INTO `sys_users` VALUES ('17', 'aaaaaaa', '573a6f32087ea8346c39d3b7c0166a41', 'f60ba9da-76ba-44ef-8a25-8d3a2ad2b53b', '11', '11111111', '1', '3', '2018-07-09 00:44:03', '2018-07-09 00:44:03', null, null);
INSERT INTO `sys_users` VALUES ('18', 'aa', '06af7a09abd673ca920fb25aaf45760d', '3f327de1-4285-4e67-9675-b942d5850fda', 'aaa', '111111', '0', '2', '2018-07-09 00:45:16', '2018-10-26 08:44:16', null, 'admin');
INSERT INTO `sys_users` VALUES ('19', 'qq', 'be17afaeeb2da6337b7ebdf984ee2e26', 'e4479018-7b70-4c1c-a4cb-9d9ec2b046b5', 'asaf', '1111111111', '1', '2', '2018-07-09 00:52:06', '2018-07-09 00:52:06', null, null);

-- ----------------------------
-- Table structure for sys_user_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_roles`;
CREATE TABLE `sys_user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- ----------------------------
-- Records of sys_user_roles
-- ----------------------------
INSERT INTO `sys_user_roles` VALUES ('1', '19', '46');
INSERT INTO `sys_user_roles` VALUES ('2', '1', '47');
INSERT INTO `sys_user_roles` VALUES ('3', '3', '46');
