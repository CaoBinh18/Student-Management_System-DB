<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Student</title>
    <%@ include file="/layout/head.jsp"%>
</head>
<body>
<div class="be-wrapper be-fixed-sidebar">
    <%@ include file="/layout/header.jsp"%>
    <%@ include file="/layout/navigation-bar.jsp"%>
    <div class="be-content">
        <div class="main-content container-fluid">
            <div class="row">
                <div class="col-lg-6">
                    <div class="card card-border-color card-border-color-primary">
                        <div class="card-body">
                            <form data-parsley-validate="" novalidate="" method="post">
                                <div class="form-group">
                                    <label for="inputUserName">Tên học sinh</label>
                                    <input class="form-control" id="inputUserName" type="text" name="name" parsley-trigger="change" readonly value="${student.name}" autocomplete="off">
                                </div>
                                <div class="form-group">
                                    <label for="inputEmail">Email</label>
                                    <input class="form-control" id="inputEmail" type="email" name="email" parsley-trigger="change" readonly value="${student.email}" autocomplete="off">
                                </div>
                                <div class="form-group">
                                    <label>Ngày sinh</label>

                                    <input class="form-control" id="inputPassword" name="dob" parsley-trigger="change" value="${student.dob}" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="inputRepeatPassword">Địa chỉ</label>
                                    <input class="form-control" name="address" id="inputRepeatPassword" readonly value="${student.address}">
                                </div>
                                <div class="row pt-0 pt-sm-5">
                                    <div class="col-sm-6 pl-0">
                                        <p class="text-right">
                                            <button class="btn btn-space btn-primary" type="submit">Delete</button>
                                            <%--                                            <button class="btn btn-space btn-secondary">Cancel</button>--%>
                                        </p>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <%@ include file="/layout/alert.jsp"%>
        </div>
    </div>
</div>
</body>
<%@ include file="/layout/script.jsp"%>
</html>