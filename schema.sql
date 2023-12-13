CREATE TABLE acl_user (
PASSWORD VARCHAR(255),
gmtModified DATETIME,
salt VARCHAR(255),
isDeleted BIT,
nickName VARCHAR(255),
id VARCHAR(255),
userName VARCHAR(255),
gmtCreate DATETIME
) ENGINE = INNODB DEFAULT  CHARSET= utf8;


create table acl_user_role (
gmtModified datetime,
isDeleted bit,
roleId VARCHAR(255),
id VARCHAR(255),
gmtCreate datetime
) ENGINE = INNODB DEFAULT  CHARSET= utf8;


create table acl_role (
gmtModified datetime,
isDeleted bit,
roleCode VARCHAR(255),
roleName VARCHAR(255),
remark VARCHAR(255),
id VARCHAR(255)
) ENGINE = INNODB DEFAULT  CHARSET= utf8;


create table acl_role_permission (
permissionId VARCHAR(255),
gmtModified datetime,
isDeleted bit,
roleId VARCHAR(255)
) ENGINE = INNODB DEFAULT  CHARSET= utf8;


create table acl_permission (
gmtModified datetime,
level INTEGER,
icon VARCHAR(255),
pid VARCHAR(255),
isSelect bit,
type INTEGER,
gmtCreate datetime,
permissionValue VARCHAR(255),
path VARCHAR(255),
component VARCHAR(255),
isDeleted bit,
name VARCHAR(255),
id VARCHAR(255)
) ENGINE = INNODB DEFAULT  CHARSET= utf8;
