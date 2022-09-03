package com.ljw4dakeai.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author ljw4dakeai
 * @description: SqlSessionFactoryUtils工具类
 * @title: SqlSessionFactoryUtils
 * @package com.ljw4dakeai.com.ljw4dakeai.utils
 * @date 2022/8/29 6:06 下午
 */


public class SqlSessionUtil {
    private static SqlSessionFactory  sqlSessionFactory;

    static {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        try {
            sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsReader("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static  SqlSession getAutoCommitSqlSession(){
        return  sqlSessionFactory.openSession(true);
    }

    public static  SqlSession getNotCommitSqlSession(){
        return  sqlSessionFactory.openSession();
    }
}
