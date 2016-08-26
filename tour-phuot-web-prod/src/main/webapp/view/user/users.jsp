<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table border="1">
    <tr>
        <td>ID</td>
        <td>Name:</td>    
        <td>Phone</td>
        <td>Dia chi</td>
        <td>Role</td>
      </tr>
    <c:forEach items="${users}" var="item">    
      <tr>
        <td>${item.id}</td>
        <td>${item.username}</td>
        <td>${item.phone}</td>
        <td>${item.diadiem}</td>
<%--        <td>${lists.role}</td> --%>
         <td>
         
          <c:forEach items="${item.roles}" var="role">  
           ${role.role} <br/>
          </c:forEach>
         </td>
      </tr>
    </c:forEach>
    </table>