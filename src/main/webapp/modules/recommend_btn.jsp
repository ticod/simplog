<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="">
    <form action="../modules/recommend.do" method="post">
        <input type="hidden" name="memberNum" value="${param.memberNum}">
        <input type="hidden" name="contentType" value="${param.contentType}">
        <input type="hidden" name="contentNum" value="${param.contentNum}">
        <c:if test="${param.isCancel}">
        <button class="btn btn-primary btn-sm">
            추천 취소
        </button>
        </c:if>
        <c:if test="${!param.isCancel}">
        <button class="btn btn-outline-primary btn-sm">
            추천
        </button>
        </c:if>
    </form>
</div>
