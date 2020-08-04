DROP TABLE IF EXISTS `tb_user_info`;

CREATE TABLE `tb_user_info` (
  `domain_id` varchar(64) NOT NULL COMMENT '域账号，类似wangxiao16677',
  `work_id` varchar(64) NOT NULL COMMENT '员工号，类似16677',
  `name` varchar(64) COLLATE utf8_unicode_ci NOT NULL DEFAULT ' ',
  `gender` tinyint(4) NOT NULL DEFAULT '1' COMMENT '1为男性，2为女性',
  `email_address` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT ' ' COMMENT '企业邮箱号',
`reserve1` varchar(64) COLLATE utf8_unicode_ci NOT NULL DEFAULT ' ' COMMENT '备用字段1',
`reserve2` varchar(64) COLLATE utf8_unicode_ci NOT NULL DEFAULT ' ' COMMENT '备用字段2',
`reserve3` varchar(64) COLLATE utf8_unicode_ci NOT NULL DEFAULT ' ' COMMENT '备用字段3',
  PRIMARY KEY (`domain_id`)
) ;
INSERT INTO tb_user_info (work_id, domain_id, name, gender, email_address, reserve1, reserve2, reserve3) VALUES
 ('00000', '00000', '管理员', 1, ' ', 'admin', ' ', ' ');
INSERT INTO tb_user_info (work_id, domain_id, name, gender, email_address, reserve1, reserve2, reserve3) VALUES
('16677', 'wangxiao16677', '王晓', 2, 'wangxiao16677@hundsun.com', ' ', ' ', ' ');

/*Data for the table `user_info` */
INSERT INTO tb_user_info (domain_id, work_id, name, gender, email_address, reserve1, reserve2, reserve3) VALUES ('000000', '000000', '管理员', 1, ' ', 'admin', ' ', ' ');
INSERT INTO tb_user_info (domain_id, work_id, name, gender, email_address, reserve1, reserve2, reserve3) VALUES ('admin1', 'admin1', '管理员1', 1, 'admin@hundsun.com', 'admin', ' ', ' ');
INSERT INTO tb_user_info (domain_id, work_id, name, gender, email_address, reserve1, reserve2, reserve3) VALUES ('baill', '09486', '白林林', 1, 'baill@hundsun.com', 'on', ' ', ' ');
INSERT INTO tb_user_info (domain_id, work_id, name, gender, email_address, reserve1, reserve2, reserve3) VALUES ('wangxiao16677', '16677', '王晓', 2, 'wangxiao16677@hundsun.com', 'on', ' ', ' ');
INSERT INTO tb_user_info (domain_id, work_id, name, gender, email_address, reserve1, reserve2, reserve3) VALUES ('wuyc12809', '12809', '吴雨财', 1, 'wuyc12809@hundsun.com', 'on', ' ', ' ');
INSERT INTO tb_user_info (domain_id, work_id, name, gender, email_address, reserve1, reserve2, reserve3) VALUES ('xuhao25219', '25219', '徐浩', 1, 'xuhao25219@hundsun.com', 'on', ' ', ' ');
INSERT INTO tb_user_info (domain_id, work_id, name, gender, email_address, reserve1, reserve2, reserve3) VALUES ('yangyc11874', '11874', '杨亚超', 1, 'yangyc11874@hundsun.com', 'on', ' ', ' ');
INSERT INTO tb_user_info (domain_id, work_id, name, gender, email_address, reserve1, reserve2, reserve3) VALUES ('zhouying22930', '22930', '周莹', 2, 'zhouying22930@hundsun.com', ' ', ' ', ' ');

/*Table structure for table `user_password` */

DROP TABLE IF EXISTS `tb_user_password`;

CREATE TABLE `tb_user_password` (
  `domain_id` varchar(64) NOT NULL COMMENT '员工号，类似16677',
  `encrpt_password` varchar(128) COLLATE utf8_unicode_ci NOT NULL DEFAULT ' ',
  PRIMARY KEY (`domain_id`)
) ;


/*Data for the table `user_password` */
INSERT INTO tb_user_password (domain_id, encrpt_password) VALUES ('000000', '4QrcOUm6Wau+VuBX8g+IPg==');
INSERT INTO tb_user_password (domain_id, encrpt_password) VALUES ('admin1', 'lueSGJZetyySpUndWjMBEg==');
INSERT INTO tb_user_password (domain_id, encrpt_password) VALUES ('baill', 'lueSGJZetyySpUndWjMBEg==');
INSERT INTO tb_user_password (domain_id, encrpt_password) VALUES ('wangxiao16677', '4861iBoKH9qtASltdVSGjQ==');
INSERT INTO tb_user_password (domain_id, encrpt_password) VALUES ('wuyc12809', 'lueSGJZetyySpUndWjMBEg==');
INSERT INTO tb_user_password (domain_id, encrpt_password) VALUES ('xuhao25219', 'lueSGJZetyySpUndWjMBEg==');
INSERT INTO tb_user_password (domain_id, encrpt_password) VALUES ('yangyc11874', 'lueSGJZetyySpUndWjMBEg==');
INSERT INTO tb_user_password (domain_id, encrpt_password) VALUES ('zhouying22930', 'lueSGJZetyySpUndWjMBEg==');
