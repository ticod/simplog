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
<nav class="navbar navbar-expand-md bg-dark navbar-dark fixed-top"
    style="z-index: 10;">

    <!-- LOGO -->
    <ul class="navbar-nav">
        <li class="navbar-brand">
            <a href="${path}/main/index.do" style="text-decoration: none; color: white;">
                Simplog
            </a>
        </li>
    </ul>

    <!-- Toggle Button -->
    <button class="navbar-toggler" type="button"
            data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="collapsibleNavbar">

        <ul class="navbar-nav">

            <!-- 로그인 상태 -->
            <c:if test="${!empty sessionScope.login}">
            <li class="nav-item">
                <a class="nav-link"
                   href="${path}/profile/info.do">
                    정보 수정
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link"
                   href="${path}/profile/password_change.do">
                    비밀번호 수정
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link"
                   href="${path}/profile/blog_management.do">
                    블로그 관리
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link"
                   href="${path}/main/logout.do">
                    로그아웃
                </a>
            </li>
            </c:if>

        </ul>
    </div>
</nav>

<!-- Side Bar & Contents -->
<div class="d-flex flex-column h-100 mt-5 pt-2 mb-0 pb-0">
    <decorator:body />
</div>

<!-- Footer -->
<div class="jumbotron jumbotron-fluid bg-dark text-white"
     style="margin-bottom: 0;">
    <div class="container text-right">
        <h5>Simplog since 2020</h5>
        <p>email: lours2021@gmail.com</p>
    </div>
</div>

<!-- Modals -->
<!-- 로그인 -->
<div class="modal fade" id="loginModal">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <form action="login.do" method="post" id="loginForm">
                <input type="hidden" name="blog" value="${blog}">

                <!-- Modal body -->
                <div class="modal-body text-center">
                    <div class="jumbotron text-center w-100 m-0">
                        <div class="form-group">

                            <div class="row my-3">
                                <div class="col-4 d-flex justify-content-end align-items-center">
                                    <label for="loginId" class="m-0">
                                        아이디
                                    </label>
                                </div>
                                <div class="col text-left">
                                    <input class="form-control" type="text" name="loginId" id="loginId">
                                </div>
                            </div>

                            <div class="row my-3">
                                <div class="col-4 d-flex justify-content-end align-items-center">
                                    <label for="loginPw" class="m-0">
                                        비밀번호
                                    </label>
                                </div>
                                <div class="col text-left w-100">
                                    <input class="form-control" type="password" name="loginPw" id="loginPw">
                                </div>
                            </div>

                            <button type="submit" class="btn btn-primary my-3"
                                    id="loginSubmit">
                                로그인
                            </button>

                        </div>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>

</body>
</html>
