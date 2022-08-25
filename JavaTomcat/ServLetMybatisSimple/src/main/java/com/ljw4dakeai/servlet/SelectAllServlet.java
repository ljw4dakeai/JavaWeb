package com.ljw4dakeai.servlet;

import com.ljw4dakeai.mybatis.mapper.UserMapper;
import com.ljw4dakeai.mybatis.pojo.User;
import com.ljw4dakeai.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @description: 查询跳转
 * @title: SelectAllServlet
 * @package com.ljw4dakeai.servlet
 * @date 2022/8/24 19:55
 * @author ljw4dakeai
 */

@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        UserMapper mapper = autoCommitSqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();
        users.forEach(System.out::println);
        autoCommitSqlSession.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
