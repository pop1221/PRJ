<%-- 
    Document   : forgetpassword
    Created on : Jun 9, 2022, 12:53:49 PM
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
            <h2>Thay đổi email</h2>
            <form action="changeEmail" method="post">
                <div class="login-info">
                    <div class="input">
                        <input type="email" name="email" required>
                        <span></span>
                        <label>Email</label>
                    </div>
                    <div></div>
                    <div></div>
                </div>
                <div class="enter">
                    <input type="submit" value="Thay đổi">
                </div>
                <%if(alert!=null) {%>
                <div class = "alert" style="text-align: center; color: red; font-size: 18px; margin: 10px 0;"><%=alert%></div> 
                <%}%>
            </form>
        </div>
        <div class="footer">
            Chưa có tài khoản? <a href="regis">Đăng kí</a>
        </div>
    </body>
</html>
