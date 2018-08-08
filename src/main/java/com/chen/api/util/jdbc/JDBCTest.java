package com.chen.api.util.jdbc;

import java.sql.*;

/**
 * 基本的jdbc查询数据库
 *
 * @author :  chen weijie
 * @Date: 2018-08-06 3:15 PM
 */
public class JDBCTest {


    public static void main(String[] args) {
        testQuery();

    }


    /**
     * 查询操作
     */
    public static void testQuery() {

        Connection connection = getConnection();

        try {
            String querySql = "select * from ent_user_cache_multi_provider_rule ";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(querySql);
            while (rs.next()) {
                System.out.println("rs:" + rs.getString("table_name"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        releaseConnection(connection);
    }

    /**
     * 测试更新操作
     */
    public static void testUpdate() {
        Connection connection = getConnection();

        String Sql = "update  ent_user_cache_multi_provider_rule set salary=8000 where employee_id=100005";
        try {
            Statement stmt1 = connection.createStatement();//或者用PreparedStatement方法
            stmt1.executeUpdate(Sql);//执行sql语句
            if (stmt1 != null) {
                try {
                    stmt1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试事务
     */
    public static void testTraction() {

        /**
         * JDBC处理事务通过关闭连接的自动提交实现的：

         Connection.setAutoCommit(false);
         提交事务：
         Connection.commit();
         回滚事务
         回滚部分：
         Connection.rollback(Savepoint);
         全部回滚：
         Connection.rollback();

         */
        Connection connection = getConnection();

        Statement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();

            String sql = "update employees set salary=500 where employee_id=100001";
            statement.executeQuery(sql);
            sql = "update employees set salary=100 where employee_id=100002";
            statement.executeQuery(sql);
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        releaseConnection(connection);
    }

    /**
     * 测试事务回滚
     */
    public static void testTractionRollBack() {

        Savepoint savepoint = null;
        Connection connection = getConnection();

        Statement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();

            String sql = "update employees set salary=500 where employee_id=100001";
            savepoint = connection.setSavepoint("savepoint1");

            statement.executeQuery(sql);
            sql = "update employees set salary=100 where employee_id=100002";
            statement.executeQuery(sql);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (savepoint == null) {
                    // SQLException occurred in saving into Employee or Address
                    // tables
                    connection.rollback();
                    System.out.println("JDBC Transaction rolled back successfully");
                } else {
                    // exception occurred in inserting into Logs table
                    // we can ignore it by rollback to the savepoint
                    connection.rollback(savepoint);
                    // lets commit now
                    connection.commit();
                }
            } catch (SQLException e1) {
                System.out.println("SQLException in rollback" + e.getMessage());
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        releaseConnection(connection);
    }


    /**
     * 获取数据库连接
     *
     * @return
     */
    public static Connection getConnection() {

        Connection connection = null;
        //1.定义驱动程序名为driver内容为com.mysql.jdbc.Driver
        String driver = "com.mysql.jdbc.Driver";
        //2.定义url；jdbc是协议；mysql是子协议：表示数据库系统管理名称；localhost：3306是你数据库来源的地址和目标端口；test是我本人建的表位置所在处，你以你的为标准。
        String url = "jdbc:mysql://172.16.117.226:3306/ent_portal?useUnicode=true&characterEncoding=UTF8";
        String user = "ent_all";
        String password = "ent";

        try {
            Class.forName(driver);
            //获取数据库连接,使用java.sql里面的DriverManager的getConnectin(String url , String username ,String password )来完成
            connection = DriverManager.getConnection(url, user, password);

            //8.构造一个statement对象来执行sql语句：主要有Statement，PreparedStatement，CallableStatement三种实例来实现
            //三种实现方法分别为：
            // Statement stmt = con.createStatement() ;
            //PreparedStatement pstmt = conn.prepareStatement(sql) ;
            // CallableStatement cstmt =  conn.prepareCall("{CALL demoSp(? , ?)}") ;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }


    /**
     * 释放数据库连接
     *
     * @param conn
     */
    public static void releaseConnection(Connection conn) {
        try {
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
