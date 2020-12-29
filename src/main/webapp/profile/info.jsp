<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>정보 수정</title>
</head>
<body>

<div class="align-self-center w-75 m-5">
    <form method="post" action="info_update.do" name="infoForm" id="infoForm">

        <div class="row my-2 w-100" style="height: 150px;">
            <div class="col-4">
                <label for="id">프로필:</label>
            </div>
            <div class="col-8 p-0 text-center">
                <input type="hidden" name="profileImagePath"
                       id="profileImagePath" value="${member.mbProfileImage}">
                <c:if test="${empty member.mbProfileImage}">
                <img class="border" id="profilePicture"
                     src="../resources/imgs/profile-user.png"
                     alt="None" style="height: 120px">
                </c:if>
                <c:if test="${!empty member.mbProfileImage}">
                <img class="border" id="profilePicture"
                     src="../resources/user_profiles/${member.mbProfileImage}"
                     alt="None" style="height: 120px">
                </c:if>

                <br>
                <a href="#" onclick="openPictureForm()">사진 업로드</a>
            </div>
        </div>

        <div class="row my-2 w-100">
            <div class="col-lg-4">
                <label for="id">아이디:</label>
            </div>
            <div class="col-lg-8">
                <input type="text" class="form-control" name="id"
                       placeholder="아이디" id="id" value="${member.mbId}" readonly>
            </div>
        </div>

        <div class="row my-2 w-100">
            <div class="col-lg-4">
                <label for="email">이메일:</label>
            </div>
            <div class="col-lg-8">
                <input type="text" class="form-control" name="email"
                       placeholder="이메일" id="email" value="${member.mbEmail}" readonly>
            </div>
        </div>

        <div class="row my-2 w-100">
            <div class="col-lg-4">
                <label for="name">이름:</label>
            </div>
            <div class="col-lg-8">
                <input type="text" class="form-control" name="name"
                       placeholder="이름" id="name" value="${member.mbName}">
            </div>
        </div>

        <div class="row my-2 w-100">
            <div class="col-lg-4">
                <label for="tel">전화번호:</label>
            </div>
            <div class="col-lg-8">
                <input type="text" class="form-control" name="tel"
                       placeholder="ex) 010-1234-1234" id="tel"
                       maxlength="13" value="${member.mbTel}">
            </div>
        </div>

        <div class="row my-2 w-100">
            <div class="col-lg-4">
                <label for="birth">생년월일:</label>
            </div>
            <div class="col-lg-8">
                <input type="text" class="form-control" name="birth"
                       placeholder="ex) 19911204" id="birth" value="${member.mbBirthday}">
            </div>
        </div>

        <div class="row my-2 w-100">
            <div class="col-lg-4">
                <label for="intro">자기 소개:</label>
            </div>
            <div class="col-lg-8">
                <textarea class="form-control w-100" name="intro"
                          id="intro" cols="30" rows="5"
                          placeholder="간단한 자기 소개를 한 줄 써보세요!"
                          style="resize: none;" maxlength="100">${member.mbProfileIntro}</textarea>
            </div>
        </div>

        <div class="row my-4 text-center">
            <div class="col">
                <button type="submit" class="btn btn-primary w-50" id="submit">
                    수정
                </button>
            </div>
        </div>

    </form>
</div>

<script>
    const telPattern = /\d{2,3}-\d{3,4}-\d{4}/;
    const birthPattern = /\d{8}/;

    $(function() {
        $("#infoForm").submit(function(event) {
            if ($("#tel").val().trim() !== "") {
                const telMismatch = !telPattern.test($("#tel").val());

                if (telMismatch) {
                    alert("전화번호는 000-0000-0000 형식으로 작성해주세요");
                    event.preventDefault();
                }
            }
            if ($("#birth").val().trim() !== "") {
                const birthMismatch = !birthPattern.test($("#birth").val());

                if (birthMismatch) {
                    alert("생년월일은 숫자 8자로 작성해주세요");
                    event.preventDefault();
                }
            }
        });
    })

    function openPictureForm() {
        const op = "width=500, height=500, left=50, top=150";
        open("user_picture_form.do", "", op);
    }

    function noneProfile(image) {
        $(image).attr("src", "../resources/imgs/profile-user.png");
    }
</script>
</body>
</html>
