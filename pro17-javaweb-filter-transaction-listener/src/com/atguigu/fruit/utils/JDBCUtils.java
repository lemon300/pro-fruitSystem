package com.atguigu.fruit.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


public class JDBCUtils {
    /**
     * @Author: twj280
     * @Description: 获取连接
     * @date: 10:34 2022/4/8
     * @Param: []
     * @return java.sql.Connection
     **/
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pro = new Properties();
        pro.load(is);
        //加载驱动
        Class.forName(pro.getProperty("classDriver"));
        Connection conn = DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("user"), pro.getProperty("password"));
//        System.out.println(conn);
        return conn;

    }

    /**
     * @return void
     * @Author: twj280
     * @Description: 关闭资源
     * @date: 10:35 2022/4/8
     * @Param: [conn, ps, rs]
     **/
    public static void closeResource(Connection conn, Statement ps, ResultSet rs) {
        try {
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (ps != null)
                ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (rs != null)
                rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * @return void
     * @Author: twj280
     * @Description: 关闭资源
     * @date: 10:35 2022/4/8
     * @Param: [conn, ps]
     **/
    public static void closeResource(Connection conn, Statement ps) {
        try {
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (ps != null)
                ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return void
     * @Author: twj280
     * @Description: 关闭资源
     * @date: 10:35 2022/4/8
     * @Param: [conn, ps]
     **/
    public static void closeResource1(Connection conn) {
        try {
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeResource(Connection conn) {

    }

    public static Connection getThreadLocalConn() throws SQLException, IOException, ClassNotFoundException {
        Connection conn = threadLocal.get();
        if (conn == null) {
            conn = getConnection();
            threadLocal.set(conn);
        }
        return threadLocal.get();
    }

    public static void closeThreadLocalConn() throws SQLException {
        Connection conn = threadLocal.get();
        if (conn == null) {
            return;
        }
        if (!conn.isClosed()) {
            conn.close();
//        threadLocal.set(null);
            threadLocal.remove();
        }
    }
}
