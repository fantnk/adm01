<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Title</title>
<c:set var="url">${pageContext.request.requestURL}</c:set>
<base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/"/>

<link rel="stylesheet" href="webjars/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="webjars/datatables/1.10.12/css/jquery.dataTables.min.css">

<body>
<button onclick="updateTable()">Update</button>
<div class="jumbotron">
    <div class="container">
        <div class="shadow">
            <div class="view-box">
                <table class="table table-striped display" id="datatable">
                    <thead>
                    <tr>
                        <th>Date</th>
                        <th>Subscriber</th>
                        <th>Uplink</th>
                        <th>Downlink</th>
                    </tr>
                    </thead>
                    <c:forEach items="${trafficList}" var="traffic">
                        <jsp:useBean id="traffic" scope="page" type="top.fedoseev.adm01.model.Traffic"/>
                        <tr>
                            <td>${traffic.date}</td>
                            <td>${traffic.subscriber}</td>
                            <td>${traffic.uplink}</td>
                            <td>${traffic.downlink}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="webjars/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript" src="webjars/datatables/1.10.12/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="webjars/noty/2.3.8/js/noty/packaged/jquery.noty.packaged.min.js"></script>
<script type="text/javascript" src="resources/js/datatablesUtil.js"></script>
<script type="text/javascript">

    var ajaxUrl = 'ajax/traffic/';
    var datatableApi;

    function updateTable() {
        $.get(ajaxUrl, updateTableByData);
    }

     $(document).ready(function () {
//    $(function () {
        datatableApi = $('#datatable').DataTable({
            "paging": true,
            "info": true,
            /*"processing": true,
            "serverSide": true,
            "ajax": {
                "url": ajaxUrl,
                "type": "GET"
            },*/
            "columns": [
                {
                    "data": "date"
                },
                {
                    "data": "subscriber"
                },
                {
                    "data": "uplink"
                },
                {
                    "data": "downlink"
                }
            ],
            "order": [
                [
                    0,
                    "asc"
                ]
            ]
        });
    });
</script>
</html>