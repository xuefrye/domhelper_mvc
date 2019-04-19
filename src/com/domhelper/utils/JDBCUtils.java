package com.domhelper.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Author: xuefrye
 * @Date: 2019/4/17 15:20
 * @Version: 1.0
 * @File: JDBCUtils
 * @Description: JDBC工具类 使用druid连接池
 */
public class JDBCUtils {

    private static DataSource ds;

    public JDBCUtils() {
    }

    static {
        try {
            //加载配置文件,使用ClassLoader加载配置文件，获取字节输入流
            Properties pro = new Properties();

            //InputStream is = new FileInputStream("localhost.properties");
            InputStream is = new FileInputStream("1758541396.cn.properties");
            System.out.println(is);
            pro.load(is);

            //2.初始化连接池对象
            ds = DruidDataSourceFactory.createDataSource(pro);

            System.out.println("数据连接池初始化完毕");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接池对象
     */
    public static DataSource getDataSource() {
        return ds;
    }


    /**
     * 获取连接Connection对象
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 关闭资源
     *
     * @param statement
     * @param connection
     */
    public static void close(Statement statement, Connection connection) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
