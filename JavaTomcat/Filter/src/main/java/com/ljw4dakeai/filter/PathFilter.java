package com.ljw4dakeai.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
/**
 * @description: 拦截路径
 * @title: PathFilter
 * @package ${PACKAGE_NAME}
 * @date 2022/8/29 9:48 上午
 * @author ljw4dakeai
 */

//@WebFilter("/*") 目录拦截
//@WebFilter("/page/*") 目录拦截
//@WebFilter("/page/login.jsp") 指定拦截
//@WebFilter({"/aaa/*", "/bbb/*"}) 多个目录拦截
@WebFilter("/*")
public class PathFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(request, response);
    }
}
