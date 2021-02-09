package com.itaz.servlet;

import com.itaz.pojo.User;
import com.itaz.service.LoginUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("userCode");
        String pwd = req.getParameter("userPassword");
        User user = null;
        try {
            user = LoginUser.getUser(name);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        if(user != null &&user.getPwd().equals(pwd)){
            req.getSession().setAttribute("user",user);
            resp.sendRedirect("/main.jsp");
        }else{
            resp.sendRedirect("/error.jsp");
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
