<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
</head>
<body>

<div class="align-self-center container-fluid d-flex flex-column p-0 m-5 w-75 border border-dark">

    <!-- 제목 부분 -->

    <div class="align-self-center text-right w-100" style="height: 1.5rem;">
        카테고리: ${currentCategory.ctName} &nbsp;
    </div>
    <div class="align-self-center row border border-light
            bg-dark text-white w-100 d-none d-md-flex"
         style="height: 2.5rem; font-size:1.2rem">
        <div class="col-md-2 d-none font-weight-bold border
            d-md-flex justify-content-center align-items-center">
            글 번호
        </div>
        <div class="col-md-7 col-sm-9 font-weight-bold border
            d-flex justify-content-center align-items-center">
            글 제목
        </div>
        <div class="col-md-3 col-sm-3 font-weight-bold border
            d-flex justify-content-center align-items-center">
            작성일
        </div>
    </div>

    <!-- 컨텐츠들 -->

    <c:if test="${boardCount <= 0}">
        <div class="align-self-center text-center border w-100">
            등록된 글이 없습니다.
        </div>
    </c:if>

    <c:if test="${boardCount > 0}">
        <c:forEach items="${boards}" var="board">
            <div class="align-self-center row border w-100" style="height: 3rem; font-size:1.3rem">
                <div class="col-md-2 d-none border
                d-md-flex justify-content-center align-items-center">
                    ${boardNum}
                </div>
                <div class="col-md-7 col-sm-12 border
                d-flex justify-content-center align-items-center">
                    <a href="post.blog?num=${board.bbNum}">
                        <c:if test="${board.bbSubject.length() > 30}">
                            ${fn:substring(board.bbSubject, 0, 30)}...
                        </c:if>
                        <c:if test="${board.bbSubject.length() <= 30}">
                            ${board.bbSubject}
                        </c:if>
                    </a>
                </div>
                <div class="col-md-3 border d-none
                d-md-flex justify-content-center align-items-center">
                    <fmt:formatDate value="${board.bbLastModifiedDatetime}"
                                    pattern="yyyy-MM-dd" />
                </div>
            </div>
            <c:set var="boardNum" value="${boardNum - 1}" />
        </c:forEach>
    </c:if>

    <form action="list.blog" method="post" id="paging">
        <input type="hidden" name="pageNum" id="pageNum" value="${pageNum}">

        <!-- 푸터 페이징 -->
        <div class="align-self-center row border w-100 m-0 p-0 pt-3">
            <div class="col font-weight-bold
                d-flex justify-content-center align-items-center">
                <ul class="pagination">

                    <!-- 이전 페이지 -->
                    <c:if test="${pageNum <= 1}">
                        <li class="page-item disabled">
                            <a class="page-link" href="#">&lt;</a>
                        </li>
                    </c:if>
                    <c:if test="${pageNum > 1}">
                        <li class="page-item">
                            <a class="page-link" href="#" onclick="movePage(${pageNum - 1})">&lt;</a>
                        </li>
                    </c:if>

                    <!-- 페이지 목록 -->
                    <c:forEach var="i" begin="${startPage}" end="${endPage}">
                        <c:if test="${i == pageNum}">
                            <li class="page-item active">
                                <a class="page-link" href="#">
                                    ${i}
                                </a>
                            </li>
                        </c:if>
                        <c:if test="${i != pageNum}">
                            <li class="page-item">
                                <a class="page-link" href="#" onclick="movePage(${i})">
                                    ${i}
                                </a>
                            </li>
                        </c:if>
                    </c:forEach>

                    <!-- 다음 페이지 -->
                    <c:if test="${pageNum >= pageCount}">
                        <li class="page-item disabled">
                            <a class="page-link" href="#">&gt;</a>
                        </li>
                    </c:if>
                    <c:if test="${pageNum < pageCount}">
                        <li class="page-item">
                            <a class="page-link" href="#" onclick="movePage(${pageNum + 1})">&gt;</a>
                        </li>
                    </c:if>
                </ul>
            </div>
        </div>
    </form>

</div>

<script>
function movePage(pageNum) {
    $("#pageNum").val(pageNum);
    $("#paging").submit();
}
</script>

</body>
</html>
