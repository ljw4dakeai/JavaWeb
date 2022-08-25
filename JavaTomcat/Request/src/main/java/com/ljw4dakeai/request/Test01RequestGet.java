package com.ljw4dakeai.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ljw4dakeai
 * @description: 测试request get请求
 * @title: Test01RequestGet
 * @package com.ljw4dakeai.request
 * @date 2022/8/25 9:22
 */
@WebServlet("/testRequestGet")
public class Test01RequestGet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求方式
        System.out.println("req.getMethod() = " + req.getMethod());

        //获取请求根路径
        System.out.println("req.getContextPath() = " + req.getContextPath());

        //获取URL统一资源定位符
        System.out.println("req.getRequestURL() = " + req.getRequestURL());

        //获取URI获取统一资源标识符
        System.out.println("req.getRequestURI() = " + req.getRequestURI());

        //获取get请求参数
        System.out.println("req.getQueryString() = " + req.getQueryString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
