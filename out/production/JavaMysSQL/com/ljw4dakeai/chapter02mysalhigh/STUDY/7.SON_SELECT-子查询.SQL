use db4;
-- 什么是子查询,看需求
-- 1.查询工资高于猪八戒工资的员工信息
    -- 1.1 查猪八戒的工资
    select  e.NAME, e.salary
    from emp e
    where NAME = '猪八戒';
    -- 1.2 高于猪八戒工资的员工信息
    select *
    from emp
    where salary > (
            select  e.salary "emp_sal"
            from emp e
            where NAME = '猪八戒'
        );
