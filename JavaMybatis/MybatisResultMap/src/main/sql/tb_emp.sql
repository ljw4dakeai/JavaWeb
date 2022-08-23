use mybatis;

create table  if not exists tb_emp(
                        emp_id int primary key auto_increment,
                        emp_name varchar(20),
                        age int,
                        gender char(1),
                        dept_id int,
                        constraint fk_emp_dept foreign key (dept_id) references tb_dept(dept_id)
);

insert into tb_emp
values
       (null, '张三', 20, '男', 1),
       (null, '李四', 21, '男', 2),
       (null, '王五', 22, '男', 3),
       (null, '赵六', 23, '男', 1);

select *
from tb_emp;
