package com.ljw4dakeai.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;

/**
 * @author ljw4dakeai
 * @description: 获取参数
 * @title: Test04RequestParametersSetCharacter
 * @package com.ljw4dakeai.request
 * @date 2022/8/25 10:12
 */
@WebServlet("/testRequestParametersSetCharacter")
public class Test04RequestParametersSetCharacter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决post请求中文乱码

        //解决get请求中文乱码
//        URLDecoder.decode( URLEncoder.encode("传入的参数", "iso-8859-1"), "utf-8");

        req.setCharacterEncoding("utf-8");
        System.out.println("获取多个参数 : ");
        //获取多个参数
       req.getParameterMap().forEach((k, v) -> System.out.println(k + " : " + Arrays.toString(v)));

        System.out.println("---------------------------------------------------------------------");

       //获取单个参数单个结果
        System.out.println("单个参数单个结果 : " + req.getParameter("username"));
        System.out.println("---------------------------------------------------------------------");
        //获取单个参数多个结果
        System.out.println("单个参数多个结果" + Arrays.toString(req.getParameterValues("hobby")));
        System.out.println("---------------------------------------------------------------------");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
