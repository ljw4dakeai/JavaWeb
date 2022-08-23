package com.ljw4dakeai.mybatis.mapper;

import com.ljw4dakeai.mybatis.pojo.User;

import java.util.List;

/**
 * @author ZJH
 */
public interface UserMapper {
    /**
     *测试 添加方法
     * @return 返回受影响的行数
     */
    int insertUser();


    /**
     *测试删除方法
     * @return  返回受影响的行数
     */
    int deleteUser();

    /**
     *
     *  测试更新方法
     * @return  返回受影响行数
     */
    int updateUser();

    /**
     * 测试 查询方法
     * @return  返回查询结果集合
     */
    List<User> selectUser();
}
