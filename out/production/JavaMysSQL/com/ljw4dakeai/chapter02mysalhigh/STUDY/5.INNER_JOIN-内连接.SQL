use db4;

-- 隐式内连接
-- SELECT 字段列表 FROM 表1,表2… WHERE 条件;
-- 查询 emp的 name， gender，dept表的dname
-- 给表 取别名
select e.NAME, e.gender, d.dname
from emp e,
     dept d
where e.dep_id = d.did;


-- 显式内连接(需求同上)
-- SELECT 字段列表 FROM 表1 [INNER] JOIN 表2 ON 条件;
select e.NAME, e.gender, d.dname
from emp e
inner join dept d
on e.dep_id = d.did;

-- inner 可以省略


-- 内连接是查询2个表的交集数据.
