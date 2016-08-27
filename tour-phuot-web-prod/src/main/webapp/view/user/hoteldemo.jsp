<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<title>Employee Management</title>
<style>
.error {
	color: #ff0000;
	font-weight: bold;
}

#listFood tr:first-child {
	font-weight: bold;
}
</style>
</head>
<body>
	<table id=foodList border="1">
		<tr>
			<td>ID</td>
			<td>NAME</td>
			<td>LOCATION NAME</td>
		</tr>
		<c:forEach items="${list}" var="food">
			<tr>
				<td>${food.id}</td>
				<td>${food.name}</td>
				<td>${food.locationEntity.name}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>