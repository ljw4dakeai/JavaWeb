package com.ljw4dakeai.mybatis.test;

import com.ljw4dakeai.mybatis.mapper.UserMapper;
import com.ljw4dakeai.mybatis.pojo.User;
import com.ljw4dakeai.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ljw4dakeai
 * @description: Mybatis查询参数测试
 * @title: MybatisParameterTest
 * @package com.ljw4dakeai.mybatis.test
 * @date 2022/8/19 8:57
 */
public class MybatisParameterTest {

    @Test
    public void testGetUserByUserName(){
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        UserMapper userMapper = autoCommitSqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserByUserName("zhangsan");
        System.out.println(user);
        autoCommitSqlSession.close();
    }


    @Test
    public void testLogin(){
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        UserMapper userMapper = autoCommitSqlSession.getMapper(UserMapper.class);
        User user = userMapper.checkLogin("zhangsan", "123");
        System.out.println(user);
        autoCommitSqlSession.close();
    }

    @Test
    public void testLoginByMap() {
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        UserMapper userMapper = autoCommitSqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username", "zhangsan");
        map.put("password", "123");
        User user = userMapper.checkLoginByMap(map);
        System.out.println(user);
        autoCommitSqlSession.close();
    }

    @Test
    public void testInsertUser(){
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        UserMapper mapper = autoCommitSqlSession.getMapper(UserMapper.class);
//        int result = mapper.insertUser(new User(null, "邹家豪", "520000", "男", "湖北武汉"));
        int result = mapper.insertUser(new User(null, "admin", "123456", "男", "襄阳"));
        System.out.println("结果 : " + result);
        autoCommitSqlSession.close();
    }

    @Test
    public void testLoginByParamAnnotation(){
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        UserMapper userMapper = autoCommitSqlSession.getMapper(UserMapper.class);
        User user = userMapper.checkLoginByParamAnnotation("邹家豪", "520000");
        System.out.println(user);
        autoCommitSqlSession.close();
    }
}
