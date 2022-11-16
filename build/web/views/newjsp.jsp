<%-- 
    Document   : newjsp
    Created on : Jul 15, 2022, 8:48:11 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p class="p" onclick="ghim()">abc</p>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script>
            function ghim() {
                            $.ajax({
                                url: "/prj-project-final/test",
                                type: "get",
                                success: function (data) {
                                    var row = document.querySelector('.p');
                                    row.innerHTML = "data: " +data;
                                },
                                error: function () {

                                }
                            });
                        }
        </script>
    </body>
</html>
