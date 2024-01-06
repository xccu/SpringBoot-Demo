insert into `acl_user` (`id`, `user_name`, `password`, `salt`, `is_deleted`, `nick_name`, `token`, `gmt_create`, `gmt_modified`)
values('1','admin','123',NULL,0,NULL,NULL,'2020-01-01 00:00:00','2020-01-01 00:00:00');


insert into `acl_role_permission` (`id`, `role_id`, `permission_id`, `is_deleted`, `gmt_create`, `gmt_modified`) 
values('1','1','1',0,'2020-01-01 00:00:00','2020-01-01 00:00:00');

insert into `acl_permission` (`id`, `pid`, `name`, `type`, `permission_value`, `path`, `component`, `icon`, `status`, `level`, `is_select`, `is_deleted`, `gmt_create`, `gmt_modified`) 
values('1',NULL,'admin','2','admin',NULL,NULL,NULL,NULL,NULL,NULL,0,'2020-01-01 00:00:00','2020-01-01 00:00:00');


insert into `acl_user_role` (`gmt_modified`, `is_deleted`, `role_id`, `user_id`, `id`, `gmt_create`) 
values('2020-01-01 00:00:00',0,'1','1','1','2020-01-01 00:00:00');