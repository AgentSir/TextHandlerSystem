<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="label.title"/></title>

        <style>
            <%@include file='/css/bootstrap.css' %>
        </style>

        <style>
            <%@include file='/css/custom.css' %>
        </style>

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="<c:url value="/resources/js/jquery-1.11.3.min.js" />"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
        <script src="<c:url value="/resources/js/full-statistics.js" />"></script>
    </head>
    <body>

        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>

        <div class="container">
            <div class="row">
                <div class="span12">

                    <nav class="navbar navbar-default">
                        <div class="container-fluid">
                            <div class="navbar-header">
                                <div class="navbar-brand"><spring:message code="label.title"/></div>
                            </div>
                            <div>
                                <ul class="nav navbar-nav visible-sm visible-md visible-lg">
                                    <li class="active"><a href="${contextPath}/"><spring:message code="label.home.page"/></a></li>
                                    <li>
                                        <a href="${contextPath}/search">
                                            <spring:message code="label.search"/>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="${contextPath}/text">
                                            <spring:message code="label.process.text"/>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </nav>

                </div>
            </div>
        </div>

        <div class="container">
            <div class="row">
                <div class="span12">
                    <div class="center">

                        <div class="page-header" align="center">
                            <h1><spring:message code="label.title"/></h1>
                        </div>

                        <h4 align="center"><spring:message code="label.description"/></h4>

                        <div align="center">
                            <div class="form-group">
                                <button id="show-all-files-statistics" name="submit" type="submit" class="btn btn-primary ">
                                    <spring:message code="label.file.statistics"/>
                                </button>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>

        <div class="container">
            <div class="row">
                <div class="span12">
                    <div class="table">

                        <table id="files-statistics" class="table table-bordered table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>
                                        <spring:message code="label.file.name"/>
                                    </th>
                                    <th>
                                        <spring:message code="label.longest.word"/>
                                    </th>
                                    <th>
                                        <spring:message code="label.smallest.word"/>
                                    </th>
                                    <th>
                                        <spring:message code="label.length"/>
                                    </th>
                                    <th>
                                        <spring:message code="label.average.word.length"/>
                                    </th>
                                </tr>
                            </thead>
                            <tbody id="fs-tbody">
                            </tbody>
                        </table>

                    </div>
                </div>
            </div>
        </div>            

        <div id="lines-modal-dialog" class="modal fade">
            <div class="modal-dialog modal-dialog-custom">
                <div class="modal-content">
                    <div class="modal-header modal-header-custom">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">
                            <spring:message code="label.file.statistics.table.name"/>
                        </h4>
                    </div>
                    <div class="modal-body">

                        <table id="file-internal-statistics" class="table table-striped custab">
                            <thead>
                                <tr>
                                    <th>
                                        <spring:message code="label.line.id"/>
                                    </th>
                                    <th>
                                        <spring:message code="label.longest.word"/>
                                    </th>
                                    <th>
                                        <spring:message code="label.smallest.word"/>
                                    </th>
                                    <th>
                                        <spring:message code="label.length"/>
                                    </th>
                                    <th>
                                        <spring:message code="label.average.word.length"/>
                                    </th>
                                </tr>
                            </thead>
                        </table>

                    </div>
                    <div class="modal-footer">
                        <button type="button" id ="close_dialog" class="btn btn-default" data-dismiss="modal" aria-hidden="true">
                            <spring:message code="label.close.modal.dialog"/>
                        </button>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>


