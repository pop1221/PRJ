<%-- 
    Document   : seeclass
    Created on : Jul 5, 2022, 9:38:47 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <% String alert = (String)request.getAttribute("alert");%>
        <div id="contain">
            <div class="head">
                <h2>Tìm lớp học</h2>
            </div>
            <div class="body">
                <div class="search">
                    <form action="searchclass" method="post">
                        <input type="text" name="classid" placeholder="Mã lớp học">
                        <input type="text" name="totalstudent" placeholder="Tổng số học sinh">
                        <input type="submit" value="Tìm kiếm">
                    </form>
                    <table border="1">
                        <tr>
                            <td>Mã lớp</td>
                            <td>Tổng số học sinh</td>
                        </tr>
                        <c:forEach items="${list}" var="x">
                            <tr>
                                <td>${x.getClassid()}</td>
                                <td>${x.getTotalstudent()}</td>
                            </tr>
                        </c:forEach>
                    </table>
                    <%if(alert!=null) {%>
                    <div class = "alert" style="text-align: center; color: red; font-size: 18px; margin: 10px 0;"><%=alert%></div> 
                    <%}%>
                    <div class="paging">
                        <c:if test="${startpage>1}">
                            <a href="searchclass?index=1">Home</a>
                            <a href="searchclass?index=${startpage+1}">Pre</a>
                        </c:if>
                        <c:forEach begin="${startpage}" end="${endpage}" var="x">
                            <a href="searchclass?index=${x}">${x}</a>
                        </c:forEach>
                        <c:if test="${endpage<nummberpage}">
                            <a href="searchclass?index=${endpage-1}">Next</a>
                            <a href="searchclass?index=${nummberpage}">End</a>
                        </c:if>
                    </div>
                    <div class="footer">
                        <a href="searchclass?search=1">Xem tất cả các lớp</a>
                        <a href="searchsubject?search=1">Xem tất cả các môn học</a>
                        <a href="search?search=1">Xem tất cả các lịch học</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
