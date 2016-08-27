<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table border="1">
    <tr>
        <td>ID</td>
        <td>Service</td>
        <td>Number</td>
        <td>Type_id</td>
        <td>User_id</td>
        <td>User name</td>
        <td>Phone</td>
      </tr>
    <c:forEach items="${lists}" var="lists">    
      <tr>
        <td>${lists.id}</td>
        <td>${lists.service}</td>
        <td>${lists.number}</td>
        <td>${lists.type_id}</td>
        <td>${lists.user_id}</td>
       	<td>${lists.userEntity.username}</td>
       	<td>${lists.userEntity.phone}</td>
      </tr>
    </c:forEach>
    </table>