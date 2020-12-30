<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SIMPLOG</title>
    <style>
        .img_resize {
            width: 100%;
            height: 100%;
            max-height: 100vh;
        }
    </style>
</head>
<body>

<!-- 검색 바 (ajax) -->
<div class="w-100" id="main_search_bar"></div>

<div class="container-fluid bg-dark mh-vh-100 mw-100 p-0">
    <div id="images" class="carousel slide" data-ride="carousel">

        <!-- Indicators -->
        <ul class="carousel-indicators">
            <li data-target="#images" data-slide-to="0" class="active"></li>
            <li data-target="#images" data-slide-to="1"></li>
            <li data-target="#images" data-slide-to="2"></li>
        </ul>

        <!-- The slideshow -->
        <div class="carousel-inner" style="height: 100%;">
            <div class="carousel-item active">
                <img class="img-fluid mx-auto d-block img_size" src="../resources/imgs/main-image/main-image-1.jpg" alt="">
            </div>
            <div class="carousel-item">
                <img class="img-fluid mx-auto d-block img_size" src="../resources/imgs/main-image/main-image-2.jpg" alt="">
            </div>
            <div class="carousel-item">
                <img class="img-fluid mx-auto d-block img_size" src="../resources/imgs/main-image/main-image-3.jpg" alt="">
            </div>
        </div>

        <!-- Left and right controls -->
        <a class="carousel-control-prev" href="#images" data-slide="prev">
            <span class="carousel-control-prev-icon"></span>
        </a>
        <a class="carousel-control-next" href="#images" data-slide="next">
            <span class="carousel-control-next-icon"></span>
        </a>

    </div>
</div>

<script src="../modules/mainSearchBar.js"></script>
</body>
</html>
