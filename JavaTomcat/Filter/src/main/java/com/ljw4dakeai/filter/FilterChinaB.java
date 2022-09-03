package com.ljw4dakeai.filter;


import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * @description: ${description}
 * @title: ${NAME}
 * @package ${PACKAGE_NAME}
 * @date 2022/8/29 10:03 上午
 * @author ljw4dakeai
 */
@WebFilter("/*")
public class FilterChinaB implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("FilterChinaB" + chain);
        System.out.println("2.FilterChinaB放行之前执行啦");
        chain.doFilter(request, response);
        System.out.println("3.FilterChinaB放行之前执行啦");
    }
}
