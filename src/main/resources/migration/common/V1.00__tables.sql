create table `t_order`
(
	`id`          bigint   not null comment '订单ID',
	`store_no`    bigint   not null comment '店铺编号',
	`desc`        varchar(256) comment '其他信息',
	`create_time` datetime not null comment '创建时间',
	primary key (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = `utf8mb4` comment '订单表0';

