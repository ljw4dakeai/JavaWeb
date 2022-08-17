/*
	分页查询:

			SELECT 字段列表 FROM 表名 LIMIT  起始索引 , 查询条目数
				* 起始索引：从0开始

*/
use db1;
select * from stu;
-- 1. 查询第1页3条数据
select *
from stu
limit 0 ,3;
-- 2. 查询第2页3条数据
select *
from stu
limit 3, 3;
-- 3. 查询第3页3条数据

select *
from stu
limit 6, 3;