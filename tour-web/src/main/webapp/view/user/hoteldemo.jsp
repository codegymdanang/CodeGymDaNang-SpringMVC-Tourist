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

#listOfEmployees tr:first-child {
	font-weight: bold;
}
</style>
</head>
<body>
	<table id="listHotel" border="1">
		<tr>
			<td>Name</td>
			<td>Phone</td>
		</tr>
		<c:forEach items="${list}" var="hotel">
			<tr>
				<td>${hotel.getName()}</td>
				<td>${hotel.getPhone()}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>