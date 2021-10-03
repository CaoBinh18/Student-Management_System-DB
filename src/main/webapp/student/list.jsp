<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>List Student</title>
    <%@ include file="/layout/head.jsp"%>
</head>
<body>
    <div class="be-wrapper be-fixed-sidebar">
        <%@ include file="/layout/header.jsp"%>
        <%@ include file="/layout/navigation-bar.jsp"%>
        <div class="be-content">
        <div class="main-content container-fluid">
            <div class="row">
                    <div class="col-sm-12">
                        <div class="card card-table">
                            <div class="card-header"><h1>Danh sách học sinh</h1>
<%--                                <div class="tools dropdown"><span class="icon mdi mdi-download"></span><a class="dropdown-toggle" href="#" role="button" data-toggle="dropdown"><span class="icon mdi mdi-more-vert"></span></a>--%>
<%--                                    <div class="dropdown-menu" role="menu"><a class="dropdown-item" href="#">Action</a><a class="dropdown-item" href="#">Another action</a><a class="dropdown-item" href="#">Something else here</a>--%>
<%--                                        <div class="dropdown-divider"></div><a class="dropdown-item" href="#">Separated link</a>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                                <span class="card-subtitle">This is a custom datable layout</span>--%>
                                    <a class="btn btn-space btn-primary" href="student?action=create">Create Student</a>
                            </div>
                            <div class="card-body">
                                <table class="table table-striped table-hover table-fw-widget" id="table2">
                                    <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>Tên</th>
                                        <th>Email</th>
                                        <th>Ngày sinh</th>
                                        <th>Địa chỉ</th>
<%--                                        <th>Điểm Trung Bình</th>--%>
                                        <th>Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="student" items="${listStudents}">
                                            <tr class="odd gradeX">
                                                <td><c:out value="${student.id}"/></td>
                                                <td><c:out value="${student.name}"/></td>
                                                <td><c:out value="${student.email}"/></td>
                                                <td><c:out value="${student.dob}"/></td>
                                                <td><c:out value="${student.address}"/></td>
<%--                                                <td><c:out value="${student.gpa}"/></td>--%>
                                                <td>
                                                    <a class="btn btn-warning" href="/student?action=edit&id=${student.id}" title="Edit">
                                                        <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                                    </a>
                                                    <a class="btn btn-danger" href="/student?action=delete&id=${student.id}" title="Delete">
                                                        <i class="fa fa-ban" aria-hidden="true"></i>
                                                    </a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            <%@ include file="/layout/alert.jsp"%>
            </div>
        </div>
    </div>
</body>
</html>