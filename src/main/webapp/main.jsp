<!DOCTYPE html>
<html lang="en">
<%@ page language="java" import="java.util.*" contentType="text/html; charset=GB2312" %>
<%@ page import="com.itaz.pojo.User" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/index.css">
    <title>zzu�Զ���ϵͳ</title>
</head>
<body>
    <div id="bigbox">
        <h3 class="head">��ӭʹ��zzu�Զ���ϵͳ</h3>
        <div id="welcome">
            <%User user = (User) session.getAttribute("user");%>
            <p>���Ľ���ϵͳѧ����</p>
            <p><%=user.getName()%></p>
            <p>���Ľ���ϵͳ������</p>
            <p><%=user.getPwd()%></p>
            <input type="button" value="�޸�">
        </div>
        <div id="show">
            <p>��<%
                String s;
                if(user.getIsvip()==1){
                    s="��";
                }else {
                    s="δ";
                }
            %>
                <%=s%>��ͨ�Զ��򿨷���</p>
            <p>��Ϊ����<%=user.getDotimes()
            %>��</p>
            <form method="get">
                <input type="submit" value="��ͨ����" class="left" formaction="/openservice">
                <input type="submit" value="�رշ���" class="right" formaction="/closeservice">
            </form>
        </div>
    </div>
</body>
</html>