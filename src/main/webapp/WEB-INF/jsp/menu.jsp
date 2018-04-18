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

    <a href="/admin/cafe/meal/create">Add menu</a>
    <hr/>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Menu</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${meals}" var="meal">
            <jsp:useBean id="meal" scope="page" type="ru.graduate.topjava.model.Meal"/>
            <tr>
                <td>${meal.name}</td>
                <td>${meal.price}</td>
                <td><a href="/admin/cafe/menu?id=${meal.id}">menu</a></td>
                <td><a href="/admin/cafe/update?id=${meal.id}">update</a></td>
                <td><a href="/admin/cafe/delete?id=${meal.id}">delete</a></td>
            </tr>
        </c:forEach>
    </table>

</section>
</body>
</html>
