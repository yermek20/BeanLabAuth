<%--
  Created by IntelliJ IDEA.
  User: CCTV-2
  Date: 16.02.2020
  Time: 2:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%@include file="templates/head.jsp"%>
</head>
<body>
<div class="container mt-5">

    <div class="row mb-3">
        <div class="col-sm-6">
            <form action="/login" method="post">

                    <div class="form-group row">
                        <label  class="col-sm-2 col-form-label">Email</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" name="email" placeholder="">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label  class="col-sm-2 col-form-label">Password</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" name="password">
                        </div>
                    </div>
                    <div class="form-group">
                        <button class="btn btn-primary">LOGIN</button>
                    </div>

            </form>
        </div>
    </div>



</div>
</body>
</html>


