package com.ljw4dakeai.service;

import com.ljw4dakeai.mapper.UserMapper;
import com.ljw4dakeai.pojo.User;
import com.ljw4dakeai.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ljw4dakeai
 * @description: 用户业务层
 * @title: UserService
 * @package com.ljw4dakeai.com.ljw4dakeai.service
 * @date 2022/8/29 6:03 下午
 */
public class UserService {
    //用户登录
    public boolean loginUser(String username, String password){
        SqlSession autoCommitSqlSession = SqlSessionUtil.getAutoCommitSqlSession();
        UserMapper mapper = autoCommitSqlSession.getMapper(UserMapper.class);
        User loginUser = mapper.selectUserByUser(new User(username, password));
        return loginUser != null;
    }

    //用户注册
    public boolean register(String username, String password){
        SqlSession autoCommitSqlSession = SqlSessionUtil.getAutoCommitSqlSession();
        UserMapper mapper = autoCommitSqlSession.getMapper(UserMapper.class);
        User existUser = mapper.selectUserByUserName(username);
        if (existUser == null){
            return mapper.insertUser(new User(username, password)) == 1;
        }
        return false;
    }
}
