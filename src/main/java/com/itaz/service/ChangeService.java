package com.itaz.service;

import com.itaz.dao.BaseDao;

import java.sql.SQLException;

public class ChangeService {
    public static int openService(String name) throws SQLException, ClassNotFoundException {
        Object[] params ={name};
        String sql = "update `user` set `vip` = 1 where name=?";
        return BaseDao.updateDb(BaseDao.getConnection(), sql, params);
    }
    public static int closeService(String name) throws SQLException, ClassNotFoundException {
        Object[] params ={name};
        String sql = "update `user` set `vip`=0 where name=?";
        return BaseDao.updateDb(BaseDao.getConnection(), sql, params);
    }
}
