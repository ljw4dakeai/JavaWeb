create database if not exists mybatis;
use mybatis;

drop table if exists tb_user;

create table tb_user(
                        id int primary key auto_increment,
                        username varchar(20),
                        password varchar(20),
                        gender char(1),
                        addr varchar(30)
);



INSERT INTO tb_user VALUES (1, 'zhangsan', '123', '男', '北京');
INSERT INTO tb_user VALUES (2, '李四', '234', '女', '天津');
INSERT INTO tb_user VALUES (3, '王五', '11', '男', '西安');

show variables like 'character_set_%';
# set character_set_database = utf8;
set character_set_server = utf8;
# drop database mybatis;
