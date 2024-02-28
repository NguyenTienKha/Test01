<%-- 
    Document   : list
    Created on : Jan 15, 2024, 1:49:05 PM
    Author     : Nguyen Tien Kha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
    a{
        text-decoration: none;
    }
</style>
<h3>List of Toys</h3>
<hr/>

<a href="<c:url value="/toy/create.do"/>" >Create</a><br/>

<table border="1" cellspacing="0" cellpadding="4" >
    <thead>
        <tr>
            <th>ID</th>       
            <th>Name</th>
            <th style="text-align: right">Price</th>
            <th style="text-align: right">Expired Date</th>
            <th>Brand ID</th>
            <th>Operations</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="toy" items="${list}">
            <tr>
                <td>${toy.id}</td>
                <td>${toy.name}</td>
                <td style="text-align: right"><fmt:formatNumber value="${toy.price}" type="currency"/></td>                
                <td style="text-align: right"><fmt:formatDate value="${toy.expDate}" pattern="MM-dd-yyyy"/></td>
                <td>${toy.brand}</td>
                <td style="display:flex;flex-wrap: no-wrap">
                    <div style="display:inline-block;margin:2px;font-weight: bold;border: 3px solid green;padding:2px"><a style="color: green;" href="<c:url value="/toy/edit.do?id=${toy.id}" />">EDIT</a></div>
                    <div style="display:inline-block;margin:2px;font-weight: bold;border: 3px solid red;padding:2px"><a style="color: red;" href="<c:url value="/toy/delete.do?id=${toy.id}" />">DELETE</a></div>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<i style="color:red">${errorMsg}</i>