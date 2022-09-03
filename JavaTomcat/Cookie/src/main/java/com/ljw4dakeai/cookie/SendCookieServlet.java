package com.ljw4dakeai.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author ljw4dakeai
 * @description: 发送Cookie
 * @title: SendCookieServlet
 * @package com.ljw4dakeai.cookie
 * @date 2022/8/28 9:25 上午
 */
@WebServlet("/SendCookieServlet")
public class SendCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = "张益达";

        //设置编码传入
        Cookie cookie = new Cookie("name",  URLEncoder.encode(name,"utf-8"));
//        //设置存储时间为一天
//        cookie.setMaxAge(60 * 60 * 24);
//        //已创建
//        //2022年8月28日星期日 09:31:19
//        //到期
//        //2022年8月29日星期一 10:00:56

//        //设置删除cookie
//        cookie.setMaxAge(0);
//        //已创建
//        //2022年8月28日星期日 10:03:21
//        //到期
//        //1970年1月1日星期四 08:00:10

        cookie.setMaxAge(-1);
        //已创建
        //2022年8月28日星期日 10:06:01
        //到期
        //浏览会话结束时
        response.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
