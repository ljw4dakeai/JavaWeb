package com.ljw4dakeai.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ljw4dakeai
 * @description: ${description}
 * @title: ${NAME}
 * @package ${PACKAGE_NAME}
 * @date 2022/8/29 11:46 上午
 */


@WebServlet("/ajaxServlet")
public class AjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("name = " + username);
        response.getWriter().write("hello : " + username);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
