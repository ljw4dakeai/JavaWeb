package com.ljw4dakeai.controller;

import com.ljw4dakeai.pojo.User;
import com.ljw4dakeai.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * 处理用户注册的请求
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户注册参数
        //注册服务查询返回 是否有该用户]
        User user = new User();
        try {
            BeanUtils.populate(user, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        String clientCheckCode = request.getParameter("checkCode");
        String serveCheckCode = (String)request.getSession().getAttribute("checkCode");
        request.getSession().removeAttribute("checkCode");
        if(clientCheckCode == null || !clientCheckCode.equalsIgnoreCase(serveCheckCode)){
            request.setAttribute("register_msg", "验证码错误, 请重新输入!");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }
        boolean flag = userService.register(user);
        if (!flag) {
            //有该用户 数据回显到注册的页面并且提示错误
            request.setAttribute("register_msg", "已经存在该用户, 请重新输入!");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }else {
            //没有该用户 注册成功并且数据显示在注册页面
            request.setAttribute("login_msg", "恭喜你注册成功!可以登录啦!!");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
