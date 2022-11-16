<%-- 
    Document   : register
    Created on : Jun 6, 2022, 1:00:44 PM
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
    </head>
    <body>
        <% String alert = (String)request.getAttribute("alert");%>
        <div class="form">
            <h2>Đăng kí</h2>
            <form action="regis" method="post">
                <div class="login-info">
                    <div class="input">
                        <input type="text" name ="username" required>
                        <span></span>
                        <label>Tên đăng kí</label>
                    </div>
                    <div></div>
                    <div></div>
                </div>

                <div class="login-info">
                    <div class="input">
                        <input type="email" name="email" required>
                        <span></span>
                        <label>Email</label>
                    </div>
                    <div></div>
                    <div></div>
                </div>

                <div class="login-info">
                    <div class="input">
                        <input type="password" name="password" required>
                        <span></span>
                        <label>Mật khẩu</label>
                    </div>
                    <div></div>
                    <div></div>
                </div>
                <div class="login-info">
                    <div class="input">
                        <input type="password" name="repassword" required>
                        <span></span>
                        <label>Nhập lại mật khẩu</label>
                    </div>
                    <div></div>
                    <div></div>
                </div>
                <div class="enter">
                    <input type="submit" value="Đăng kí">
                </div>
            </form>
            <%if(alert!=null) {%>
            <div class = "alert" style="text-align: center; color: red; font-size: 18px; margin: 10px 0;"><%=alert%></div> 
            <%}%>
        </div>
        <div class="footer">
            Đã có tài khoản? <a href="login">Đăng nhập</a>
        </div>
    </body>
</html>
