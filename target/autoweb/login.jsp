<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/style.css">
    <title>登录界面</title>
</head>
<body>
<div id="bigbox">
    <h1>自动打卡登录</h1>
    <h2>登录前请先进行注册</h2>
    <div class="inputBox">
        <form action="/login" method="POST">
            <div class="inputtext">
                <input type="text" name="userCode" placeholder="学号">
            </div>
            <div class="inputtext">
                <input type="password" name="userPassword" placeholder="打卡系统密码">
            </div>
            <input type="submit" id="loginin" value="登录" name="login">
            <input type="submit" id="loginup" value="注册" name="loginup" formaction="/register">
        </form>
    </div>
</div>
</body>
</html>