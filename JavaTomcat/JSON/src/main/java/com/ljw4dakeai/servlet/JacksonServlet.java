package com.ljw4dakeai.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ljw4dakeai.pojo.User;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ljw4dakeai
 * @description: ${description}
 * @title: ${NAME}
 * @package ${PACKAGE_NAME}
 * @date 2022/8/29 4:07 下午
 */


@WebServlet("/JacksonServlet")
public class JacksonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        ArrayList<String> strings = new ArrayList<>();
        Collections.addAll(strings, "湖北", "上海", "北京");
        User user = new User(1, "张益达", "1001011", strings);

        ObjectMapper objectMapper = new ObjectMapper();
//        String json = objectMapper.writeValueAsString(user);
//        response.getWriter().write(json);

        objectMapper.writeValue(response.getOutputStream(), user);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        //方式一
//        String line = request.getReader().readLine();
//        System.out.println(objectMapper.readValue(line, User.class));

        //方式二
        System.out.println(objectMapper.readValue(request.getReader(), User.class));
    }
}
