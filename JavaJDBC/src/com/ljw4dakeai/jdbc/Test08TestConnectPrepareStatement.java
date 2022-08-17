package com.ljw4dakeai.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * 使用 PreparedStatement (预编译语句对象) 解决SQL注入
 *
 * @author ZJH
 */
public class Test08TestConnectPrepareStatement {

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获取连接：如果连接的是本机mysql并且端口是默认的 3306 可以简化书写
        String url = "jdbc:mysql://localhost:23306/db5?useSSL=false&useServerPrepStmts=true";
        Connection conn = DriverManager.getConnection(url, "root", "root");

        // 接收用户输入 用户名和密码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String name = sc.nextLine();
        System.out.println("请输入密码:");
        String pwd = sc.nextLine();

        //定义SQL
        String sql = "select * from db5.tb_user where username = ? and password = ?";

        //预编译SQL,得到PrepareStatement对象(执行SQL语句的对象)
        PreparedStatement prepareStatement = conn.prepareStatement(sql);

        //设置参数
        prepareStatement.setString(1, name);
        prepareStatement.setString(2, pwd);
        // 执行sql
        //sql已经提前编译,无需传SQL
        ResultSet rs = prepareStatement.executeQuery();

        // 判断登录是否成功
        if (rs.next()) {
            System.out.println("登录成功~");
        } else {
            System.out.println("登录失败~");
        }

        //7. 释放资源
        rs.close();
        prepareStatement.close();
        conn.close();
    }
}
