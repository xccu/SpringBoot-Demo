CREATE TABLE acl_user (
id VARCHAR(255),
user_name VARCHAR(255),
password VARCHAR(255),
salt VARCHAR(255),
is_deleted BOOLEAN,
nick_name VARCHAR(255),
token VARCHAR(255),
gmt_create DATETIME,
gmt_modified DATETIME
) ENGINE = INNODB DEFAULT  CHARSET= utf8;


create table acl_user_role (
gmt_modified datetime,
is_deleted BOOLEAN,
role_id VARCHAR(255),
user_id VARCHAR(255),
id VARCHAR(255),
gmt_create datetime
) ENGINE = INNODB DEFAULT  CHARSET= utf8;


create table acl_role (
gmt_modified datetime,
is_deleted BOOLEAN,
role_code VARCHAR(255),
role_name VARCHAR(255),
remark VARCHAR(255),
id VARCHAR(255)
) ENGINE = INNODB DEFAULT  CHARSET= utf8;


CREATE TABLE acl_role_permission (
id VARCHAR(255),
role_id VARCHAR(255),
permission_id VARCHAR(255),
is_deleted BOOLEAN,
gmt_create DATETIME,
gmt_modified DATETIME
) ENGINE = INNODB DEFAULT  CHARSET= utf8;



CREATE TABLE acl_permission (
id VARCHAR(255),
pid VARCHAR(255),
name VARCHAR(255),
type INTEGER,
permission_value VARCHAR(255),
path VARCHAR(255),
component VARCHAR(255),
icon VARCHAR(255),
status INTEGER,
level INTEGER,
is_select BOOLEAN,
is_deleted BOOLEAN,
gmt_create DATETIME,
gmt_modified DATETIME
) ENGINE = INNODB DEFAULT  CHARSET= utf8;
