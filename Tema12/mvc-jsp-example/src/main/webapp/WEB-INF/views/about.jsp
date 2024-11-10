<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Descrierea site-ului</h1>
	<p>Paragraf descriptiv.</p>
	<h3>Date de contact</h3>
	<p>email: test.email@mail.com</p>
    <p>phoneNumber: +1234567</p>
    <img src="${pageContext.request.contextPath}/pictures/image.jpg" alt="Debug img" />
</body>
</html>