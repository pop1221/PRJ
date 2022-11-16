<%-- 
    Document   : updatesubject
    Created on : Jul 5, 2022, 9:06:55 PM
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
        <form action="updatesubject" method="post">
            <input type="text" name="subjectid" value="${o.getSubjectid()}" readonly="" placeholder="nhập mã môn học">
            <input type="text" name="subjectname" value="${o.getSubjectname()}" required="" placeholder="nhập tên môn học">
            <input type="text" name="totalslot" value="${o.getTotalslot()}" required="" placeholder="nhập số slot học">
            <input type="text" name="kihoc" value="${o.getKihoc()}" required="" placeholder="nhập chuyên ngành kì">
            <input type="submit" value="xác nhận">
        </form>
    </body>
</html>
