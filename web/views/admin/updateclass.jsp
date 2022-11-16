<%-- 
    Document   : updateclass
    Created on : Jul 5, 2022, 6:15:46 PM
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
        <form action="updateclass" method="post">
            <input type="text" name="classid" value="${o.getClassid()}" readonly="" placeholder="nhập tên lớp học">
            <input type="text" name="totalstudent" value="${o.getTotalstudent()}" required="" placeholder="nhập số học sinh">
            <input type="submit" value="xác nhận">
        </form>
    </body>
</html>
