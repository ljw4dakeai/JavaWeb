package com.ljw4dakeai.mybatis.test;

import com.ljw4dakeai.mybatis.mapper.SelectMapper;
import com.ljw4dakeai.mybatis.mapper.SpecialSqlMapper;
import com.ljw4dakeai.mybatis.pojo.User;
import com.ljw4dakeai.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author ljw4dakeai
 * @description: 特殊SQL查询测试
 * @title: SpecialSqlTest
 * @package com.ljw4dakeai.mybatis.test
 * @date 2022/8/19 17:48
 */
public class SpecialSqlTest {
    @Test
    public void testGetUserByLike(){
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        SpecialSqlMapper mapper = autoCommitSqlSession.getMapper(SpecialSqlMapper.class);
        List<User> users = mapper.getUserByLike("%a%");
        users.forEach(System.out::println);
        autoCommitSqlSession.close();
    }

    @Test
    public void testDeleteMoreUserById(){
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        SpecialSqlMapper mapper = autoCommitSqlSession.getMapper(SpecialSqlMapper.class);
        int result = mapper.deleteMoreUserById("1, 2");
        System.out.println(result + "行受影响!");
        autoCommitSqlSession.close();
    }

    @Test
    public void testGetUserByTableName(){
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        SpecialSqlMapper mapper = autoCommitSqlSession.getMapper(SpecialSqlMapper.class);
        List<User> users = mapper.selectUserByTableName("tb_user");
        users.forEach(System.out::println);
        autoCommitSqlSession.close();
    }

    @Test
    public void testInsertUserReturnAutoIncrementId(){
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        SpecialSqlMapper mapper = autoCommitSqlSession.getMapper(SpecialSqlMapper.class);
        User user = new User(null, "小明", "111222", "女", "湖北黄石");
        int result = mapper.insertUserReturnAutoIncrementId(user);
        System.out.println(result + "行受影响!, 获取的自增主键为 : " +  user.getId());
        autoCommitSqlSession.close();
    }


}
