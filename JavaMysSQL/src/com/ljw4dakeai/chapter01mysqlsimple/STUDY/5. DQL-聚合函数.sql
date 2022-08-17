/*
	count(列名):统计数量（一般选用不为null的列）
	max(列名):最大值
	min(列名):最小值
	sum(列名):求和
	avg(列名):平均值
*/
use db1;
select *
from stu;
-- 1.统计班级一共有多少个学生
select count(id)
from stu;
-- 2.查询数学成绩的最高分
select max(math)
from stu;
-- 3.查询数学成绩的最低分
select min(english)
from stu;
-- 4.查询数学成绩的总分
select sum(math)
from stu;
-- 5.查询数学成绩的平均分
select avg(math)
from stu;
-- 6.查询英语成绩的最低分
select *
from stu
where english = (
    select min(english)
    from stu
);