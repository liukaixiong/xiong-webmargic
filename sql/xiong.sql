/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : xiong

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2017-04-05 13:27:05
*/

SET FOREIGN_KEY_CHECKS=0;
 
-- ----------------------------
-- Table structure for wyy_comment
-- ----------------------------
DROP TABLE IF EXISTS `wyy_comment`;
CREATE TABLE `wyy_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `music_id` int(11) DEFAULT NULL COMMENT '歌曲编号',
  `music_url` varchar(255) DEFAULT NULL COMMENT '歌曲链接',
  `comment_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL COMMENT '用户编号',
  `like_count` int(11) DEFAULT NULL COMMENT '点赞总数',
  `content` text,
  `comment_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '评论时间',
  `liked` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `comment_id_union` (`comment_id`) USING HASH COMMENT '评论编号唯一索引'
) ENGINE=InnoDB AUTO_INCREMENT=650303 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for wyy_hot_comment
-- ----------------------------
DROP TABLE IF EXISTS `wyy_hot_comment`;
CREATE TABLE `wyy_hot_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `music_id` int(11) DEFAULT NULL COMMENT '歌曲编号',
  `music_url` varchar(255) DEFAULT NULL COMMENT '歌曲链接',
  `comment_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL COMMENT '用户编号',
  `like_count` int(11) DEFAULT NULL COMMENT '点赞总数',
  `content` varchar(1000) DEFAULT NULL COMMENT '内容',
  `comment_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '评论时间',
  `liked` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `comment_id_union` (`comment_id`) USING HASH COMMENT '评论编号唯一索引'
) ENGINE=InnoDB AUTO_INCREMENT=4823 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wyy_music
-- ----------------------------
DROP TABLE IF EXISTS `wyy_music`;
CREATE TABLE `wyy_music` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `music_name` varchar(255) DEFAULT NULL COMMENT '歌曲名称',
  `music_Album` varchar(255) DEFAULT NULL COMMENT '专辑名称',
  `name` varchar(255) DEFAULT NULL COMMENT '歌手名称',
  `comment_count` int(11) DEFAULT NULL,
  `time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `music_id` int(11) DEFAULT NULL,
  `music_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `music_id_unions` (`music_id`) USING BTREE COMMENT '音乐编号唯一'
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wyy_user
-- ----------------------------
DROP TABLE IF EXISTS `wyy_user`;
CREATE TABLE `wyy_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `nike_name` varchar(50) DEFAULT NULL COMMENT '用户名称',
  `user_url` varchar(255) DEFAULT NULL COMMENT '用户主页',
  `vip_type` int(11) DEFAULT NULL COMMENT 'vip类型',
  `auth_status` int(11) DEFAULT NULL COMMENT '用户状态',
  `remark_name` varchar(100) DEFAULT NULL COMMENT '名称描述',
  `expert_tags` varchar(255) DEFAULT NULL COMMENT '标签',
  `user_type` int(11) DEFAULT NULL COMMENT '用户类型',
  `create_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `head_url` varchar(255) DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`),
  UNIQUE KEY `userid_union` (`userid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=727912 DEFAULT CHARSET=utf8;
