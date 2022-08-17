package com.ljw4dakeai.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author ZJH
 */
public class Test05JdbcTestConnectStatement {
    /**
     * 演示 Statement
     */
    public static void main(String[] args) throws Exception {
        //步骤:
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得数据库连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2?useSSL=false", "root", "1234");
        //Connection conn = DriverManager.getConnection("jdbc:mysql:///db2?useSSL=false", "root", "1234");
        //3.定义SQL  ddl
        String sql = "create table t1(id int primary key auto_increment);";
        //4.得到执行SQL语句的对象
        Statement stmt = conn.createStatement();

        //5.执行SQL
        int rows = stmt.executeUpdate(sql);

        //ResultSet rs = stmt.executeQuery("select * from account");
        //6.处理结果
        System.out.println(rows);
        //7.释放资源
        stmt.close();
        conn.close();
    }
}
