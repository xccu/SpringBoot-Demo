DROP TABLE IF EXISTS user;

CREATE TABLE t_user(
    id CHAR(50) NOT NULL PRIMARY KEY,
    name CHAR(50) NULL,
    password CHAR(50) NULL,
    age INT(6) NOT NULL,
    gender CHAR(50) NULL,
    race CHAR(50) NULL,
    img_url CHAR(max) NULL,
    email CHAR(128) NULL,
    phone_number CHAR(50) NULL,
    birth_date DATE (50) DEFAULT '2000-01-01',
    issue_date DATE(50) DEFAULT '2000-01-01'
);


CREATE TABLE t_product(
    id INT(20) NOT NULL PRIMARY KEY COMMENT '主键ID',
    NAME VARCHAR(30) NULL DEFAULT NULL COMMENT '商品名称',
    price INT(11) DEFAULT 0 COMMENT '价格',
    VERSION INT(11) DEFAULT 0 COMMENT '乐观锁版本号'
);