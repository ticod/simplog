<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인 페이지</title>
</head>
<body>

<div class="align-self-center w-50 m-5">
    <form method="post" action="login.do">

        <div class="row my-4">
            <div class="col-lg-3">
                <label for="id">아이디:</label>
            </div>
            <div class="col-lg-6">
                <input type="text" class="form-control"
                       placeholder="아이디" name="loginId" id="id" required>
            </div>
        </div>

        <div class="row my-4">
            <div class="col-lg-3">
                <label for="pw">비밀번호:</label>
            </div>
            <div class="col-lg-6">
                <input type="password" class="form-control"
                       placeholder="비밀번호" name="loginPw" id="pw" required>
            </div>
        </div>

        <div class="row my-4 text-center">
            <div class="col">
                <button type="submit" class="btn btn-primary w-25">
                    로그인
                </button>
            </div>
        </div>

        <div class="row my-5 text-center">
            <div class="col text-right">
                <a href="id_find_form.do" class="btn btn-dark w-75">
                    아이디 찾기
                </a>
            </div>
            <div class="col text-left">
                <a href="pw_find_form.do" class="btn btn-dark w-75">
                    비밀번호 찾기
                </a>
            </div>
        </div>

    </form>
</div>

</body>
</html>
