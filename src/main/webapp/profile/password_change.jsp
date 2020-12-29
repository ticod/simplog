<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>비밀번호 수정</title>
</head>
<body>

<div class="align-self-center w-50 m-5">
    <form method="post" action="password_change_process.do"
          name="passwordForm" id="passwordForm">

        <div class="row my-2 w-100">
            <div class="col-lg-4">
                <label for="currentPw">현재 비밀번호:</label>
            </div>
            <div class="col-lg-8">
                <input type="password" class="form-control" name="currentPw"
                       placeholder="현재 비밀번호" id="currentPw"
                       required minlength="6" maxlength="20">
            </div>
        </div>

        <div class="row my-2 w-100">
            <div class="col-lg-4">
                <label for="pw">새 비밀번호:</label>
            </div>
            <div class="col-lg-8">
                <input type="password" class="form-control" name="pw"
                       placeholder="새 비밀번호" id="pw"
                       required minlength="6" maxlength="20">
            </div>
        </div>

        <div class="row my-2 w-100">
            <div class="col-lg-4">
                <label for="currentPwCheck">새 비밀번호 확인:</label>
            </div>
            <div class="col-lg-8">
                <input type="password" class="form-control" name="currentPwCheck"
                       placeholder="비밀번호 확인" id="currentPwCheck"
                       required minlength="6" maxlength="20">
            </div>
        </div>

        <div class="row my-4 text-center">
            <div class="col">
                <button type="submit" class="btn btn-primary w-25" id="submit">
                    수정
                </button>
            </div>
        </div>

    </form>
</div>

<script>
    const passwordForm = $("#passwordForm");
    const currentPwCheck = $("#currentPwCheck");
    let checkedPw = false;

    $(function() {
        passwordForm.submit(function() {
            if (!checkedPw) {
                alert("새 비밀번호를 다시 확인해주세요")
                currentPwCheck.focus()
                return false;
            }
        })

        currentPwCheck.keyup(function() {
            checkedPw = $(this).val() === $("#pw").val();
        });
    })
</script>
</body>
</html>
