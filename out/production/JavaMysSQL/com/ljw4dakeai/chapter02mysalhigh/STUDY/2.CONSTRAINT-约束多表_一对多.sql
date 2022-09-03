create database if not exists db3;
use db3;

-- 2.-- 演示没有创建外键 -- 删除1号部门,可以
delete
from dept
where id = 1;

select *
from dept;


-- 3.  外键理解: 外键是2个表之间的关联,通过一个列进行关联,外键是创建在多的一方上
-- 创建外键的语法, 创建表时添加外键 (一对多)
--  [CONSTRAINT] [外键名称] FOREIGN KEY(外键列名) REFERENCES 主表(主表列名)


-- 4.-- 测试外键的效果, 删除1号部门?  通过图标查看外键
delete
from dept
where id = 1;
-- [23000][1451] Cannot delete or update a parent row:
-- a foreign key constraint fails (`db3`.`emp`, CONSTRAINT `fk_emp_dept` FOREIGN KEY (`dep_id`) REFERENCES `dept` (`id`))

select *
from dept;


-- 5.-- 演示通过修改表的方式创建外键,
-- ALTER TABLE 表名 ADD CONSTRAINT 外键名称 FOREIGN KEY (外键字段名称) REFERENCES 主表名称(主表列名称);
alter table emp
    add constraint fk_emp_dept foreign key (dep_id) references dept (id);


-- 6.-- 演示删除外键
# ALTER TABLE 表名 DROP FOREIGN KEY 外键名称;
alter table emp
    drop foreign key fk_emp_dept;

-- 创建数据集
-- 删除表
DROP TABLE IF EXISTS emp;
DROP TABLE IF EXISTS dept;


-- 部门表
CREATE TABLE dept
(
    id       int primary key auto_increment,
    dep_name varchar(20),
    addr     varchar(20)
);

-- 员工表
CREATE TABLE emp
(
    id     int primary key auto_increment,
    name   varchar(20),
    age    int,
    dep_id int,
    -- 在多的一方创建外键
    --  [CONSTRAINT] [外键名称] FOREIGN KEY(外键列名) REFERENCES 主表(主表列名)
    constraint fk_emp_dept foreign key (dep_id) references dept(id)
);

-- 添加 2 个部门(外键先依赖那个表, 就应该添加那个表的数据)
insert into dept(dep_name, addr)
values ('研发部', '广州'),
       ('销售部', '深圳');

-- 添加员工,dep_id 表示员工所在的部门
INSERT INTO emp (NAME, age, dep_id)
VALUES ('张三', 20, 1),
       ('李四', 20, 1),
       ('王五', 20, 1),
       ('赵六', 20, 2),
       ('孙七', 22, 2),
       ('周八', 18, 2);

-- 员工表
select *
from emp;

-- 部门表
select *
from dept;
