package com.ljw4dakeai.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author ljw4dakeai
 * @description: xml配置
 * @title: TestServletXML
 * @package com.ljw4dakeai.servlet
 * @date 2022/8/24 14:40
 */
public class TestServletXML implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("通过xml配置Servlet");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
