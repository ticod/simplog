<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>카테고리 설정</title>

</head>
<body>
<div class="jumbotron text-center font-weight-bold w-100 h-100 m-0 p-1">

    <div class="row d-flex justify-content-center align-items-center
                w-100 h-100 m-0 pb-5 p-0">

        <div class="col" style="height: 80%">
            <input type="radio" name="mainLayout" value="0" id="0"
                   <c:if test="${blog.bgMainLayout == 0}">checked</c:if>>
            <label for="0">메인 커버 이미지</label>
            <div>
                <img src="" alt="asdf" height="600">
            </div>
            <button data-toggle="modal" data-target="#mainCoverModal" >설정 수정</button>
        </div>

        <div class="col" style="height: 80%">
            <input type="radio" name="mainLayout" value="1" id="1"
                   <c:if test="${blog.bgMainLayout == 1}">checked</c:if>>
            <label for="1">메인 글 선택</label>
            <div>
                <img src="" alt="asdf" height="600">
            </div>
            <button data-toggle="modal" data-target="#mainCoverModal" >설정 수정</button>
        </div>

        <div class="col" style="height: 80%">
            <input type="radio" name="mainLayout" value="2" id="2"
                   <c:if test="${blog.bgMainLayout == 2}">checked</c:if>>
            <label for="2">글 목록</label>
            <div>
                <img src="" alt="" height="600">
            </div>
        </div>

    </div>


    <!-- 메인 커버 모달 -->
    <div class="modal fade" id="mainCoverModal">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">

                <!-- Modal body -->
                <div class="modal-body">
                    <div class="jumbotron text-center font-weight-bold"
                         style="width: 100%; margin: 0;">
                        <form action="">
                            <input type="hidden" name="blog" value="${blog}">
                            <div class="form-group">
                                <label for="mainCover">메인 커버 사진 선택</label>
                                <input type="file" id="mainCover" name="mainCover">
                                <label for="mainIntro">메인 소개 입력</label>
                                <textarea name="mainIntro" id="mainIntro" cols="30" rows="10"></textarea>
                            </div>
                        </form>
                    </div>
                </div>

            </div>
        </div>
    </div>

</div>
</body>
</html>