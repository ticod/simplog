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
<div class="jumbotron text-center font-weight-bold bg-light w-100">
    <form action="/process/layout.do" method="post" id="form">
        <div class="row" style="height: 600px;">
            <div class="col-6">
                <input type="radio" name="list" value="board" id="board" <c:if test="${blog.bgLayout == 0}">checked</c:if>>
                <label for="board">글 위주의 레이아웃</label>
                <div>
                    <img src="" alt="글 위주 그림" height="600">
                </div>
            </div>
            <div class="col-6">
                <input type="radio" name="list" value="image" id="image" <c:if test="${blog.bgLayout == 1}">checked</c:if>>
                <label for="image">이미지 위주의 레이아웃</label>
                <div>
                    <img src="" alt="이미지 위주 그림" height="600">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col">
                <input type="submit" value="설정 수정">
            </div>
        </div>

    </form>
</div>
</body>
</html>