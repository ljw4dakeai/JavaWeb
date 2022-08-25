package com.ljw4dakeai.servlet;

import com.ljw4dakeai.mybatis.mapper.UserMapper;
import com.ljw4dakeai.mybatis.pojo.User;
import com.ljw4dakeai.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * @description: 登录验证
 * @title: ServletLonIn
 * @package com.ljw4dakeai.servlet
 * @date 2022/8/25 17:13
 * @author ljw4dakeai
 */
@WebServlet("/ServletLonIn")
public class ServletLonIn extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //获取传入参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //执行查找方法
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        UserMapper mapper = autoCommitSqlSession.getMapper(UserMapper.class);
        User user = mapper.SelectUserLogIn(username, password);

        //响应
        response.getWriter().write(user == null ? "<script>alert(\"登录失败!\")</script>" : "<script>alert(\"登录成功!\")</script>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
