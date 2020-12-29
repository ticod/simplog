<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>비밀번호 확인</title>
</head>
<body>

<div class="align-self-center w-50 m-5">
    <form method="post" action="../profile/profile.do">

        <div class="row my-4">
            <div class="col-lg-3">
                <label for="pw">비밀번호 확인:</label>
            </div>
            <div class="col-lg-6">
                <input type="password" class="form-control"
                       placeholder="비밀번호" name="pw" id="pw" required>
            </div>
        </div>

        <div class="row my-4 text-center">
            <div class="col">
                <button type="submit" class="btn btn-primary w-25">
                    로그인
                </button>
            </div>
        </div>

    </form>
</div>

</body>
</html>
