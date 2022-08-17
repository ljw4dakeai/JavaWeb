package com.ljw4dakeai.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.ljw4dakeai.druid.Test01TestDruidConnect;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author ZJH
 */
public class DruidConnectUtil {
    public static Connection getConnection() throws Exception {
        Properties properties = new Properties();
        InputStream resource = DruidConnectUtil.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(resource);

        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        return dataSource.getConnection();
    }

    public static void breakConnection(Connection connection) throws SQLException {
        connection.close();
    }
}
