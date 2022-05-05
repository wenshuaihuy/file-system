package com.wsh.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author huwenshuai
 * @date 2022/5/5 10:31
 */
public class ConnTest {

  /*  driverClassName=com.mysql.jdbc.Driver
      url=jdbc:mysql://127.0.0.1:3306/filesystem
      username=root
      password=123456*/

    public static String sqlConn() {
        String driverName = null;
        String url = null;

        //mysql
        driverName = "com.mysql.jdbc.Driver";
        //"?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8"
        url = "jdbc:mysql://127.0.0.1:3306/filesystem";

        try {
            Class.forName(driverName);
            Connection connection = DriverManager.getConnection(url, "root", "123456");
            connection.close();
        } catch (Exception e) {
            return "测试失败";
        }
        return "测试成功";
    }

    public static void main(String[] args) {
        ConnTest.sqlConn();

    }


}
