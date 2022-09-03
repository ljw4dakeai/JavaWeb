use db5;
-- 1.PPT播放介绍下事务
-- SQL演示下事务
DROP TABLE IF EXISTS account;

-- 创建账户表
CREATE TABLE account(
                        id int PRIMARY KEY auto_increment,
                        name varchar(10),
                        money double(10,2)
);

-- 添加数据
INSERT INTO account(name,money) values('张三',1000),('李四',1000);

-- 重置账户余额
-- UPDATE account set money = 1000;

select * from account;

-- 演示转账步骤
-- 正常转账
	-- 李四 - 500
	-- 张三 + 500
    update account
    set  money = money - 500
    where  name = '李四';

    update account
    set  money = money + 5000
    where  name = '张三';

-- 异常转账
	-- 模拟异常 select * from aaa;
	update account
    set  money = money - 500
    where  name = '李四';

    select * from a; -- 模拟出现异常

    update account
    set  money = money + 5000
    where  name = '张三';

    select * from account;

-- 事务转账(异常)
-- 先begin,出异常,发现异常,rollback
-- 处理完异常,commit
 -- 开启事务
set autocommit  = false;
begin ;
-- 模拟异常
update account
set  money = money - 500
where  name = '李四';

select * from a; -- 模拟出现异常

update account
set  money = money + 5000
where  name = '张三';

select * from account;

-- 处理完异常,commit
rollback ;


-- 事务的四大特征
-- 原子性（Atomicity）: 事务是不可分割的最小操作单位，要么同时成功，要么同时失败
-- 一致性（Consistency） :事务完成时，必须使所有的数据都保持一致状态
-- 隔离性（Isolation） :多个事务之间，操作的可见性
-- 持久性（Durability） :事务一旦提交或回滚，它对数据库中的数据的改变就是永久的


