<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>dfd</h2>
<c:if test="${1 == 1}">
    <h1>True!</h1>
</c:if>
<c:if test="${1 == 1}">
    <h1>False!</h1>
</c:if>
<%= application.getContextPath() %>
한글이 다 깨지나?
</body>
</html>
