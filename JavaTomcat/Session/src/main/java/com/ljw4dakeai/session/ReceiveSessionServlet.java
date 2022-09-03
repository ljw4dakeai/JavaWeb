package com.ljw4dakeai.session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * @author ljw4dakeai
 * @description: 接收Session
 * @title: ReceiveSessionServlet
 * @package com.ljw4dakeai.cookie
 * @date 2022/8/28 9:26 上午
 */
@WebServlet("/ReceiveSessionServlet")
public class ReceiveSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println("ReceiveSessionServlet中的session : " + session);
        Object name = session.getAttribute("name");
        System.out.println("name : " + name);
//        立即销毁Session
        session.invalidate();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
