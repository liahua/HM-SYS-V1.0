/*
SQLyog Ultimate - MySQL GUI v8.2 
MySQL - 5.5.19 : Database - eylsys
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`eylsys` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `eylsys`;

/*Table structure for table `check_info` */

DROP TABLE IF EXISTS `check_info`;

CREATE TABLE `check_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stay_id` int(11) DEFAULT NULL,
  `due_money` float DEFAULT NULL,
  `order_money` float DEFAULT NULL,
  `discount_rate` float DEFAULT NULL,
  `discount_price` float DEFAULT NULL,
  `paid_up_money` float DEFAULT NULL,
  `check_date` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `operator` varchar(20) DEFAULT NULL,
  `createdTime` datetime DEFAULT NULL,
  `modifiedTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `check_info_ibfk_1` FOREIGN KEY (`id`) REFERENCES `stay_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `check_info` */

/*Table structure for table `customer_info` */

DROP TABLE IF EXISTS `customer_info`;

CREATE TABLE `customer_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(20) DEFAULT NULL,
  `gender` char(2) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `card_type` varchar(20) DEFAULT NULL,
  `card_num` varchar(20) DEFAULT NULL,
  `oprator` varchar(20) DEFAULT NULL,
  `createdTime` datetime DEFAULT NULL,
  `modifiedTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `customer_info` */

insert  into `customer_info`(`id`,`customer_name`,`gender`,`country`,`telephone`,`card_type`,`card_num`,`oprator`,`createdTime`,`modifiedTime`) values (1,'李菲菲','女','中国','13036985274','身份证','4566887992545','54654','2018-12-27 09:02:38','2018-12-20 09:02:42'),(2,'刘帅帅','男','越南','17025689345','护照','54661646456','465464','2018-12-26 09:02:46','2018-12-20 09:02:50');

/*Table structure for table `customer_type` */

DROP TABLE IF EXISTS `customer_type`;

CREATE TABLE `customer_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_type` varchar(20) DEFAULT NULL COMMENT '顾客类型',
  `discount_per` float DEFAULT NULL COMMENT '打折比例',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `customer_type` */

insert  into `customer_type`(`id`,`customer_type`,`discount_per`) values (1,'散户',1),(2,'组团',0.9),(3,'政府',0.8);

/*Table structure for table `july_price` */

DROP TABLE IF EXISTS `july_price`;

CREATE TABLE `july_price` (
  `id` int(11) NOT NULL,
  `day` datetime DEFAULT NULL COMMENT '当天日期',
  `price_std` int(11) DEFAULT NULL COMMENT '每日基准价格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `july_price` */

/*Table structure for table `order_info` */

DROP TABLE IF EXISTS `order_info`;

CREATE TABLE `order_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `room_id` int(11) DEFAULT NULL COMMENT '房间编号',
  `customer_name` int(2) DEFAULT NULL COMMENT '客户姓名',
  `telephone` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `checkin_date` datetime DEFAULT NULL COMMENT '预订入住时间',
  `checkout_date` datetime DEFAULT NULL COMMENT '预订离店时间',
  `customer_type` varchar(20) DEFAULT NULL COMMENT '顾客类型',
  `staus` int(11) DEFAULT NULL COMMENT '订单状态',
  `order_money` float DEFAULT NULL COMMENT '预订金额',
  `operator` varchar(20) DEFAULT NULL,
  `createdTime` datetime DEFAULT NULL,
  `modifiedTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `order_info_ibfk_1` FOREIGN KEY (`id`) REFERENCES `room_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `order_info` */

insert  into `order_info`(`id`,`room_id`,`customer_name`,`telephone`,`checkin_date`,`checkout_date`,`customer_type`,`staus`,`order_money`,`operator`,`createdTime`,`modifiedTime`) values (1,1,0,'12345678912','2018-12-25 08:55:16','2018-12-28 08:55:45','1',0,200,'zha','2018-12-28 08:57:50','2018-12-29 08:57:54'),(2,2,0,'56895678912','2018-12-04 08:55:30','2018-12-15 08:55:56','1',NULL,200,'的好方法','2018-12-20 08:57:58','2018-12-27 08:58:01');

/*Table structure for table `room_info` */

DROP TABLE IF EXISTS `room_info`;

CREATE TABLE `room_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rt_id` int(11) DEFAULT NULL,
  `room_name` varchar(20) DEFAULT NULL,
  `room_add` varchar(20) DEFAULT NULL,
  `bed_num` int(11) DEFAULT NULL,
  `statu_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `room_info_ibfk_1` FOREIGN KEY (`id`) REFERENCES `room_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `room_info` */

insert  into `room_info`(`id`,`rt_id`,`room_name`,`room_add`,`bed_num`,`statu_id`) values (1,1,'1101','1楼',1,1),(2,2,'2202','2楼',1,2),(3,3,'3303','3楼',1,3);

/*Table structure for table `room_state` */

DROP TABLE IF EXISTS `room_state`;

CREATE TABLE `room_state` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stat` varchar(20) DEFAULT NULL COMMENT '房间状态',
  `createdTime` datetime DEFAULT NULL,
  `modifiedTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `room_state` */

insert  into `room_state`(`id`,`stat`,`createdTime`,`modifiedTime`) values (1,'空闲',NULL,NULL),(2,'已入住',NULL,NULL),(3,'已预订',NULL,NULL);

/*Table structure for table `room_type` */

DROP TABLE IF EXISTS `room_type`;

CREATE TABLE `room_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rt_name` varchar(20) NOT NULL,
  `price_up` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `room_type` */

insert  into `room_type`(`id`,`rt_name`,`price_up`) values (1,'高级大床房',1.1),(2,'豪华套房',1.5),(3,'总统套房',2),(4,'行政房',2.1),(5,'豪华双床房',10);

/*Table structure for table `stay_info` */

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
  `status` int(11) DEFAULT NULL,
  `operator` varchar(20) DEFAULT NULL,
  `createdTime` datetime DEFAULT NULL,
  `modifiedTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `stay_info_ibfk_1` FOREIGN KEY (`id`) REFERENCES `room_info` (`id`),
  CONSTRAINT `stay_info_ibfk_2` FOREIGN KEY (`id`) REFERENCES `customer_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `stay_info` */

insert  into `stay_info`(`id`,`order_id`,`room_id`,`customer_id`,`stay_date`,`stay_day_count`,`stay_man_count`,`cash`,`leave_date`,`status`,`operator`,`createdTime`,`modifiedTime`) values (1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `sys_configs` */

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

/*Data for the table `sys_configs` */

insert  into `sys_configs`(`id`,`name`,`value`,`note`,`createdTime`,`modifiedTime`,`createdUser`,`modifiedUser`) values (4,'uploadPath','/upload/images','上传路径','2018-04-22 17:39:55','2018-04-22 17:39:55',NULL,NULL),(5,'downloadPath','/downloads/','文件下载路径','2018-04-22 17:40:41','2018-04-22 17:40:41',NULL,NULL),(6,'555','100','aaa','2018-05-28 12:40:27','2018-05-28 12:40:27',NULL,NULL),(7,'p1','v1','wqe','2018-06-05 08:44:17','2018-06-05 08:44:17',NULL,NULL),(8,'p2','v2','ppp','2018-06-05 13:07:52','2018-06-05 13:07:52',NULL,NULL),(9,'aaaaaaaa1','aa','aa','2018-06-05 19:01:56','2018-06-05 19:01:56',NULL,NULL),(10,'d','spring-boot-02-quickstart','sd','2018-06-05 19:02:50','2018-06-05 19:02:50',NULL,NULL),(11,'ddd','sdfasdf','sadf','2018-06-05 19:40:03','2018-06-05 19:40:03',NULL,NULL),(12,'数据库端口','3306','数据库监听端口','2018-06-05 19:43:37','2018-10-29 12:09:36',NULL,NULL),(13,'端口','8080','服务器端口','2018-06-05 22:36:47','2018-10-29 12:09:06',NULL,NULL);

/*Table structure for table `sys_depts` */

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

/*Data for the table `sys_depts` */

insert  into `sys_depts`(`id`,`name`,`parentId`,`sort`,`note`,`createdTime`,`modifiedTime`,`createdUser`,`modifiedUser`) values (2,'产品部',NULL,1,'负责产品设计及研发','2018-04-19 18:59:09','2018-10-29 12:21:55','admin',NULL),(3,'计调部',NULL,2,'负责计划安排','2018-04-19 19:15:05','2018-10-29 12:22:52',NULL,NULL),(5,'dept-a-001',2,1,'111111','2018-07-08 23:42:01','2018-07-08 23:45:32',NULL,NULL);

/*Table structure for table `sys_dicts` */

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

/*Data for the table `sys_dicts` */

/*Table structure for table `sys_logs` */

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

/*Data for the table `sys_logs` */

insert  into `sys_logs`(`id`,`username`,`operation`,`method`,`params`,`time`,`ip`,`createdTime`) values (9,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',3,'0:0:0:0:0:0:0:1','2018-04-17 19:53:38'),(10,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',2,'0:0:0:0:0:0:0:1','2018-04-17 19:54:05'),(11,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',1,'0:0:0:0:0:0:0:1','2018-04-17 19:54:36'),(12,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',155,'0:0:0:0:0:0:0:1','2018-04-18 15:14:44'),(13,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',165,'0:0:0:0:0:0:0:1','2018-04-19 18:52:35'),(14,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',75,'0:0:0:0:0:0:0:1','2018-04-19 19:10:36'),(15,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',69,'0:0:0:0:0:0:0:1','2018-04-19 19:12:46'),(16,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',187,'0:0:0:0:0:0:0:1','2018-04-19 23:27:14'),(17,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',103,'0:0:0:0:0:0:0:1','2018-04-20 13:11:37'),(18,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',85,'0:0:0:0:0:0:0:1','2018-04-20 13:55:04'),(19,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',89,'0:0:0:0:0:0:0:1','2018-04-20 13:57:12'),(20,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',69,'0:0:0:0:0:0:0:1','2018-04-20 13:58:32'),(21,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',291,'0:0:0:0:0:0:0:1','2018-04-20 15:22:55'),(22,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',158,'0:0:0:0:0:0:0:1','2018-04-22 16:20:56'),(23,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',94,'0:0:0:0:0:0:0:1','2018-04-22 17:05:34'),(24,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',138,'0:0:0:0:0:0:0:1','2018-04-22 17:20:32'),(25,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',124,'0:0:0:0:0:0:0:1','2018-04-22 17:24:12'),(26,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',75,'0:0:0:0:0:0:0:1','2018-04-22 17:31:51'),(27,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',148,'0:0:0:0:0:0:0:1','2018-04-22 17:33:25'),(28,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',69,'0:0:0:0:0:0:0:1','2018-04-22 17:39:26'),(29,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',120,'0:0:0:0:0:0:0:1','2018-04-22 19:10:28'),(30,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',104,'0:0:0:0:0:0:0:1','2018-04-22 19:23:56'),(31,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',79,'0:0:0:0:0:0:0:1','2018-04-22 19:42:40'),(32,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',71,'0:0:0:0:0:0:0:1','2018-04-22 19:58:49'),(33,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',201,'0:0:0:0:0:0:0:1','2018-04-22 20:02:01'),(34,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',119,'0:0:0:0:0:0:0:1','2018-04-22 20:26:31'),(35,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',131,'0:0:0:0:0:0:0:1','2018-04-22 20:58:21'),(36,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',9,'192.168.43.1','2018-04-22 21:32:25'),(37,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',6,'192.168.43.183','2018-04-22 21:34:40'),(38,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',4,'192.168.43.211','2018-04-22 22:10:04'),(39,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',71,'0:0:0:0:0:0:0:1','2018-04-23 08:47:21'),(40,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',4,'0:0:0:0:0:0:0:1','2018-04-23 18:22:51'),(41,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',133,'0:0:0:0:0:0:0:1','2018-04-28 17:51:31'),(42,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',185,'0:0:0:0:0:0:0:1','2018-05-15 23:22:01'),(43,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',114,'0:0:0:0:0:0:0:1','2018-05-16 09:55:16'),(44,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',184,'0:0:0:0:0:0:0:1','2018-05-20 08:05:15'),(45,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',254,'172.20.10.1','2018-05-27 10:22:56'),(46,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin \"',8,'172.20.10.9','2018-05-27 10:22:58'),(47,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',9,'172.20.10.11','2018-05-27 10:23:18'),(48,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',5,'172.20.10.14','2018-05-27 10:23:25'),(49,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin \"',5,'172.20.10.9','2018-05-27 10:23:36'),(50,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',102858,'192.168.152.1','2018-05-27 11:42:19'),(51,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',5496830,'192.168.152.1','2018-05-27 13:14:26'),(52,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',100,'0:0:0:0:0:0:0:1','2018-05-28 12:40:09'),(53,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',187,'0:0:0:0:0:0:0:1','2018-05-31 19:43:43'),(54,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',454942,'0:0:0:0:0:0:0:1','2018-05-31 19:53:32'),(55,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',220,'0:0:0:0:0:0:0:1','2018-06-04 13:01:37'),(56,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',4208,'0:0:0:0:0:0:0:1','2018-06-04 13:43:18'),(57,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',139,'0:0:0:0:0:0:0:1','2018-06-04 13:54:55'),(58,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',200,'0:0:0:0:0:0:0:1','2018-06-05 08:42:41'),(59,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',182,'0:0:0:0:0:0:0:1','2018-06-05 13:10:56'),(60,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',139,'0:0:0:0:0:0:0:1','2018-06-05 13:16:21'),(61,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',5,'0:0:0:0:0:0:0:1','2018-06-05 13:17:07'),(62,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',186,'0:0:0:0:0:0:0:1','2018-06-05 13:19:22'),(63,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',139,'0:0:0:0:0:0:0:1','2018-06-05 13:33:09'),(64,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',146,'0:0:0:0:0:0:0:1','2018-06-05 18:47:17'),(65,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',79,'0:0:0:0:0:0:0:1','2018-06-05 18:59:03'),(66,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',65,'0:0:0:0:0:0:0:1','2018-06-05 19:24:08'),(67,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',70,'0:0:0:0:0:0:0:1','2018-06-05 19:24:56'),(68,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',87,'0:0:0:0:0:0:0:1','2018-06-05 19:39:55'),(69,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',71,'0:0:0:0:0:0:0:1','2018-06-05 19:43:30'),(70,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',71,'0:0:0:0:0:0:0:1','2018-06-05 19:51:27'),(71,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',196,'0:0:0:0:0:0:0:1','2018-06-05 22:29:07'),(72,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',161,'0:0:0:0:0:0:0:1','2018-06-05 22:32:27'),(73,'admin','登陆操作','com.jt.sys.service.impl.SysUserServiceImpl.login()','\"admin\"',4,'0:0:0:0:0:0:0:1','2018-06-05 22:36:33'),(74,'admin','分页查询配置信息','com.jt.sys.service.impl.SysConfigServiceImpl.findPageObjects','[null,1]',33,'0:0:0:0:0:0:0:1','2018-07-11 19:00:43'),(75,'admin','分页查询配置信息','com.jt.sys.service.impl.SysConfigServiceImpl.findPageObjects','[null,1]',10,'0:0:0:0:0:0:0:1','2018-07-11 19:00:52'),(76,'admin','分页查询配置信息','com.jt.sys.service.impl.SysConfigServiceImpl.findPageObjects','[null,1]',183,'0:0:0:0:0:0:0:1','2018-08-15 18:38:22'),(77,'admin',NULL,'com.jt.sys.service.impl.SysRoleServiceImpl.findPageObjects','[null, 1]',147,'0:0:0:0:0:0:0:1',NULL),(78,'admin',NULL,'com.jt.sys.service.impl.SysRoleServiceImpl.findPageObjects','[null, 1]',5,'0:0:0:0:0:0:0:1',NULL),(79,'admin',NULL,'com.jt.sys.service.impl.SysRoleServiceImpl.findPageObjects','[null, 1]',7,'0:0:0:0:0:0:0:1',NULL),(80,'admin',NULL,'com.jt.sys.service.impl.SysRoleServiceImpl.findPageObjects','[null, 1]',6,'0:0:0:0:0:0:0:1',NULL);

/*Table structure for table `sys_menus` */

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

/*Data for the table `sys_menus` */

insert  into `sys_menus`(`id`,`name`,`url`,`type`,`sort`,`note`,`parentId`,`permission`,`createdTime`,`modifiedTime`,`createdUser`,`modifiedUser`) values (8,'系统管理','请求路径',1,8,NULL,NULL,'sys:list','2017-07-12 15:15:59','2017-07-21 11:16:00','admin','admin'),(24,'配置管理','config/doFindPageObjects.do',1,24,NULL,8,'sys:config:view','2017-07-12 15:15:59','2018-10-29 12:15:19','admin',NULL),(25,'日志管理','log/doFindPageObject.do',1,25,NULL,8,'sys:log:view','2017-07-12 15:15:59','2018-10-29 12:15:48','admin',NULL),(45,'用户管理','user/doUserListUI.do',1,45,NULL,8,'sys:user:view','2017-07-12 15:15:59','2018-10-29 12:16:41','admin',NULL),(46,'菜单管理','menu/doMenuListUI.do',1,46,NULL,8,'sys:menu:view','2017-07-12 15:15:59','2018-10-29 12:17:01','admin',NULL),(47,'角色管理','role/doRoleListUI.do',1,47,NULL,8,'sys:role:view','2017-07-12 15:15:59','2018-10-29 12:17:46','admin',NULL),(48,'组织管理','dept/doFindPageObjects.do',1,48,NULL,8,'sys:org:view','2017-07-12 15:15:59','2018-10-29 12:16:20','admin',NULL),(115,'查看','',2,1,NULL,46,'sys:menu:view','2017-07-13 16:33:41','2017-07-21 11:09:05',NULL,NULL),(116,'新增','',2,2,NULL,46,'sys:menu:add','2017-07-13 16:34:02','2017-07-21 11:09:22',NULL,NULL),(117,'修改','',2,3,NULL,46,'sys:menu:update','2017-07-13 16:34:25','2017-07-21 11:09:45',NULL,NULL),(118,'删除','',2,4,NULL,46,'sys:menu:delete','2017-07-13 16:34:46','2017-07-21 11:10:12',NULL,NULL),(119,'查看','',2,1,NULL,45,'sys:user:view','2017-07-13 16:35:05','2017-07-21 11:12:46',NULL,NULL),(120,'查看','',2,1,NULL,47,'sys:role:view','2017-07-13 16:35:26','2017-07-21 11:13:43',NULL,NULL),(126,'新增','',2,2,NULL,45,'sys:user:add','2017-07-21 11:11:34','2017-07-21 11:11:34',NULL,NULL),(127,'修改','',2,3,NULL,45,'sys:user:update','2017-07-21 11:11:56','2017-07-21 11:11:56',NULL,NULL),(128,'新增','',2,2,NULL,47,'sys:role:add','2017-07-21 11:14:24','2017-07-21 11:14:24',NULL,NULL),(129,'修改','',2,3,NULL,47,'sys:role:update','2017-07-21 11:14:48','2017-07-21 11:14:48',NULL,NULL),(130,'删除','',2,4,NULL,47,'sys:role:delete','2017-07-21 11:15:09','2017-07-21 11:15:09',NULL,NULL),(131,'禁用启用','user/doValidById.do',1,111111,NULL,45,'sys:user:valid','2018-07-18 19:24:48','2018-07-18 19:24:48',NULL,NULL),(132,'日志删除','log/doDeleteObject.do',2,10,NULL,25,'sys:log:delete','2018-10-29 12:18:42','2018-10-29 12:18:42',NULL,NULL),(133,'添加配置','config/doSaveObject.do',1,2,NULL,24,'sys:config:save','2018-10-29 12:20:07','2018-10-29 12:20:07',NULL,NULL),(134,'添加配置','config/doSaveObject.do',1,2,NULL,24,'sys:config:save','2018-10-29 12:20:08','2018-10-29 12:20:08',NULL,NULL);

/*Table structure for table `sys_role_menus` */

DROP TABLE IF EXISTS `sys_role_menus`;

CREATE TABLE `sys_role_menus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  `menu_id` int(11) DEFAULT NULL COMMENT 'ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1391 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

/*Data for the table `sys_role_menus` */

insert  into `sys_role_menus`(`id`,`role_id`,`menu_id`) values (1232,1,8),(1233,1,24),(1234,1,25),(1235,1,45),(1236,1,119),(1237,1,126),(1238,1,127),(1239,1,46),(1240,1,115),(1241,1,116),(1242,1,117),(1243,1,118),(1244,1,47),(1245,1,120),(1246,1,128),(1247,1,129),(1248,1,130),(1249,1,48),(1352,47,8),(1353,47,24),(1354,47,133),(1355,47,134),(1356,47,25),(1357,47,132),(1358,47,45),(1359,47,119),(1360,47,126),(1361,47,127),(1362,47,131),(1363,47,46),(1364,47,115),(1365,47,116),(1366,47,117),(1367,47,118),(1368,47,47),(1369,47,120),(1370,47,128),(1371,47,129),(1372,47,130),(1373,47,48),(1374,46,8),(1375,46,24),(1376,46,45),(1377,46,119),(1378,46,126),(1379,46,127),(1380,46,46),(1381,46,115),(1382,46,116),(1383,46,117),(1384,46,118),(1385,46,47),(1386,46,120),(1387,46,128),(1388,46,129),(1389,46,130),(1390,46,48);

/*Table structure for table `sys_roles` */

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

/*Data for the table `sys_roles` */

insert  into `sys_roles`(`id`,`name`,`note`,`createdTime`,`modifiedTime`,`createdUser`,`modifiedUser`) values (46,'软件工程师','负责软件设计与研发','2018-07-06 19:25:36','2018-11-13 08:25:29',NULL,NULL),(47,'系统管理员','系统管理员。。。。。。。。','2018-07-18 19:23:11','2018-11-13 08:24:25',NULL,NULL);

/*Table structure for table `sys_user_roles` */

DROP TABLE IF EXISTS `sys_user_roles`;

CREATE TABLE `sys_user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

/*Data for the table `sys_user_roles` */

insert  into `sys_user_roles`(`id`,`user_id`,`role_id`) values (1,19,46),(2,1,47),(3,3,46);

/*Table structure for table `sys_users` */

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

/*Data for the table `sys_users` */

insert  into `sys_users`(`id`,`username`,`password`,`salt`,`email`,`mobile`,`valid`,`deptId`,`createdTime`,`modifiedTime`,`createdUser`,`modifiedUser`) values (1,'admin','4ebd394fbd25e495e0753a7dc9889a8e','7adb778c-e7d3-4dd3-a3c5-5f80a158006d','admin@t.cn','13624356789',1,3,NULL,'2018-07-18 19:23:31',NULL,'admin'),(2,'zhangli','bdcf69375bdb532e50279b91eb00940d','5e7cbd36-e897-4951-b42b-19809caf3caa','zhangli@t.cn','13678909876',0,3,'2017-07-18 10:01:51','2018-04-22 20:49:19',NULL,'admin'),(3,'wangke','c5dc32ec66041aeddf432b3146bd2257','5e3e1475-1ea9-4a6a-976e-b07545827139','wangke@t.cn','18678900987',1,3,'2017-07-18 11:40:53','2018-11-13 08:24:45',NULL,NULL),(4,'zhangql','+HBpqtPuj9KLBIpneR5X0A==','ed487fac-9952-45c9-acaa-21dab9c689cc','zhangql@t.cn','13678909876',1,2,'2017-07-18 12:17:30','2018-07-18 19:27:14',NULL,'admin'),(5,'fanwei','1acab7425d6dfae670f26bd160518902','34fbedb2-e135-4f8d-b595-24360edc348d','fanwei@t.cn','13876545678',0,3,'2017-07-20 17:03:22','2018-07-18 19:27:07',NULL,'admin'),(6,'wumei','431ebdcccf3404787a144f9ba669a8e2','8a14f46f-7a17-4dfe-85ab-08e63cb618ce','wumei@t.cn','13567898765',1,2,'2017-07-21 10:57:40','2018-04-22 20:46:49',NULL,NULL),(7,'user-003','689c673a0d8bda7ee795dd45a126ae96','3faa1d2b-a99f-4ffb-9d29-0e71563258af','t@t.com','123',1,3,'2018-01-12 23:19:58','2018-04-22 20:46:07',NULL,'admin'),(9,'user-002','e10adc3949ba59abbe56e057f20f883e',NULL,'t@t.com','123',1,3,'2018-01-12 23:20:31','2018-04-22 20:45:55',NULL,NULL),(12,'user-001','5bf6593afd106aa544000d559f0c2241','9528e727-2901-4746-8558-9010d9607da2','t@t.com','123',1,3,'2018-01-13 01:48:32','2018-04-22 20:45:37',NULL,NULL),(13,'user-c','2630d8bd50c76abf001a9daceeae97e6','30fff766-e245-4a93-9f5e-6eb2c2cec494','t@t.com','123456',0,3,'2018-01-13 02:01:56','2018-04-22 20:43:58',NULL,'admin'),(15,'user-b','2ce586af95c6431112092f653659c85f','eaedbaee-d760-40e4-b71e-ccecf01b6187','t@t.com','123456',1,3,'2018-01-13 02:02:06','2018-04-22 20:54:10',NULL,'admin'),(16,'user-a','710058cf374a38d76510d009f63bf28d','e8e35b96-bbdd-4090-81ee-b71a36141760','1@t.com','121212',NULL,2,'2018-04-22 19:43:11','2018-04-22 20:54:02',NULL,NULL),(17,'aaaaaaa','573a6f32087ea8346c39d3b7c0166a41','f60ba9da-76ba-44ef-8a25-8d3a2ad2b53b','11','11111111',1,3,'2018-07-09 00:44:03','2018-07-09 00:44:03',NULL,NULL),(18,'aa','06af7a09abd673ca920fb25aaf45760d','3f327de1-4285-4e67-9675-b942d5850fda','aaa','111111',0,2,'2018-07-09 00:45:16','2018-10-26 08:44:16',NULL,'admin'),(19,'qq','be17afaeeb2da6337b7ebdf984ee2e26','e4479018-7b70-4c1c-a4cb-9d9ec2b046b5','asaf','1111111111',1,2,'2018-07-09 00:52:06','2018-07-09 00:52:06',NULL,NULL);

/*Table structure for table `vip_info` */

DROP TABLE IF EXISTS `vip_info`;

CREATE TABLE `vip_info` (
  `id` int(11) NOT NULL,
  `vip_name` varchar(20) DEFAULT NULL,
  `vip_tel` int(50) DEFAULT NULL,
  `gender` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `vip_info` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
