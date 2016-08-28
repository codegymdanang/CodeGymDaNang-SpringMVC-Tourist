<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table id="listOfEmployees" border="1">
    <tr>
        <td>ID</td>
        <td>User Name</td>
        <td>Password</td>
        <td>Image</td>
        <td>Phone</td>
      </tr>
    <c:forEach items="${lists}" var="user">    
      <tr>
        <td>${user.id}</td>
        <td>${user.username}</td>
        <td>${user.password}</td>
        <td>${user.image}</td>
       	<td>${user.phone}</td>
      </tr>
    </c:forEach>
    </table>