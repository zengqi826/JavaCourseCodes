CREATE TABLE `user` (
                        `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
                        `user_name` varchar(64) NOT NULL DEFAULT '' COMMENT '用户名',
                        `phone` varchar(20) NOT NULL DEFAULT '' COMMENT '手机',
                        `email` varchar(50) NOT NULL DEFAULT '' COMMENT '邮箱',
                        `created_time` datetime NOT NULL default now() COMMENT '创建时间',
                        `updated_time` datetime NOT NULL default now() COMMENT '更新时间',
                        `created_by` varchar(64) not null DEFAULT '' COMMENT '创建人',
                        `updated_by` varchar(64) not null DEFAULT '' COMMENT '更新人',
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `unique_idx_user_name` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

CREATE TABLE `product` (
                           `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
                           `product_name` varchar(100) NOT NULL DEFAULT '' COMMENT '商品名称',
                           `product_code` varchar(32) NOT NULL DEFAULT '' COMMENT '商品代码',
                           `product_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '商品价格',
                           `desc` varchar(100) NOT NULL DEFAULT '' COMMENT '描述',
                           `created_time` datetime NOT NULL default now() COMMENT '创建时间',
                           `updated_time` datetime NOT NULL default now() COMMENT '更新时间',
                           `created_by` varchar(64) not null DEFAULT '' COMMENT '创建人',
                           `updated_by` varchar(64) not null DEFAULT '' COMMENT '更新人',
                           PRIMARY KEY (`id`),
                           UNIQUE KEY `unique_idx_product_code` (`product_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品表';


CREATE TABLE `order` (
                         `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
                         `order_id` varchar(32) NOT NULL DEFAULT '' COMMENT '订单号',
                         `product_code` varchar(32) NOT NULL DEFAULT '' COMMENT '商品代码',
                         `user_name` varchar(32) NOT NULL DEFAULT '' COMMENT '用户名',
                         `count` int(11) NOT NULL DEFAULT '0' COMMENT '购买数量',
                         `unit_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '单价',
                         `real_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '实际价格',
                         `discount_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '折扣价格',
                         `created_time` datetime NOT NULL default now() COMMENT '创建时间',
                         `updated_time` datetime NOT NULL default now() COMMENT '更新时间',
                         `created_by` varchar(64) not null DEFAULT '' COMMENT '创建人',
                         `updated_by` varchar(64) not null DEFAULT '' COMMENT '更新人',
                         PRIMARY KEY (`id`),
                         UNIQUE KEY `unique_idx_order_id` (`order_id`),
                         KEY `idx_product_code` (`product_code`),
                         KEY `idx_user_name` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单表';
