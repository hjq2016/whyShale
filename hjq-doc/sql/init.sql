CREATE TABLE `common_table` (
  `id` bigint(36) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `created_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `updated_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否逻辑删除 0-正常 1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `sys_menu` (
  `id` bigint(36) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `created_by` varchar(64) NOT NULL COMMENT '创建者',
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(64) NOT NULL COMMENT '更新者',
  `updated_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否逻辑删除 0-正常 1-删除',
  `parent_id` bigint(20) NOT NULL COMMENT '父级菜单id root为0',
  `name` varchar(1024) NOT NULL COMMENT '菜单名',
  `path` varchar(1024) DEFAULT NULL COMMENT '请求路径',
  `path_method` varchar(8) DEFAULT NULL COMMENT '请求方式 get put',
  `sort` int(4) NOT NULL COMMENT '同级菜单的排序',
  `hidden` tinyint(1) NOT NULL DEFAULT '0' COMMENT '隐藏菜单 0-不隐藏 1-吟唱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统菜单表';

CREATE TABLE `sys_role` (
  `id` bigint(36) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `created_by` varchar(64) DEFAULT 'SYS' COMMENT '创建者',
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(64) DEFAULT 'SYS' COMMENT '更新者',
  `updated_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否逻辑删除 0-正常 1-删除',
  `code` varchar(64) NOT NULL COMMENT '角色代号 admin',
  `name` varchar(64) NOT NULL COMMENT '角色名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='用户角色类型.如admin,default, anonymous';

CREATE TABLE `sys_role_menu` (
  `role_id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `sys_role_user` (
  `user_id` bigint(20) NOT NULL COMMENT 'sys_user',
  `role_id` bigint(20) NOT NULL COMMENT 'sys_role',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `sys_user` (
  `id` bigint(36) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `created_by` varchar(64) DEFAULT 'SYS' COMMENT '创建者',
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(64) DEFAULT 'SYS' COMMENT '更新者',
  `updated_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否逻辑删除 0-正常 1-删除',
  `username` varchar(256) NOT NULL COMMENT '用户名',
  `password` varchar(256) NOT NULL COMMENT '密码',
  `nickname` varchar(256) DEFAULT NULL COMMENT '昵称',
  `phone` varchar(16) DEFAULT NULL COMMENT '手机号',
  `email` varchar(128) DEFAULT NULL COMMENT '邮箱',
  `head_img_url` varchar(1024) DEFAULT NULL COMMENT '头像url',
  `sex` tinyint(255) DEFAULT NULL COMMENT '性别 0-男 1-女',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;




INSERT INTO `whyshare`.`sys_role`(`id`, `created_by`, `creatd_date`, `updated_by`, `updated_date`, `is_deleted`, `role_code`, `role_name`) VALUES (1, 'SYS', '2021-06-10 11:16:06', 'SYS', '2021-06-10 11:16:06', '0', 'admin', '管理员');
INSERT INTO `whyshare`.`sys_role`(`id`, `created_by`, `creatd_date`, `updated_by`, `updated_date`, `is_deleted`, `role_code`, `role_name`) VALUES (2, 'SYS', '2021-06-10 11:16:27', 'SYS', '2021-06-10 11:16:27', '0', 'user', '登录用户');
INSERT INTO `whyshare`.`sys_role`(`id`, `created_by`, `creatd_date`, `updated_by`, `updated_date`, `is_deleted`, `role_code`, `role_name`) VALUES (3, 'SYS', '2021-06-10 11:16:58', 'SYS', '2021-06-10 11:16:58', '0', 'anonymous', '匿名访问用户');