<%-- 
    Document   : search
    Created on : Jul 4, 2022, 3:15:15 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <h2>Tìm lịch học</h2>
            </div>
            <div class="body">
                <div class="search">
                    <form action="search" method="post">
                        <input type="text" name="subjectid" placeholder="Mã môn học">
                        <input type="text" name="classid" placeholder="Mã lớp học">
                        <select name="semester" id="">
                            <option value="">Chọn kì học</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                        </select>
                        <select name="slotbooked">
                            <option value="">Chọn slot học</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                        </select>
                        <input type="submit" value="Tìm kiếm">
                    </form>
                    <table border="1">
                        <tr>
                            <td>Mã Môn</td>
                            <td>Tên môn</td>
                            <td>Chuyên ngành kì</td>
                            <td>Mã lớp</td>
                            <td>Tổng số học sinh</td>
                            <td>Kì học</td>
                            <td>Phòng học</td>
                            <td>Slot học</td>
                            <td>Ngày học</td>
                            <td>Số slot học</td>
                        </tr>
                        <c:forEach items="${list}" var="x">
                            <tr>
                                <td>${x.getSubjectid()}</td>
                                <td>${x.getSubjectname()}</td>
                                <td>${x.getKihoc()}</td>
                                <td>${x.getClassid()}</td>
                                <td>${x.getTotalstudent()}</td>
                                <td>${x.getSemester()}</td>
                                <td>${x.getRoomid()}</td>
                                <td>${x.getSlotbooked()}</td>
                                <td>${x.getDay()}</td>
                                <td>${x.getTotalslot()}</td>
                            </tr>
                        </c:forEach>
                    </table>    
                    <%if(alert!=null) {%>
                    <div class = "alert" style="text-align: center; color: red; font-size: 18px; margin: 10px 0;"><%=alert%></div> 
                    <%}%>
                    <div class="paging">
                        <c:if test="${startpage>1}">
                            <a href="search?index=1">Home</a>
                            <a href="search?index=${startpage+1}">Pre</a>
                        </c:if>
                        <c:forEach begin="${startpage}" end="${endpage}" var="x">
                            <a href="search?index=${x}">${x}</a>
                        </c:forEach>
                        <c:if test="${endpage<nummberpage}">
                            <a href="search?index=${endpage-1}">Next</a>
                            <a href="search?index=${nummberpage}">End</a>
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
