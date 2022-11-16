<%-- 
    Document   : usersinfo
    Created on : Jul 9, 2022, 6:04:32 PM
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
                <h2>Thông tin người dùng</h2>
            </div>
            <div class="body">
                <div class="usersinfo">
                    <form action="usersinfo" method="post">
                        <input type="text" name="username" placeholder="Tên tài khoản">
                        <input type="text" name="email" placeholder="Email">
                        <input type="submit" value="Tìm kiếm">
                    </form>
                    <table border="1">
                        <tr>
                            <td>Tên tài khoản</td>
                            <td>Email</td>
                        </tr>
                        <c:forEach items="${list}" var="x">
                            <tr>
                                <td>${x.getUssername()}</td>
                                <td>${x.getEmail()}</td>
                                <td>
                                    <c:if test="${x.getDeci().trim()=='1'}">
                                        <a href="setadmin?username=${x.getUssername().trim()}&deci=${x.getDeci().trim()}">Bỏ admin</a>
                                    </c:if>
                                    <c:if test="${x.getDeci().trim()!='1'}">
                                        <a href="setadmin?username=${x.getUssername().trim()}&deci=${x.getDeci().trim()}">Thêm admin</a>
                                    </c:if>
                                    <a href="#" onclick="showmess('${x.getUssername().trim()}')">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>   
                    <%if(alert!=null) {%>
                    <div class = "alert" style="text-align: center; color: red; font-size: 18px; margin: 10px 0;"><%=alert%></div> 
                    <%}%>
                    <div class="paging">
                        <c:if test="${startpage>1}">
                            <a href="usersinfo?index=1">Home</a>
                            <a href="usersinfo?index=${startpage+1}">Pre</a>
                        </c:if>
                        <c:forEach begin="${startpage}" end="${endpage}" var="x">
                            <a href="usersinfo?index=${x}">${x}</a>
                        </c:forEach>
                        <c:if test="${endpage<nummberpage}">
                            <a href="usersinfo?index=${endpage-1}">Next</a>
                            <a href="usersinfo?index=${nummberpage}">End</a>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
        <script>
            function showmess(username) {
                var option = confirm('Xác nhận xóa ?');
                if (option == true) {
                    window.location.href = 'deleteusers?username=' + username;
                }
            }
        </script>
    </body>
</html>
