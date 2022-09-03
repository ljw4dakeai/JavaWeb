package com.ljw4dakeai.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
/**
 * @description: 简单的filter
 * @title: SimpleFilter
 * @package com.ljw4dakeai.filter
 * @date 2022/8/29 9:15 上午
 * @author ljw4dakeai
 */
@WebFilter("/*")
public class SimpleFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    /**
     * 过滤到拦截和请求之后执行
     * @param request 请求
     * @param response 响应
     * @param chain 拦截链
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("SimpleFilter 执行啦.....");
        chain.doFilter(request, response);
    }
}
