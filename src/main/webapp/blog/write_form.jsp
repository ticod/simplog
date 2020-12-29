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
    <form method="post" action="write.blog"
          enctype="multipart/form-data"
          name="writeForm" id="writeForm">

        <div class="row my-2">
            <div class="col-sm-3 d-none d-md-flex justify-content-center align-items-center">
                <label for="category" class="m-0">
                    카테고리
                </label>
            </div>
            <div class="col-sm-9 d-flex justify-content-center align-items-center">
                <select class="form-control" name="category" id="category" required>
                    <option value="0">기본 카테고리 (카테고리 선택)</option>
                    <c:forEach items="${categories}" var="category">
                        <option value="${category.ctNum}">${category.ctName}</option>
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
                       placeholder="제목" maxlength="50" required>
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
                          style="resize: none;" required>${member.mbProfileIntro}</textarea>
            </div>
        </div>

        <div class="row my-2">
            <div class="col-sm-3 d-none d-md-flex justify-content-center align-items-center">
                <label for="file" class="m-0">
                    첨부파일
                </label>
            </div>
            <div class="col-sm-9 d-flex justify-content-center align-items-center text-center">
                <input type="file" class="form-control text-center" name="file" id="file"
                       placeholder="첨부 파일" maxlength="50">
            </div>
        </div>

        <div class="row my-3 text-center">
            <div class="col-sm-6 p-1">
                <button type="submit" class="btn btn-primary w-25" id="submit">
                    작성
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

</body>
</html>
