<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>



<html>
<head>
    <title>Форма редактирования кафе</title>
</head>
<body>

<section>
    <%--<h3><a href="/">Home</a></h3>--%>
    <%--<h3><spring:message code="${cafe.isNew() ? 'cafe.create_cafe' : 'cafe.edit_cafe'}"/></h3>--%>
    <hr>
    <jsp:useBean id="cafe" type="ru.graduate.topjava.model.Cafe" scope="request"/>
    <form method="post" action="/admin/cafe">
        <input type="hidden" name="id" value="${cafe.id}">
        <dl>
            <dt>Name:</dt>
            <dd><input type="text" value="${cafe.name}" name="name" required></dd>
        </dl>
        <button type="submit">save</button>
        <button onclick="window.history.back()" type="button">cancel</button>
    </form>
</section>


</body>
</html>