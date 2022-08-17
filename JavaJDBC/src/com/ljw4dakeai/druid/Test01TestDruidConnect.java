package com.ljw4dakeai.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 连接池的概述和作用
 * 1、 资源重用
 * 2、提升响应速度
 * 3、避免连接遗漏
 *
 * @author ZJH
 */
public class Test01TestDruidConnect {
    public static void main(String[] args) throws Exception {
        //连接池步骤
        //加载配置文件
        Properties properties = new Properties();
        //获取输入流
        InputStream resource = Test01TestDruidConnect.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(resource);
        //输出kv键值对
        properties.forEach((k,v) -> System.out.println(k + "=" + v));

        //创建连接池对象 DruidDataSourceFactory
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();

        connection.close();
    }

}
