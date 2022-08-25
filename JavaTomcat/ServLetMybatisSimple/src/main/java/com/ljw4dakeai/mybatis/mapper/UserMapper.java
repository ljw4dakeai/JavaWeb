package com.ljw4dakeai.mybatis.mapper;

import com.ljw4dakeai.mybatis.pojo.User;

import java.util.List;

/**
 * @author ljw4dakeai
 * @description: UserMapper接口
 * @title: UserMapper
 * @package com.ljw4dakeai.mybatis.mapper
 * @date 2022/8/24 19:43
 */
public interface UserMapper {

    /**
     * 查询所有用户信息
     * @return 查询到的用户列表
     */
    List<User> selectAll();
}
