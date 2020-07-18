# 产品表
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` varchar(32) NOT NULL,
  `productNum` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `productName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cityName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DepartureTime` date NULL DEFAULT NULL,
  `productPrice` double(11, 0) NULL DEFAULT NULL,
  `productDesc` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `productStatus` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, '001', '广东一日游', '广州', '2020-04-07', 2100, '广州欢迎你', 0);
INSERT INTO `product` VALUES (2, '002', '三亞三日游', '海南', '2020-06-06', 1800, '海南欢迎你', 1);
INSERT INTO `product` VALUES (3, '003', '上海一日游', '上海', '2020-05-08', 3800, '上海欢迎你', 1);
INSERT INTO `product` VALUES (4, '004', '北京三日游', '北京', '2020-05-09', 5800, '首都我来了', 1);
INSERT INTO `product` VALUES (5, '005', '深圳七日游', '昆明', '2020-04-07', 18000, '深圳欢迎你', 1);
INSERT INTO `product` VALUES (6, '006', '昭通一日游', '昭通', '2020-05-08', 1200, '昭通大山包', 0);
INSERT INTO `product` VALUES (7, '007', '丽江一日游', '昆明', '2020-06-04', 1500, '丽江古镇', 0);
INSERT INTO `product` VALUES (8, 'aaa', 'aaaaa', 'aaaaa', '2020-04-07', 18000, 'aaaa', 1);

# 会员表
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`  (
  `id` varchar(32) NOT NULL ,
  `name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nickName` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `phoneNum` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `member` VALUES (1, '张三', '小三', '1388888888', 'zhangsan@QQ.com');
INSERT INTO `member` VALUES (2, '张四', '小三', '1388888888', 'zhangsan@QQ.com');
INSERT INTO `member` VALUES (3, '张五', '小三', '1388888888', 'zhangsan@QQ.com');
INSERT INTO `member` VALUES (4, '张六', '小三', '1388888888', 'zhangsan@QQ.com');
INSERT INTO `member` VALUES (5, '张七', '小三', '1388888888', 'zhangsan@QQ.com');
INSERT INTO `member` VALUES (6, '张八', '小三', '1388888888', 'zhangsan@QQ.com');
INSERT INTO `member` VALUES (7, '张九', '小三', '1388888888', 'zhangsan@QQ.com');

# 旅客表
DROP TABLE IF EXISTS `traveller`;
CREATE TABLE `traveller`  (
  `id` varchar(32) NOT NULL,
  `name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phoneNum` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `credentialsType` int(11) NULL DEFAULT NULL COMMENT '证件类型 0身份证 1护照 2军官证',
  `credentialsNum` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证件号码',
  `travellerType` int(11) NULL DEFAULT NULL COMMENT '旅客类型(人群) 0 成人 1 儿童',
#   `order_traveller` int(32) null default null,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `traveller` VALUES (1, '张三', '男', '13888888888', 0, '123456789009876543', 0);
INSERT INTO `traveller` VALUES (2, '张三2', '男', '13888888888', 0, '123456789009876543', 0);
INSERT INTO `traveller` VALUES (3, '张三3', '男', '13888888888', 0, '123456789009876543', 0);
INSERT INTO `traveller` VALUES (4, '张三4', '男', '13888888888', 0, '123456789009876543', 0);
INSERT INTO `traveller` VALUES (5, '张三5', '男', '13888888888', 0, '123456789009876543', 0);
INSERT INTO `traveller` VALUES (6, '张三6', '男', '13888888888', 0, '123456789009876543', 0);
INSERT INTO `traveller` VALUES (7, '张三7', '男', '13888888888', 0, '123456789009876543', 0);
INSERT INTO `traveller` VALUES (8, '张三8', '男', '13888888888', 0, '123456789009876543', 0);
INSERT INTO `traveller` VALUES (9, '张三9', '男', '13888888888', 0, '123456789009876543', 0);
INSERT INTO `traveller` VALUES (10, '张三10', '男', '13888888888', 0, '123456789009876543', 0);

# 订单表
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` varchar(32)  COLLATE utf8_general_ci NOT NULL,
  `orderNum` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `orderTime` timestamp(0) NULL DEFAULT NULL,
  `peopleCount` int(11) NULL DEFAULT NULL,
  `orderDesc` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `payType` int(11) NULL DEFAULT NULL,
  `orderStatus` int(11) NULL DEFAULT NULL,
  `productId` varchar(32) NULL ,
  `memberId` varchar(32) NULL ,
  PRIMARY KEY (`id`) USING BTREE,
#   INDEX `fk_o_p`(`productId`) USING BTREE,
#   INDEX `fk_o_m`(`memberId`) USING BTREE,
  CONSTRAINT `fk_o_m` FOREIGN KEY (`memberId`) REFERENCES `member` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_o_p` FOREIGN KEY (`productId`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `orders` VALUES ('1', '1', '2018-02-03 00:00:00', 1, '订单一', 0, 1, 1, 1);
INSERT INTO `orders` VALUES ('2', '12', '2020-05-15 11:15:17', 2, '订单二', 0, 2, 2, 2);
INSERT INTO `orders` VALUES ('3', '123', '2020-06-15 11:15:17', 3, '订单三', 0, 3, 3, 3);
INSERT INTO `orders` VALUES ('4', '1234', '2020-07-15 11:15:17', 4, '订单四', 0, 4, 4, 4);
INSERT INTO `orders` VALUES ('5', '12345', '2020-08-15 11:15:17', 5, '订单五', 0, 5, 5, 5);
INSERT INTO `orders` VALUES ('6', '123456', '2020-09-15 11:15:17', 6, '订单六', 0, 6, 6, 6);
INSERT INTO `orders` VALUES ('7', '1234567', '2020-10-15 11:15:17', 7, '订单七', 0, 7, 7, 7);

drop table if exists order_traveller;
create table order_traveller(
#     `id` int not null auto_increment,
    `orderId` varchar (32) not null,
    `travellerId` varchar (32) not null,
    Primary key (orderId,travellerId),
    foreign key (orderId) REFERENCES orders (id),
    foreign key (travellerId) references traveller (id)
)default character set utf8;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int(32) NOT NULL auto_increment,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phoneNum` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL COMMENT '状态0 未开启 1 开启',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20615 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `users` VALUES (1, 'a@qq.com', 'admin', '$2a$10$Ce8LB3jdYDZ2f6HB281zA.4eC7v6ziJdK8MMWg0Yu8ETMg5ToMpIe', '13888888888', 1);
INSERT INTO `users` VALUES (2, 'adfa', 'tom', '$2a$10$Ce8LB3jdYDZ2f6HB281zA.4eC7v6ziJdK8MMWg0Yu8ETMg5ToMpIe', '546514684', 1);
INSERT INTO `users` VALUES (3, '1847481@QQ.com', 'wBekvam', '$2a$10$Ce8LB3jdYDZ2f6HB281zA.4eC7v6ziJdK8MMWg0Yu8ETMg5ToMpIe', '15752250992', 1);
INSERT INTO `users` VALUES (4, '11948939@qq.com', '等灯', '$2a$10$Ce8LB3jdYDZ2f6HB281zA.4eC7v6ziJdK8MMWg0Yu8ETMg5ToMpIe', '15752250992', 0);
INSERT INTO `users` VALUES (5, 'a@qq.com', 'user', '$2a$10$i7QFXNog.2TT3pCrekha1uJsw54fcBPqVK1ncWtW6HxaGkiMFCBw.', '54154151', 1);
INSERT INTO `users` VALUES (6, 'a@qq.com', '赵龙', '$2a$10$Ce8LB3jdYDZ2f6HB281zA.4eC7v6ziJdK8MMWg0Yu8ETMg5ToMpIe', '13888888888', 1);
INSERT INTO `users` VALUES (6862, '11919@qq.com', 'hz', '$2a$10$mEKoiccVd9lmBJh7czLgy.3bIzaGLiUmn1nsQ65mEvSlI7G3K.1J6', '15752250992', 1);
INSERT INTO `users` VALUES (20614, 'zhixing1010@163.com', 'root', '$2a$10$xmIe31HlXwR5xLKAzzEnju.CDiYZ.qFuCaO832.fFQB0mWYNc/xya', '15752250992', 0);
insert into `users` value (8, 'a@qq.com', '456', '456', '13888888888', 0);

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(32) not null auto_increment,
  `roleName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `roleDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `role` VALUES (1, 'ADMIN', '系统管理员');
INSERT INTO `role` VALUES (2, 'USER', '用户');
delete from role where id=3;

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `userId` int(32) NOT NULL,
  `roleId` int(32) NOT NULL,
  PRIMARY KEY (`userId`, `roleId`) USING BTREE,
  INDEX `roleId`(`roleId`) USING BTREE,
  CONSTRAINT `users_role_ibfk_1` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `users_role_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `user_role` VALUES (1, 1);
INSERT INTO `user_role` VALUES (5, 1);
INSERT INTO `user_role` VALUES (6, 1);
INSERT INTO `user_role` VALUES (6862, 1);
INSERT INTO `user_role` VALUES (1, 2);
INSERT INTO `user_role` VALUES (2, 2);
INSERT INTO `user_role` VALUES (3, 2);
INSERT INTO `user_role` VALUES (4, 2);
INSERT INTO `user_role` VALUES (5, 2);
INSERT INTO `user_role` VALUES (6, 2);
INSERT INTO `user_role` VALUES (6862, 2);
INSERT INTO `user_role` VALUES (8, 1);
insert into `user_role` values (20615,1);

DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` int(32) NOT NULL,
  `permissionName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
alter table permission modify id int(32) auto_increment;
INSERT INTO `permission` VALUES (107, '角色管理', '/role/findAll.do');
INSERT INTO `permission` VALUES (1943, '资源权限管理', '/permission/findAll.do');
INSERT INTO `permission` VALUES (23527, '超级管理员', '/user/findAll.do');

DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `permissionId` int(32) NOT NULL,
  `roleId` int(32) NOT NULL,
  PRIMARY KEY (`permissionId`, `roleId`) USING BTREE,
  INDEX `r_id`(`roleId`) USING BTREE,
  CONSTRAINT `role_permission_ibfk_1` FOREIGN KEY (`permissionId`) REFERENCES `permission` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `role_permission_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `role_permission` VALUES (107, 1);
INSERT INTO `role_permission` VALUES (1943, 1);
INSERT INTO `role_permission` VALUES (23527, 1);
INSERT INTO `role_permission` VALUES (107, 2);
INSERT INTO `role_permission` VALUES (1943, 2);
INSERT INTO `role_permission` VALUES (23527, 2);


DROP TABLE IF EXISTS `syslog`;
CREATE TABLE `syslog`  (
  `id` int(70)  COLLATE utf8_general_ci NOT NULL auto_increment,
  `visitTime` datetime NULL DEFAULT NULL COMMENT '访问时间',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作者用户名',
  `ip` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问ip',
  `url` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问资源url',
  `executionTime` int(11) NULL DEFAULT NULL COMMENT '执行时长',
  `method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问方法',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


INSERT INTO `syslog` VALUES ('1', '2020-04-16 16:57:45', 'admin', '0:0:0:0:0:0:0:1', '/user/findAll.do', 22, '[类名] com.hz.controller.UserController [方法名] findAll');
INSERT INTO `syslog` VALUES ('2', '2020-04-22 03:34:22', 'admin', '0:0:0:0:0:0:0:1', '/orders/findAll.do', 7, '[类名] com.hz.controller.OrdersController [方法名] findAll');
INSERT INTO `syslog` VALUES ('3', '2020-04-22 03:20:43', 'admin', '0:0:0:0:0:0:0:1', '/user/findAll.do', 23, '[类名] com.hz.controller.UserController [方法名] findAll');
INSERT INTO `syslog` VALUES ('4', '2020-04-22 03:48:32', 'admin', '0:0:0:0:0:0:0:1', '/orders/findAll.do', 23, '[类名] com.hz.controller.OrdersController [方法名] findAll');
INSERT INTO `syslog` VALUES ('5', '2020-04-22 03:34:15', 'admin', '0:0:0:0:0:0:0:1', '/orders/findAll.do', 22, '[类名] com.hz.controller.OrdersController [方法名] findAll');
INSERT INTO `syslog` VALUES ('6', '2020-04-22 03:20:54', 'admin', '0:0:0:0:0:0:0:1', '/product/findAll.do', 16, '[类名] com.hz.controller.ProductController [方法名] findAll');
INSERT INTO `syslog` VALUES ('7', '2020-04-22 03:20:57', 'admin', '0:0:0:0:0:0:0:1', '/orders/findAll.do', 48, '[类名] com.hz.controller.OrdersController [方法名] findAll');
