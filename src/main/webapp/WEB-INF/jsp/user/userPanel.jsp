<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Основоное окно пользователя</title>
</head>
<body>
<section>
    Основоное окно пользователя
    <hr>
    <form method="post" action="/user/vote">
        <c:forEach items="${menu.menuList}" var="menuVar">
            <p><input name="cafeId" type="radio" value="${menuVar.cafe.id}">${menuVar.cafe.name}</p>
            <%--<b><c:out value="${menuVar.cafe.name}"/></b>--%>

            <table border="1" cellpadding="8" cellspacing="0">
                <tbody>
                    <c:forEach items="${menuVar.meals}" var="mealVar">
                        <tr>
                            <td> <c:out value="${mealVar.name}"/> </td>
                            <td> <c:out value="${mealVar.price}"/> </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </c:forEach>

        <p><input type="submit" value="Выбрать"></p>
    </form>

</section>
</body>
</html>
