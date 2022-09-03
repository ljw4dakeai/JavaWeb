package com.ljw4dakeai.controller;

import com.ljw4dakeai.service.UserService;

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
 * @date 2022/8/29 3:11 下午
 */


@WebServlet("/checkUserNameServlet")
public class CheckUserNameServlet extends HttpServlet {
    private  final UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
       response.getWriter().write(userService.checkUser(username) ? "true" : "false");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
