<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>블로그 삭제</title>
</head>
<body>
<div class="jumbotron text-center font-weight-bold"
     style="width: 50%;">
    <form action="../process/delete.do" method="post" id="form">
        <div class="form-group">
            블로그를 정말 삭제하시겠습니까? <br>
            데이터는 복구되지 않습니다. <br>
            <br>
            <label for="name">
                블로그 명을 입력하세요
                <div class="text-danger"> [ ${blog} ] </div>
            </label>
            <input class="form-control" type="text" id="name" name="name" placeholder="${blog}" required>
            <div class="text-danger" id="valid-check"></div>
        </div>
        <button type="submit" class="btn btn-danger" id="submit">삭제</button>
    </form>
</div>
<script>
    $(function() {
        $("#form").submit(function() {
            if ($("#name").val() !== "${blog}") {
                $("#valid-check").html("블로그 명을 확인하세요");
                return false;
            }
        })
    })
</script>
</body>
</html>