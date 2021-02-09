<!DOCTYPE html>
<html lang="en">
<%@ page language="java" import="java.util.*" contentType="text/html; charset=GB2312" %>
<%@ page import="com.itaz.pojo.User" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/index.css">
    <title>zzu自动打卡系统</title>
</head>
<body>
    <div id="bigbox">
        <h3 class="head">欢迎使用zzu自动打卡系统</h3>
        <div id="welcome">
            <%User user = (User) session.getAttribute("user");%>
            <p>您的健康系统学号是</p>
            <p><%=user.getName()%></p>
            <p>您的健康系统密码是</p>
            <p><%=user.getPwd()%></p>
            <input type="button" value="修改">
        </div>
        <div id="show">
            <p>您<%
                String s;
                if(user.getIsvip()==1){
                    s="已";
                }else {
                    s="未";
                }
            %>
                <%=s%>开通自动打卡服务</p>
            <p>已为您打卡<%=user.getDotimes()
            %>天</p>
            <form method="get">
                <input type="submit" value="开通服务" class="left" formaction="/openservice">
                <input type="submit" value="关闭服务" class="right" formaction="/closeservice">
            </form>
        </div>
    </div>
</body>
</html>