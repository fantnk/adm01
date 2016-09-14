<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
    <c:set var="url">${pageContext.request.requestURL}</c:set>
    <base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/"/>

    <script type="text/javascript" src="webjars/jquery/2.2.4/jquery.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="webjars/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="webjars/datatables/1.10.12/css/jquery.dataTables.min.css">
</head>
<body>
<div class="jumbotron">
    <div class="container">
        <div class="shadow">
            <div class="view-box">
                <form:form method="post" class="form-horizontal" role="form" id="filter">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="startDate">From Date:</label>

                        <div class="col-sm-2">
                            <input class="form-control" name="startDate" id="startDate">
                        </div>

                        <label class="control-label col-sm-2" for="endDate">To Date:</label>

                        <div class="col-sm-2">
                            <input class="form-control" name="endDate" id="endDate">
                        </div>
                    </div>
                    <%--<div class="form-group">
                        <label class="control-label col-sm-2" for="startTime">From Time:</label>

                        <div class="col-sm-2">
                            <input class="form-control time-picker" name="startTime" id="startTime">
                        </div>

                        <label class="control-label col-sm-2" for="endTime">To Time:</label>

                        <div class="col-sm-2">
                            <input class="form-control time-picker" name="endTime" id="endTime">
                        </div>
                    </div>--%>
                    <div class="form-group">
                        <div class="col-sm-8">
                            <button type="submit" class="btn btn-primary pull-right">Submit</button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
        <div class="results">Ждем ответа</div>
    </div>
</div>
</body>
<script type="text/javascript">

    var ajaxUrl = 'ajax/traffic/';

//    $(function () {
    $(document).ready(function(){
        $('#filter').submit(function () {
//            alert("sd");
            getResult();
            return false;
        });
    });

    function getResult() {
        $.ajax({
            type: "POST",
            url: ajaxUrl,
            data: $('#filter').serialize(),
            success: function (jsondata) {
                $('.results').html('date = ' + jsondata.date + ', subscriber = ' + jsondata.subscriber);
            }
        });
        return false;
    }

    /*$.ajax({
     dataType: 'json',
     url: ajaxUrl,
     success: function (jsondata) {
     $('.results').html('Name = ' + jsondata.name + ', Nickname = ' + jsondata.nickname);
     }
     });*/

</script>
</html>
