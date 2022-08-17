package com.ljw4dakeai.jdbc;

import com.ljw4dakeai.pojo.Account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author ZJH
 */
public class Test06TestConnectResultAccount {
    /**
     * ResultSet 案例
     * 需求：查询account账户表数据，封装为Account对象中，并且存储到ArrayList集合中
     */
    public static void main(String[] args) throws Exception {
        //步骤:
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得数据库连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:23306/db5?useSSL=false", "root", "root");

        //3.定义SQL  select 语句
        String sql = "select * from db5.account";

        //4.得到执行SQL语句的对象
        Statement stmt = conn.createStatement();
        //5.执行SQL select 语句
        ResultSet rs = stmt.executeQuery(sql);
        //6.处理结果集
        /*
        boolean   next()：(1) 将光标从当前位置向下移动一行 （2）判断当前行是否为有效行
            返回值：
            true：有效行，当前行有数据
            false：无效行，当前行没有数据
         */
        ArrayList<Account> accounts = new ArrayList<>();
        while (rs.next()) { //向下移动一行
            //xxx    getXxx(参数)：获取数据
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double money = rs.getDouble("money");
            accounts.add(new Account(id, name, money));
        }

        accounts.forEach(System.out::println);
        //7.释放资源
        rs.close();
        stmt.close();
        conn.close();
    }
}
