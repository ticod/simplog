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

<!-- Side Bar & Contents -->
<div class="jumbotron jumbotron-fluid bg-white"
     style="height: 98vh; padding: 1vh 1vh 1vh 0;">
    <div class="row" style="height: 100%">

        <!-- Side Bar -->
        <div class="col-md-2 w-25" style="width: 260px;">
            <div class="container container-fluid bg-secondary"
                 style="width: 100%; height: 100%">

                <!-- 프로필, 로고 -->
                <h1 style="word-break: break-all">
                    <a href="../main.blog" style="text-decoration: none; color: white;">
                        <c:if test="${empty blog.bgLogo}">
                            LOGO
                        </c:if>
                        <c:if test="${!empty blog.bgLogo}">
                            <img src="" alt="${blog.bgName}">
                        </c:if>
                    </a>
                </h1>
                <div class="card bg-white">
                    <c:if test="${empty blog.bgProfileImage}">
                        <img class="card-img-top rounded-circle bg-white" src="../../resources/imgs/profile-user.png" alt="Profile"
                             style="height: 120px; object-fit: contain;">
                    </c:if>
                    <c:if test="${!empty blog.bgProfileImage}">
                        <img class="card-img-top rounded-circle bg-white" src="../../resources/blog_profiles/${blog.bgProfileImage}" alt="Profile"
                             style="height: 120px; object-fit: contain;">
                    </c:if>
                </div>

                <!-- 리스트 -->
                <div id="listGroup">
                    <div class="list-group" style="margin-top: 32px;">
                        <a href="dashboard.blog" id="dashboard"
                           class="list-group-item list-group-item-action
                            <c:if test="${url == '/settings/dashboard.blog'}">active</c:if>">
                            대시 보드
                        </a>
                    </div>
                    <div class="list-group" style="margin-top: 16px;">
                        <a href="profile.blog" id="profile"
                           class="list-group-item list-group-item-action
                            <c:if test="${url == '/settings/profile.blog'}">active</c:if>">
                            프로필 수정
                        </a>
                        <a href="layout_main.blog" id="layout_main"
                           class="list-group-item list-group-item-action
                            <c:if test="${url == '/settings/layout_main.blog'}">active</c:if>">
                            메인 화면 설정
                        </a>
                        <a href="layout.blog" id="layout"
                           class="list-group-item list-group-item-action
                            <c:if test="${url == '/settings/layout.blog'}">active</c:if>">
                            레이아웃 설정
                        </a>
                        <a href="category.blog" id="category"
                           class="list-group-item list-group-item-action
                            <c:if test="${url == '/settings/category.blog'}">active</c:if>">
                            카테고리 설정
                        </a>
                    </div>
                    <div class="list-group" style="margin-top: 64px;">
                        <a data-toggle="modal" data-target="#deleteModal" id="blog_delete"
                           class="list-group-item list-group-item-action list-group-item-danger">
                            블로그 삭제
                        </a>
                    </div>
                </div>

            </div>
        </div>

        <!-- Main Contents -->
        <div class="col-10">
            <div class="container container-fluid bg-white
            d-flex justify-content-center align-items-center"
                 style="width: 100%; height: 100%; max-width: 1500px;"
                 id="main_contents">
                <decorator:body />
            </div>
        </div>

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

<!-- 블로그 삭제 Modal -->
<div class="modal fade" id="deleteModal">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">

            <form action="../../blog/process/delete.do" method="post" id="deleteForm">
                <input type="hidden" name="blog" value="${blog.bgName}">
                <!-- Modal body -->
                <div class="modal-body">
                    <div class="jumbotron text-center font-weight-bold"
                         style="width: 100%; margin: 0;">
                        <div class="form-group">
                            블로그를 정말 삭제하시겠습니까? <br>
                            데이터는 복구되지 않습니다. <br>
                            <br>
                            <label for="name">
                                블로그 명을 입력하세요
                                <div class="text-danger"> [ ${blog.bgName} ] </div>
                            </label>
                            <br>
                            <input class="form-control" type="text" id="name" name="name" placeholder="${blog.bgName}" required>
                            <div class="text-danger" id="valid-check"></div>
                            <br>
                            <button type="submit" class="btn btn-danger" id="blogDeleteSubmit">삭제</button>
                            <button type="button" class="btn btn-success" data-dismiss="modal">취소</button>
                        </div>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>

<script>
    $(function() {
        $("#deleteForm").submit(function() {
            if ($("#name").val() !== "${blog.bgName}") {
                $("#valid-check").html("블로그 명을 확인하세요");
                return false;
            }
        })
    })

    function noneProfile(image) {
        $(image).attr("src", "../../resources/imgs/profile-user.png");
    }

    function noneLogo(image) {
        $(image).replaceWith("${blog.bgName}");
    }
</script>
</body>
</html>
