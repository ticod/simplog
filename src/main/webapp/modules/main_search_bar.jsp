<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="border border-secondary bg-dark p-2">
    <form action="search.do" method="post"
          class="form-inline d-flex justify-content-center row px-5">
        <select class="form-control col-lg-2" name="category" id="category" style="margin:0.5%;">
            <option value="all">전체</option>
            <option value="블로그">블로그</option>
            <option value="글">글</option>
            <option value="유저">유저</option>
        </select>
        <select class="form-control col-lg-2" name="type" id="type" style="margin:0.5%;">
            <option value="all">모든 분야</option>
            <option value="">생활</option>
            <option value="">IT</option>
            <option value="">여행</option>
            <option value="">먹거리</option>
            <option value="">영화</option>
            <option value="">문학</option>
            <option value="">디자인</option>
            <option value="">사진</option>
            <option value="">음악</option>
            <option value="">드라마/방송</option>
            <option value="">게임</option>
            <option value="">건강</option>
            <option value="">인테리어/DIY</option>
            <option value="">동물</option>
            <option value="">패션</option>
            <option value="">공연</option>
            <option value="">개발</option>
        </select>
        <input class="form-control col" type="text"
               name="target" id="target" placeholder="검색하세요!"
               style="width: 60%; margin:0.5%;">
        <input type="image" class="form-control col-lg-1"
               src="" id="search_icon"
               style="object-fit: contain;">
    </form>
</div>