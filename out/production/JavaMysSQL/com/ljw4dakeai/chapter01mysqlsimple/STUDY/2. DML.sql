-- 1.给指定列添加数据 INSERT INTO 表名(列名1,列名2,…) VALUES(值1,值2,…);
use db1;
show tables;

desc stu;

insert into stu(id, name, gender, birthday, score, email, tel, status)
values (001, '小红', '女', 20010101, 520.50, '28931723 787@qq.com', '182347247282', 3);

-- 2.给所有列添加数据，列名的列表可以省略的

insert into stu
values (002, '小明', '男', '2002/01/20', 180.5, '10342089830@qq.com', '1283892410', 4);
-- 3.批量添加数据
insert into stu(id, name, gender, birthday, score, email, tel, status)
values (0003, '邹家豪', '男', '2001-11-20', 95.0, '2631247954@qq.com', '131971514000', 1),
       (004, '李静雯', '女', '2001-04-26', 150.50, '1598291479@qq.com', '152271041749', 2);


select *
from stu;
-- 修改数据 UPDATE 表名 SET 列名1=值1,列名2=值2,… [WHERE 条件] ;

-- 4.将张三的性别改为女
update stu
set gender = '女'
where name = '小明';

select *
from stu;
-- 5、将张三的生日改为 1999-02-12 分数改为99.99
update stu
set birthday = 19990212,
    score=99.99
where name = '小明';

select *
from stu;
-- 6、将王五的分数在原有的基础上-10分
update stu
set score = score - 10
where name = '小明';

select *
from stu;
-- 删除  DELETE FROM 表名 [WHERE 条件] ;
-- 7.删除张三记录
delete
from stu
where name = '小红';


select *
from stu;