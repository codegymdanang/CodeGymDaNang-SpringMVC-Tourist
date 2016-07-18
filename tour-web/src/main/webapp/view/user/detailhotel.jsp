<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="UTF-8"%>


<table border="1">
	<tr>
		<td>ID</td>
		<td>Name</td>

	</tr>
	<c:forEach items="${list}" var="location">
		<tr>
			<td>${location.id}</td>
		<%-- 	<c:forEach items="${location.ListHotel}" var="hotel">
			<td>${hotel.name}</td> --%>
			<%-- </c:forEach> --%>
			<td>${location.name}</td>
		</tr>
	</c:forEach>
</table>