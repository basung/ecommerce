-- ----------------------------
-- Records of BSS_ADMIN_PERMISSION
-- ----------------------------
INSERT INTO `bss_admin_permission` VALUES ('10000-00001', '2018-10-07 09:44:01', 'system_admin', '1', '0', 'system_admin', '2018-10-07 09:44:01', '0', 'tenant_id', '10000-00001', '权限模块', 'RESTFUL', '权限', '0', '/permission');
INSERT INTO `bss_admin_permission` VALUES ('10000-00002', '2018-10-07 09:44:01', 'system_admin', '1', '0', 'system_admin', '2018-10-07 09:44:01', '0', 'tenant_id', '10000-00002', '权限模块', 'RESTFUL', '权限增加', '10000-00001', '/permission/create');
INSERT INTO `bss_admin_permission` VALUES ('10000-00003', '2018-10-07 09:44:01', 'system_admin', '1', '0', 'system_admin', '2018-10-07 09:44:01', '0', 'tenant_id', '10000-00003', '权限模块', 'RESTFUL', '权限编辑', '10000-00001', '/permission/edit');
INSERT INTO `bss_admin_permission` VALUES ('10000-00004', '2018-10-07 09:44:01', 'system_admin', '1', '0', 'system_admin', '2018-10-07 09:44:01', '0', 'tenant_id', '10000-00004', '权限模块', 'RESTFUL', '权限删除', '10000-00001', '/permission/remove');
INSERT INTO `bss_admin_permission` VALUES ('10000-00005', '2018-10-07 09:44:01', 'system_admin', '1', '0', 'system_admin', '2018-10-07 09:44:01', '0', 'tenant_id', '10000-00005', '权限模块', 'RESTFUL', '权限获取', '10000-00001', '/permission/get');
INSERT INTO `bss_admin_permission` VALUES ('10000-00006', '2018-10-07 09:44:01', 'system_admin', '1', '0', 'system_admin', '2018-10-07 09:44:01', '0', 'tenant_id', '10000-00006', '权限模块', 'RESTFUL', '权限列表', '10000-00001', '/permission/query');


-- ----------------------------
-- Records of BSS_ADMIN_ROLE
-- ----------------------------
INSERT INTO `bss_admin_role` values ('20000-00001', '2018-10-07 09:44:01', 'system_admin', '1', 'system_admin', '2018-10-07 09:44:01', '0', 'tenant_id', '系统管理员,拥有所有权限', '系统管理员', '0');


-- ----------------------------
-- Records of BSS_ADMIN_ROLE_PERMISSION
-- ----------------------------
INSERT INTO `bss_admin_role_permission` values ('30000-00001', '2018-10-07 09:44:01', 'system_admin', '1', '0', 'system_admin', '2018-10-07 09:44:01', '0', 'tenant_id', '10000-00001', '20000-00001');
INSERT INTO `bss_admin_role_permission` values ('30000-00002', '2018-10-07 09:44:01', 'system_admin', '1', '0', 'system_admin', '2018-10-07 09:44:01', '0', 'tenant_id', '10000-00002', '20000-00001');
INSERT INTO `bss_admin_role_permission` values ('30000-00003', '2018-10-07 09:44:01', 'system_admin', '1', '0','system_admin', '2018-10-07 09:44:01', '0', 'tenant_id', '10000-00003', '20000-00001');
INSERT INTO `bss_admin_role_permission` values ('30000-00004', '2018-10-07 09:44:01', 'system_admin', '1', '0', 'system_admin', '2018-10-07 09:44:01', '0', 'tenant_id', '10000-00004', '20000-00001');
INSERT INTO `bss_admin_role_permission` values ('30000-00005', '2018-10-07 09:44:01', 'system_admin', '1', '0', 'system_admin', '2018-10-07 09:44:01', '0', 'tenant_id', '10000-00005', '20000-00001');
INSERT INTO `bss_admin_role_permission` values ('30000-00006', '2018-10-07 09:44:01', 'system_admin', '1', '0', 'system_admin', '2018-10-07 09:44:01', '0', 'tenant_id', '10000-00006', '20000-00001');


-- ----------------------------
-- Records of BSS_ADMIN_USER
-- ----------------------------
INSERT INTO `bss_admin_user` values ('40000-00001', '2018-10-07 09:44:01', 'system_admin', '1', '0', 'system_admin', '2018-10-07 09:44:01', '0', 'tenant_id', 'superAdmin', 'http://wx1.sinaimg.cn/orj360/006pnLoLgy1ft6yichmarj30j60j675x.jpg', '2018-10-07 09:44:01', 'rocky.wang@basung.com', 'admin', '15000526290', '0c6c19560799980f4fb7413e9b3e3b43', '20000-00001', 'z3egb', '1', '400-1234-5678', '王洋');