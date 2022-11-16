<%-- 
    Document   : homepage
    Created on : Jun 2, 2022, 8:57:29 PM
    Author     : Admin
--%>

<%@page import =  "model.account" %> >
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="./CSS/home.css">
        <link rel="stylesheet" href="./icon/themify-icons/themify-icons.css">
        <% String alert = (String)request.getAttribute("alert");%>
        <% account account = (account)request.getAttribute("accinfo");%>
    </head>
    <body>
        <div id="container">
            <div id="head">
                <div class="logo">Đây là logo</div>
                <ul class="page-list">
                    <li><a href="">About us</a></li>
                    <li><a href="">Feature</a></li>
                    <li><a href="">Contact</a></li>
                </ul>


                <%if(alert == null) {%>
                <div class="login-btn1" onclick="clickbtn()">
                    <i class="ti-user"></i>
                    <ul class="user-menu">
                        <li><a onclick="openinfotable()">Information</a></li>
                        <li><a href="logout">Log Out</a></li>
                    </ul>
                </div>
                <%} else {%>
                <div class="login-btn">
                    <a href="login">Login</a>
                </div>
                <%}%>

            </div>
            <div class="infomation">
                <div class="sub-info">
                    <div class="close-btn"><i class="ti-close" onclick="closeinfotable()"></i></div>
                    <table>
                        <tr>
                            <td>Tên tài khoản: </td>
                            <%if(account!=null) {%>
                            <td><%=account.getUssername()%></td>
                            <%}%>

                        </tr>
                        <tr>
                            <td>Email: </td>
                            <%if(account!=null) {%>
                            <td><%=account.getEmail()%></td>
                            <%}%>
                            <td><a href="changeEmail">Chỉnh sửa</a></td>
                        </tr>
                        <tr>
                            <td>Mật khẩu: </td>
                            <%if(account!=null) {%>
                            <td><%=account.getPassword()%></td>
                            <%}%>
                            <td><a href="changePassword">Chỉnh sửa</a></td>
                        </tr>
                    </table>
                </div>
            </div>
            <div id="main">
                <div class="part1">
                    <span class="text1">Welcome to FPTU</span>
                    <span class="text2">Đây là miêu tả về trang web này</span>
                </div>

                <div class="part2">
                    <div class="card">
                        <div class="img"><i class="ti-search"></i></div>
                        <div class="info">
                            <h1>Tìm lớp</h1>
                            <p>Đây là miêu tả về phần tìm lớp</p>
                            <a class="btn" href="search">Tìm kiếm</a>
                        </div>
                    </div>

                    <div class="card">
                        <div class="img"><i class="ti-comments"></i></div>
                        <div class="info">
                            <h1>Trao đổi</h1>
                            <p>Đây là miêu tả về phần trao đổi</p>
                            <a class="btn" href="post">Trao đổi</a>
                        </div>
                    </div>
                </div>
            </div>
            <div id="footer">
                <div class="button">
                    <div class="icon">
                        <i class="fab ti-facebook"></i>
                    </div>
                    <span>Facebook</span>
                </div>

                <div class="button">
                    <div class="icon">
                        <i class="fab ti-instagram"></i>
                    </div>
                    <span>Instagram</span>
                </div>

                <div class="button">
                    <div class="icon">
                        <i class="fab ti-twitter-alt"></i>
                    </div>
                    <span>Twitter</span>
                </div>
            </div>
        </div>    
        <script src="./js/code.js"></script>
    </body>
</html>
