<%-- 
    Document   : create
    Created on : Jan 18, 2024, 12:49:28 PM
    Author     : Nguyen Tien Kha
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="row">
    <div class="col">
        <h3>Create a new toy</h3>
        <hr/>
        <form action="<c:url value="/toy/create_handler.do"/>">
            <div class="mb-3">
                <label for="id" >Id :</label>
                <input class="form-control" type="text" name="id" id="id" value="${param.id}"/>
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

            <button type="submit" value="create" class="btn btn-primary border-rounded"> <i class="bi bi-check-circle"></i> Create</button>

        </form>
        <i style="color:red">${errorMsg}</i>
    </div>

    <div class="col">

    </div>

</div>