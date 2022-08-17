package com.ljw4dakeai.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 演示事务
 * 1.正常(使用事务)
 * 2.异常(使用事务)
 * 3.不用事务,异常
 * @author ZJH
 */
public class Test03JdbcTestConnectTransaction {
    public static void main(String[] args) throws Exception {
        //演示事务
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //加载两次
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //2.获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:23306/db5?useSSL=false", "root", "root");
        //3.获取执行SQL语句的对象
        Statement statement = conn.createStatement();
        //4.定义SQL
        String sql = "update db5.account set money = 3000 where   id = 1;";

        String sql2 = "update db5.account set money = 3000 where   id = 2";

        try {
            //开启事务
            conn.setAutoCommit(false);

            //5.执行SQL
            int rows = statement.executeUpdate(sql);
            System.out.println(rows);

            //模拟出现异常
             //int i = 100 / 0;

            int rows2 = statement.executeUpdate(sql2);
            System.out.println(rows2);

            //提交事务
            conn.commit();

        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            conn.rollback();
        }
        //6.释放资源
        statement.close();
        conn.close();
    }
}
