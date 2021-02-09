package com.itaz.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


public class BaseDao {
    private static final String driver;
    private static final String name;
    private static final String pwd;
    private static final String url;

    static {
        Properties properties = new Properties();
        InputStream is = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver=properties.getProperty("driver");
        name = properties.getProperty("name");
        pwd = properties.getProperty("pwd");
        url = properties.getProperty("url");
    }
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        return DriverManager.getConnection(url, name, pwd);
    }
    public static ResultSet searchDb(Connection connection,String sql,Object[] params) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for(int i = 0; i<params.length; i++){
            preparedStatement.setObject(i+1,params[i]);
        }
        return preparedStatement.executeQuery();
    }
    public static int updateDb(Connection connection,String sql,Object[] params) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for(int i = 0; i<params.length; i++){
            preparedStatement.setObject(i+1,params[i]);
        }
        return preparedStatement.executeUpdate();
    }
}
