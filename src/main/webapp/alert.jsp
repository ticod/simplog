<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    <c:if test="${!empty msg}">
        alert("${msg}");
    </c:if>

    <c:if test="${empty url}">
        location.reload();
    </c:if>
    <c:if test="${!empty url}">
        location.href = "${url}";
    </c:if>
</script>