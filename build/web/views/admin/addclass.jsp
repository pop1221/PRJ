<%-- 
    Document   : addclass
    Created on : Jul 4, 2022, 11:02:46 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="./CSS/search1.css">
    </head>
    <body>
        <a class="home" href="home">Trở lại</a>
        <div class="head">
            <h2>Thêm lớp mới</h2>
        </div>
        <% String alert = (String)request.getAttribute("alert");%>
        <form action="addclass" method="post">
            <input type="text" name="classid" placeholder="nhập tên lớp" required="">
            <input type="text" name="totalstudent" placeholder="nhập số học sinh" required="">
            <input type="submit" value="xác nhận">
        </form>
        <%if(alert!=null) {%>
        <div class = "alert" style="text-align: center; color: red; font-size: 18px; margin: 10px 0;"><%=alert%></div> 
        <%}%>
    </body>
</html>
