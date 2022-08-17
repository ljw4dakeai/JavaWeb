# 一、SQL练习

创建员工表

~~~sql
create table employee(
	id int,					-- 编号
	name varchar(20),		-- 姓名
	sex varchar(10),		-- 性别
	birthday date,			-- 生日
	salary float,			-- 薪水
	resume varchar(20)		-- 介绍
);
~~~

添加数据

~~~sql
INSERT INTO employee VALUES(1,'zhangsan','male','1980-11-25',2000,'good body');
INSERT INTO employee VALUES(2,'lisi','male','1980-04-25',1000,'good body');
INSERT INTO employee VALUES(3,'xiaohong','female','1978-11-25',4000,'good girl');
~~~



需求练习：

~~~sql
-- 将所有员工薪水修改为5000元。
-- 将姓名为’zhangsan’的员工薪水修改为3000元。
-- 将姓名为’lisi’的员工薪水修改为4000元,sex改为female。
-- 将xiaohong的薪水在原有基础上增加1000元。
~~~

# 二、SQL练习

创建表

~~~sql
-- 部门表
create table dept(
	deptno int primary key,  -- 部门编号  主键：唯一，非空
	dname varchar(14), 		 -- 部门名称
	loc varchar(13)			 -- 部门地址
);

insert into dept values	(10,'accounting','new york');
insert into dept values (20,'research','dallas');
insert into dept values	(30,'sales','chicago');
insert into dept values	(40,'operations','boston');

-- 员工表
create table emp(
	empno int  primary key, 	-- 员工编号
	ename varchar(10), 			-- 员工姓名
	job varchar(9), 			-- 员工工作
	mgr int, 					-- 员工直属领导编号
	hiredate date, 				-- 入职时间
	sal double, 				-- 工资
	comm double, 				-- 奖金
	deptno int  				-- 所在部门
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
~~~



需求练习：

~~~sql
-- 1、查找部门30中员工的详细信息。
-- 2、找出从事职员工作的员工的编号、姓名、部门号。
-- 3、检索出奖金多于基本工资的员工信息。
-- 4、检索出奖金多于基本工资60%的员工信息。
-- 5、找出姓名中包含A的员工信息。
-- 6、找出姓名以A、B、S开始的员工信息。
-- 7、找到名字长度为7个字符的员工信息。
-- 8、名字中不包含R字符的员工信息。
-- 9、返回员工的详细信息并按姓名升序排序。
-- 10、返回员工的信息并按姓名降序,工资升序排列。
-- 11、计算员工的日薪(按30天)。
-- 12、找出获得奖金的员工的工作。
-- 13、找出奖金少于100或者没有获得奖金的员工的信息。
-- 14、找出10部门的经理、20部门的职员 的员工信息。
-- 15、找出10部门的经理、20部门的职员 或者 既不是经理也不是职员但是工资高于2000元的员工信息。
-- 16、查询每个职位的员工个数，没有奖金的不在统计范围之内
~~~



































~~~sql
-- 将所有员工薪水修改为5000元。
UPDATE employee SET salary=5000;
-- 将姓名为’zhangsan’的员工薪水修改为3000元。
UPDATE employee SET salary=3000 WHERE NAME='zhangsan';
-- 将姓名为’lisi’的员工薪水修改为4000元,sex改为female。
UPDATE employee SET salary=4000, sex='female' WHERE NAME='lisi';
-- 将xiaohong的薪水在原有基础上增加1000元。
UPDATE employee SET salary=salary+1000 WHERE NAME='xiaohong';
SELECT salary+1000 FROM employee;




-- 1、查找部门30中员工的详细信息。
SELECT * FROM emp WHERE deptno=30;

-- 2、找出从事职员工作的员工的编号、姓名、部门号。
SELECT empno 编号, ename 姓名, deptno 部门号 FROM emp WHERE job='职员';

-- 3、检索出奖金多于基本工资的员工信息。
SELECT * FROM emp WHERE comm > sal;

-- 4、检索出奖金多于基本工资60%的员工信息。
SELECT * FROM emp WHERE comm > sal*0.6;

-- 5、找出姓名中包含A的员工信息。
SELECT * FROM emp WHERE ename LIKE '%A%';

-- 6、找出姓名以A、B、S开始的员工信息。
SELECT * FROM emp WHERE ename LIKE 'A%' OR ename LIKE 'B%' OR ename LIKE 'S%';

-- 7、找到名字长度为7个字符的员工信息。
SELECT * FROM emp WHERE ename LIKE '_______';


-- 8、名字中不包含R字符的员工信息。
SELECT * FROM emp WHERE ename NOT LIKE '%R%';



-- 9、返回员工的详细信息并按姓名升序排序。
SELECT * FROM emp ORDER BY ename ASC;

-- 10、返回员工的信息并按姓名降序,工资升序排列。
SELECT * FROM emp ORDER BY ename DESC, sal ASC;


-- 11、计算员工的日薪(按30天)。
SELECT ename,sal/30 FROM emp;

-- 12、找出获得奖金的员工的工作。
SELECT * FROM emp WHERE comm IS NOT NULL;

-- 13、找出奖金少于100或者没有获得奖金的员工的信息。
SELECT * FROM emp WHERE comm IS NULL OR comm <100;

-- 14、找出10部门的经理、20部门的职员 的员工信息。
SELECT * FROM emp WHERE (deptno=10 AND job='经理')  OR (deptno=20 AND job='职员');


-- 15、找出10部门的经理、20部门的职员 或者既不是经理也不是职员但是工资高于2000元的员工信息
SELECT * FROM emp WHERE (deptno=10 AND job='经理')  OR (deptno=20 AND job='职员') OR (job!='经理' AND job!='职员' AND sal>2000);

-- 16、查询每个职位的员工个数，没有奖金的不在统计范围之内
SELECT job, COUNT(*) FROM emp WHERE comm IS NOT NULL GROUP BY job;
~~~













