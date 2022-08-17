create database if not exists db6;

use db6;
-- 数据准备
-- 创建user表
CREATE TABLE USER(
	id INT PRIMARY KEY AUTO_INCREMENT, -- 用户id
	NAME VARCHAR(20),			       -- 用户姓名
	age INT                                -- 用户年龄
);
-- 添加数据
INSERT INTO USER VALUES (1,'张三',23);
INSERT INTO USER VALUES (2,'李四',24);
INSERT INTO USER VALUES (3,'王五',25);
INSERT INTO USER VALUES (4,'赵六',26);


-- 订单表
CREATE TABLE orderlist(
	id INT PRIMARY KEY AUTO_INCREMENT,	-- 订单id
	number VARCHAR(30),			-- 订单编号
	uid INT,    -- 外键字段
	CONSTRAINT ou_fk1 FOREIGN KEY (uid) REFERENCES USER(id)
);
-- 添加数据
INSERT INTO orderlist VALUES (1,'hm001',1);
INSERT INTO orderlist VALUES (2,'hm002',1);
INSERT INTO orderlist VALUES (3,'hm003',2);
INSERT INTO orderlist VALUES (4,'hm004',2);
INSERT INTO orderlist VALUES (5,'hm005',3);
INSERT INTO orderlist VALUES (6,'hm006',3);
INSERT INTO orderlist VALUES (7,'hm007',NULL);


-- 商品分类表
CREATE TABLE category(
	id INT PRIMARY KEY AUTO_INCREMENT,  -- 商品分类id
	NAME VARCHAR(10)                    -- 商品分类名称
);
-- 添加数据
INSERT INTO category VALUES (1,'手机数码');
INSERT INTO category VALUES (2,'电脑办公');
INSERT INTO category VALUES (3,'烟酒茶糖');
INSERT INTO category VALUES (4,'鞋靴箱包');


-- 商品表
CREATE TABLE product(
	id INT PRIMARY KEY AUTO_INCREMENT,   -- 商品id
	NAME VARCHAR(30),                    -- 商品名称
	cid INT, -- 外键字段
	CONSTRAINT cp_fk1 FOREIGN KEY (cid) REFERENCES category(id)
);
-- 添加数据
INSERT INTO product VALUES (1,'华为手机',1);
INSERT INTO product VALUES (2,'小米手机',1);
INSERT INTO product VALUES (3,'联想电脑',2);
INSERT INTO product VALUES (4,'苹果电脑',2);
INSERT INTO product VALUES (5,'中华香烟',3);
INSERT INTO product VALUES (6,'玉溪香烟',3);
INSERT INTO product VALUES (7,'计生用品',NULL);


-- 中间表
CREATE TABLE us_pro(
	upid INT PRIMARY KEY AUTO_INCREMENT,  -- 中间表id
	uid INT, -- 外键字段。需要和用户表的主键产生关联
	pid INT, -- 外键字段。需要和商品表的主键产生关联
	CONSTRAINT up_fk1 FOREIGN KEY (uid) REFERENCES USER(id),
	CONSTRAINT up_fk2 FOREIGN KEY (pid) REFERENCES product(id)
);
-- 添加数据
INSERT INTO us_pro VALUES (NULL,1,1);
INSERT INTO us_pro VALUES (NULL,1,2);
INSERT INTO us_pro VALUES (NULL,1,3);
INSERT INTO us_pro VALUES (NULL,1,4);
INSERT INTO us_pro VALUES (NULL,1,5);
INSERT INTO us_pro VALUES (NULL,1,6);
INSERT INTO us_pro VALUES (NULL,1,7);
INSERT INTO us_pro VALUES (NULL,2,1);
INSERT INTO us_pro VALUES (NULL,2,2);
INSERT INTO us_pro VALUES (NULL,2,3);
INSERT INTO us_pro VALUES (NULL,2,4);
INSERT INTO us_pro VALUES (NULL,2,5);
INSERT INTO us_pro VALUES (NULL,2,6);
INSERT INTO us_pro VALUES (NULL,2,7);
INSERT INTO us_pro VALUES (NULL,3,1);
INSERT INTO us_pro VALUES (NULL,3,2);
INSERT INTO us_pro VALUES (NULL,3,3);
INSERT INTO us_pro VALUES (NULL,3,4);
INSERT INTO us_pro VALUES (NULL,3,5);
INSERT INTO us_pro VALUES (NULL,3,6);
INSERT INTO us_pro VALUES (NULL,3,7);
INSERT INTO us_pro VALUES (NULL,4,1);
INSERT INTO us_pro VALUES (NULL,4,2);
INSERT INTO us_pro VALUES (NULL,4,3);
INSERT INTO us_pro VALUES (NULL,4,4);
INSERT INTO us_pro VALUES (NULL,4,5);
INSERT INTO us_pro VALUES (NULL,4,6);
INSERT INTO us_pro VALUES (NULL,4,7);
-- 练习题目
-- 1.查询用户的编号、姓名、年龄。订单编号
select u.*, o.number
from user u
    join orderlist o on u.id = o.uid;
-- 2.查询所有的用户。用户的编号、姓名、年龄。订单编号
select u.*, o.number
from user u
    left join orderlist o on u.id = o.uid;
-- 3.查询所有的订单。用户的编号、姓名、年龄。订单编号
select u.*, o.number
from user u
    right join orderlist o on u.id = o.uid;
-- 4.查询用户年龄大于23岁的信息。显示用户的编号、姓名、年龄。订单编号
select u.*, o.number
from user u
    left join orderlist o on u.id = o.uid
where age > 23;
-- 5.查询张三和李四用户的信息。显示用户的编号、姓名、年龄。订单编号
select u.*, o.number
from user u
    left join orderlist o on u.id = o.uid
where name in ('张三', '李四');
-- 6.查询商品分类的编号、分类名称。分类下的商品名称
select c.*, p.NAME
from category  c
join product p on c.id = p.cid;
-- 7.查询所有的商品分类。商品分类的编号、分类名称。分类下的商品名称
select c.*, p.NAME
from category  c
left join product p on c.id = p.cid;
-- 8.查询所有的商品信息。商品分类的编号、分类名称。分类下的商品名称
select c.*, p.NAME
from category  c
right join product p on c.id = p.cid;
-- 9.查询所有的用户和该用户能查看的所有的商品。显示用户的编号、姓名、年龄。商品名称
select u.*, o.number, p.NAME
from user u
    join orderlist o on u.id = o.uid
left join us_pro up on u.id = up.uid
left join product p on up.pid = p.id;
-- 10.查询张三和李四这两个用户可以看到的商品。显示用户的编号、姓名、年龄。商品名称
select u.*, o.number, p.NAME
from user u
    join orderlist o on u.id = o.uid
left join us_pro up on u.id = up.uid
left join product p on up.pid = p.id
where u.NAME in ('张三', '李四');

-- --------------------------------------------------------------------------------------------------------------------


-- 数据准备
-- 部门表
create table dept(
	deptno int primary key,      -- 部门编号  主键：唯一，非空
	dname varchar(14), 		 -- 部门名称
	loc varchar(13)			     -- 部门地址
);

insert into dept values	(10,'accounting','new york');
insert into dept values             (20,'research','dallas');
insert into dept values	(30,'sales','chicago');
insert into dept values	(40,'operations','boston');

-- 员工表
create table emp(
	empno int  primary key, 	    -- 员工编号
	ename varchar(10), 			-- 员工姓名
	job varchar(9), 			    -- 员工工作
	mgr int, 					    -- 员工直属领导编号
	hiredate date, 				    -- 入职时间
	sal double, 				        -- 工资
	comm double, 				    -- 奖金
	deptno int  				    -- 所在部门
);
insert into emp values(7369,'smith','职员',7566,'1980-12-17',800,null,20);
insert into emp values(7499,'allen','销售员',7698,'1981-02-20',1600,300,30);
insert into emp values(7521,'ward','销售员',7698,'1981-02-22',1250,500,30);
insert into emp values(7566,'jones','经理',7839,'1981-04-02',2975,null,20);
insert into emp values(7654,'martin','销售员',7698,'1981-09-28',1250,1400,30);
insert into emp values(7698,'blake','经理',7839,'1981-05-01',2850,null,30);
insert into emp values(7782,'clark','经理',7839,'1981-06-09',2450,null,10);
insert into emp values(7788,'scott','职员',7566,'1987-07-03',3000,2000,20);
insert into emp values(7839,'king','董事长',null,'1981-11-17',5000,null,10);
insert into emp values(7844,'turners','销售员',7698,'1981-09-08',1500,50,30);
insert into emp values(7876,'adams','职员',7566,'1987-07-13',1100,null,20);
insert into emp values(7900,'james','职员',7698,'1981-12-03',1250,null,30);
insert into emp values(7902,'ford','销售员',7566,'1981-12-03',3000,null,20);
insert into emp values(7934,'miller','职员',7782,'1981-01-23',1300,null,10);

-- 工资等级表
create table salgrade(
	grade int,-- 等级
	losal double, -- 最低工资
	hisal double ); -- 最高工资

insert into salgrade values (1,500,1000);
insert into salgrade values (2,1001,1500);
insert into salgrade values (3,1501,2000);
insert into salgrade values (4,2001,3000);
insert into salgrade values (5,3001,9999);
-- 多表与分组练习
-- 注意：员工如果没有特殊指明，指的就是所有人。

-- 1、返回部门号及其本部门的最低工资。
select d.deptno,  d.dname, min(sal)
from dept d
left join emp e on d.deptno = e.deptno
group by d.deptno;
-- 2、计算出员工的年薪，并且以年薪排序。
select e.ename, e.sal *12 + ifnull(e.comm, 0)  "年薪"
from emp e;
-- 3、返回员工工作及其从事此工作的最低工资。
select job, min(sal)
from emp
group by job;
-- 4、查找和scott从事相同工作的员工信息
select *
from emp
where job = (
        select job
        from emp
        where  ename = 'scott'
    );
-- 5、工资水平多于james的员工信息。
select *
from emp
where sal >  (
        select sal
        from emp
        where  ename = 'james'
    );
-- 6、返回工资大于平均工资的员工信息。
select *
from emp
where sal >  (
        select avg(sal)
        from emp
    );
-- 7、返回销售部(sales)所有员工的姓名。
select ename
from emp
where deptno = (
    select deptno
    from dept
    where dept.dname = 'sales'
);

select e.ename
from emp e
right join dept d on e.deptno = d.deptno
where dname = 'sales';
-- 8、返回工资高于30部门所有员工工资水平的员工信息。
select *
from emp
where sal > (
        select avg(sal)
        from emp
        where deptno = 30
);
-- 9、返回查找最高工资和最低工资的职员信息
select *
from  emp
where sal  = (select  max(sal) from emp) or
      sal = (select  min(sal) from emp);
-- 10、返回拥有员工的部门名、部门号。
select distinct e.deptno , d.dname
from dept d
join emp e on d.deptno = e.deptno
where e.deptno is not null;
-- 11、返回员工的姓名、所在部门名及其工资。
select e.ename, d.dname, e.sal
from emp e
left join dept d on e.deptno = d.deptno;
-- 12、返回从事职员工作的员工姓名和所在部门名称。
select e.ename, e.job, d.dname, e.sal
from emp e
left join dept d on e.deptno = d.deptno
where e.job = '职员';
-- 13、返回部门号、部门名、部门所在位置及其每个部门的员工总数。
select  d.*, count(e.empno)
from dept d
left join emp e on d.deptno = e.deptno
group by d.deptno;
-- 14、返回员工(职员或者销售员)和所属经理的姓名。

-- 15、查询员工姓名、职位、薪水、薪资等级

/*三、多表设计
商品有手机数码、电脑办公、烟酒茶糖、鞋靴箱包四大分类。

手机数码分类中有：华为手机、小米手机。

电脑办公分类中有：联想电脑、苹果电脑。

烟酒茶糖分类中有：中华香烟、玉溪香烟。

请完成表的设计、数据的初始化。并查询出所有分类下所有的商品。
*/