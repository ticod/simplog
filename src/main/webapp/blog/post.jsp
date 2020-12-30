<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="수정일" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${board.bbSubject} - ${blog.bgName}님의 블로그</title>
</head>
<body>

<div class="shadow-lg align-self-center container-fluid d-flex
    flex-column p-0 m-5 w-75 border border-dark">
    <div class="text-right small">
        카테고리: 테스트 카테고리1
    </div>
    <div class="card">
        <div class="card-header">
            <h2 class="text-center my-4">
                ${board.bbSubject}
            </h2>
            <div class="row m-0 d-none d-md-flex">
                <div class="col-6 text-left">
                    조회 수: ${board.bbHits} <br>
                    추천 수: 30
                </div>
                <div class="col-6 text-right">
                    최종 수정 시간: <br>
                    <fmt:formatDate value="${board.bbLastModifiedDatetime}"
                        pattern="yyyy-MM-dd HH-mm" />
                </div>
            </div>
        </div>
        <div class="card-body">
            <div class="row" style="min-height: 400px;">
                <div class="col px-4 py-3">
                    ${board.bbContent}
                </div>
            </div>
        </div>
        <div class="card-footer">

            <c:if test="${!empty board.bbFile}">
            <div class="row border border-secondary rounded p-2 my-2
                    justify-content-center align-items-center">

                첨부파일: &nbsp;
                <a href="../resources/blog_files/${board.bbFile}">
                    ${board.bbFile}
                </a>

            </div>
                </c:if>

            <div class="row border border-dark rounded p-2
                    justify-content-center align-items-center">

                <c:if test="${isBlogger}">
                    <a href="update_form.blog?num=${board.bbNum}"
                       class="btn btn-success mx-1">
                        수정
                    </a>
                    <button data-toggle="modal" data-target="#deleteModal"
                       class="btn btn-danger mx-1" href="#">
                        삭제
                    </button>
                </c:if>

                <c:if test="${!isBlogger}">
                    <a href="delete_form.blog"
                       class="btn btn-primary mx-1">
                        추천
                    </a>
                    <a href="update_form.blog"
                       class="btn btn-danger mx-1">
                        신고
                    </a>
                </c:if>

                <a href="#" onclick="history.back()"
                   class="btn btn-dark mx-1">
                    목록
                </a>

            </div>

            <!-- 댓글 창 토글 버튼 -->
            <div class="row border border-dark rounded p-2
                    justify-content-center align-items-center my-2">
                <button class="btn btn-dark" id="commentToggle"
                        data-toggle="collapse" data-target="#comment">
                    댓글창 열기
                </button>
            </div>

            <!-- 댓글 전체 창 -->
            <div class="row border border-dark rounded p-0
                    justify-content-center align-items-center my-2 collapse"
                 id="comment">

                <div class="shadow card w-100 m-1" style="min-height: 220px;">
                    <div class="card-body row h-100 m-1 p-1
                            d-flex justify-content-start align-items-center">

                        <!-- 댓글 작성자 -->
                        <div class="shadow col-sm-2 h-100 p-0">
                            <div class="card w-100">
                                <img class="card-img-top" src="../resources/imgs/profile-user.png" alt="프로필"
                                     height="160" style="object-fit: contain;">
                                <div class="card-body p-0 mb-0">
                                    <small class="card-title text-center">
                                        유저 이름
                                        asdfasdfasfd
                                    </small>
                                    <br>
                                    <div class="card-text text-left small">
                                        작성시간
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- 댓글 내용 -->
                        <div class="col-sm-6 col-md-8">
                            <div class="mb-2 text-right">
                                추천 수 : 3000
                            </div>
                            <div>
                                asdfsdfdasfasfsdfsdasdfasdfasfdasdfsadfasdfsdfdasfasfsdfsdasdfasdfasfdasdfsadf
                                asdfsdfdasfasfsdfsdasdfasdfasfdasdfsadfasdfsdfdasfasfsdfsdasdfasdfasfdasdfsadf
                                asdfsdfdasfasfsdfsdasdfasdfasfdasdfsadfasdfsdfdasfasfsdfsdasdfasdfasfdasdfsadf
                            </div>
                        </div>

                        <!-- 버튼 -->
                        <div class="col-sm-3 col-md-2 text-center">
                            <div class="row my-1">
                                <div class="col">
                                    <button class="btn btn-primary">
                                        추천
                                    </button>
                                </div>
                            </div>
                            <div class="row my-2">
                                <div class="col">
                                    <button class="btn btn-danger">
                                        신고
                                    </button>
                                </div>
                            </div>

                            <div class="row my-1">
                                <div class="col">
                                    <button class="btn btn-dark">
                                        답글
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="shadow card w-100 m-1" style="min-height: 220px;">
                    <div class="card-body row h-100 m-1 p-1
                            d-flex justify-content-start align-items-center">

                        <!-- 댓글 작성자 -->
                        <div class="shadow col-sm-2 h-100 p-0">
                            <div class="card w-100 d-none d-md-flex">
                                <img class="card-img-top" src="../resources/imgs/profile-user.png" alt="프로필"
                                     height="160" style="object-fit: contain;">
                                <div class="card-body p-0 mb-0">
                                    <small class="card-title text-center">
                                        유저 이름
                                        asdfasdfasfd
                                    </small>
                                    <br>
                                    <div class="card-text text-left small">
                                        작성시간
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- 댓글 내용 -->
                        <div class="col-sm-8 col-md-9">
                            <div class="mb-2 text-right">
                                추천 수 : 3000
                            </div>
                            <div>
                                asdfsdfdasfasfsdfsdasdfasdfasfdasdfsadfasdfsdfdasfasfsdfsdasdfasdfasfdasdfsadf
                                asdfsdfdasfasfsdfsdasdfasdfasfdasdfsadfasdfsdfdasfasfsdfsdasdfasdfasfdasdfsadf
                                asdfsdfdasfasfsdfsdasdfasdfasfdasdfsadfasdfsdfdasfasfsdfsdasdfasdfasfdasdfsadf
                            </div>
                        </div>

                        <!-- 버튼 -->
                        <div class="col-sm-2 col-md-1 text-center">
                            <div class="row my-1">
                                <div class="col">
                                    <button class="btn btn-success">
                                        수정
                                    </button>
                                </div>
                            </div>
                            <div class="row my-2">
                                <div class="col">
                                    <button class="btn btn-danger">
                                        삭제
                                    </button>
                                </div>
                            </div>

                            <div class="row my-1">
                                <div class="col">
                                    <button class="btn btn-dark">
                                        답글
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- 답글 -->
                <div class="shadow card w-100 m-1 ml-5 bg-light border-secondary" style="min-height: 220px;">
                    <div class="card-body row h-100 m-1 p-1
                            d-flex justify-content-start align-items-center">

                        <!-- 댓글 작성자 -->
                        <div class="shadow col-sm-2 h-100 p-0">
                            <div class="card w-100">
                                <img class="card-img-top" src="../resources/imgs/profile-user.png" alt="프로필"
                                     height="80" style="object-fit: contain;">
                                <div class="card-body p-0 mb-0 h-100">
                                    <small class="card-title text-center">
                                        유저 이름
                                        asdfasdfasfd
                                    </small>
                                    <br>
                                    <div class="card-text text-left small">
                                        작성시간
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- 댓글 내용 -->
                        <div class="col-sm-8 col-md-9">
                            <div class="mb-2 text-right">
                                추천 수 : 3000
                            </div>
                            <div>
                                asdfsdfdasfasfsdfsdasdfasdfasfdasdfsadfasdfsdfdasfasfsdfsdasdfasdfasfdasdfsadf
                                asdfsdfdasfasfsdfsdasdfasdfasfdasdfsadfasdfsdfdasfasfsdfsdasdfasdfasfdasdfsadf
                                asdfsdfdasfasfsdfsdasdfasdfasfdasdfsadfasdfsdfdasfasfsdfsdasdfasdfasfdasdfsadf
                            </div>
                        </div>

                        <!-- 버튼 -->
                        <div class="col-sm-2 col-md-1 text-center">
                            <div class="row my-1">
                                <div class="col">
                                    <button class="btn btn-primary">
                                        추천
                                    </button>
                                </div>
                            </div>
                            <div class="row my-2">
                                <div class="col">
                                    <button class="btn btn-danger">
                                        신고
                                    </button>
                                </div>
                            </div>

                            <div class="row my-1">
                                <div class="col">
                                    <button class="btn btn-dark">
                                        답글
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- 비밀 댓글 -->
                <div class="shadow card w-100 m-1" style="min-height: 80px;">
                    <div class="card-body ml-5
                        d-flex justify-content-start align-items-center">
                        비밀 댓글 입니다.
                    </div>
                </div>

                <!-- 삭제된 댓글 -->
                <div class="shadow card w-100 m-1" style="min-height: 80px;">
                    <div class="card-body ml-5
                        d-flex justify-content-start align-items-center">
                        삭제된 댓글 입니다.
                    </div>
                </div>

                <!-- 삭제된 댓글 -->
                <div class="card w-100 m-1 bg-light d-flex justify-content-start align-items-center"
                     style="min-height: 40px;">
                    <div class="card-body
                        d-flex justify-content-start align-items-center">
                        <ul class="pagination m-0">
                            <li class="page-item">
                                <a class="page-link" href="#">
                                    1
                                </a>
                            </li>
                            <li class="page-item active">
                                <a class="page-link" href="#">
                                    2
                                </a>
                            </li>
                            <li class="page-item">
                                <a class="page-link" href="#">
                                    3
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>

            </div>

        </div>
    </div>

</div>

<!-- 블로그 삭제 모달 -->
<!-- Modals -->
<!-- 로그인 -->
<c:if test="${!empty sessionScope.login && isBlogger}">
    <div class="modal fade" id="deleteModal">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">

                <div class="modal-body m-2 p-5 bg-light
                    d-flex flex-column justify-content-center align-items-center">
                    <h4 class="my-3">
                        정말 삭제하실건가요?
                    </h4>
                    <br>
                    <br>
                    <form class="mt-3" action="delete.blog">
                        <input type="hidden" name="num" value="${board.bbNum}">
                        <button class="btn btn-outline-danger">
                            확인
                        </button>
                    </form>
                </div>

            </div>
        </div>
    </div>
</c:if>

<script>
$(function() {
    $("#commentToggle").click(function() {
        if ($("#comment").hasClass("show")) {
            $(this).text("댓글창 열기");
        } else {
            $(this).text("댓글창 닫기")
        }
    })
})

function submitToList() {
    $('#toList').submit();
}
</script>

</body>
</html>
