package com.ljw4dakeai.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ljw4dakeai
 * @description: 请求转发发 接受方
 * @title: Test05RequestForwardReceive
 * @package com.ljw4dakeai.request
 * @date 2022/8/25 11:18
 *
 */
@WebServlet("/testRequestForwardReceive")
public class Test05RequestForwardReceive extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受数据
        String study = (String)req.getAttribute("study");
        System.out.println("study = " + study);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
