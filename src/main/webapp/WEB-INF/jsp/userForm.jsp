<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>



<html>
<head>
    <title>Форма редактирования юзера</title>
</head>
<body>

<section>
    <%--<h3><a href="/">Home</a></h3>--%>
    <%--<h3><spring:message code="${user.isNew() ? 'user.create_user' : 'user.edit_user'}"/></h3>--%>
    <hr>
    <jsp:useBean id="user" type="ru.graduate.topjava.model.User" scope="request"/>
    <form method="post" action="/admin/user">
        <input type="hidden" name="id" value="${user.id}">
        <dl>
            <dt>Name:</dt>
            <dd><input type="text" value="${user.name}" name="name" required></dd>
        </dl>
        <button type="submit">save</button>
        <button onclick="window.history.back()" type="button">cancel</button>
    </form>
</section>


</body>
</html>