/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : xiong

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2017-05-05 12:06:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for wb_comments
-- ----------------------------
DROP TABLE IF EXISTS `wb_comments`;
CREATE TABLE `wb_comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_no` varchar(50) DEFAULT NULL COMMENT '用户编号',
  `username` varchar(50) DEFAULT NULL COMMENT '用户昵称',
  `home_page` varchar(500) DEFAULT NULL COMMENT '用户首页',
  `topic_id` varchar(50) DEFAULT NULL COMMENT '话题编号',
  `comments_id` varchar(50) DEFAULT NULL COMMENT '评论编号',
  `content` text COMMENT '内容',
  `comments_count` int(11) DEFAULT NULL COMMENT '评论总数',
  `like_count` int(11) DEFAULT NULL COMMENT '点赞总数',
  `created` varchar(50) DEFAULT NULL COMMENT '创建时间',
  `system_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '系统时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `comments_id` (`comments_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wb_reply
-- ----------------------------
DROP TABLE IF EXISTS `wb_reply`;
CREATE TABLE `wb_reply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(50) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL COMMENT '用户昵称',
  `home_page` varchar(500) DEFAULT NULL,
  `topic_id` varchar(50) DEFAULT NULL,
  `comments_id` varchar(50) DEFAULT NULL,
  `reply_id` varchar(50) DEFAULT NULL,
  `content` text,
  `like_count` int(255) DEFAULT NULL,
  `created` varchar(50) DEFAULT NULL COMMENT '用户昵称',
  `system_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `reply_id` (`reply_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wb_topic
-- ----------------------------
DROP TABLE IF EXISTS `wb_topic`;
CREATE TABLE `wb_topic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_no` varchar(50) DEFAULT NULL COMMENT '用户编号',
  `username` varchar(100) DEFAULT NULL COMMENT '用户昵称',
  `home_page` varchar(50) DEFAULT NULL COMMENT '用户主页',
  `topic_id` varchar(50) DEFAULT NULL COMMENT '话题编号',
  `content` text COMMENT '内容',
  `forward_count` int(11) DEFAULT NULL COMMENT '转发总数',
  `comments_count` int(11) DEFAULT NULL COMMENT '评论总数',
  `like_count` int(11) DEFAULT NULL COMMENT '点赞总数',
  `created` varchar(50) DEFAULT NULL COMMENT '创建时间',
  `system_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '系统生成时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `topic_id` (`topic_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=660450 DEFAULT CHARSET=utf8mb4;

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
) ENGINE=InnoDB AUTO_INCREMENT=5191 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=999 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=730186 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for zh_answer
-- ----------------------------
DROP TABLE IF EXISTS `zh_answer`;
CREATE TABLE `zh_answer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_id` int(11) DEFAULT NULL COMMENT '问题编号',
  `answer_id` int(11) NOT NULL COMMENT '答题编号',
  `title` varchar(500) DEFAULT NULL COMMENT '标题',
  `user_id` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户编号',
  `content` mediumtext COMMENT '内容',
  `voteup_count` int(11) DEFAULT NULL COMMENT '点赞数',
  `comment_count` int(11) DEFAULT NULL COMMENT '评论数',
  `excerpt` text COMMENT '摘录',
  `is_copyable` varchar(10) CHARACTER SET utf8 DEFAULT NULL COMMENT '是否可复制',
  `thanks_count` int(11) DEFAULT NULL COMMENT '感谢总数',
  `created_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `system_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '系统创建时间',
  PRIMARY KEY (`id`,`answer_id`),
  UNIQUE KEY `answer_id` (`answer_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=28188 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for zh_answer_comments
-- ----------------------------
DROP TABLE IF EXISTS `zh_answer_comments`;
CREATE TABLE `zh_answer_comments` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户编号',
  `comments_id` int(11) NOT NULL,
  `content` text COMMENT '内容',
  `vote_count` int(11) DEFAULT NULL COMMENT '点赞数',
  `answer_id` int(11) DEFAULT NULL COMMENT '评论编号',
  `created_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `system_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '系统时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `comments_id` (`comments_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=117841 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for zh_question
-- ----------------------------
DROP TABLE IF EXISTS `zh_question`;
CREATE TABLE `zh_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_id` int(11) NOT NULL COMMENT '问题编号',
  `url` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '问题地址',
  `title` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT '标题',
  `remark` text COMMENT '描述',
  `type` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '类型',
  `question_type` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '问题类型',
  `follow_count` int(11) DEFAULT NULL COMMENT '关注者数目',
  `browse_count` int(11) DEFAULT NULL COMMENT '被浏览数',
  `tag` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '问题标签',
  `total` int(11) DEFAULT NULL COMMENT '回答总数',
  `created` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `system_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '系统时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `question_id` (`question_id`) USING BTREE COMMENT '问题编号唯一'
) ENGINE=InnoDB AUTO_INCREMENT=164 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for zh_user
-- ----------------------------
DROP TABLE IF EXISTS `zh_user`;
CREATE TABLE `zh_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `url_token` varchar(255) DEFAULT NULL COMMENT '用户token',
  `name` varchar(100) DEFAULT NULL COMMENT '用户昵称',
  `gender` int(11) DEFAULT NULL COMMENT '用户性别',
  `avatar_url` varchar(255) DEFAULT NULL COMMENT '头像',
  `headline` varchar(255) DEFAULT NULL COMMENT '格言',
  `type` varchar(20) DEFAULT NULL COMMENT '类型',
  `avatar_url_template` varchar(255) DEFAULT NULL COMMENT '头像模版',
  `is_followed` varchar(20) DEFAULT NULL COMMENT '是否关注',
  `is_advertiser` varchar(20) DEFAULT NULL COMMENT '是否广告商',
  `is_org` varchar(20) DEFAULT NULL COMMENT '是否是机构认证',
  `is_following` varchar(20) DEFAULT NULL COMMENT '是否关注',
  `user_type` varchar(20) DEFAULT NULL COMMENT '用户类型',
  `system_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '系统时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=2594 DEFAULT CHARSET=utf8;
