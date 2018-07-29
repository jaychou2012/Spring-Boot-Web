package com.tandong.testjavaweb.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    // mysql 连接参数
    private static String jdbcDriver = null;
    private static String url = null;
    private static String user = null;
    private static String password = null;
    private static boolean isCfg = false; // 记录是否读取过jdbc.properties文件配置 、避免多次读取
    // 线程安全的懒汉模式单例
    private static JDBCUtils jdbcUtils = null;

    public static synchronized JDBCUtils getInstance() {
        if (jdbcUtils == null) {
            if (!isCfg) {
                initJDBCParameter();
            }
            return jdbcUtils = new JDBCUtils();
        }
        return jdbcUtils;
    }

    /**
     * 读取属性文件中的mysql配置
     */
    private static void initJDBCParameter() {
        Properties properties = new Properties();
        InputStream in = JDBCUtils.class.getResourceAsStream("/application.properties");//加载 application.properties资源文件，如果该文件在包内则加包名
        try {
            properties.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (jdbcDriver == null || url == null || user == null || password == null) {
            jdbcDriver = properties.getProperty("spring.datasource.driver-class-name");
            url = properties.getProperty("spring.datasource.url");
            user = properties.getProperty("spring.datasource.username");
            password = properties.getProperty("spring.datasource.password");
            isCfg = true;
        }
    }

    /**
     * 获取数据连接
     *
     * @return
     * @throws Exception
     */
    public Connection getConnection() throws Exception {
        Class.forName(jdbcDriver);
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 释放数据库链接资源
     *
     * @param con  // 数据库连接对象
     * @param stmt // 执行sql操作对象
     * @param rs   // 查询结果集对象
     */
    public void closeConnection(Connection con, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
