package com.ljw4dakeai.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ljw4dakeai
 * @description: 请求转发
 * @title: Test02ResponseReDirectReceive
 * @package com.ljw4dakeai.response
 * @date 2022/8/25 14:47
 */

@WebServlet("/testResponseReDirectReceive")
public class Test02ResponseReDirectReceive extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String study = (String) req.getAttribute("study");
        System.out.println(study);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
