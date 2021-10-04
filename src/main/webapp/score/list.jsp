<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Điểm Toán</title>
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
                        <div class="card-header"><h1>Điểm Toán</h1>
                        </div>
                        <div class="card-body">
                            <table class="table table-striped table-hover table-fw-widget" id="table2">
                                <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Tên</th>
                                    <th>Điểm bài cũ</th>
                                    <th>Điểm 15 phút</th>
                                    <th>Điểm 45 phút</th>
                                    <th>Điểm học kì</th>
<%--                                    <th>Ngày sinh</th>--%>
<%--                                    <th>Địa chỉ</th>--%>
                                    <%--                                        <th>Điểm Trung Bình</th>--%>
                                    <th>Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="math" items="${mathList}">
                                    <tr class="odd gradeX">
                                        <td><c:out value="${math.id}"/></td>
                                        <td><c:out value="${math.name}"/></td>
                                        <td><c:out value="${math.ktBaiCu}"/></td>
                                        <td><c:out value="${math.kt15p}"/></td>
                                        <td><c:out value="${math.kt45p}"/></td>
                                        <td><c:out value="${math.ktHocKi}"/></td>
<%--                                        <td><c:out value="${student.dob}"/></td>--%>
<%--                                        <td><c:out value="${student.address}"/></td>--%>
                                            <%--                                                <td><c:out value="${student.gpa}"/></td>--%>
                                        <td>
                                            <a class="btn btn-warning" href="/score?action=edit&id=${math.id}" title="Edit">
                                                <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                            </a>
<%--                                            <a class="btn btn-danger" href="/student?action=delete&id=${math.id}" title="Delete">--%>
<%--                                                <i class="fa fa-ban" aria-hidden="true"></i>--%>
<%--                                            </a>--%>
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