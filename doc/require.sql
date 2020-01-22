/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : require

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 22/01/2020 17:09:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_dept
-- ----------------------------
DROP TABLE IF EXISTS `t_dept`;
CREATE TABLE `t_dept`  (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `dept_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '部门名字',
  `parent_id` int(11) NOT NULL DEFAULT 0 COMMENT '父级id',
  `order_num` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `modify_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `is_del` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否删除 0未删除 1已删除',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '部门信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu`  (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `parent_id` int(11) NOT NULL DEFAULT 0 COMMENT '父级id',
  `menu_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '菜单/按钮名称',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '对应路由path',
  `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '对应路由组件component',
  `perms` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '权限标识',
  `icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '图标',
  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '类型 0菜单 1按钮',
  `order_num` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `modify_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `is_del` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否删除 0未删除 1已删除',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES (1, 0, '用户管理', '/system/user', '', 'user:view', '', 0, 1, '2020-01-20 10:31:05', '2020-01-20 10:31:05', 0);
INSERT INTO `t_menu` VALUES (2, 0, '角色管理', '/system/role', '', 'role:view', '', 0, 2, '2020-01-20 10:31:06', '2020-01-20 10:31:06', 0);
INSERT INTO `t_menu` VALUES (3, 0, '菜单管理', '/system/menu', '', 'menu:view', '', 0, 3, '2020-01-20 10:31:08', '2020-01-20 10:31:08', 0);
INSERT INTO `t_menu` VALUES (4, 0, '部门管理', '/system/dept', '', 'dept:view', '', 0, 4, '2020-01-20 10:45:38', '2020-01-20 10:45:38', 0);
INSERT INTO `t_menu` VALUES (5, 1, '新增用户', '', '', 'user:add', '', 1, 1, '2020-01-20 10:45:29', '2020-01-20 10:45:29', 0);
INSERT INTO `t_menu` VALUES (6, 1, '修改用户', '', '', 'user:update', '', 1, 1, '2020-01-20 10:45:30', '2020-01-20 10:45:30', 0);
INSERT INTO `t_menu` VALUES (7, 1, '删除用户', '', '', 'user:delete', '', 1, 1, '2020-01-20 10:45:33', '2020-01-20 10:45:33', 0);
INSERT INTO `t_menu` VALUES (8, 2, '新增角色', '', '', 'role:add', '', 1, 1, '2020-01-20 10:45:33', '2020-01-20 10:45:33', 0);
INSERT INTO `t_menu` VALUES (9, 2, '修改角色', '', '', 'role:update', '', 1, 1, '2020-01-20 10:45:33', '2020-01-20 10:45:33', 0);
INSERT INTO `t_menu` VALUES (10, 2, '删除角色', '', '', 'role:delete', '', 1, 1, '2020-01-20 10:45:33', '2020-01-20 10:45:33', 0);
INSERT INTO `t_menu` VALUES (11, 3, '新增菜单', '', '', 'menu:add', '', 1, 1, '2020-01-20 10:45:33', '2020-01-20 10:45:33', 0);
INSERT INTO `t_menu` VALUES (12, 3, '修改菜单', '', '', 'menu:update', '', 1, 1, '2020-01-20 10:45:33', '2020-01-20 10:45:33', 0);
INSERT INTO `t_menu` VALUES (13, 3, '删除菜单', '', '', 'menu:delete', '', 1, 1, '2020-01-20 10:45:33', '2020-01-20 10:45:33', 0);
INSERT INTO `t_menu` VALUES (14, 4, '新增部门', '', '', 'dept:add', '', 1, 0, '2020-01-20 10:45:33', '2020-01-20 10:45:33', 0);
INSERT INTO `t_menu` VALUES (15, 4, '修改部门', '', '', 'dept:update', '', 1, 0, '2020-01-20 10:45:33', '2020-01-20 10:45:33', 0);
INSERT INTO `t_menu` VALUES (16, 4, '删除部门', '', '', 'dept:delete', '', 1, 0, '2020-01-20 10:45:33', '2020-01-20 10:45:33', 0);
INSERT INTO `t_menu` VALUES (17, 0, '文件管理', '', '', 'upload:view', '', 0, 5, '2020-01-20 16:41:40', '2020-01-20 16:41:40', 0);
INSERT INTO `t_menu` VALUES (18, 17, '新增文件', '', '', 'upload:add', '', 1, 1, '2020-01-22 17:05:19', '2020-01-22 17:05:19', 0);
INSERT INTO `t_menu` VALUES (19, 17, '修改文件', '', '', 'upload:update', '', 1, 1, '2020-01-22 17:05:21', '2020-01-22 17:05:21', 0);
INSERT INTO `t_menu` VALUES (20, 17, '删除文件', '', '', 'upload:delete', '', 1, 1, '2020-01-22 17:05:24', '2020-01-22 17:05:24', 0);
INSERT INTO `t_menu` VALUES (21, 0, '需求管理', '', '', 'require:view', '', 0, 6, '2020-01-22 11:19:10', '2020-01-22 11:19:10', 0);
INSERT INTO `t_menu` VALUES (22, 21, '新增需求', '', '', 'require:add', '', 1, 1, '2020-01-22 17:05:29', '2020-01-22 17:05:29', 0);
INSERT INTO `t_menu` VALUES (23, 21, '修改需求', '', '', 'require:update', '', 1, 1, '2020-01-22 17:05:30', '2020-01-22 17:05:30', 0);
INSERT INTO `t_menu` VALUES (24, 21, '删除需求', '', '', 'require:delete', '', 1, 1, '2020-01-22 17:05:32', '2020-01-22 17:05:32', 0);
INSERT INTO `t_menu` VALUES (25, 0, '标签管理', '', '', 'tag:view', '', 0, 7, '2020-01-22 17:05:03', '2020-01-22 17:05:03', 0);
INSERT INTO `t_menu` VALUES (26, 25, '新增标签', '', '', 'tag:add', '', 1, 1, '2020-01-22 17:05:57', '2020-01-22 17:05:57', 0);
INSERT INTO `t_menu` VALUES (27, 25, '修改标签', '', '', 'tag:update', '', 1, 1, '2020-01-22 17:06:13', '2020-01-22 17:06:13', 0);
INSERT INTO `t_menu` VALUES (28, 25, '删除标签', '', '', 'tag:delete', '', 1, 1, '2020-01-22 17:06:30', '2020-01-22 17:06:30', 0);
INSERT INTO `t_menu` VALUES (29, 0, '评论管理', '', '', 'comment:view', '', 0, 8, '2020-01-22 17:07:11', '2020-01-22 17:07:11', 0);
INSERT INTO `t_menu` VALUES (30, 29, '新增评论', '', '', 'comment:add', '', 1, 1, '2020-01-22 17:07:36', '2020-01-22 17:07:36', 0);
INSERT INTO `t_menu` VALUES (31, 29, '修改评论', '', '', 'comment:update', '', 1, 1, '2020-01-22 17:07:57', '2020-01-22 17:07:57', 0);
INSERT INTO `t_menu` VALUES (32, 29, '删除评论', '', '', 'comment:delete', '', 1, 1, '2020-01-22 17:08:12', '2020-01-22 17:08:12', 0);

-- ----------------------------
-- Table structure for t_require
-- ----------------------------
DROP TABLE IF EXISTS `t_require`;
CREATE TABLE `t_require`  (
  `require_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '需求id',
  `require_title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '需求标题',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  `priority` tinyint(4) NOT NULL DEFAULT 0 COMMENT '重要程度',
  `urgent` tinyint(4) NOT NULL COMMENT '紧急程度',
  `status` tinyint(4) NOT NULL COMMENT '状态',
  `create_user_id` int(11) NOT NULL COMMENT '创建人id',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `modify_user_id` int(11) NOT NULL COMMENT '修改人id',
  `modify_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `parent_id` int(11) NOT NULL DEFAULT 0 COMMENT '父级id',
  `is_del` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否删除 0未删除 1以删除',
  PRIMARY KEY (`require_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '需求信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_require
-- ----------------------------
INSERT INTO `t_require` VALUES (1, '测试测试测试测试测试', '测试测试测试测试测试测试测试测试测试', 0, 0, 0, 1, '2020-01-22 11:21:04', 1, '2020-01-22 11:21:04', 0, 0);

-- ----------------------------
-- Table structure for t_require_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_require_comment`;
CREATE TABLE `t_require_comment`  (
  `comment_id` int(11) NOT NULL COMMENT '评论信息',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '内容',
  `create_user_id` int(11) NOT NULL DEFAULT 0 COMMENT '创建人id',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `modify_user_id` int(11) NOT NULL DEFAULT 0 COMMENT '修改人',
  `modify_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `require_id` int(11) NOT NULL COMMENT '需求id',
  `is_del` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否删除 0未删除 1以删除',
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '需求评论' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_require_file
-- ----------------------------
DROP TABLE IF EXISTS `t_require_file`;
CREATE TABLE `t_require_file`  (
  `require_id` int(11) NOT NULL COMMENT '需求id',
  `file_id` int(11) NOT NULL COMMENT '文件id',
  PRIMARY KEY (`file_id`, `require_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '需求附件信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_require_merge
-- ----------------------------
DROP TABLE IF EXISTS `t_require_merge`;
CREATE TABLE `t_require_merge`  (
  `require_master_id` int(11) NOT NULL COMMENT '主需求id',
  `require_branch_id` int(11) NOT NULL COMMENT '分支需求id',
  PRIMARY KEY (`require_master_id`, `require_branch_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '需求合并' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_require_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_require_tag`;
CREATE TABLE `t_require_tag`  (
  `require_id` int(11) NOT NULL COMMENT '需求id',
  `tag_id` int(11) NOT NULL COMMENT '标签id',
  PRIMARY KEY (`tag_id`, `require_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '需求标签信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `role_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '角色名称',
  `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '角色描述',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `modify_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `is_del` tinyint(4) NOT NULL COMMENT '是否删除 0 未删除 1 已删除',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, '管理员', '管理员', '2020-01-20 10:36:03', '2020-01-20 10:36:03', 0);
INSERT INTO `t_role` VALUES (2, '普通用户', '普通用户', '2020-01-20 10:36:04', '2020-01-20 10:36:04', 0);

-- ----------------------------
-- Table structure for t_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menu`;
CREATE TABLE `t_role_menu`  (
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `menu_id` int(11) NOT NULL COMMENT '菜单id',
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色菜单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role_menu
-- ----------------------------
INSERT INTO `t_role_menu` VALUES (1, 1);
INSERT INTO `t_role_menu` VALUES (1, 2);
INSERT INTO `t_role_menu` VALUES (1, 3);
INSERT INTO `t_role_menu` VALUES (1, 4);
INSERT INTO `t_role_menu` VALUES (1, 5);
INSERT INTO `t_role_menu` VALUES (1, 6);
INSERT INTO `t_role_menu` VALUES (1, 7);
INSERT INTO `t_role_menu` VALUES (1, 8);
INSERT INTO `t_role_menu` VALUES (1, 9);
INSERT INTO `t_role_menu` VALUES (1, 10);
INSERT INTO `t_role_menu` VALUES (1, 11);
INSERT INTO `t_role_menu` VALUES (1, 12);
INSERT INTO `t_role_menu` VALUES (1, 13);
INSERT INTO `t_role_menu` VALUES (1, 14);
INSERT INTO `t_role_menu` VALUES (1, 15);
INSERT INTO `t_role_menu` VALUES (1, 16);
INSERT INTO `t_role_menu` VALUES (1, 17);
INSERT INTO `t_role_menu` VALUES (1, 18);
INSERT INTO `t_role_menu` VALUES (1, 19);
INSERT INTO `t_role_menu` VALUES (1, 20);
INSERT INTO `t_role_menu` VALUES (1, 21);
INSERT INTO `t_role_menu` VALUES (1, 22);
INSERT INTO `t_role_menu` VALUES (1, 23);
INSERT INTO `t_role_menu` VALUES (1, 24);
INSERT INTO `t_role_menu` VALUES (1, 25);
INSERT INTO `t_role_menu` VALUES (1, 26);
INSERT INTO `t_role_menu` VALUES (1, 27);
INSERT INTO `t_role_menu` VALUES (1, 28);
INSERT INTO `t_role_menu` VALUES (1, 29);
INSERT INTO `t_role_menu` VALUES (1, 30);
INSERT INTO `t_role_menu` VALUES (1, 31);
INSERT INTO `t_role_menu` VALUES (1, 32);

-- ----------------------------
-- Table structure for t_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag`  (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标签id',
  `tag_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '标签名字',
  `tag_desc` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '标签描述',
  `create_user_id` int(11) NOT NULL DEFAULT 0 COMMENT '创建人id',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `modify_user_id` int(11) NOT NULL DEFAULT 0 COMMENT '修改人id',
  `modify_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `is_del` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否删除 0未删除 1 以删除',
  PRIMARY KEY (`tag_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '标签信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_upload_file
-- ----------------------------
DROP TABLE IF EXISTS `t_upload_file`;
CREATE TABLE `t_upload_file`  (
  `file_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文件id',
  `file_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '文件类型',
  `file_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '文件路径',
  `file_size` bigint(20) NOT NULL DEFAULT 0 COMMENT '文件大小',
  `file_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '文件名字',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `modify_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `is_del` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否删除 0未删除 1已删除',
  PRIMARY KEY (`file_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文件信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_upload_file
-- ----------------------------
INSERT INTO `t_upload_file` VALUES (1, '.gif', '64f86820956b4b5a931dc89701bd9780.gif', 875566, '6e3e5b9bgy1g9dlo7vkr9g205006m1g7.gif', '2020-01-20 16:48:15', '2020-01-20 16:48:15', 0);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '登录名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '用户密码',
  `mobile` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '手机号',
  `sex` tinyint(4) NOT NULL DEFAULT 0 COMMENT '性别 0 男 1 女',
  `dept_id` int(11) NOT NULL DEFAULT 0 COMMENT '部门id',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `modify_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态 0有效 1锁定',
  `is_del` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否删除 0 未删除 1 已删除',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'shaowen', '', '', 0, 0, '2020-01-22 09:54:38', '2020-01-22 09:54:38', 0, 0);

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES (1, 1);

SET FOREIGN_KEY_CHECKS = 1;
