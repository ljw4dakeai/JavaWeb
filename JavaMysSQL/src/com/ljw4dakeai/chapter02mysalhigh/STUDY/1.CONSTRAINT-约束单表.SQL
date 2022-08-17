show databases;

show create database if not exists db2;
use db2;


DROP TABLE IF EXISTS emp;

-- 员工表
CREATE TABLE emp
(
    id       INT primary key auto_increment,  -- 员工id，主键且自增长(最后加)
    ename    VARCHAR(50) not null unique,   -- 员工姓名，非空并且唯一
    joindate DATE not null,                   -- 入职日期，非空
    salary   DOUBLE(7, 2) not null,            -- 工资，非空
    bonus    DOUBLE(7, 2) default 0          -- 奖金，如果没有奖金默认为0

);


INSERT INTO emp(id, ename, joindate, salary, bonus)
values (1, '张三', '1999-11-11', 8800, 5000);

select *
from emp;

-- 主键: 表中一行记录的唯一标识,一个表只能有一个主键,主键可以建在一列上,也可以建在多列上

-- 演示主键约束:非空且唯一
-- 演示主键的非空(如果开了auto_increment, 添加null 会自动增加id)
INSERT INTO emp(id, ename, joindate, salary, bonus)
values (null, '张三', '1999-11-11', 8800, 5000);

-- 演示主键的唯一
INSERT INTO emp(id, ename, joindate, salary, bonus)
values (1, '张三', '1999-11-11', 8800, 5000);
-- [23000][1062] Duplicate entry '1' for key 'PRIMARY'

INSERT INTO emp(id, ename, joindate, salary, bonus)
values (2, '张三2', '1999-11-11', 8800, 5000);
-- [23000][1062] Duplicate entry '2' for key 'PRIMARY'

-- 演示非空约束
INSERT INTO emp(id, ename, joindate, salary, bonus)
values (2, null, '1999-11-11', 8800, 5000);
-- [23000][1048] Column 'ename' cannot be null

-- 演示唯一约束
INSERT INTO emp(id, ename, joindate, salary, bonus)
values (2, '张三', '1999-11-11', 8800, 5000);

INSERT INTO emp(id, ename, joindate, salary, bonus)
values (2, '张磊', '1999-11-11', 8800, 5000);
-- [23000][1062] Duplicate entry '2' for key 'PRIMARY'

-- 演示默认约束
INSERT INTO emp(id, ename, joindate, salary, bonus)
values (3, '张磊', '1999-11-11', 8800, null); -- null 不使用默认值, 插入数据中就是null


select *
from emp;

INSERT INTO emp(id, ename, joindate, salary)
values (4, '张飞', '1999-11-11', 8800);
-- 不提供该列的值,才使用默认值
INSERT INTO emp(id, ename, joindate, salary, bonus)
values (5, '赵六', '1999-11-11', 8800, default);
-- 使用default也可以设置默认值
-- 最后演示自动增长,当列是数值,且唯一时,可以使用 auto_increment,一个表只能有一个自动增长列!

INSERT INTO emp(id, ename, joindate, salary, bonus)
values (null, '张磊', '1999-11-11', 8800, 5000);

INSERT INTO emp(ename, joindate, salary, bonus)
values ('张飞', '1999-11-11', 8800, 5000);