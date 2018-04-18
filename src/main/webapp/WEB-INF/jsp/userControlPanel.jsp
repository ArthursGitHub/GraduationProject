<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Информация про всех юзеров</title>
</head>
<body>
<section>
    Информация про всех юзеров
    <hr>

    <a href="/admin/user/create">Create user</a>
    <hr/>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Name</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${users}" var="user">
            <jsp:useBean id="user" scope="page" type="ru.graduate.topjava.model.User"/>
            <tr>
                <td>${user.name}</td>
                <td><a href="/admin/user/update?id=${user.id}">update</a></td>
                <td><a href="/admin/user/delete?id=${user.id}">delete</a></td>
            </tr>
        </c:forEach>
    </table>

</section>
</body>
</html>
