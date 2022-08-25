package com.ljw4dakeai.httpservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ljw4dakeai
 * @description: HttpServlet
 * @title: TestHttpServlet
 * @package com.ljw4dakeai.httpservlet
 * @date 2022/8/24 15:58
 */
@WebServlet("/testHttpServlet")
public class TestHttpServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet方法执行啦-----------------");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost方法执行啦-----------------");
    }
}
