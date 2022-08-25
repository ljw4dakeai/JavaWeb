package com.ljw4dakeai.servlet;

import com.ljw4dakeai.mybatis.mapper.UserMapper;
import com.ljw4dakeai.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ljw4dakeai
 * @description: 注册验证
 * @title: ServletRegister
 * @package com.ljw4dakeai.servlet
 * @date 2022/8/25 17:14
 */
@WebServlet("/ServletRegister")
public class ServletRegister extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //支持中文
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //获取输入参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter responseWriter = response.getWriter();
        if (username == null || username.equals("") || username.contains(" ")) {
            responseWriter.write("<script>alert(\"注册失败账户名不能为空或者空白!\")</script>");
        } else {
            //查询该账户是否存在
            SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
            UserMapper mapper = autoCommitSqlSession.getMapper(UserMapper.class);
            String findUser = mapper.SelectUserRegister(username);
            if (findUser == null) {
                //不存在就注册用户
                Integer integer = mapper.InsertUserRegister(username, password);
                responseWriter.write(integer == 0 ? "<script>alert(\"注册失败, 用户写入失败!\")</script>" : "<script>alert(\"注册成功!\")</script>");
            } else {
                //存在就返回注册失败
                responseWriter.write("<script>alert(\"注册失败, 该账户已经存在!\")</script>");
            }
            autoCommitSqlSession.close();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
