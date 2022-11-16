<%-- 
    Document   : update
    Created on : Jul 5, 2022, 10:02:32 AM
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
        <link rel="stylesheet" href="./CSS/search.css">
    </head>
    <body>
        <form action="update" method="post">
            <input type="text" name="subjectid" value="${o.getSubjectid()}" readonly="" placeholder="nhập mã môn học">
            <input type="text" name="classname" value="${o.getSubjectname()}" readonly="" placeholder="nhập tên môn học">
            <input type="text" name="classname" value="${o.getKihoc()}" readonly="" placeholder="nhập chuyên ngành học kì">
            <input type="text" name="classid" value="${o.getClassid()}" readonly="" placeholder="nhập tên lớp học">
            <input type="text" name="totalstudent" value="${o.getTotalstudent()}" readonly="" placeholder="nhập số học sinh">
            <input type="text" name="semester" value="${o.getSemester()}" required="" placeholder="nhập kì học">
            <input type="text" name="roomid" value="${ o.getRoomid()}" required="" placeholder="nhập phòng học">
            <input type="text" name="slotbooked" value="${o.getSlotbooked()}" required="" placeholder="nhập slot học">
            <input type="text" name="day" value="${o.getDay()}" required="" placeholder="nhập ngày học">
            <input type="submit" value="xác nhận">
        </form>
    </body>
</html>
