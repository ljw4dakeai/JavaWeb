use mybatis;

create table if not exists tb_dept
(
    dept_id   int primary key auto_increment,
    dept_name varchar(20)
);

insert into tb_dept
values (1, 'A'),
       (2, 'B'),
       (3, 'C');

select *
from tb_dept;