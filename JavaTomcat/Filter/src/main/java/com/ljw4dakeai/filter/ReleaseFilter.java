package com.ljw4dakeai.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * @description: ${description}
 * @title: ${NAME}
 * @package ${PACKAGE_NAME}
 * @date 2022/8/29 9:26 上午
 * @author ljw4dakeai
 */
@WebFilter("/*")
public class ReleaseFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    //先执行放行前逻辑, 再执行放行,再执行放行后乱码
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("ReleaseFilter放行前逻辑...");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        chain.doFilter(request, response);
        System.out.println("ReleaseFilter放行后逻辑...");
    }
}
