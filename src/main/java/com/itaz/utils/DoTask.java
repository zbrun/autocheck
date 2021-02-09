package com.itaz.utils;

import com.google.common.annotations.VisibleForTesting;
import com.itaz.dao.BaseDao;
import com.itaz.pojo.User;
import com.itaz.utils.Task;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.TimerTask;


public class DoTask extends TimerTask {
    @Override
    public void run() {
        String sql = "select * from user where vip=?";
        Object[] para = {1};
        ArrayList<User> users = new ArrayList();
        try {
            ResultSet rs = BaseDao.searchDb(BaseDao.getConnection(), sql, para);
            while (rs.next()) {
                User user = new User();
                user.setName(rs.getString("name"));
                user.setPwd(rs.getString("password"));
                users.add(user);
            }
            for(User user:users){
                Task.doAuto(user.getName(),user.getPwd());
                user.setDotimes(user.getDotimes()+1);
                String sql1 ="update user set dotimes=? where name=?";
                Object[] params ={user.getDotimes(),user.getName()};
                Connection c=BaseDao.getConnection();
                BaseDao.updateDb(c, sql1, params);
                c.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}