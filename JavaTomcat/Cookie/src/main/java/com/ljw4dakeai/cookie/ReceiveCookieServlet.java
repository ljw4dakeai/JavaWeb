package com.ljw4dakeai.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * @author ljw4dakeai
 * @description: 接收Cookie
 * @title: ReceiveCookieServlet
 * @package com.ljw4dakeai.cookie
 * @date 2022/8/28 9:26 上午
 */
@WebServlet("/ReceiveCookieServlet")
public class ReceiveCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("name")){
                //解码前的name = %E5%BC%A0%E7%9B%8A%E8%BE%BE
                System.out.println("解码前的name" + " = "+cookie.getValue());
                //解码后的name = 张益达
                System.out.println("解码后的name" + " = "+ URLDecoder.decode(cookie.getValue(), "utf-8"));
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
