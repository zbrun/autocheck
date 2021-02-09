package com.itaz.servlet;

import com.itaz.pojo.User;
import com.itaz.service.ChangeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class OpenService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         User user = (User) req.getSession().getAttribute("user");
        try {
            int i = ChangeService.openService(user.getName());
            user.setIsvip(1);
            req.getSession().setAttribute("user",user);
            resp.sendRedirect("/main.jsp");
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
