<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Информация про все кафешки</title>
</head>
<body>
<section>
    Информация про все кафешки
    <hr>

    <a href="/admin/cafe/create"> Create cafe</a>
    <hr/>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Name</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${cafes}" var="cafe">
            <jsp:useBean id="cafe" scope="page" type="ru.graduate.topjava.model.Cafe"/>
            <tr>
                <td>${cafe.name}</td>
                <td><a href="/admin/cafe/update?id=${cafe.id}">update</a></td>
                <td><a href="/admin/cafe/delete?id=${cafe.id}">delete</a></td>
            </tr>
        </c:forEach>
    </table>

</section>
</body>
</html>


