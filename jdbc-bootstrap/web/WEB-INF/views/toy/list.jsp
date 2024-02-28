<%-- 
    Document   : list
    Created on : Jan 15, 2024, 1:49:05 PM
    Author     : Nguyen Tien Kha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h3>List of Toys</h3>
<hr/>

<a class="text-decoration-none fw-bold" href="<c:url value="/toy/create.do"/>" >Create</a><br/>

<table class="table table-hover table-bordered">
    <thead >
        <tr>
            <th>ID</th>       
            <th>Name</th>
            <th style="text-align: right">Price</th>
            <th style="text-align: right">Expired Date</th>
            <th>Brand ID</th>
            <th>Operations</th>
        </tr>
    </thead>
    <tbody class="table-group-divider">
        <c:forEach var="toy" items="${list}">
            <tr>
                <td>${toy.id}</td>
                <td>${toy.name}</td>
                <td style="text-align: right"><fmt:formatNumber value="${toy.price}" type="currency"/></td>                
                <td style="text-align: right"><fmt:formatDate value="${toy.expDate}" pattern="MM-dd-yyyy"/></td>
                <td>${toy.brand}</td>
                <td >
                    <a class="fw-bold text-decoration-none" style="color: green;" href="<c:url value="/toy/edit.do?id=${toy.id}" />">EDIT</a>
                    <a class="fw-bold text-decoration-none" style="color: red;" href="<c:url value="/toy/delete.do?id=${toy.id}" />">DELETE</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<i style="color:red">${errorMsg}</i>