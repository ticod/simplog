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
<div class="jumbotron text-center font-weight-bold bg-light"
     style="width: 100%;">
    <form action="../process/category.do" method="post" id="form">
        <input type="hidden" name="blog" value="${blog}">

        <div class="row" style="height: 60vh;">
            <div class="col-6">
                <input type="radio" name="list" value="board" id="board" checked>
                <label for="board">글 위주의 레이아웃</label>
                <div class="container bg-white text-left" style="border: 1px solid black; height: 90%;">
                    <div class="container bg-light" style="border: 1px solid black; height: 10%; margin-top: 2%;">
                        게시글...
                    </div>
                    <div class="container bg-light" style="border: 1px solid black; height: 10%; margin-top: 2%;">
                        게시글...
                    </div>
                    <div class="container bg-light" style="border: 1px solid black; height: 10%; margin-top: 2%;">
                        게시글...
                    </div>
                    <div class="container bg-light" style="border: 1px solid black; height: 10%; margin-top: 2%;">
                        게시글...
                    </div>
                    <div class="container bg-light" style="border: 1px solid black; height: 10%; margin-top: 2%;">
                        게시글...
                    </div>
                    <div class="container bg-light" style="border: 1px solid black; height: 10%; margin-top: 2%;">
                        게시글...
                    </div>
                    <div class="container bg-light" style="border: 1px solid black; height: 10%; margin-top: 2%;">
                        게시글...
                    </div>
                    <div class="container bg-light text-center"
                         style="border: 1px solid black; width: 30%; height: 10%; margin-top: 2%;">
                        페이지 번호
                    </div>
                </div>
            </div>
            <div class="col-6">
                <input type="radio" name="list" value="image" id="image">
                <label for="image">이미지 위주의 레이아웃</label>
                <div class="container" style="border: 1px solid black; height: 90%; padding: 2%;">
                    <div class="row" style="height: 40%;">
                        <div class="col-6">
                            <div class="container_fluid" style="border: 1px solid black; height: 80%; margin: 2%;"></div>
                        </div>
                        <div class="col-6">
                            <div class="container_fluid" style="border: 1px solid black; height: 80%; margin: 2%;"></div>
                        </div>
                    </div>
                    <div class="row" style="height: 40%;">
                        <div class="col-6">
                            <div class="container_fluid" style="border: 1px solid black; height: 80%; margin: 2%;"></div>
                        </div>
                        <div class="col-6">
                            <div class="container_fluid" style="border: 1px solid black; height: 80%; margin: 2%;"></div>
                        </div>
                    </div>
                    <div class="container bg-light text-center"
                         style="border: 1px solid black; width: 30%; height: 10%; margin-top: 2%;">
                        페이지 번호
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-2">
                사이드 바 위치:
            </div>
            <div class="col-2">
                <label for="left">왼쪽</label>
                <input type="radio" name="sidebar" value="left" id="left" checked>
            </div>
            <div class="col-2">
                <label for="right">오른쪽</label>
                <input class="" type="radio" name="sidebar" value="right" id="right">
            </div>
        </div>
        <div class="row">

        </div>

    </form>
</div>
</body>
</html>