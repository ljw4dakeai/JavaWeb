package com.ljw4dakeai.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ljw4dakeai
 * @description: 请求转发, 发送方
 * @title: Test06RequestForwardSend
 * @package com.ljw4dakeai.request
 * @date 2022/8/25 11:17
 * @info
 * 无法访问外部资源, 自能访问服务器内服资源
 */
@WebServlet("/testRequestForwardSend")
public class Test06RequestForwardSend extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //添加转发
        req.setAttribute("study", "english");
        req.getRequestDispatcher("/testRequestForwardReceive").forward(req, resp);

        //不可以设置外部资源
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
