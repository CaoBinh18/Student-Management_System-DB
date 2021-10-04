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
<%--            <div class="row">--%>
<%--                    <div class="col-sm-12">--%>
<%--                        <div class="card card-table">--%>
<%--                            <div class="card-header"><h1>Danh sách học sinh</h1>--%>
<%--&lt;%&ndash;                                <div class="tools dropdown"><span class="icon mdi mdi-download"></span><a class="dropdown-toggle" href="#" role="button" data-toggle="dropdown"><span class="icon mdi mdi-more-vert"></span></a>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    <div class="dropdown-menu" role="menu"><a class="dropdown-item" href="#">Action</a><a class="dropdown-item" href="#">Another action</a><a class="dropdown-item" href="#">Something else here</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                        <div class="dropdown-divider"></div><a class="dropdown-item" href="#">Separated link</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <span class="card-subtitle">This is a custom datable layout</span>&ndash;%&gt;--%>
<%--                                    <a class="btn btn-space btn-primary" href="student?action=create">Create Student</a>--%>
<%--                            </div>--%>
<%--                            <div class="card-body">--%>
<%--                                <table class="table table-striped table-hover table-fw-widget" id="table2">--%>
<%--                                    <thead>--%>
<%--                                    <tr>--%>
<%--                                        <th>Id</th>--%>
<%--                                        <th>Tên</th>--%>
<%--                                        <th>Email</th>--%>
<%--                                        <th>Ngày sinh</th>--%>
<%--                                        <th>Địa chỉ</th>--%>
<%--&lt;%&ndash;                                        <th>Điểm Trung Bình</th>&ndash;%&gt;--%>
<%--                                        <th>Action</th>--%>
<%--                                    </tr>--%>
<%--                                    </thead>--%>
<%--                                    <tbody>--%>
<%--                                        <c:forEach var="student" items="${listStudents}">--%>
<%--                                            <tr class="odd gradeX">--%>
<%--                                                <td><c:out value="${student.id}"/></td>--%>
<%--                                                <td><c:out value="${student.name}"/></td>--%>
<%--                                                <td><c:out value="${student.email}"/></td>--%>
<%--                                                <td><c:out value="${student.dob}"/></td>--%>
<%--                                                <td><c:out value="${student.address}"/></td>--%>
<%--&lt;%&ndash;                                                <td><c:out value="${student.gpa}"/></td>&ndash;%&gt;--%>
<%--                                                <td>--%>
<%--                                                    <a class="btn btn-warning" href="/student?action=edit&id=${student.id}" title="Edit">--%>
<%--                                                        <i class="fa fa-pencil-square-o" aria-hidden="true"></i>--%>
<%--                                                    </a>--%>
<%--                                                    <a class="btn btn-danger" href="/student?action=delete&id=${student.id}" title="Delete">--%>
<%--                                                        <i class="fa fa-ban" aria-hidden="true"></i>--%>
<%--                                                    </a>--%>
<%--                                                </td>--%>
<%--                                            </tr>--%>
<%--                                        </c:forEach>--%>
<%--                                    </tbody>--%>
<%--                                </table>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            <%@ include file="/layout/alert.jsp"%>--%>
<%--            </div>--%>
            <div class="row">
                <div class="col-sm-12">
                    <div class="card card-table">
                        <div class="card-header"><h1>Danh sách học sinh</h1>
<%--                            <div class="tools dropdown"><span class="icon mdi mdi-download"></span><a class="dropdown-toggle" href="#" role="button" data-toggle="dropdown"><span class="icon mdi mdi-more-vert"></span></a>--%>
<%--                                <div class="dropdown-menu" role="menu"><a class="dropdown-item" href="#">Action</a><a class="dropdown-item" href="#">Another action</a><a class="dropdown-item" href="#">Something else here</a>--%>
<%--                                    <div class="dropdown-divider"></div><a class="dropdown-item" href="#">Separated link</a>--%>
<%--                                </div>--%>
<%--                            </div>--%>
                            <a class="btn btn-space btn-primary" href="student?action=create">Create Student</a>
                        </div>
                        <div class="card-body">
                            <table class="table table-striped table-hover table-fw-widget" id="table1">
                                <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Tên</th>
                                    <th>Email</th>
                                    <th>Ngày sinh</th>
                                    <th>Địa chỉ</th>
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
            <script src="assets\lib\jquery\jquery.min.js" type="text/javascript"></script>
            <script src="assets\lib\perfect-scrollbar\js\perfect-scrollbar.min.js" type="text/javascript"></script>
            <script src="assets\lib\bootstrap\dist\js\bootstrap.bundle.min.js" type="text/javascript"></script>
            <script src="assets\js\app.js" type="text/javascript"></script>
            <script src="assets\lib\datatables\datatables.net\js\jquery.dataTables.js" type="text/javascript"></script>
            <script src="assets\lib\datatables\datatables.net-bs4\js\dataTables.bootstrap4.js" type="text/javascript"></script>
            <script src="assets\lib\datatables\datatables.net-buttons\js\dataTables.buttons.min.js" type="text/javascript"></script>
            <script src="assets\lib\datatables\datatables.net-buttons\js\buttons.flash.min.js" type="text/javascript"></script>
            <script src="assets\lib\datatables\jszip\jszip.min.js" type="text/javascript"></script>
            <script src="assets\lib\datatables\pdfmake\pdfmake.min.js" type="text/javascript"></script>
            <script src="assets\lib\datatables\pdfmake\vfs_fonts.js" type="text/javascript"></script>
            <script src="assets\lib\datatables\datatables.net-buttons\js\buttons.colVis.min.js" type="text/javascript"></script>
            <script src="assets\lib\datatables\datatables.net-buttons\js\buttons.print.min.js" type="text/javascript"></script>
            <script src="assets\lib\datatables\datatables.net-buttons\js\buttons.html5.min.js" type="text/javascript"></script>
            <script src="assets\lib\datatables\datatables.net-buttons-bs4\js\buttons.bootstrap4.min.js" type="text/javascript"></script>
            <script src="assets\lib\datatables\datatables.net-responsive\js\dataTables.responsive.min.js" type="text/javascript"></script>
            <script src="assets\lib\datatables\datatables.net-responsive-bs4\js\responsive.bootstrap4.min.js" type="text/javascript"></script>
            <script type="text/javascript">
                $(document).ready(function(){
                    //-initialize the javascript
                    App.init();
                    App.dataTables();
                });
            </script>
</body>
</html>