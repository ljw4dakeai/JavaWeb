create database if not exists servlet_mybatis;
use servlet_mybatis;

drop table if exists tb_user;

create table tb_user(
                        id int primary key auto_increment,
                        username varchar(20),
                        password varchar(32)
);



INSERT INTO tb_user VALUES (1, 'zhangsan', '123');
INSERT INTO tb_user VALUES (2, '李四', '234');
INSERT INTO tb_user VALUES (3, '王五', '11');
