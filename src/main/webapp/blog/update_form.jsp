<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${blog.bgName} : 글 작성</title>
</head>
<body>

<div class="align-self-center w-75 m-5">
    <form method="post" action="update.blog"
          enctype="multipart/form-data"
          name="updateForm" id="updateForm">

        <input type="hidden" name="boardNum" value="${board.bbNum}">

        <div class="row my-2">
            <div class="col-sm-3 d-none d-md-flex justify-content-center align-items-center">
                <label for="categoryNum" class="m-0">
                    카테고리
                </label>
            </div>
            <div class="col-sm-9 d-flex justify-content-center align-items-center">
                <select class="form-control" name="categoryNum" id="categoryNum" required>
                    <option value="0">기본 카테고리 (카테고리 선택)</option>
                    <c:forEach items="${categories}" var="categoryList">
                        <c:forEach items="${categoryList.value}" var="category" end="0">
                            <option value="${category.ctNum}">${category.ctName}</option>
                        </c:forEach>
                        <c:forEach items="${categoryList.value}" var="category" begin="1">
                            <option value="${category.ctNum}">- ${category.ctName}</option>
                        </c:forEach>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="row my-2">
            <div class="col-sm-3 d-none d-md-flex justify-content-center align-items-center">
                <label for="subject" class="m-0">
                    제목
                </label>
            </div>
            <div class="col-sm-9 d-flex justify-content-center align-items-center">
                <input type="text" class="form-control" name="subject" id="subject"
                       placeholder="제목" maxlength="50" value="${board.bbSubject}" required>
            </div>
        </div>

        <div class="row my-2">
            <div class="col-sm-3 d-none d-md-flex justify-content-center align-items-center">
                <label for="content" class="m-0">
                    내용
                </label>
            </div>
            <div class="col-sm-9 d-flex justify-content-center align-items-center">
                <textarea class="form-control w-100" name="content"
                          id="content" cols="30" rows="20"
                          placeholder="내용"
                          style="resize: none;" required>${board.bbContent}</textarea>
            </div>
        </div>

        <div class="row my-2">
            <div class="col-sm-3 d-none d-md-flex justify-content-center align-items-center">
                <label for="file" class="m-0">
                    첨부파일
                </label>
            </div>
            <div class="col-sm-9 d-flex justify-content-center align-items-center text-center">
                <div class="w-100" id="currentFile">

                <c:if test="${!empty board.bbFile}">
                    <input type="hidden" name="currentFile" value="${board.bbFile}">
                    ${board.bbFile}&nbsp;&nbsp;<a href="#" onclick="fileDelete()">첨부파일 삭제</a>
                </c:if>

                <c:if test="${empty board.bbFile}">
                    <input type="file" class="form-control text-center w-100" name="file" id="file">
                </c:if>

                </div>
            </div>
        </div>

        <div class="row my-3 text-center">
            <div class="col-sm-6 p-1">
                <button type="submit" class="btn btn-primary w-25" id="submit">
                    수정
                </button>
            </div>
            <div class="col-sm-6 p-1">
                <button type="button" class="btn btn-dark w-25" onclick="history.go(-1)">
                    뒤로가기
                </button>
            </div>
        </div>

    </form>
</div>

<script>
    const currentFile = $("#currentFile");

    $(function() {
        $("#categoryNum").val(${board.ctNum})
    })

    function fileDelete() {
        // currentFile.css("display", "none");
        currentFile.html('<input type="file" class="form-control text-center" name="file" id="file">');
    }
</script>
</body>
</html>