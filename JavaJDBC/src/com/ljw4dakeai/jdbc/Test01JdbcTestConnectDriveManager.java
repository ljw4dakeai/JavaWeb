package com.ljw4dakeai.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author ZJH
 */
public class Test01JdbcTestConnectDriveManager {
    /**
     * JDBC 引入
     */
    public static void main(String[] args) throws Exception {
        //步骤:
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        ////注册驱动
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        //2.获得数据库连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:23306/db5?useSSL=false", "root", "root");

        //3.定义SQL
        String sql = "update db5.account set money = 3000 where id = 1";

        //4.得到执行SQL语句的对象
        Statement stmt = conn.createStatement();

        //5.执行SQL
        int rows = stmt.executeUpdate(sql);

        //6.处理结果
        System.out.println(rows);
        //7.释放资源
        stmt.close();
        conn.close();
    }
}
