package com.ljw4dakeai.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @author ZJH
 */
public class Test07TestSqlInjection {

    public static void main(String[] args) throws Exception {
        //2. 获取连接：如果连接的是本机mysql并且端口是默认的 3306 可以简化书写
        String url = "jdbc:mysql://localhost:23306/db5?useSSL=false";
        Connection conn = DriverManager.getConnection(url, "root", "root");
        // 接收用户输入 用户名和密码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String name = sc.nextLine();
        System.out.println("请输入密码:");
//        String pwd = sc.nextLine();
        //修改了原来的关键字 改变了sql的意思
        String pwd = "' or '1' = '1";


        String sql = "select * from db5.tb_user where username = '" + name + "' and password = '" + pwd + "'";
        //打印最终执行的SQL看看
        System.out.println(sql);

        // 获取stmt对象
        Statement stmt = conn.createStatement();

        // 执行sql
        ResultSet rs = stmt.executeQuery(sql);

        // 判断登录是否成功
        if (rs.next()) {
            System.out.println("登录成功~");
        } else {
            System.out.println("登录失败~");
        }

        //7. 释放资源
        rs.close();
        stmt.close();
        conn.close();
    }
}
