package com.wsh.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author WS Hu
 * @date 2020/12/17 10:15
 */
public class DbUtils {
//    private static String driveClassName = "com.mysql.jdbc.Driver";
//    private static String url = "jdbc:mysql://127.0.0.1:3306/test1";
//    private static String user = "root";
//    private static String password = "123456";

    /**
     * 链接数据库方法
     * @return connection
     */
//    public static Connection getConnection() {
//        Connection connection = null;
//        try {
//            //加载驱动
//            Class.forName(driveClassName);
//            //链接数据库
//            connection = DriverManager.getConnection(url, user, password);
//            System.out.println("success");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return connection;
//    }

    public static DataSource getConnection() {
        DataSource ds = null;
        try {
            // 创建一个配置文件对象
            Properties properties = new Properties();
            // 获取文件流  DruidTest.class.getResourceAsStream获取的是classess文件的路径  返回流
            InputStream is = DbUtils.class.getResourceAsStream("/druid.properties");
            // 配置文件对象加载配置文件
            properties.load(is);
            // 创建druid的连接
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
}
