/*
	分组函数
			SELECT 字段列表 FROM 表名 [WHERE 分组前条件限定] GROUP BY 分组字段名 [HAVING 分组后条件过滤]…;
*/
use db1;
select *
from stu;
-- 1. 查询男同学和女同学各自的数学平均分
select sex, avg(math)
from stu
group by sex;
-- 2. 查询男同学和女同学各自的数学平均分，以及各自人数
select sex, count(id), avg(math)
from stu
group by sex;
-- 3. 查询男同学和女同学各自的数学平均分，以及各自人数，要求：分数低于70分的不参与分组
select sex, count(id), avg(math)
from stu
where math >= 70
group by sex;
-- 4. 查询男同学和女同学各自的数学平均分，以及各自人数，要求：分数低于70分的不参与分组，分组之后人数大于2个的。
select *
from (select sex, count(id) "人数", avg(math)
      from stu
      where math >= 70
      group by sex
      having 人数 > 2) "test_table"
order by test_table.人数;







