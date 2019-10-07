<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://topjava.javawebinar.ru/functions" %>
<html>
<head>
    <title>Meal</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<section>
    <h3><a href="index.html">Home</a></h3>
    <hr/>
    <h2>Meals</h2>
    <form method="get" action="clients">
        <input type="hidden" name="action" value="filter">
        <dl>
            <dt>From Date:</dt>
            <dd><input type="date" name="startDate" value="${param.startDate}"></dd>
        </dl>
        <dl>
            <dt>To Date:</dt>
            <dd><input type="date" name="endDate" value="${param.endDate}"></dd>
        </dl>
        <dl>
            <dt>From Time:</dt>
            <dd><input type="time" name="startTime" value="${param.startTime}"></dd>
        </dl>
        <dl>
            <dt>To Time:</dt>
            <dd><input type="time" name="endTime" value="${param.endTime}"></dd>
        </dl>
        <button type="submit">Filter</button>
    </form>
    <hr/>
    <a href="clients?action=create">Add Client</a>
    <br><br>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>first name</th>
            <th>last name</th>
            <th>date time last contact</th>
            <th>status</th>
            <th>satisfaction</th>
            <th>address</th>
            <th>email</th>
            <th>telephone Number</th>
        </tr>
        </thead>
        <c:forEach items="${clients}" var="client">
            <jsp:useBean id="client" type="ru.javawebinar.clients.model.Client"/>
            <tr data-mealExcess="${client}">
                <td>${client.firstName}</td>
                <td>${client.lastName}</td>
                <td>
                        <%--${client.dateTime.toLocalDate()} ${client.dateTime.toLocalTime()}--%>
                        <%--<%=TimeUtil.toString(client.getDateTime())%>--%>
                        <%--${fn:replace(client.dateTime, 'T', ' ')}--%>
                        ${fn:formatDateTime(client.dateTime)}
                </td>
                <td>${client.status}</td>
                <td>${client.satisfaction}</td>
                <td>${client.address}</td>
                <td>${client.email}</td>
                <td>${client.telephoneNumber}</td>
                <td><a href="clients?action=update&id=${client.id}">Update</a></td>
                <td><a href="clients?action=delete&id=${client.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>