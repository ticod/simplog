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
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="collapsibleNavbar">

        <!-- 헤더 좌측 -->
        <ul class="navbar-nav">
            <li class="nav-item">
                <a href="${path}/main/search.do"
                   class="nav-link">
                    검색
                </a>
            </li>
            <li class="nav-item">
                <a href="${path}/main/chat.do"
                   class="nav-link">
                    채팅
                </a>
            </li>
            <li class="nav-item">
                <a href="${path}/main/question.do"
                   class="nav-link">
                    문의
                </a>
            </li>
        </ul>

        <ul class="navbar-nav">

            <!-- 로그아웃 상태 -->
            <c:if test="${empty sessionScope.login}">
                <li class="nav-item">
                    <a data-toggle="modal" data-target="#loginModal"
                       class="nav-link" href="${path}/main/login.do">
                        로그인
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${path}/main/signup_form.do">
                        회원가입
                    </a>
                </li>
            </c:if>

            <!-- 로그인 상태 -->
            <c:if test="${!empty sessionScope.login}">
            <li class="nav-item">
                <a class="nav-link"
                   href="${path}/main/alert.do">
                    알림
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link"
                   href="${path}/main/setting.do">
                    정보 수정
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
                <div class="modal-body">
                    <div class="jumbotron text-center font-weight-bold"
                         style="width: 100%; margin: 0;">
                        <div class="form-group">
                            <div class="row">
                                <div class="col-5 text-right">
                                    <label for="loginId">
                                        아이디
                                    </label>
                                </div>
                                <div class="col text-left">
                                    <input type="text" name="loginId" id="loginId">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-5 text-right">
                                    <label for="loginPw">
                                        비밀번호
                                    </label>
                                </div>
                                <div class="col text-left">
                                    <input type="password" name="loginPw" id="loginPw"> <br>
                                </div>
                            </div>

                             <br>


                            <button type="submit" class="btn btn-primary"
                                    id="loginSubmit">
                                로그인
                            </button>
                            <br>
                            <br>
                            <button class="btn btn-light">아이디 찾기</button>
                            <button class="btn btn-light">비밀번호 찾기</button>
                        </div>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>

</body>
</html>
