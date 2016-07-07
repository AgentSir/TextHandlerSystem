<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf8">
        <title>403</title>

        <style>
            <%@include file='/css/bootstrap.css' %>
        </style>

        <style>
            .center {
                width: 500px;
                padding: 10px;
                margin: auto;
                background: rgba(237, 255, 223, 0);
            }
        </style>
    </head>
    <body>

        <div class="container">
            <div class="row">
                <div class="span12">
                    <div class="center">
                        <div class="page-header" align="center">
                            <h1><spring:message code="label.title"/></h1>
                        </div>
                        <div align="center">
                            <h3> 403 </h3>
                        </div>
                        <a href="<c:url value="/" />">
                            <spring:message code="label.home.page"/>
                        </a>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>

