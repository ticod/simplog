$(function() {
    $.ajax("../modules/main_search_bar.do", {
        success: function(data) {
            $("#main_search_bar").html(data);
            $("#search_icon").attr("src", "../resources/imgs/search.png");
        },
        error: function(error) {
            alert("서버 오류, " + error.status);
        }
    })
})