package com.itaz.service;

import com.itaz.dao.BaseDao;

import java.sql.SQLException;

public class AddUser {
    public static int addUser(String name,String pwd) throws SQLException, ClassNotFoundException {
        String sql = "insert into `user` (`name`,`password`) VALUE (?,?)";
        Object[] params={name,pwd};
        int i = BaseDao.updateDb(BaseDao.getConnection(), sql, params);
        return i;
    }
}
