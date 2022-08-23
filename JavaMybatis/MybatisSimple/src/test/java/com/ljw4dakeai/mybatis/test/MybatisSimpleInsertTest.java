package com.ljw4dakeai.mybatis.test;

import com.ljw4dakeai.mybatis.mapper.UserMapper;
import com.ljw4dakeai.mybatis.pojo.User;
import com.ljw4dakeai.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisSimpleInsertTest {


    @Test
    public void testInsert() throws IOException {
        //获取核心配置文件输入流
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder 主要是用来构建SqlSessionFactory(工厂模式)
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //通过输入流创建工厂对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //sqlSession对象,mybatis操作数据库对象(不会自动提交事务)
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //设置自动开启事务
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //原始方法
        //nameSpace.sqlID
        //sqlSession.insert("com.ljw4dakeai.mybatis.mapper.UserMapper.insertUser");
        //获取UserMapper代理实现类对象(代理模式, 找到映射文件中的sql语句,实现)
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用接口中的方法,实现用户信息添加功能
        int result = mapper.insertUser();
        //没有提交事务,默认是回滚的
        //提交事务
        //sqlSession.commit();
        System.out.println("结果 : " +result);
        //关闭sqlSession对象
        sqlSession.close();
    }

    @Test
    public void testDelete(){
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        UserMapper mapper = autoCommitSqlSession.getMapper(UserMapper.class);
        int result = mapper.deleteUser();
        autoCommitSqlSession.close();;
    }

    @Test
    public void testUpdate(){
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        UserMapper mapper = autoCommitSqlSession.getMapper(UserMapper.class);
        int result = mapper.updateUser();
        autoCommitSqlSession.close();;
    }


    @Test
    @Before
    @After
    public void testSelect(){
        SqlSession autoCommitSqlSession = SqlSessionUtils.getAutoCommitSqlSession();
        UserMapper mapper = autoCommitSqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectUser();
        users.forEach(System.out::println);
        autoCommitSqlSession.close();;
    }


}
