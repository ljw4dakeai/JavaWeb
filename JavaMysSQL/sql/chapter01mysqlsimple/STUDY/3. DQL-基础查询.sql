use db1;

alter table stu
    rename student;

-- 删除stu表
drop table if exists stu;


-- 创建stu表
CREATE TABLE stu
(
    id        int,          -- 编号
    name      varchar(20),  -- 姓名
    age       int,          -- 年龄
    sex       varchar(5),   -- 性别
    address   varchar(100), -- 地址
    math      double(5, 2), -- 数学成绩
    english   double(5, 2), -- 英语成绩
    hire_date date          -- 入学时间
);

-- 添加数据
INSERT INTO stu(id, name, age, sex, address, math, english, hire_date)
VALUES (1, '马运', 55, '男', '杭州', 66, 78, '1995-09-01'),
       (2, '马花疼', 45, '女', '深圳', 98, 87, '1998-09-01'),
       (3, '马斯克', 55, '男', '香港', 56, 77, '1999-09-02'),
       (4, '柳白', 20, '女', '湖南', 76, 65, '1997-09-05'),
       (5, '柳青', 20, '男', '湖南', 86, NULL, '1998-09-01'),
       (6, '刘德花', 57, '男', '香港', 99, 99, '1998-09-01'),
       (7, '张学右', 22, '女', '香港', 99, 99, '1998-09-01'),
       (8, '德玛西亚', 18, '男', '南京', 56, 65, '1994-09-02');

show tables;
-- 1.查询name、age两列
select name as "姓名", age as "年纪"
from stu;
-- 2.查询所有列的数据，列名的列表可以使用*替代
select *
from stu;
-- 3.查询地址信息，去除重复记录
select distinct address "地址"
from stu;
-- 4.查询姓名、数学成绩、英语成绩，要求查询结果列名展示对应的中文名称
select name as "姓名", math "数学成绩", english "英语成绩"
from stu;