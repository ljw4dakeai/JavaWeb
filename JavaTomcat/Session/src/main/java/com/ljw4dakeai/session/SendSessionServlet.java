package com.ljw4dakeai.session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author ljw4dakeai
 * @description: 发送Session
 * @title: SendSessionServlet
 * @package com.ljw4dakeai.cookie
 * @date 2022/8/28 9:25 上午
 */
@WebServlet("/SendSessionServlet")
public class SendSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = "张益达";
        //一次会话中第一次调用该方法会常见session对象, 以后调用该方法都是获取同一个第一次创建的session
        HttpSession session = request.getSession();
        System.out.println("SendSessionServlet中的Session : " + session );
        session.setAttribute("name", name);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
