package com.ljw4dakeai.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ljw4dakeai.service.BookService;
import com.ljw4dakeai.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ljw4dakeai
 * @description: 基本的Servlet
 * @title: BaseServlet
 * @package com.ljw4dakeai.controller
 * @date 2022/9/1 6:04 下午
 */


public class BaseServlet extends HttpServlet {
    protected final BookService bookService= new BookServiceImpl();
    protected final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        int index = uri.lastIndexOf('/');
        String  methodName = uri.substring(index + 1);
        try {
            Method declaredMethod = this.getClass().getDeclaredMethod(methodName ,HttpServletRequest.class, HttpServletResponse.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
