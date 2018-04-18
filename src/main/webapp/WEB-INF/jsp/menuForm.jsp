<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>



<html>
<head>
    <title>Форма редактирования меню</title>
</head>
<body>

<section>
    <%--<h3><a href="/">Home</a></h3>--%>
    <%--<h3><spring:message code="${meal.isNew() ? 'meal.create_user' : 'meal.edit_user'}"/></h3>--%>
    <hr>
    <jsp:useBean id="meal" type="ru.graduate.topjava.model.Meal" scope="request"/>
    <form method="post" action="/admin/cafe/meal">
        <input type="hidden" name="id" value="${meal.id}">
        <input type="hidden" name="cafeId" value="${param.cafeId}">
        <dl>
            <dt>Name:</dt>
            <dd><input type="text" value="${meal.name}" name="name" required></dd>
            <dt>Price:</dt>
            <dd><input type="text" value="${meal.price}" name="price" required></dd>
        </dl>
        <button type="submit">save</button>
        <button onclick="window.history.back()" type="button">cancel</button>
    </form>
</section>


</body>
</html>