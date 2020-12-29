<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><decorator:title /></title>
    <decorator:head />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<!-- Header -->
<nav class="navbar navbar-expand-md bg-dark navbar-dark"
    style="position: fixed; width: 100%;">

    <!-- Toggler/collapsibe Button -->
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>

    <!-- Navbar links -->
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="navbar-brand">
                <a href="${path}/index.do" style="text-decoration: none; color: white;">
                    Simplog
                </a>
            </li>
            <li class="nav-item">
                <a href="${path}/search.do"
                   class="nav-link">
                    검색
                </a>
            </li>
            <li class="nav-item">
                <a href="${path}/chat.do"
                   class="nav-link">
                    채팅
                </a>
            </li>
            <li class="nav-item">
                <a href="${path}/question.do"
                   class="nav-link">
                    문의
                </a>
            </li>
        </ul>
    </div>

    <!-- 로그아웃 상태 -->
    <c:if test="${empty sessionScope.login}">
        <ul class="navbar-nav justify-content-end">
            <li class="nav-item">
                <a class="nav-link"
                   href="${path}/login.do">
                    로그인
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link"
                   href="${path}/signup.do">
                    회원가입
                </a>
            </li>
        </ul>
    </c:if>

    <!-- 로그인 상태 -->
    <c:if test="${!empty sessionScope.login}">
        <ul class="navbar-nav justify-content-end">
            <li class="nav-item">
                <a class="nav-link"
                   href="${path}/alert.do">
                    알림
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link"
                   href="${path}/setting.do">
                    정보 수정
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link"
                   href="${path}/logout.do">
                    로그아웃
                </a>
            </li>
        </ul>
    </c:if>
</nav>

<!-- Side Bar & Contents -->
<div class="jumbotron jumbotron-fluid bg-white"
style="height: 98vh;">
    <div class="container">
        <decorator:body />
    </div>
</div>

<!-- Footer -->
<div class="jumbotron jumbotron-fluid bg-dark text-white"
    style="margin-bottom: 0;">
    <div class="container text-right">
        <h5>Simplog since 2020</h5>
        <p>email: lours2021@gmail.com</p>
    </div>
</div>
</body>
</html>
