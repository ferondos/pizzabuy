<%--
  Created by IntelliJ IDEA.
  User: Noirix
  Date: 09.02.2023
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
${pizzaName}
<div>
    <h1>pizzas</h1>
</div>
<div>
    <table>
        <tr>
            <td>id</td>
            <td>Name</td>
            <td>price</td>
            <td>category</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        <c:forEach var="pizza" items="${pizzas}">
            <tr>
                <td>${pizza.id}</td>
                <td>${pizza.name}</td>
                <td>${pizza.price}</td>
                <td>${pizza.category}</td>
                <td>
                    <button>Edit</button>
                </td>
                <td>
                    <button>Delete</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>


</body>
</html>
