<%-- 
    Document   : addschedule
    Created on : Jul 5, 2022, 12:22:01 AM
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
            <h2>Thêm lịch học mới</h2>
        </div>
        <% String alert = (String)request.getAttribute("alert");%>
        <form action="addschedule" method="post">
            <input type="text" name="subjectid" placeholder="nhập mã môn học" required="">
            <input type="text" name="classid" placeholder="nhập tên lớp học" required="">
            <input type="text" name="semester" placeholder="nhập kì học" required="">
            <input type="text" name="roomid" placeholder="nhập phòng học" required="">
            <input type="text" name="slotbooked" placeholder="nhập slot học" required="">
            <input type="text" name="day" placeholder="nhập ngày học" required="">
            <input type="submit" value="xác nhận">
        </form>
        <%if(alert!=null) {%>
        <div class = "alert" style="text-align: center; color: red; font-size: 18px; margin: 10px 0;"><%=alert%></div> 
        <%}%>
    </body>
</html>
