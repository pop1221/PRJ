<%-- 
    Document   : login
    Created on : Jun 2, 2022, 8:22:45 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="./CSS/login.css">
        <% String alert = (String)request.getAttribute("alert");%>
    </head>
    <body>
        <div class="form">
            <h2>Đăng nhập</h2>
            <form action="login" method="post">
                <div class="login-info">
                    <div class="input">
                        <input type="text" name="username" value="${username}" required>
                        <span></span>
                        <label>Tên đăng nhập</label>
                    </div>
                    <div></div>
                    <div></div>
                </div>

                <div class="login-info">
                    <div class="input">
                        <input type="password" name="password" value="${password}" required>
                        <span></span>
                        <label>Mật khẩu</label>
                    </div>
                    <div></div>
                    <div></div>
                </div>
                <a href="forget" class="forget-password">Quên mật khẩu</a>
                <div class="enter">
                    <div class="remember">
                        <input type="checkbox" name="check">
                        <p>Nhớ mật khẩu</p>
                    </div>
                    <input type="submit" value="Đăng nhập">
                </div>
            </form>
            <%if(alert!=null) {%>
            <div class = "alert" style="text-align: center; color: red; font-size: 18px; margin: 10px 0;"><%=alert%></div> 
            <%}%>
        </div>
        <div class="footer">
            Chưa có tài khoản? <a href="regis">Đăng kí</a>
        </div>
    </body>
</html>
