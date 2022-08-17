-- 1.查看所有数据库
show databases;
-- 2.创建db1数据库
create database db1;
-- 3.创建db2数据库，如果不存在的话就创建
create database if not exists db2;
-- 4.删除db2数据库
drop database db2;
-- 5.删除db2数据库，如果存在的话就删除
drop database if exists db2;
-- 6.使用db1数据库
use db1;
-- 7.查看当前使用的数据库
select database();

-- --------------------------------------------------------

-- 1.查询当前数据库下的所有表
use mysql;
show tables;
-- 2.查询表结构
desc user;
/*
	CREATE TABLE 表名 (
		字段名1  数据类型1,
		字段名2  数据类型2,
		…
		字段名n  数据类型n
	);

	3.需求：创建tb_user表
		id int,
		username varchar(20),
		password varchar(20)
*/
/*
	4.需求：设计一张学生表(student)，请注重数据类型、长度的合理性
		编号(id)
		姓名(name)，姓名最长不超过10个汉字
		性别(gender)，因为取值只有两种可能，因此最多一个汉字
		生日(birthday)，取值为年月日
		入学成绩(score)，小数点后保留两位
		邮件地址(email)，最大长度不超过 64
		家庭联系电话(tel)，不一定是手机号码，可能会出现 - 等字符
		学生状态(status)（用数字表示，正常、休学、毕业...）

*/

use db1;

create table if not exists student
(
    id       int unsigned,
    name     varchar(10),
    gender   enum ('男', '女'),
    birthday date,
    score    decimal(5, 2),
    email    varchar(64),
    tel      varchar(12),
    status   tinyint(1)
);



desc student;


create table if not exists tb_user
(
    id       int unsigned,
    username varchar(10),
    password varchar(20)
);

desc tb_user;


-- 5.删除tb_user表
drop table tb_user;
-- 6.删除tb_user表,判断表是否存在。
drop table if exists tb_user;



-- 7.修改student表名称为stu
alter table student
    rename to stu;
-- 8.给stu表添加一列address，类型为varchar类型
alter table stu
    add column address varchar(20);

desc stu;
-- 9.修改address列的类型为char类型
alter table stu
    modify address char(20);

desc stu;
-- 10.修改address列为addr并且类为为varchar类型
alter table stu
    change address addr varchar(20);

desc stu;
-- 11.删除addr列
alter table stu
    drop addr;

desc stu;