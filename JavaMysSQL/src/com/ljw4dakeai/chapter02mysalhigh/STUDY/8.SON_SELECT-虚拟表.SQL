use db4;
-- 演示子查询-多行单列
-- 1.查询 '财务部' 和 '市场部' 所有的员工信息
	-- 1.1 查询财务部和市场部的部门编号
	select d.did
    from dept d
    where dname in('市场部', '财务部');
	-- 1.2 查询 '财务部' 和 '市场部' 的员工信息
    select *
    from emp
    where dep_id in (
            select d.did
            from dept d
            where dname in('市场部', '财务部')
        );

    select e.*, d.did
    from dept d, emp e
    where e.dep_id = d.did and dname in('市场部', '财务部');

-- 演示子查询-多行多列(虚拟表)
-- 2.查询入职日期是 '2011-11-11' 之后的员工信息和部门信息
	-- 2.1查询 入职日期是 '2011-11-11' 之后的员工信息
    select *
    from emp
    where join_date > '2011-11-11';
	-- 2.2 将上面的结果与部门表(dept)连接
    select some_emp.* , d.dname
    from (
            select *
            from emp
            where join_date > '2011-11-11'
         ) some_emp
    left join dept  d
        on some_emp.dep_id =  d.did;

    select e.* , d.dname
    from emp e, dept  d
    where e.dep_id =  d.did and join_date > '2011-11-11' ;

    select e.* , d.dname
    from emp e  left join dept  d
        on e.dep_id =  d.did
    where join_date > '2011-11-11' ;
	



