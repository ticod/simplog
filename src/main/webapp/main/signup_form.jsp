<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 가입</title>
</head>
<body>

<div class="align-self-center w-50 m-5">
<form method="post" action="signup.do" id="sighupForm">
    <div class="row my-4">
        <div class="col-lg-3">
            <label for="id">아이디:</label>
        </div>
        <div class="col-lg-6">
            <input type="text" class="form-control" name="id"
                   placeholder="아이디" id="id" required>
        </div>
        <div class="col-lg-3 col">
            <button type="button" class="btn btn-primary w-100" id="idValidCheck">
                중복 확인
            </button>
        </div>
    </div>
    <div class="row my-4">
        <div class="col-lg-3">
            <label for="pw">비밀번호:</label>
        </div>
        <div class="col-lg-6">
            <input type="password" class="form-control" name="pw"
                   placeholder="비밀번호" id="pw" required minlength="6" maxlength="20">
        </div>
    </div>
    <div class="row my-4">
        <div class="col-lg-3">
            <label for="pwCheck">비밀번호 확인:</label>
        </div>
        <div class="col-lg-6">
            <input type="password" class="form-control"
                   placeholder="비밀번호 재입력" id="pwCheck" required minlength="6" maxlength="20">
        </div>
    </div>
    <div class="row my-4">
        <div class="col-lg-3">
            <label for="email">이메일:</label>
        </div>
        <div class="col-lg-6 col">
            <input type="email" class="form-control" name="email"
                   placeholder="이메일" id="email" required>
        </div>
        <div class="col-lg-3 col">
            <button type="button" class="btn btn-primary w-100" id="authNumberSubmit">
                인증번호 전송
            </button>
        </div>
    </div>
    <div class="row my-4">
        <div class="col-lg-3">
            <label for="authNumber">인증 번호:</label>
        </div>
        <div class="col-lg-6">
            <input type="text" class="form-control"
                   placeholder="인증 번호" id="authNumber" required>
        </div>
        <div class="col-lg-3 col">
            <button type="button" class="btn btn-primary w-100" id="authNumberCheck">
                확인
            </button>
        </div>
    </div>
    <div class="row my-4 text-center" id="authAlert"></div>
    <div class="row my-4 text-center">
        <div class="col">
            <button type="submit" class="btn btn-primary w-50 disabled" id="submit">
                회원 가입 완료
            </button>
        </div>
    </div>

</form>
</div>

<div class="invisible position-absolute" id="mailCheck"></div>

<script>
    const authNumberSubmit = $("#authNumberSubmit");
    const authNumberCheck =  $("#authNumberCheck");
    const idValidCheck = $("#idValidCheck");
    const pwCheck = $("#pwCheck");

    let finishAuth = false;
    let finishCheckedPw = false;

    $(function() {
        $("#sighupForm").submit(function(event) {
            let isValid = isValidId($("#id").val());
            console.log(isValid);
            if (!finishAuth || !finishCheckedPw || !isValid) {
                event.preventDefault();
            }
            if (!finishCheckedPw) {
                alert("비밀번호를 확인하세요");
            }
            if (!finishAuth) {
                alert("이메일 인증을 해주세요");
            }
            if (!isValid) {
                alert("아이디 중복 확인을 해주세요");
            }
        });

        pwCheck.keyup(function() {
            if ($(this).val() === $("#pw").val()) {
                finishCheckedPw = true;
            } else {
                finishCheckedPw = false;
            }
        });

        authNumberSubmit.click(emailSubmit);
        authNumberCheck.click(authCheck);
        idValidCheck.click(checkId);

    })

    function emailSubmit() {
        const email = $("#email").val();
        const params = {
            email: email
        };
        $.ajax("mail_auth.do", {
            data: params,
            success: function(data) {
                $("#mailCheck").html(data);
                console.log($("#success").html());
                if ($("#success").html() === "true") {
                    $("#email").attr("readonly", "true");
                    authNumberSubmit.off();
                    authNumberSubmit.addClass("disabled");
                    authNumberSubmit.text("전송 완료");
                    setTimeout(function () {
                        $("#email").attr("readonly", "false");
                        authNumberSubmit.click(emailSubmit);
                        authNumberSubmit.removeClass("disabled");
                        authNumberSubmit.text("인증번호 재전송");
                    }, 300000);
                }
            },
            error: function(e) {
                alert("서버 오류: " + e.status);
            }
        })
    }

    function authCheck() {
        const number = $("#authNumber").val();
        const email = $("#email").val();
        const params = {
            number: number,
            email: email
        }
        $.ajax("mail_auth_check.do", {
            data: params,
            success: function(data) {
                if (data !== "true") {
                    const html = '<div class="alert alert-danger w-100">' +
                        '<strong>인증 실패!</strong> 이메일과 인증 번호를 다시 확인하세요.' +
                        '</div>';
                    $("#authAlert").html(html);
                } else {
                    const html = '<div class="alert alert-success w-100">' +
                        '<strong>인증 성공!</strong> 남은 정보를 작성하고 회원 가입을 끝마치세요!' +
                        '</div>';
                    $("#authAlert").html(html);

                    $("#email").attr("readonly", "true");
                    $("#authNumber").attr("readonly", "true");

                    authNumberSubmit.addClass("disabled");
                    authNumberCheck.addClass("disabled");
                    authNumberSubmit.off();
                    authNumberCheck.off();

                    $("#submit").removeClass("disabled")
                    authNumberCheck.val("인증 완료");
                    finishAuth = true;
                }
            },
            error: function(e) {
                alert("서버 오류: " + e.status);
            }
        })
    }

    function checkId() {
        let isValid = false;
        const id = $("#id");
        const params = {
            id: id.val()
        };
        if (id.val().length > 15 || id.val().length < 4) {
            alert("아이디는 4자 이상, 15자 이하로 지어주세요")
        } else if (!isValidId(id.val())) {
            console.log(isValidId(id.val()))
            alert("아이디는 영어 소문자, 숫자만 허용합니다.");
        } else {
            $.ajax("id_check.do", {
                data: params,
                success: function(data) {
                    if (data === "true") {
                        alert("사용 가능한 아이디입니다!");
                        return true;
                    } else {
                        alert("이미 존재하는 아이디입니다");
                    }
                },
                error: function(e) {
                    alert("서버 오류: " + e.status);
                }
            })
        }
        return isValid;
    }

    function isValidId(id) {
        const pattern = /^[a-z0-9+]*$/;

        return pattern.test(id);
    }
</script>
</body>
</html>
