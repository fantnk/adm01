<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Тестовое задание - Федосеев Александр</title>

    <link rel="stylesheet" href="webjars/bootstrap/3.3.6/css/bootstrap.min.css">
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
                            <input class="form-control" name="startDate" id="startDate" placeholder="yyyy-MM-dd HH:mm"
                                   pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31)) (0[0-9]|1[0-9]|2[0-3])(:[0-5][0-9]){1}"
                                   required>
                        </div>

                        <label class="control-label col-sm-3" for="endDate">To Date:</label>

                        <div class="col-sm-3">
                            <input class="form-control" name="endDate" id="endDate" placeholder="yyyy-MM-dd HH:mm"
                                   pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31)) (0[0-9]|1[0-9]|2[0-3])(:[0-5][0-9]){1}"
                                   required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-3" for="accountNumber">Account Number:</label>

                        <div class="col-sm-3">
                            <input class="form-control time-picker" type="number" name="accountNumber"
                                   id="accountNumber" required>
                        </div>

                        <label class="control-label col-sm-3" for="linkType">Link Type:</label>

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
        <p>Скрипт populateDB производит наполнение БД тестовыми данными. Для номеров с 1090001 до 1090020 в таблице
        traffic содержатся данные по трафику (в промежутке с "2016-09-08 00:00:00" до "2016-09-10 00:00:00").</p>
    </div>
</div>
<div class="container">
    <div class="lead">
        <div class="stats">
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="webjars/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript" src="webjars/Bootstrap-3-Typeahead/3.1.1/bootstrap3-typeahead.js"></script>
<script type="text/javascript" src="webjars/noty/2.3.8/js/noty/packaged/jquery.noty.packaged.min.js"></script>
<script type="text/javascript" src="webjars/datetimepicker/2.4.7/build/jquery.datetimepicker.full.min.js"></script>
<script type="text/javascript">

    $(document).ready(function () {
        $('#filter').submit(function () {
            $.ajax({
                type: "POST",
                url: "ajax/trafficstats",
                data: $('#filter').serialize(),
                success: function (jsondata) {
                    $('.stats').html('Статистика за период с <b>' + jsondata.startDate.replace('T', ' ').substr(0, 16)
                            + '</b> до <b>' + jsondata.endDate.replace('T', ' ').substr(0, 16) + '</b>' +
                            '<br/>Абонент: ' + jsondata.subscriber +
                            '<br/>Направление: ' + jsondata.linkType +
                            '<br/>Объем переданного трафика: ' + jsondata.bytesTransferred + ' байт' +
                            '<br/>Пропускная способность: ' + Math.round(jsondata.speed) + ' бит/c');
                },
                error: function (xhr, status, error) {
                    failedNote = noty({
                        text: 'Failed: ' + xhr.statusText + '<br>',
                        type: 'error',
                        timeout: 1500,
                        layout: 'bottomRight'
                    });
                }
            });
            return false;
        });

        $('input[name=accountNumber]').typeahead({
                    source: function (query, process) {
                        return $.get('ajax/subscriber', {'accountNumber': query},
                                function (response) {
                                    var data = new Array();
                                    $.each(response, function (i, subscriber) {
                                        data.push(subscriber.accountNumber.toString());
                                    });
                                    return process(data);
                                },
                                'json'
                        );
                    },
                    updater: function (item) {
                        return item;
                    }
                }
        );

    });

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
