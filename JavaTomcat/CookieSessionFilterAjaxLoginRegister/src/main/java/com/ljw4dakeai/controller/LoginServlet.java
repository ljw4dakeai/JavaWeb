package com.ljw4dakeai.controller;

import com.ljw4dakeai.pojo.User;
import com.ljw4dakeai.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * 处理用户登录的请求
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //接受页面传入的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //调用service的longin方法(返回查询到的对象, 为null 就是登录失败)
        User user = userService.login(username, password);
        if (user == null) {
            //为null数据回显
            request.setAttribute("login_msg", "登录失败,请重新输入账号和密码");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            //不为null进入数据显示页面
            //创建两个cookie, 一个保存账号, 一个保存密码
            Cookie usernameCookie = new Cookie("username", URLEncoder.encode(username, "utf-8"));
            Cookie passwordCookie = new Cookie("password", URLEncoder.encode(password, "utf-8"));
            HttpSession requestSession = request.getSession();
            //如果验证成功 并且 记住信息为yes
            if("yes".equals(request.getParameter("remember"))){
                //设置存活时间为7天
                usernameCookie.setMaxAge(60 * 60*24*7);
                passwordCookie.setMaxAge(60 * 60*24*7);
            }else {
                //如果取消勾选记住信息,设置存货时间为0
                usernameCookie.setMaxAge(0);
                passwordCookie.setMaxAge(0);
            }
            //设置cookie
            response.addCookie(usernameCookie);
            response.addCookie(passwordCookie);


            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect(request.getContextPath() + "/selectAllServlet");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
