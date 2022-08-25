package com.ljw4dakeai.servlettemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: Servlet模版创建
 * @title: ServletTemplate
 * @package com.ljw4dakeai.servlettemplate
 * @date 2022/8/24 17:13
 * @author ljw4dakeai
 */


@WebServlet("/ServletTemplate")
public class ServletTemplate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
