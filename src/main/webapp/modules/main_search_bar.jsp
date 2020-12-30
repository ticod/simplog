<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="border border-secondary bg-dark p-2">
    <form action="search.do" method="post"
          class="form-inline d-flex justify-content-center row px-5">
        <select class="form-control col-lg-1" name="blogType" id="blogType" required>
            <option value="">분야 선택</option>
            <c:forEach items="${blogTypes}" var="blogType">
                <option value="${blogType.btType}">${blogType.btName}</option>
            </c:forEach>
        </select>
        <select class="form-control col-lg-1" name="category" id="category" style="margin:0.5%;" required>
            <option value="">어디서?</option>
            <option value="blog">블로그</option>
            <option value="board">글</option>
            <option value="member">유저</option>
        </select>
        <input class="form-control col" type="text"
               name="target" id="target" placeholder="검색하세요!"
               style="width: 60%; margin:0.5%;">
        <input type="image" class="form-control col-lg-1"
               src="" id="search_icon"
               style="object-fit: contain;">
    </form>
</div>