# root 用户登录系统创建数据库
# 创建数据库并制定编码格式
CREATE DATABASE mybatis01
  CHARACTER SET utf8mb4 -- UTF-8 Unicode
  COLLATE utf8mb4_general_ci;

# grant all privileges on mybatis01.* to wangchen @'%' identified by 'wangchen@123';
# flush privileges;


# --------
# 创建表
CREATE TABLE `flower` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL COMMENT '花名',
  `price` float NOT NULL COMMENT '价格',
  `production` varchar(30) NOT NULL COMMENT '原产地',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO flower VALUES (DEFAULT, '喇叭花', 2.5, '阿根廷');
INSERT INTO flower VALUES (DEFAULT, '狗尾巴', 5.0, '墨西哥');
INSERT INTO flower VALUES (DEFAULT, '莲花', 4.3, '巴西');
