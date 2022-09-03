package com.ljw4dakeai.filter;


import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @description: ${description}
 * @title: ${NAME}
 * @package ${PACKAGE_NAME}
 * @date 2022/8/29 10:02 上午
 * @author ljw4dakeai
 * 过滤器链执行顺序按照类名字母顺序执行的
 * 过滤器链对象只有一个,而且是由tomCat创建
 */
@WebFilter("/*")
public class FilterChainA implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("FilterChinaB" + chain);
        chain.doFilter(request, response);
        System.out.println("1.FilterChinaA放行之前执行啦");
        chain.doFilter(request, response);
        System.out.println("4.FilterChinaB放行之前执行啦");
    }
}
