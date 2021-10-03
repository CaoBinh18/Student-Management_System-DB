<div id="alert">
    <c:if test='${requestScope["success"] != null}'>
        <div class="alert alert-success alert-dismissible" role="alert">
            <button class="close" type="button" data-dismiss="alert" aria-label="Close"><span class="mdi mdi-close" aria-hidden="true"></span></button>
            <div class="icon"><span class="mdi mdi-check"></span></div>
            <div class="message"><strong>Add Success! </strong>${requestScope["error"]}</div>
        </div>
        <script>
            Swal.fire({
                icon: 'success',
                title: 'New student was created',
                showConfirmButton: false,
                timer: 1500
            })
        </script>
    </c:if>
    <c:if test='${requestScope["error"] != null}'>
<%--        <div class="alert alert-danger" style="position: fixed; bottom: 0; right: 0; left: 0">--%>
<%--            <button type="button" class="close" data-dismiss="alert">x</button>--%>
<%--            <strong>Error!</strong> ${requestScope["error"]}--%>
<%--        </div>--%>
        <div class="alert alert-danger alert-dismissible" role="alert">
            <button class="close" type="button" data-dismiss="alert" aria-label="Close"><span class="mdi mdi-close" aria-hidden="true"></span></button>
            <div class="icon"> <span class="mdi mdi-close-circle-o"></span></div>
            <div class="message"><strong>Error! </strong> ${requestScope["error"]}
            </div>
        </div>
        <script>
            $(document).ready(function() {
                $("#submit").click(function () {
                    $(".alert-danger").slideUp("slow");
                });

                $(".close").click(function () {
                    $(".alert-danger").slideUp("slow");
                });
            });
        </script>
    </c:if>
    <c:if test='${requestScope["warning"] != null}'>
<%--        <div class="alert alert-warning" style="position: fixed; bottom: 0; right: 0; left: 0">--%>
<%--            <button type="button" class="close" data-dismiss="alert">x</button>--%>
<%--            <strong>Warning!</strong> ${requestScope["warning"]}--%>
<%--        </div>--%>
        <div class="alert alert-warning alert-dismissible" role="alert">
            <button class="close" type="button" data-dismiss="alert" aria-label="Close"><span class="mdi mdi-close" aria-hidden="true"></span></button>
            <div class="icon"><span class="mdi mdi-alert-triangle"></span></div>
            <div class="message"><strong>Warning! </strong>${requestScope["warning"]}</div>
        </div>
        <script>
            $(document).ready(function() {
                $("#submit").click(function () {
                    $(".alert-warning").slideUp("slow");
                });
                $(".close").click(function () {
                    $(".alert-warning").slideUp("slow");
                });
            });
        </script>
    </c:if>
</div>

