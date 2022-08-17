package com.ljw4dakeai.jdbc;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author ZJH
 */
public class Test02JdbcTestConnectConnection {
    /**
     * jdbc入门案例
     */
    public static void main(String[] args) throws Exception {
        //步骤:
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        ////驱动注册两次
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //2.获得数据库连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:23306/db5?useSSL=false", "root", "root");

        //3.定义SQL
        String sql = "select * from db5.account";
        //4.得到执行SQL语句的对象
        Statement statement = connection.createStatement();
        //5.执行SQL
        ResultSet resultSet = statement.executeQuery(sql);

        //6.处理结果
        int id;
        BigDecimal money;
        String name;
        System.out.println("id\t用户名\t金额");
        // 遍历结果集
        while (resultSet.next()) {
            // 获得id值
            id = resultSet.getInt("id");
            // 获得用户名
            name = resultSet.getString("name");
            // 获得金额
            money  = resultSet.getBigDecimal("money");
            System.out.println(id + "\t" + name + "\t" + money);
        }

        //7.释放资源
        statement.close();
        connection.close();

    }
}
