<%-- 
    Document   : create
    Created on : Jan 18, 2024, 12:49:28 PM
    Author     : Nguyen Tien Kha
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h3>Edit a toy</h3>
<hr/>
<form action="<c:url value="/toy/edit_handler.do"/>">
    Id : <br/>
    <input type="text"  value="${toy.id}" disabled/>
    <input type="hidden" name="id" value="${toy.id}"/>
    <br/>  
    Name : <br/>
    <input type="text" name="name" value="${toy.name}"/><br/>
    Price : <br/>
    <input type="number" name="price" value="${toy.price}"/><br/>
    Expired Date : <br/>
    <input type="date" name="expDate" value="<fmt:formatDate value="${toy.expDate}" pattern="yyyy-MM-dd"/>"/><br/>
    Brand : <br/>
   <!--<input type="text" name="brand" value="${param.brand}"/><br/>-->
    <select name="brand" size="1">
        <c:forEach var="brand" items="${list}">
            <option value="${brand.id}" ${brand.id==param.brand?"selected":""}>${brand.name}</option>
        </c:forEach>
    </select><br/>
    <input type="submit" value="Update"/>

</form>
<i style="color:red">${errorMsg}</i>
