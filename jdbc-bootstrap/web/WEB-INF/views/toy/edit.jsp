<%-- 
    Document   : create
    Created on : Jan 18, 2024, 12:49:28 PM
    Author     : Nguyen Tien Kha
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="row">
    <div class="col">
        <h3>Edit a toy</h3>
        <hr/>
        <form action="<c:url value="/toy/edit_handler.do"/>">
            <div class="mb-3">
                <label for="id" >Id :</label>
                <input type="text"  value="${toy.id}" class="form-control" disabled/>
                <input  type="hidden" name="id" id="id" value="${param.id}"/>
            </div>
            <div class="mb-3">
                <label for="name" >Name :</label>
                <input class="form-control" type="text" name="name" id="name" value="${param.name}"/>
            </div>
            <div class="mb-3">
                <label for="price" >Price :</label>
                <input class="form-control" type="number" name="price" id="price" value="${param.price}"/>
            </div>
            <div class="mb-3">
                <label for="expDate" >Expired Date :</label>
                <input class="form-control" type="date" name="expDate" id="expDate" value="${param.expDate}"/>
            </div>
            <div class="mb-3">
                <label for="brand" >Brand : </label>
                <select class="form-control" name="brand" size="1">
                    <c:forEach var="brand" items="${list}">
                        <option value="${brand.id}" ${brand.id==param.brand?"selected":""}>${brand.name}</option>
                    </c:forEach>
                </select>
            </div>

            <button type="submit" value="update" class="btn btn-success border-rounded"> <i class="bi bi-pencil-square"></i> Edit</button>
        </form>
        <i style="color:red">${errorMsg}</i>
    </div>
    <div class="col"></div>
</div>

