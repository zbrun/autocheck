package com.itaz.service;

import com.itaz.dao.BaseDao;
import com.itaz.pojo.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginUser {
    public static User getUser(String name) throws SQLException, ClassNotFoundException {
        User user = new User();
        String sql="select * from user where name=?";
        Object[] params ={name};
        ResultSet rs = BaseDao.searchDb(BaseDao.getConnection(), sql, params);
        while(rs.next()) {
            user.setName(rs.getString("name"));
            user.setPwd(rs.getString("password"));
            user.setDotimes(rs.getInt("dotimes"));
            user.setIsvip(rs.getInt("vip"));
        }
        return user;
    }
}
