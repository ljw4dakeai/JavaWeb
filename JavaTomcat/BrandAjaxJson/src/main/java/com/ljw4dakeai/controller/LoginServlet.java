package com.ljw4dakeai.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.ljw4dakeai.pojo.User;
import com.ljw4dakeai.pojo.UserSave;
import com.ljw4dakeai.service.UserService;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ljw4dakeai
 * @description: 登录的servlet
 * @title: LoginServlet
 * @package com.ljw4dakeai.com.ljw4dakeai.controller
 * @date 2022/8/31 2:36 下午
 */


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private  final UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(request.getReader(), User.class);
        boolean findUser = userService.loginUser(user.getUsername(), user.getPassword());
        if (!findUser){
            objectMapper.writeValue(response.getWriter(), "请输入正确的账号和密码");
        }else {

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
