<%-- 
    Document   : main
    Created on : Jan 11, 2024, 1:45:55 PM
    Author     : Nguyen Tien Khacc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Latest compiled and minified CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

        <!-- Latest compiled JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
        <title>JDBC</title>

    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col">
                    <h1 style="text-align: center">JDBC</h1>
                    <hr/>         
                    <jsp:include page="/WEB-INF/views/${controller}/${action}.jsp"/>
                    <hr/>
                    <div style="text-align: center">Nguyen Tien KhaCCCCCCCCCCCCCCCCCCCC - FPT Students</div>
                </div>
            </div>
        </div>
    </body>
</html>
