use db4;
-- 介绍多表查询的分类
DROP TABLE IF EXISTS emp;
DROP TABLE IF EXISTS dept;


# 创建部门表
CREATE TABLE dept(
                     did INT PRIMARY KEY AUTO_INCREMENT,
                     dname VARCHAR(20)
);

# 创建员工表
CREATE TABLE emp (
                     id INT PRIMARY KEY AUTO_INCREMENT,
                     NAME VARCHAR(10),
                     gender CHAR(1), -- 性别
                     salary DOUBLE, -- 工资
                     join_date DATE, -- 入职日期
                     dep_id INT,
                     constraint fk_emp_dept FOREIGN KEY (dep_id) REFERENCES dept(did) -- 外键，关联部门表(部门表的主键)
);
-- 添加部门数据
INSERT INTO dept (dNAME) VALUES ('研发部'),('市场部'),('财务部'),('销售部');
-- 添加员工数据
INSERT INTO emp(NAME,gender,salary,join_date,dep_id) VALUES
('孙悟空','男',7200,'2013-02-24',1),
('猪八戒','男',3600,'2010-12-02',2),
('唐僧','男',9000,'2008-08-08',2),
('白骨精','女',5000,'2015-10-07',3),
('蜘蛛精','女',4500,'2011-03-14',1),
('小白龙','男',2500,'2011-02-14',null);

-- 员工表
select * from emp;
-- 部门表
select * from dept;

-- 查询员工信息以及对应的部门信息
select e.*, d.dname
from emp e
left join dept d on d.did = e.dep_id;


-- 笛卡尔积
select *
from emp, dept;
-- 取AB两个集合的所有情况
-- 根据条件连接2个表
select *
from emp, dept
where emp.dep_id <=> dept.did;

