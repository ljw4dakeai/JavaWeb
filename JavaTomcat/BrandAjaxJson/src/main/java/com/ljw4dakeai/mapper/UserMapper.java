package com.ljw4dakeai.mapper;

import com.ljw4dakeai.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ljw4dakeai
 * @description: UserMapper接口
 * @title: UserMapper
 * @package com.ljw4dakeai.com.ljw4dakeai.mapper
 * @date 2022/8/29 6:01 下午
 */
public interface UserMapper {
    /**
     * 通过用户和密码查询用户
     * @param user 需要查询的用户
     * @return 返回查询到的用户
     */
    @Select("select * from servlet_mybatis.tb_user where username = #{username} and password = #{password} ")
    User selectUserByUser(User user);

    /**
     * 通过username查询用户
     * @param username 查询的用户名
     * @return 查询到的用户
     */
    @Select("select * from servlet_mybatis.tb_user where username = #{username}")
    User selectUserByUserName(@Param("username") String username);

    /**
     * 插入用户
     * @param user 插入用户的信息
     * @return 受影响的行
     */
    @Insert("insert into servlet_mybatis.tb_user values (null, #{username} , #{password} )")
    Integer insertUser(User user);
}
