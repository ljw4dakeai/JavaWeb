package com.ljw4dakeai.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author ljw4dakeai
 * @description: 简单实现servlet
 * @title: TestServlet
 * @package com.ljw4dakeai.servlet
 * @date 2022/8/24 11:57
 */

@WebServlet("/testServlet") //访问路径 暂时必须以/开头
public class TestServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("测试类执行了!");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
