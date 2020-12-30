function ajaxRecommendButton(memberNum,
                                      contentType,
                                      contentNum,
                                      selector,
                                      isCancel) {

    const params = {
        memberNum: memberNum,
        contentType: contentType,
        contentNum: contentNum,
        isCancel: isCancel
    }

    $.ajax("../modules/recommend_btn.jsp", {
        data: params,
        success: function(data) {
            $("#" + selector).html(data);
            console.log(data);
        },
        error: function(e) {
            alert("서버 오류: " + e.status);
        }
    })

}