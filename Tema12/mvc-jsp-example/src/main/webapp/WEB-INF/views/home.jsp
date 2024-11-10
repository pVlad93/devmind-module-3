<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Bine ai venit in lumea Spring MVC!</h1>

	<P>Timpul pe server este: ${serverTime}.</p>

<%--	acesta este un action form care inregistreaza un user name--%>
	<form action="user" method="post">
		username: <input type="text" name="userName"><br>
		email: <input type="text" name="email"> <br>
        phone number: <input type="text" name="phoneNumber"> <br>
        birth date: <input type="text" name="birthDate"><br> <br>
		<input type="submit" value="Login">
	</form>
</body>
</html>