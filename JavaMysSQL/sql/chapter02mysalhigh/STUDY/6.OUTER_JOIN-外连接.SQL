use db4;

-- 查询emp表所有数据(包含小白龙)和对应的部门信息
select e.*, d.dname
from emp e
         left join dept d on d.did = e.dep_id;
-- 介绍含义,格式,完成需求
-- 左外连接
-- 查询emp表所有数据和对应的部门信息
-- SELECT 字段列表 FROM 表1 LEFT [OUTER] JOIN 表2 ON 条件;

-- 右外连接
-- 查询dept表所有数据和对应的员工信息
-- SELECT 字段列表 FROM 表1 RIGHT [OUTER] JOIN 表2 ON 条件;
select d.dname, e.*
from emp e
         right join dept d on d.did = e.dep_id;
