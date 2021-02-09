package com.itaz.filter;

import com.itaz.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainSent implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request =(HttpServletRequest)req;
        Object user = request.getSession().getAttribute("user");
        if(user!=null){
           filterChain.doFilter(req,resp);
        }else{
            ((HttpServletResponse)resp).sendRedirect("/error.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
