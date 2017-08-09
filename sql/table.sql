CREATE TABLE `task_url_list` (
`id`  int NOT NULL AUTO_INCREMENT ,
`url`  varchar(500) NULL COMMENT '网址' ,
`type`  varchar(255) NULL COMMENT '网址类型' ,
`title`  varchar(255) NULL COMMENT '网址标题' ,
`status`  int(10) NULL COMMENT '状态 0 未爬取 1已爬取 2爬取失败' ,
`time`  datetime(255) NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间' ,
`update_time`  datetime NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '爬取时间' ,
PRIMARY KEY (`id`)
)
COMMENT='爬虫地址抓取表'
;

