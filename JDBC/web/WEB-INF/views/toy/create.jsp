<%-- 
    Document   : create
    Created on : Jan 18, 2024, 12:49:28 PM
    Author     : Nguyen Tien Kha
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h3>Create a new toy</h3>
<hr/>
<form action="<c:url value="/toy/create_handler.do"/>">
    Id : <br/>
    <input type="text" name="id" value="${param.id}"/><br/>  
    Name : <br/>
    <input type="text" name="name" value="${param.name}"/><br/>
    Price : <br/>
    <input type="number" name="price" value="${param.price}"/><br/>
    Expired Date : <br/>
    <input type="date" name="expDate" value="${param.expDate}"/><br/>
    Brand : <br/>
    <!--<input type="text" name="brand" value="${param.brand}"/><br/>-->
    <select name="brand" size="1">
        <c:forEach var="brand" items="${list}">
            <option value="${brand.id}" ${brand.id==param.brand?"selected":""}>${brand.name}</option>
        </c:forEach>
    </select>
    <br/>
    <input type="submit" value="Create"/>

</form>
<i style="color:red">${errorMsg}</i>
