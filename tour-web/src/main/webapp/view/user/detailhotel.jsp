<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="UTF-8"%>


<table border="1">
	<tr>
		<td>ID</td>
		<td>Name</td>
		<td>Price</td>
		<td>description</td>

	</tr>
	<c:forEach items="${list}" var="hotel">
		<tr>
			<td>${hotel.id}</td>
			<td>${hotel.name}</td>
			<td>${hotel.price}</td>
			<td>${hotel.description}</td>
		</tr>
	</c:forEach>
</table>