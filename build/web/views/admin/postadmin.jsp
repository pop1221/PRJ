<%-- 
    Document   : postadmin
    Created on : Jul 7, 2022, 11:13:57 PM
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
        <title>JSP Page</title>
        <link rel="stylesheet" href="./CSS/post.css">
    </head>
    <body>
        <a class="home" href="home">Trở lại</a>
        <h1>Cộng đồng</h1>
        <div class="postbtn">
            <a href="#" onclick="abc()">Đăng bài</a>
        </div>
        <div class="newpost">
            <form action="post" method="post" novalidate="">
                <p class="close" onclick="abc()">Close</p>
                <h2>Đăng bài</h2>
                <div>
                    <label for="title">Tiêu đề</label>
                    <input id="title" required="" type="text" name="title" placeholder="Tiêu đề bài viết">
                </div>
                <div>
                    <label for="content">Nội dung</label>
                    <textarea id="content" required="" name="content" placeholder="Nội dung"></textarea>
                </div>
                <input type="submit">
            </form>
        </div>
        <c:forEach begin="0" end="${list.size()-1}" var="x">
            <div class="post">
                <c:if test="${list.get(x).getPin()==1}">
                    <p id="pin${list.get(x).getSTT()}" class="ghim">Ghim</p>
                </c:if>
                <c:if test="${list.get(x).getPin()==0}">
                    <p id="pin${list.get(x).getSTT()}" style="display: none" class="ghim">Ghim</p>
                </c:if>
                <div class="edit">
                    <a href="#">edit</a>
                    <ul class="sub">
                        <c:if test="${list.get(x).isCheckacc()==true}">
                            <li><a href="#" onclick="edit('${x}')">Chỉnh sửa</a></li>
                            </c:if>
                            <c:if test="${list.get(x).getPin()==1}">
                            <li><a id="ghim${list.get(x).getSTT()}" onclick="ghim('${list.get(x).getSTT()}', '${list.get(x).getPin()}')" href=#>Bỏ ghim</a></li>
                            </c:if>
                            <c:if test="${list.get(x).getPin()!=1}">
                            <li><a id="ghim${list.get(x).getSTT()}" onclick="ghim('${list.get(x).getSTT()}', '${list.get(x).getPin()}')" href=#>Ghim</a></li>
                            </c:if>
                        <li><a href="#" onclick="showmess('${list.get(x).getSTT()}')">Xóa</a></li>
                    </ul>
                </div>
                <h5>${list.get(x).getUsername()}</h5>
                <h3>${list.get(x).getTitle()}</h3>
                <p>${list.get(x).getContent()}</p>
                <div class="comment">
                    <a href="#" onclick="comment('${x}')">Đọc comment</a>
                    <a href="#" onclick="postcomment('${x}')">Viết comment</a>
                </div>
                <div class="texteditcontainer">
                    <div class="textedit">
                        <p class="close" onclick="edit('${x}')">close</p>
                        <form action="edit" method="post">
                            <input type="text" hidden="" name="STT" value="${list.get(x).getSTT()}">
                            <input type="text" name="edittitle" value="${list.get(x).getTitle()}">
                            <textarea type="text" name="editcontent">${list.get(x).getContent()}</textarea>
                            <input type="submit" value="submit">
                        </form>
                    </div>
                </div>
                <div class="commentcontainer">
                    <div class="textedit">
                        <p class="close" onclick="comment('${x}')">close</p>
                        <c:forEach items="${commentlist}" var="y">
                            <c:if test="${y.getSTT()==list.get(x).getSTT()}">
                                <div class="commenttext">
                                    <h5>${y.getUsername()}</h5>
                                    <p>${y.getContent()}</p>
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
                <div class="postcmt">
                    <p class="closepost" onclick="postcomment('${x}')">close</p>
                    <form action="postcmt" method="post">
                        <input type="text" hidden="" name="STT" value="${list.get(x).getSTT()}">
                        <input type="text" hidden="" name="username" value="${username}">
                        <input type="text" name="comment" placeholder="Comment">
                        <input type="submit" value="send">
                    </form>
                </div>
            </div>
        </c:forEach>
        <div class="paging">
            <c:if test="${startpage>1}">
                <a href="post?index=1">Home</a>
                <a href="post?index=${startpage+1}">Pre</a>
            </c:if>
            <c:forEach begin="${startpage}" end="${endpage}" var="x">
                <a href="post?index=${x}">${x}</a>
            </c:forEach>
            <c:if test="${endpage<nummberpage}">
                <a href="post?index=${endpage-1}">Next</a>
                <a href="post?index=${nummberpage}">End</a>
            </c:if>
        </div>
        <script src="https://cdn.ckeditor.com/ckeditor5/34.2.0/classic/ckeditor.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script>
                        ClassicEditor
                                .create(document.querySelector('#content'), {
                                    // toolbar: [ 'heading', '|', 'bold', 'italic', 'link' ]
                                })
                                .then(editor => {
                                    window.editor = editor;
                                })
                                .catch(err => {
                                    console.error(err.stack);
                                });
                        var e = 1;
                        function abc() {
                            e++;
                            var b = document.querySelector(".newpost");
                            if (e % 2 === 0)
                                b.style.display = "flex";
                            else
                                b.style.display = "none";
                        }
                        var a = 1;
                        function edit(i) {
                            a++;
                            var b = document.querySelectorAll(".texteditcontainer");
                            if (a % 2 === 0)
                                b[i].style.display = "flex";
                            else
                                b[i].style.display = "none";
                        }

                        var c = 1;
                        function comment(i) {
                            c++;
                            var b = document.querySelectorAll(".commentcontainer");
                            if (c % 2 === 0)
                                b[i].style.display = "block";
                            else
                                b[i].style.display = "none";
                        }

                        var d = 1;
                        function postcomment(i) {
                            d++;
                            var b = document.querySelectorAll(".postcmt");
                            if (d % 2 === 0)
                                b[i].style.display = "block";
                            else
                                b[i].style.display = "none";
                        }

                        function showmess(STT) {
                            var option = confirm('Xác nhận xóa ?');
                            if (option === true) {
                                window.location.href = 'deleteforum?STT=' + STT;
                            }
                        }

                        function ghim(STT, pin1) {
                            var STT = STT;
                            var pin = pin1;
                            $.ajax({
                                url: "/prj-project-final/ghim",
                                type: "get",
                                data: {
                                    STT: STT,
                                    pin: pin
                                },
                                success: function (data) {
                                    var row = document.getElementById('ghim' + STT);
                                    var ele = document.getElementById('pin' + STT);
                                    row.innerHTML = data;
                                    if (data === 'Ghim') {
                                        ele.style.display = "none";
                                        pin1 = '0';
                                    } else {
                                        ele.style.display = "block";
                                        pin1 = '1';
                                    }
                                },
                                error: function () {

                                }
                            });
                        }
        </script>
    </body>
</html>
