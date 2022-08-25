package com.ljw4dakeai.mybatis.mapper;

import com.ljw4dakeai.mybatis.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

    /**
     * 登录方法, 通过用户和密码查询用户是否存在
     * @param username 查询的用户
     * @param password 查询的用户密码
     * @return 返回查询到的用户如果没有查询到就返回null
     */
    @Select("select * from servlet_mybatis.tb_user where username = #{username} and password = #{password}")
    User SelectUserLogIn(@Param("username") String username, @Param("password") String password);

    /**
     * 注册查询用户是否存在
     * @param username 注册的用户名
     * @return 返回查询到的用户名
     */
    @Select("select username from servlet_mybatis.tb_user where username = #{username}")
    String SelectUserRegister(@Param("username") String username);

    /**
     * 注册用户插入方法
     * @param username 注册的用户名
     * @param password 注册用户的用户密码
     * @return 受影响的行
     */
    @Insert("insert into servlet_mybatis.tb_user values (null, #{username}, #{password})")
    Integer InsertUserRegister(@Param("username") String username, @Param("password") String password);
}
