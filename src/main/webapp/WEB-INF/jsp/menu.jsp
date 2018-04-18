<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Меню выбранного кафе</title>
</head>
<body>
<section>
    Меню выбранного кафе
    <hr>

<c:choose>
    <c:when test="${not empty param.id}">
        <c:set var="cafeIdVar" value="${param.id}"/>
    </c:when>
    <c:otherwise>
        <c:set var="cafeIdVar" value="${cafeId}"/>
    </c:otherwise>
</c:choose>

<c:if test="${not empty cafeIdVar}">

    <a href="/admin/cafe/meal/create?cafeId=${cafeIdVar}">Add menu</a>
    <hr/>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${meals}" var="meal">
            <jsp:useBean id="meal" scope="page" type="ru.graduate.topjava.model.Meal"/>
            <tr>
                <td>${meal.name}</td>
                <td>${meal.price}</td>
                <td><a href="/admin/cafe/meal/update?id=${meal.id}&cafeId=${cafeIdVar}">update</a></td>
                <td><a href="/admin/cafe/meal/delete?id=${meal.id}&cafeId=${cafeIdVar}">delete</a></td>
            </tr>
        </c:forEach>
    </table>

</c:if>
</section>
</body>
</html>
