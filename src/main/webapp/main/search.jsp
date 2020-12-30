<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SIMPLOG</title>
</head>
<body>

<!-- 검색 바 (ajax) -->
<div id="main_search_bar"></div>

<div class="container-fluid" style="height: 90vh; padding: 0;">

</div>

<script>
    $(function() {
        $.ajax("../modules/main_search_bar.do", {
            success: function(data) {
                $("#main_search_bar").html(data);
                $("#search_icon").attr("src", "../resources/imgs/search.png");
            },
            error: function(error) {
                alert("서버 오류, " + error.status);
            }
        })
    })
</script>
</html>
