<%-- 
    Document   : create
    Created on : Jan 18, 2024, 12:49:28 PM
    Author     : Nguyen Tien Kha
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h3>Confirmation</h3>
<hr/>
<form action="<c:url value="/toy/delete_handler.do"/>">
    Are you sure to delete this toy (id=${id})?<br/>
    <input type="hidden" name="id" value="${id}"/>
    <input type="submit" value="Yes" name="op"/>
    <input type="submit" value="No" name="op"/>


</form>
<i style="color:red;front-style:italic;">${errorMsg}</i>
