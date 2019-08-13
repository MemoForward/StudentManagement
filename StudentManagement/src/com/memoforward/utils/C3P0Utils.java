package com.memoforward.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class C3P0Utils {
    private C3P0Utils() {
    }

    //读取c3p0-config.xml默认配置文件
    private static ComboPooledDataSource ds = new ComboPooledDataSource();
    private static ThreadLocal<Connection> tl = new ThreadLocal<>();

    public static DataSource getDataSource() {
        return ds;
    }

    public static Connection getConnection() {
        Connection con = tl.get();
        if (con == null) {
            try {
                con = ds.getConnection();
                tl.set(con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return con;
    }


    public static void closeConn(){
        Connection conn = null;
        try {
            conn=getConnection();
            conn.close();
            tl.remove();
//            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // 释放资源
    public static void closeResource(Statement st, ResultSet rs) {
        closeResultSet(rs);
        closeStatement(st);
    }

    // 释放资源
    public static void closeResource(Connection conn, Statement st, ResultSet rs) {
        closeResource(st, rs);
        closeConn(conn);
    }

    // 释放 connection
    public static void closeConn(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                //和线程解绑
                tl.remove();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }

    // 释放 statement
    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            st = null;
        }
    }

    // 释放结果集
    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
    }


    //开启事务
    public static void startTransaction() throws SQLException{
        getConnection().setAutoCommit(false);
    }

    /**
     * 事务提交且释放连接
     */
    public static void commitAndClose(){
        Connection conn = null;
        try {
            conn=getConnection();
            //事务提交
            conn.commit();
            //关闭资源
            conn.close();
            //解除版定
            tl.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 事务回滚且释放资源
     */
    public static void rollbackAndClose(){
        Connection conn = null;
        try {
            conn=getConnection();
            //事务回滚
            conn.rollback();
            //关闭资源
            conn.close();
            //解除版定
            tl.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
