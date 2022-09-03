package com.ljw4dakeai.service;

import com.ljw4dakeai.mapper.UserMapper;
import com.ljw4dakeai.pojo.User;
import com.ljw4dakeai.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * 处理用户相关的业务
 */
public class UserService {


    /**
     * 用户登录
     * @param username 登录的用户
     * @param password 登录的密码
     * @return 登录的用户
     */
    public User login(String username, String password){
        //2 获取SqlSession对象
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        //3 获取UserMapper接口代理对象
        UserMapper userMapper = autoCommitSqlSession.getMapper(UserMapper.class);
        //4 执行方法，得到结果
        User user = userMapper.select(username, password);
        //5 处理结果，释放资源
        autoCommitSqlSession.close();
        return user;
    }

    /**
     * 用户注册
     * @return 注册是否成功
     */
    public boolean register(User user){
        //2 获取SqlSession对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //3 获取UserMapper接口代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //4 执行方法，得到结果
        //4.1 调用selectByUsername方法，查询用户信息
        User existUser = userMapper.selectByUsername(user.getUsername());
        if(existUser==null){
            //4.3 如果user==null，表示用户名不存在，可以添加,调用add方法进行添加/注册
            userMapper.add(user);
            //5 处理结果，释放资源
            sqlSession.commit();
            sqlSession.close();
            return true; //表示注册成功
        }
        //5 处理结果，释放资源
        sqlSession.close();
        return false; //表示注册失败
    }

    public boolean checkUser(String username){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        //3 获取UserMapper接口代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //4 执行方法，得到结果
        //4.1 调用selectByUsername方法，查询用户信息
        User existUser = userMapper.selectByUsername(username);
        return existUser != null;
    }

}
