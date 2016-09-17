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

    <link rel="stylesheet" href="webjars/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="webjars/datatables/1.10.12/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="webjars/datetimepicker/2.4.7/jquery.datetimepicker.css">
</head>
<body>
<div class="jumbotron">
    <div class="container">
        <div class="shadow">
            <div class="view-box">
                <form:form method="post" class="form-horizontal" role="form" id="filter">
                    <div class="form-group">
                        <label class="control-label col-sm-3" for="startDate">From Date:</label>

                        <div class="col-sm-3">
                            <input type="text" class="form-control" name="startDate" id="startDate" required>
                        </div>

                        <label class="control-label col-sm-3" for="endDate">To Date:</label>

                        <div class="col-sm-3">
                            <input class="form-control" name="endDate" id="endDate" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-3" for="accountNumber">Subscriber:</label>

                        <div class="col-sm-3">
                            <input class="form-control time-picker" type="number" name="accountNumber"
                                   id="accountNumber" required>
                        </div>

                        <label class="control-label col-sm-3" for="linkType">linkType:</label>

                        <div class="col-sm-3" id="linkType">
                            <label class="radio-inline"><input type="radio" name="linkType" value="UPLINK" required
                                                               checked>UPLINK</label>
                            <label class="radio-inline"><input type="radio" name="linkType"
                                                               value="DOWNLINK">DOWNLINK</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-8">
                            <button type="submit" class="btn btn-primary pull-right">Submit</button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="lead">
        <div class="results">Ждем ответа</div>
    </div>
</div>
<script type="text/javascript" src="webjars/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript" src="webjars/Bootstrap-3-Typeahead/3.1.1/bootstrap3-typeahead.js"></script>
<%--<script type="text/javascript" src="http://twitter.github.com/typeahead.js/releases/latest/typeahead.bundle.js"></script>--%>
<%--<script type="text/javascript" src="resources/js/bootstrap-typeahead.js"></script>--%>
</body>
<script type="text/javascript">

    var ajaxUrl = 'ajax/traffic/stat';

    //    $(function () {
    $(document).ready(function () {
        $('#filter').submit(function () {
//            alert("sd");
            getResult();
            return false;
        });
        /*       var accountNumbers = new Bloodhound({
         datumTokenizer: Bloodhound.tokenizers.obj.whitespace('value'),
         queryTokenizer: Bloodhound.tokenizers.whitespace,
         //            prefetch: '../data/films/post_1960.json',
         remote: {
         url: 'ajax/subscriber?query=%QUERY',
         wildcard: '%QUERY'
         }
         });

         $('input[name=accountNumber]').typeahead(null, {
         name: 'account-number',
         display: 'accountNumber',
         source: accountNumbers
         });*/
        /*$('input[name=accountNumber]').typeahead({
         source: function(typeahead, query) {
         var _this = this;
         return $.ajax({
         url: "ajax/subscriber?query=" + query,
         success: function(data) {
         return typeahead.process(data);
         }
         });
         },
         property: "accountNumber"
         });*/

        $('input[name=accountNumber]').typeahead({
                    //источник данных
                    source: function (query, process) {
                        //                        return $.post('ajax/subscriber', {'query':query+"L"},
                        return $.get('ajax/subscriber', {'accountNumber': query},
                                function (response) {
                                    var data = new Array();
                                    //                                    alert(JSON.parse(response.toString()));
                                    //преобразовываем данные из json в массив
                                    $.each(response, function (i, subscriber) {
                                        data.push(subscriber.accountNumber.toString());
                                    });
//                                    alert(data);
                                    return process(data);
                                },
                                'json'
                        );
                    }
                    //источник данных
                    //вывод данных в выпадающем списке
                    /*, highlighter: function (item) {
                     var parts = item.split('_');
                     parts.shift();
                     return parts.join('_');
                     }*/
                    //вывод данных в выпадающем списке
                    //действие, выполняемое при выборе елемента из списка
                    , updater: function (item) {
                        return item;
                    }
                    //действие, выполняемое при выборе елемента из списка
                }
        );
        /*$("#accountNumber").typeahead({
         //            triggerLength: 2,
         //            loadingClass: "loading-circle",
         /!*remote: {
         url : 'ajax/subscriber'
         }*!/
         ajax: {
         url: 'ajax/subscriber',
         displayField: 'accountNumber',
         method: 'findByAccountNumberPart'
         }
         /!*source: function(request, response) {
         $.ajax({
         url: "ajax/subscriber",
         dataType: "json",
         data: {
         state: $("#accountNumber").val(),
         term: request.term
         },
         success: function (data) {
         response(data);
         }
         });
         }*!/
         //            autoSelect: true
         });*/
    });

    function getResult() {
        $.ajax({
            type: "POST",
            url: ajaxUrl,
            data: $('#filter').serialize(),
            success: function (jsondata) {
                $('.results').html('Статистика за период с <b>' + jsondata.startDate.replace('T', ' ').substr(0, 16)
                        + '</b> до <b>' + jsondata.endDate.replace('T', ' ').substr(0, 16) + '</b>' +
                        '<br/>Абонент: ' + jsondata.subscriber +
                        '<br/>Направление: ' + jsondata.linkType +
                        '<br/>Объем переданного трафика: ' + jsondata.bytesTransferred + ' байт' +
                        '<br/>Пропускная способность: ' + jsondata.speed + ' бит/c');
            }
        });
        return false;
    }
</script>
<script type="text/javascript" src="webjars/datatables/1.10.12/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="webjars/datetimepicker/2.4.7/build/jquery.datetimepicker.full.min.js"></script>
<script type="text/javascript">
    $(function () {
        var startDate = $('#startDate');
        var endDate = $('#endDate');

        startDate.datetimepicker({
            format: 'Y-m-d H:m',
            lang: 'ru',
            onShow: function (ct) {
                this.setOptions({
                    maxDate: endDate.val() ? endDate.val() : false
                })
            }
        });
        endDate.datetimepicker({
            format: 'Y-m-d H:m',
            onShow: function (ct) {
                this.setOptions({
                    minDate: startDate.val() ? startDate.val() : false
                })
            }
        });
    });
</script>

</html>
