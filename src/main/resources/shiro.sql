/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.27 : Database - shiro
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`shiro` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `shiro`;

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values (10),(10),(10);

/*Table structure for table `sys_permission` */

DROP TABLE IF EXISTS `sys_permission`;

CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL,
  `available` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `number_sort` datetime DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `parent_ids` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `resource_type` enum('menu','button') DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `sys_permission` */

insert  into `sys_permission`(`id`,`available`,`name`,`number_sort`,`parent_id`,`parent_ids`,`permission`,`resource_type`,`url`) values (1,'\0','用户管理','2018-06-25 11:30:51',0,'0/','userInfo:view','menu','userInfo/userView'),(2,'\0','用户添加','2018-06-25 11:34:51',1,'0/1','userInfo:add','button','userInfo/userAdd'),(3,'\0','用户禁用','2018-06-25 11:35:51',1,'0/1','userInfo:del','button','userInfo/updateState'),(4,'\0','角色管理','2018-06-25 11:40:51',0,NULL,'roleInfo:view','menu','roleInfo/roleView'),(5,'\0','资源管理','2018-06-25 11:40:51',0,NULL,'sysPermission:view','menu','sysPermission/permissionView'),(9,'\0','学生管理','2018-09-01 20:08:46',0,NULL,'student:view','menu','student/studentView');

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL,
  `available` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`available`,`description`,`role`) values (2,'\0','新注册用户','新用户'),(1,'\0','管理员','admin');

/*Table structure for table `sys_role_permission` */

DROP TABLE IF EXISTS `sys_role_permission`;

CREATE TABLE `sys_role_permission` (
  `permission_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `FK9q28ewrhntqeipl1t04kh1be7` (`role_id`),
  KEY `FKomxrs8a388bknvhjokh440waq` (`permission_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `sys_role_permission` */

insert  into `sys_role_permission`(`permission_id`,`role_id`) values (5,1),(4,1),(1,1),(3,1),(2,1),(6,1);

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `uid` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `FKhh52n8vd4ny9ff4x9fb8v65qx` (`role_id`),
  KEY `FKgkmyslkrfeyn9ukmolvek8b8f` (`uid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`uid`,`role_id`) values (1,1);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` varchar(255) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`create_date`,`update_date`,`age`,`name`) values ('56a514fc657d4dc09cb12b09f39d6846','2018-08-28 01:42:20','2018-08-28 01:42:20',0,'老王的儿子'),('c9e56bc8d15c45bb838a63786f931908','2018-08-28 15:07:32',NULL,25,'老王'),('739086403d084de397282e8173d29f73','2018-08-28 15:35:44',NULL,22,'老王2'),('c6bae69dad8c4b538ad4bafd435837c3','2018-08-28 16:46:02',NULL,18,'老王4');

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `uid` int(11) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `state` int(11) NOT NULL,
  `update_date` datetime DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `UK_f2ksd6h8hsjtd57ipfq9myr64` (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `user_info` */

insert  into `user_info`(`uid`,`create_date`,`name`,`password`,`phone`,`reason`,`remarks`,`salt`,`state`,`update_date`,`username`) values (1,'2018-06-23 17:07:40','管理员','d3c59d25033dbf980d29554025c23a75',NULL,NULL,NULL,'8d78869f470951332959580424d4bf4f',1,'2018-08-31 15:56:33','admin'),(3,'2018-08-31 16:13:53','张三','79332ad51f315fdcdaaa0394c46ffcd7',NULL,NULL,'','8d78869f470951332959580424d4bf4f',0,'2018-08-31 16:13:53','zhangsan');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
