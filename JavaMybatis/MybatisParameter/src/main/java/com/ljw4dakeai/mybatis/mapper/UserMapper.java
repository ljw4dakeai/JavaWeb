package com.ljw4dakeai.mybatis.mapper;

import com.ljw4dakeai.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @description: tb_user映射接口
 * @title: UserMapper
 * @package com.ljw4dakeai.mybatis.mapper
 * @date 2022/8/19 8:46
 * 1. 若mapper接口中的方法为单个自变量类型
 * 此时可以通过#{} ${}以仍和内容获取参数值
 * 一定要注意${}的单引号
 * ${} 本质是字符串拼接, #{} 本质是占位符
 * <p>
 * 2. 若mapper接口中的方法为当个多个变量类型
 * 此时mybatis会将参数放在集合里面,以两种方式存储
 * 1) : arg0, arg1 ....
 * 2) : param1, param2 ....
 * 我们使用#{} 和 ${} 访问参数集合就可以获取对应的值
 * <p>
 * 3.若mapper接口中的方法的参数为map集合类型的参数
 * 我们使用#{} 和 ${} 访问参数集合就可以获取对应的值
 * #{} 和 ${} 中放的是 map集合中的key
 * <p>
 * 4.若mapper接口中的方法的参数为实体类类型的参数
 * 我们使用#{} 和 ${} 访问参数集合就可以获取对应的值
 * #{} 和 ${} 中放的是实体类中的属性值
 * 属性值是(get方法后面那个字段的首字母小写, 一般是IDEA自动生成的所以就是成员变量)
 *
 * 4.若mapper接口中的方法为当个多个变量类型(并且使用注解)
 *  1) param1, param2 来访问对应的值
 *  2) 自定义的param的value属性来访问值
 * 我们使用#{注解中的value} 和 ${注解中} 访问参数集合就可以获取对应的值(都是一一对应的)
 * @author ljw4dakeai
 */
public interface UserMapper {
    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 查询到的用户
     */
    User getUserByUserName(String username);

    /**
     * 验证登录方法
     *
     * @param username 用户名
     * @param password 用户密码
     * @return 验证登录的结果
     */
    User checkLogin(String username, String password);

    /**
     * 验证登录方法通过自定义map
     *
     * @param map 自定义map
     * @return 验证登录的结果
     */
    User checkLoginByMap(Map<String, Object> map);

    /**
     * 插入用户方法
     *
     * @param user 插入的用户对象
     * @return 返回受影响的行数
     */
    int insertUser(User user);

    /**
     * 验证登录方法(通过注解实现)
     *
     * @param username 用户名
     * @param password 用户密码
     * @return 验证登录的结果
     */
    User checkLoginByParamAnnotation(@Param("username") String username, @Param("password") String password);
}
