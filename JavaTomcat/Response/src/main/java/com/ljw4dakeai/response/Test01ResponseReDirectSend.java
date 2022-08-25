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
 * @title: Test01ResponseReDirectSend
 * @package com.ljw4dakeai.response
 * @date 2022/8/25 14:47
 */

@WebServlet("/testResponseReDirectSend")
public class Test01ResponseReDirectSend  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //方法1
//        resp.setStatus(302);
//        resp.setHeader("location", req.getContextPath() + "/testResponseReDirectReceive");
//
//        //方法2
//        //访问本机servlet
//        resp.sendRedirect(req.getContextPath() + "/testResponseReDirectReceive");
//
//        //访问本机html
//        resp.sendRedirect(req.getContextPath() + "/index.html");
//
//        //访问外部html
//        resp.sendRedirect("https://www.baidu.com");


        //设置资源共享
        req.setAttribute("study", "english");
        resp.sendRedirect(req.getContextPath() + "/testResponseReDirectReceive");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
