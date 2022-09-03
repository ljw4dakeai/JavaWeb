package com.ljw4dakeai.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ljw4dakeai.pojo.Book;
import com.ljw4dakeai.service.BookService;
import com.ljw4dakeai.service.impl.BookServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ljw4dakeai
 * @description: 书本的Servlet
 * @title: BookServlet
 * @package com.ljw4dakeai.controller
 * @date 2022/9/1 8:58 下午
 */


@WebServlet("/book/*")
public class BookServlet extends BaseServlet{
    public void selectAllServlet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        List<Book> books = bookService.selectAllBook();
        objectMapper.writeValue(response.getWriter(), books);
        //book/selectAllServlet
    }

    public void insertBookServlet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String description = request.getParameter("description");
        boolean successIf = bookService.insertBook(type, name, description);
        objectMapper.writeValue(response.getWriter(), successIf);
        //book/insertBookServlet?name="爬虫"&type="网络编程"&description="面向监狱编程"
    }

    public void deleteBookByIdServlet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        Integer id = Integer.parseInt(request.getParameter("id"));
        boolean successIf = bookService.deleteBookById(id);
        objectMapper.writeValue(response.getWriter(), successIf);
        //book/deleteBookByIdServlet?id=1
    }

    public void updateBookByIdServlet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("utf-8");
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String description = request.getParameter("description");
        boolean successIf = bookService.updateBookById(id, type, name, description);
        objectMapper.writeValue(response.getWriter(), successIf);
        //book/updateBookByIdServlet?id=1&name="爬虫"&type="网络编程"&description="面向监狱编程"
    }
}
