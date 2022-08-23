package com.ljw4dakeai.mybatis.test;

import com.ljw4dakeai.mybatis.mapper.SelectMapper;
import com.ljw4dakeai.mybatis.pojo.User;
import com.ljw4dakeai.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author ljw4dakeai
 * @description: 查询方法测试
 * @title: SelectMapperTest
 * @package com.ljw4dakeai.mybatis.test
 * @date 2022/8/19 11:52
 * @info 查询的 结果为多条的时候, 一定不能将实体类的作为返回值类型,
 * 会抛出TooManyResultException
 * 查询结果为一条的时候, 可以使用实体类作为返回值, 也可以使用实体类集合作为返回值类型
 */
public class SelectMapperTest {

    @Test
    public void testSelectUserById() {
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        SelectMapper mapper = autoCommitSqlSession.getMapper(SelectMapper.class);
        User user = mapper.selectByUserId(12);
        System.out.println(user);
        autoCommitSqlSession.close();
    }

    @Test
    public void testSelectAllUser() {
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        SelectMapper mapper = autoCommitSqlSession.getMapper(SelectMapper.class);
        List<User> users = mapper.selectAllUser();
        users.forEach(System.out::println);
        autoCommitSqlSession.close();
    }

    @Test
    public void testGetCountUser() {
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        SelectMapper mapper = autoCommitSqlSession.getMapper(SelectMapper.class);
        Integer integer = mapper.selectCountUser();
        System.out.println("表中有" + integer + "人");
        autoCommitSqlSession.close();
    }

    @Test
    public void testGetUserByIDToMap() {
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        SelectMapper mapper = autoCommitSqlSession.getMapper(SelectMapper.class);
        Map<String, Object> user = mapper.getUserByIDToMap(12);
        user.forEach((k, v) -> System.out.println(k + " : " + v));
        /* 查询的结果
        password : 520000
        gender : 男
        id : 12
        addr : 湖北武汉
        username : 邹家豪
        */
        autoCommitSqlSession.close();
    }

    @Test
    public void testGetAllUserToMapOne() {
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        SelectMapper mapper = autoCommitSqlSession.getMapper(SelectMapper.class);
        List<Map<String, Object>> users = mapper.getAllUserToMapOne();
        users.forEach(val -> {
            val.forEach((k, v) -> System.out.println(k + " : " + v));
            System.out.println("--------------------------------");
        });
        /*
        password : 123
        gender : 男
        id : 1
        addr : 北京
        username : zhangsan
        --------------------------------
        password : 234
        gender : 女
        id : 2
        addr : 天津
        username : 李四
        --------------------------------
        password : 11
        gender : 男
        id : 3
        addr : 西安
        username : 王五
        --------------------------------
        password : 520000
        gender : 男
        id : 12
        addr : 湖北武汉
        username : 邹家豪
        --------------------------------
         */
        autoCommitSqlSession.close();
    }

    @Test
    public void testGetAllUserToMapTwo() {
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        SelectMapper mapper = autoCommitSqlSession.getMapper(SelectMapper.class);
        Map<String, Object> users = mapper.getAllUserToMapTwo();
        users.entrySet().forEach(System.out::println);
        /*
        1={password=123, gender=男, id=1, addr=北京, username=zhangsan}
        2={password=234, gender=女, id=2, addr=天津, username=李四}
        3={password=11, gender=男, id=3, addr=西安, username=王五}
        12={password=520000, gender=男, id=12, addr=湖北武汉, username=邹家豪}
         */
        autoCommitSqlSession.close();
    }

}
