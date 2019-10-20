<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Client</title>
    <link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
<section>
    <h3><a href="index.html">Home</a></h3>
    <hr>
    <h2>${param.action == 'create' ? 'Create client' : 'Edit client'}</h2>
    <jsp:useBean id="client" type="ru.javawebinar.clients.model.Client" scope="request"/>
    <!--   <form method="post" action="clients" >
        <input type="hidden" name="id" value="${client.id}">
        <dl>
            <dt>First name:</dt>
            <dd><input type="text" value="${client.firstName}" size=40 name="firstName" required></dd>
        </dl>
        <dl>
            <dt>Last name:</dt>
            <dd><input type="text" value="${client.lastName}" name="lastName" required></dd>
        </dl>
        <dl>
            <dt>Date time last contact:</dt>
            <dd><input type="datetime-local" value="${client.dateTime}" name="dateTime" required></dd>
        </dl>
        <dl>
            <dt>Status:</dt>
            <dd><input type="text" value="${client.status}" name="status" required></dd>
        </dl>
        <dl>
            <dt>Satisfaction:</dt>
            <dd><input type="text" value="${client.satisfaction}" name="satisfaction" required></dd>
        </dl>
        <dl>
            <dt>Address:</dt>
            <dd><input type="text" value="${client.address}" name="address" required></dd>
        </dl>
        <dl>
            <dt>Email:</dt>
            <dd><input type="text" value="${client.email}" name="email" required></dd>
        </dl>
        <dl>
            <dt>Telephone number:</dt>
            <dd><input type="text" value="${client.telephoneNumber}" name="telephoneNumber" required></dd>
        </dl>
       <dl>
            <dt>Image name:</dt>
            <dd><input type="text" value="${client.imagePath}" name="imagePath" required></dd>
        </dl>
        <dl>
            <dt>Image:</dt>
            <dd><input type="image" src="images//${client.imagePath}"></dd>
        </dl>
        <img src="images/${client.imagePath}" >
        <button type="submit">Save</button>
        <button onclick="window.history.back()" type="button">Cancel</button>
    </form> -->

    <form action = "clients" method = "post" enctype = "multipart/form-data">

        <input type="hidden" name="id" value="${client.id}">
        <dl>
            <dt>First name:</dt>
            <dd><input type="text" value="${client.firstName}" size=40 name="firstName" required></dd>
        </dl>
        <dl>
            <dt>Last name:</dt>
            <dd><input type="text" value="${client.lastName}" name="lastName" required></dd>
        </dl>
        <dl>
            <dt>Date time last contact:</dt>
            <dd><input type="datetime-local" value="${client.dateTime}" name="dateTime" required></dd>
        </dl>
        <dl>
            <dt>Status:</dt>
            <dd><input type="text" value="${client.status}" name="status" required></dd>
        </dl>
        <dl>
            <dt>Satisfaction:</dt>
            <dd><input type="text" value="${client.satisfaction}" name="satisfaction" required></dd>
        </dl>
        <dl>
            <dt>Address:</dt>
            <dd><input type="text" value="${client.address}" name="address" required></dd>
        </dl>
        <dl>
            <dt>Email:</dt>
            <dd><input type="text" value="${client.email}" name="email" required></dd>
        </dl>
        <dl>
            <dt>Telephone number:</dt>
            <dd><input type="text" value="${client.telephoneNumber}" name="telephoneNumber" required></dd>
        </dl>
        <dl>
            <dt>Image:</dt>
            <img src="${pageContext.request.contextPath}/images/${client.imagePath}">                             <!-- ?????????????????????????   -->
        </dl>
        <input type="hidden" name="imagePath" value="${client.imagePath}">

        <input type = "file" name = "file" size = "50" />
        <input type = "submit"/>
    </form>
</section>
</body>
</html>
