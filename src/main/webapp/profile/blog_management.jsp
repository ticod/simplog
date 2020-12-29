<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>블로그 관리</title>
</head>
<body>

<div class="align-self-center w-50 m-5 border border-dark text-center">
    <br>
    <c:if test="${empty blogs}">
        <h4>개설한 블로그가 없습니다.</h4> <br> <br>
    </c:if>
    <c:if test="${!empty blogs}">
        <c:forEach items="${blogs}" var="blog">
            <div class="row my-2 mx-0 w-100
            d-flex justify-content-center align-items-center">
                <div class="col-lg-4">

                    <c:if test="${empty blog.bgProfileImage}">
                    <img src="../resources/imgs/profile-user.png"
                         alt="" style="height: 120px;">
                    </c:if>
                    <c:if test="${!empty blog.bgProfileImage}">
                    <img src="../resources/blog_profiles/${blog.bgProfileImage}"
                         alt="" style="height: 120px;">
                    </c:if>
                    <br>

                    <a href="../${blog.bgUrl}/main.blog">
                        ${blog.bgName}
                    </a>
                    <br>
                </div>
                <div class="col-lg-8">
                    <c:if test="${empty blog.bgIntro}">
                        블로그 소개 글이 없습니다.
                    </c:if>
                    <c:if test="${!empty blog.bgIntro}">
                        ${blog.bgIntro}
                    </c:if>
                    <br>
                </div>
            </div>
        </c:forEach>
    </c:if>

    <c:if test="${blogs.size() < 5 || empty blogs}">
    <div class="row my-2 mx-0 w-100 text-center">
        <div class="col-lg-12">
            <button data-toggle="modal" data-target="#blogCreateModal"
                    class="btn btn-primary w-50" type="button">
                블로그 개설
            </button>
        </div>
    </div>
    </c:if>

    <c:if test="${blogs.size() >= 5}">
    <div class="row my-2 mx-0 w-100 text-center">
        <div class="col">
            <button class="btn btn-primary disabled" type="button">
                블로그는 최대 5개까지만 개설하실 수 있습니다.
            </button>
        </div>
    </div>
    </c:if>

</div>

<p class="text-center text-danger">
    삭제는 블로그 설정 페이지에서 가능합니다.
</p>

<!-- Modals -->
<!-- 블로그 개설 -->
<div class="modal fade" id="blogCreateModal">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <form action="blog_create.do" method="post" id="blogCreateForm">
                <input type="hidden" name="blog" value="${blogs}">

                <!-- Modal body -->
                <div class="modal-body text-center">
                    <div class="jumbotron text-center w-100 m-0">

                        <div class="row my-2">
                            <div class="col-md-3 d-flex justify-content-center align-items-center">
                                <label for="blogType" class="m-0">
                                    분야
                                </label>
                            </div>
                            <div class="col-md-9 d-flex justify-content-center align-items-center">
                                <select class="form-control" name="blogType" id="blogType" required>
                                    <option value="">분야 선택</option>
                                    <c:forEach items="${blogTypes}" var="blogType">
                                        <option value="${blogType.btType}">${blogType.btName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="row my-2">
                            <div class="col-md-3 d-flex justify-content-center align-items-center">
                                <label for="blogName" class="m-0">
                                    이름
                                </label>
                            </div>
                            <div class="col-md-9 d-flex justify-content-center align-items-center">
                                <input type="text" name="blogName"
                                       placeholder="블로그 명"
                                       id="blogName" class="form-control"
                                       minlength="4" maxlength="20" required>
                            </div>
                        </div>

                        <div class="row my-2">
                            <div class="col-md-3 d-flex justify-content-center align-items-center">
                                <label for="blogUrl" class="m-0">
                                    URL
                                </label>
                            </div>
                            <div class="col-md-6 d-flex justify-content-center align-items-center">
                                <input type="text" name="blogUrl"
                                       placeholder="주소창에 사용됩니다!"
                                       id="blogUrl" class="form-control"
                                       minlength="4" maxlength="12" required>
                            </div>
                            <div class="col-md-3 d-flex justify-content-center align-items-center">
                                <button type="button" id="urlOverlapCheckButton"
                                        class="btn btn-primary btn-sm">
                                    중복 확인
                                </button>
                            </div>
                        </div>

                        <div class="row my-4">
                            <div class="col-md-3 d-flex justify-content-center align-items-center">
                                <label for="blogIntro" class="m-0">
                                    소개
                                </label>
                            </div>
                            <div class="col-md-9 d-flex justify-content-center align-items-center">
                                <textarea class="form-control w-100" name="blogIntro"
                                          id="blogIntro" cols="30" rows="5"
                                          placeholder="간단한 블로그 소개를 써봐요! 안써도 상관없습니다."
                                          style="resize: none;" maxlength="100"></textarea>
                            </div>
                        </div>

                        <button type="submit" class="btn btn-primary my-3"
                                id="blogCreate">
                            개설
                        </button>

                    </div>
                </div>
            </form>

        </div>
    </div>
</div>

<script>
const blogUrl = $("#blogUrl");
const blogCreateForm = $("#blogCreateForm");
const urlOverlapCheckButton = $("#urlOverlapCheckButton");

let urlRegexCheck = false;
let urlOverlapCheck = false;

$(function() {
    blogCreateForm.submit(function(event) {
        checkUrlOverlap();
        checkUrlRegex();

        if (!urlRegexCheck) {
            alert("URL은 4~12자 이내의 영어 소문자, 숫자만 허용합니다.");
            event.preventDefault();
            return false;
        }
        if (!urlOverlapCheck) {
            alert("이미 존재하는 주소입니다!");
            event.preventDefault();
            return false;
        }
    })

    blogUrl.keyup(checkUrlRegex);
    urlOverlapCheckButton.click(clickCheckUrl);
})

function checkUrlRegex() {
    const pattern = /^[a-z0-9+]*$/;
    urlRegexCheck = pattern.test(blogUrl.val()) && blogUrl.val().trim() !== "";
}

function checkUrlOverlap() {
    const url = blogUrl.val();
    const params = {
        url: url
    };
    $.ajax("url_check.do", {
        data: params,
        async: false,
        success: function(data) {
            urlOverlapCheck = data === "true";
        },
        error: function(e) {
            alert("서버 오류: " + e.status);
        }
    })
}

function clickCheckUrl() {
    checkUrlOverlap();
    checkUrlRegex();
    if (!urlRegexCheck) {
        alert("URL은 4~12자 이내의 영어 소문자, 숫자만 허용합니다.");
    } else if (!urlOverlapCheck) {
        alert("이미 존재하는 주소입니다.");
    } else {
        alert("사용 가능한 주소입니다!");
    }
}

</script>

</body>
</html>
