package com.ljw4dakeai.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ljw4dakeai
 * @description: ${description}
 * @title: ${NAME}
 * @package ${PACKAGE_NAME}
 * @date 2022/8/29 10:24 上午
 */

@WebFilter(value = "/filter/*", dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        //冲session域对象中获取user
        Object user = req.getSession().getAttribute("user");
        //如果user == null 就是没有登录
        //
        // 如果user != null 就是登录了
        if (user == null) {
            //没有登录就返回login.jsp 并且输出错误信息
            request.setAttribute("login_msg", "你还无权限访问");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }
}
