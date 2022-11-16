<%-- 
    Document   : code
    Created on : Jun 27, 2022, 4:56:35 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./CSS/login.css">
    </head>
    <body>
        <% String alert = (String)request.getAttribute("alert");%>
        <div class="form">
            <h2>Nhập mã xác minh</h2>
            <form action="code" method="post">
                <div class="login-info">
                    <div class="input">
                        <input type="text" name="code" required>
                        <span></span>
                        <label>Mã xác minh</label>
                    </div>
                    <div></div>
                    <div></div>
                </div>
                <div class="enter">
                    <input type="submit" value="Lấy mã">
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
