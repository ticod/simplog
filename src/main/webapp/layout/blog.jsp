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
<nav class="navbar bg-dark navbar-dark fixed-top"
     style="z-index: 10;">

    <button class="navbar-toggler" type="button" id="sidebar-toggler"
            data-toggle="collapse" data-target="#sidebar">
        <span class="navbar-toggler-icon"></span>
    </button>

    <!-- LOGO -->
    <ul class="navbar-nav">
        <li class="navbar-brand">
            <a href="main.blog" style="text-decoration: none; color: white;">
                LOGO
            </a>
        </li>
    </ul>

    <!-- Toggle Button -->
    <button class="navbar-toggler" type="button" id="navbar-toggler"
            data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="collapsibleNavbar">

        <!-- 헤더 좌측 -->
        <ul class="navbar-nav">
            <li class="nav-item">
                <a href="search.do"
                   class="nav-link">
                    검색
                </a>
            </li>
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
                       href="${path}/main/password_check.do">
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

            <!-- 블로그 주인 -->
            <c:if test="${sessionScope.login == blog}"></c:if>

        </ul>

    </div>

</nav>

<!-- Contents -->
<div class="container-fluid">
    <div class="row">
        <div class="col-3 my-1 mt-5 pt-2 px-0 mb-0 pb-0 fixed-top">
            <div class="collapse card bg-light text-center mh-100" style="min-width: 30vw;"
                 id="sidebar">

                <div class="card-header">
                    <div class="text-left">

                        <c:if test="${empty blog.bgLogo}">
                            <img src="../resources/imgs/search.png" alt="" height="40">
                        </c:if>

                        <c:if test="${!empty blog.bgLogo}">
                            <img src="../resources/blog_logos/${blog.bgLogo}" alt="" height="40">
                        </c:if>

                    </div>
                    <div>

                        <c:if test="${empty blog.bgProfileImage}">
                            <img src="../resources/imgs/profile-user.png" alt="" height="120">
                        </c:if>

                        <c:if test="${!empty blog.bgProfileImage}">
                            <img src="../resources/blog_profiles/${blog.bgProfileImage}" alt="" height="120">
                        </c:if>

                    </div>
                    <br>

                    <div>
                        <h4>${blog.bgName}</h4>
                    </div>

                    <div>
                        <p>${blog.bgIntro}</p>
                    </div>

                </div>
                <div class="card-body">

                    <!-- 카테고리 -->
                    <form action="list.blog" method="post" id="toList">
                    <div class="pre-scrollable text-left">
                        <ul>
                            <li class="m-1">
                                <a href="#" onclick="submitList(0)">
                                    전체 글 보기
                                </a>
                            </li>
                            <br>
                            <c:forEach items="${categories}" var="categoryList">
                                <c:forEach items="${categoryList.value}" var="category" end="0">
                                    <li class="m-2">
                                        <a href="#" onclick="submitList(${category.ctNum})">
                                                ${category.ctName}
                                        </a>
                                    </li>
                                </c:forEach>
                                <c:forEach items="${categoryList.value}" var="category" begin="1">
                                    <ul class="m-2">
                                        <li>
                                            <a href="#" onclick="submitList(${category.ctNum})">
                                                    ${category.ctName}
                                            </a>
                                        </li>
                                    </ul>
                                </c:forEach>
                            </c:forEach>
                        </ul>
                    </div>
                    </form>
                    <br>

                    <!-- footer (글 작성, 설정 / 추천, 신고) -->
                    <c:if test="${!empty sessionScope.login}">
                        <div class="card-footer">
                            <div class="row">

                                <c:if test="${isBlogger}">
                                <div class="col-lg-6">
                                    <a href="write_form.blog">새 글 작성</a>
                                </div>
                                <div class="col-lg-6">
                                    <a href="settings/dashboard.blog">블로그 설정</a>
                                </div>
                                </c:if>

                                <c:if test="${!isBlogger}">
                                    <div class="col-lg-6">
                                        <a href="recommended.blog">추천</a>
                                    </div>
                                    <div class="col-lg-6">
                                        <a href="report.blog">신고</a>
                                    </div>
                                </c:if>

                            </div>
                        </div>
                    </c:if>

                </div>

            </div>
        </div>
    </div>
</div>

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
<c:if test="${empty sessionScope.login}">
<div class="modal fade" id="loginModal">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <form action="../main/login.do" method="post" id="loginForm">
                <input type="hidden" name="blog" value="${blog}">

                <!-- Modal body -->
                <div class="modal-body text-center">
                    <div class="jumbotron text-center w-100 m-0">
                        <div class="form-group">

                            <div class="row my-3">
                                <div class="col-4 d-flex justify-content-center align-items-center">
                                    <label for="loginId" class="m-0">
                                        아이디
                                    </label>
                                </div>
                                <div class="col text-left">
                                    <input class="form-control" type="text" name="loginId" id="loginId">
                                </div>
                            </div>

                            <div class="row my-3">
                                <div class="col-4 d-flex justify-content-center align-items-center">
                                    <label for="loginPw" class="m-0">
                                        비밀번호
                                    </label>
                                </div>
                                <div class="col text-left">
                                    <input class="form-control" type="password" name="loginPw" id="loginPw">
                                </div>
                            </div>

                            <a href="login_form.do" class="btn btn-dark my-3">
                                아이디/비밀번호 찾기
                            </a>

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
</c:if>

<script>
    const toListForm = $("#toList");
    $(function() {
        $("#sidebar-toggler").click(function() {
            $("#collapsibleNavbar").collapse("hide");
        });
        $("#navbar-toggler").click(function() {
            $("#sidebar").collapse("hide");
        });
    })
    function submitList(categoryNum) {
        const parameter = "<input type='hidden' name='categoryNum' value='" + categoryNum + "'>";
        toListForm.append(parameter);
        toListForm.submit();
    }
</script>
</body>
</html>
