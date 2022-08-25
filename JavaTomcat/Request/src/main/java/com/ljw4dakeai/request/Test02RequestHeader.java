package com.ljw4dakeai.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ljw4dakeai
 * @description: 获取请求头请求体数据
 * @title: Test02RequestHeader
 * @package com.ljw4dakeai.request
 * @date 2022/8/25 9:47
 */
@WebServlet("/testRequestHeader")
public class Test02RequestHeader extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求头
        System.out.println("获取请求头数据 : " + req.getHeader("user-agent"));

        System.out.println("获取请求体数据 : " + req.getReader().readLine());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
