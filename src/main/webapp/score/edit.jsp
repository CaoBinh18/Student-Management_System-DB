<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Score</title>
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
                        <div class="card-header card-header-divider"><h1>Chỉnh sửa điểm học sinh</h1><span class="card-subtitle">This is the default bootstrap form layout</span></div>
                        <div class="card-body">
                            <form data-parsley-validate="" novalidate="" method="post">
                                <div class="form-group">
                                    <label>Tên học sinh</label>
                                    <input class="form-control" type="text" name="name" parsley-trigger="change" readonly value="${score.name}" autocomplete="off">
                                </div>
                                <div class="form-group">
                                    <label>Điểm Bài Cũ</label>
                                    <input class="form-control" type="number" name="ktbc" parsley-trigger="change" required="" value="${score.ktBaiCu}" autocomplete="off">
                                </div>
                                <div class="form-group">
                                    <label>Điểm 15 phút</label>

                                    <input class="form-control" type="number" name="kt15p" parsley-trigger="change" value="${score.kt15p}" required="">
                                </div>
                                <div class="form-group">
                                    <label>Điểm 45 phút</label>
                                    <input class="form-control" type="number" name="kt45p"  required="" value="${score.kt45p}">
                                </div>
                                <div class="form-group">
                                    <label>Điểm Học Kì</label>
                                    <input class="form-control" type="number" name="kthk" required="" value="${score.ktHocKi}">
                                </div>
                                <div class="row pt-0 pt-sm-5">
                                    <div class="col-sm-6 pl-0">
                                        <p class="text-right">
                                            <button class="btn btn-space btn-primary" type="submit">Submit</button>
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
</div>
</body>
<%@ include file="/layout/script.jsp"%>
</html>