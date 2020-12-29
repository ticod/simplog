<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${blog.bgName}</title>
</head>
<body>

<div class="overlay w-100 bg-dark position-absolute" style="z-index: 5;"></div>
<!-- 0번 레이아웃 -->
<c:if test="${blog.bgMainLayout == 0}">
    <div class="w-100">
        <img src="../resources/imgs/main-image/main-image-1.jpg" alt="" class="w-100">
        <div class="w-100 position-absolute" style="background-color: black; z-index: 5;"></div>
    </div>
    <div id="mainContent"></div>
</c:if>

<!-- 1번 레이아웃 -->
<c:if test="${blog.bgMainLayout == 1}">
    <div id="mainContent"></div>
</c:if>

<!-- 2번 레이아웃 -->
<c:if test="${blog.bgMainLayout == 2}">
    <script>
        location.href = "list.blog";
    </script>
</c:if>

</body>
</html>
