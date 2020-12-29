<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>카테고리 설정</title>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
</head>
<body>
<div class="jumbotron text-center font-weight-bold"
     style="width: 36%;">
    <form action="../process/category.do" method="post" id="form">
        <input type="hidden" name="blog" value="${blog}">

        <!-- 카테고리 목록 -->
        <div class="container pre-scrollable" id="categoryList"
             style="height: 800px;">
            <c:forEach items="${categories}" var="category">

                <c:choose>
                    <!-- 기본 카테고리 -->
                    <c:when test="${category.ctNum == 0}">

                    </c:when>

                    <!-- 깊이 1 카테고리 -->
                    <c:when test="${category.ctParent == 0}">

                    </c:when>

                    <!-- 깊이 2 카테고리 -->
                    <c:otherwise>

                    </c:otherwise>

                </c:choose>
            </c:forEach>
            <div class="row" id="1" style="margin: 0.5em 0 0.5em 0">
                <div class="col-6 text-left">카테고리 1</div>
                <div class="col-6 text-right">
                    <button type="button" class="btn btn-danger"
                            onclick="categoryDelete(this)">-
                    </button>
                </div>
            </div>
            <div class="row" id="2" style="margin: 0.5em 0 0.5em 0">
                <div class="col-6 text-left">카테고리 2</div>
                <div class="col-6 text-right">
                    <button type="button" class="btn btn-danger"
                            onclick="categoryDelete(this)">-</button>
                </div>
            </div>
            <div class="row" id="3" style="margin: 0.5em 0 0.5em 0">
                <div class="col-8 text-left"> - 카테고리 2 - 1</div>
                <div class="col-4 text-right">
                    <button type="button" class="btn btn-danger"
                            onclick="categoryDelete(this)">-</button>
                </div>
            </div>
        </div>

        <button type="button" class="btn btn-success"
                data-toggle="modal" data-target="#addModal">
            추가
        </button>
        <button type="submit" class="btn btn-success">
            수정
        </button>

    </form>
</div>

<!-- 추가 모달 -->
<div class="modal fade" id="addModal">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">

            <!-- Modal body -->
            <div class="modal-body">
                <div class="jumbotron text-center font-weight-bold"
                     style="width: 100%; margin: 0;">
                    <div class="form-group">
                        <label for="categoryName">
                            카테고리 명 입력
                        </label>
                        <br>
                        <input class="form-control" type="text" id="categoryName" name="name" placeholder="카테고리 명">
                        <br>
                        <button type="button" class="btn btn-success" id="submit"
                                onclick="categoryAdd()">
                            추가
                        </button>
                        <button type="button" class="btn btn-danger" data-dismiss="modal">
                            취소
                        </button>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>

<script>
    function categoryDelete(button) {
        $(button).parent().parent().remove();
    }

    function categoryAdd() {
        const categoryName = $("#categoryName");
        $("#categoryList").append('<div class="row" id="1" style="margin: 0.5em 0 0.5em 0">' +
            '<div class="col-6 text-left">' + categoryName.val() + '</div>' +
            '<div class="col-6 text-right">' +
            '<button type="button" class="btn btn-danger" onclick="categoryDelete(this)">-</button>' +
            '</div></div></div>');
        categoryName.val("");
        $("#addModal").modal("hide");
    }

    $(function() {
        $("#categoryList").sortable();
    })
</script>
</body>
</html>