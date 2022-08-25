package com.ljw4dakeai.response;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author ljw4dakeai
 * @description: 响应写字符流
 * @title: Test04ResponseOutPutStream
 * @package com.ljw4dakeai.response
 * @date 2022/8/25 15:15
 */
@WebServlet("/testResponseOutPutStream")
public class Test04ResponseOutPutStream extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\software\\code\\java\\JavaWeb\\JavaTomcat\\Response\\src\\main\\webapp\\imgs\\e.jpg");
        IOUtils.copy(fileInputStream, resp.getOutputStream());
        fileInputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
