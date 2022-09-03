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
 * @description: SqlSession工具类
 * @title: SqlSessionUtil
 * @package com.ljw4dakeai.utils
 * @date 2022/9/1 8:51 上午
 */


public class SqlSessionUtil {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        try {
            sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsReader("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getAutoCommitSqlSession(){
        return  sqlSessionFactory.openSession(true);
    }

    public static  SqlSession getNotCommitSqlSession(){
        return  sqlSessionFactory.openSession();
    }
}
