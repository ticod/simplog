<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>카테고리 설정</title>

</head>
<body>
<div class="jumbotron text-center font-weight-bold"
     style="padding: 1%; margin: 0; width: 100%; height: 100%;">

    <div class="row" style="height: 45%; margin: 2% 0 2% 0;">
        <div class="col" style="height: 100%">
            <div class="container bg-white" style="height: 100%;">
                <canvas id="dailyHits" style="width: 100%; height: 100%;"></canvas>
            </div>
        </div>
    </div>

    <div class="row" style="height: 45%; margin: 2% 0 2% 0;">

        <div class="col" style="height: 100%">
            <div class="container bg-white" style="height: 100%;">
                <canvas id="categoryHits" style="width: 33%; height: 100%;"></canvas>
            </div>
        </div>

        <div class="col" style="height: 100%">
            <div class="container bg-white" style="height: 100%;">
                <br>
                <div>오늘의 컨텐츠</div>
                <br>
            </div>
        </div>

        <div class="col" style="height: 100%">
            <div class="container bg-white" style="height: 100%;">
                <br>
                <div>새로운 댓글</div>
                <br>
            </div>
        </div>

    </div>
</div>

<!-- chart.js -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.min.js"></script>
<script>
    const randomColorFactor = function() {
        return Math.round(Math.random() * 255);
    };

    const randomColor = function(opacity) {
        return "rgba(" + randomColorFactor() + ","
            + randomColorFactor() + ","
            + randomColorFactor() + ","
            + (opacity || '.3') + ")";
    };

    $(function() {
        const categoryHitsCtx = document.getElementById("categoryHits").getContext("2d");
        const dailyHitsCtx = document.getElementById("dailyHits").getContext("2d");
    })
</script>
</body>
</html>