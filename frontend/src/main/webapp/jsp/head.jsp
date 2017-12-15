<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="visibility" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Head of practice page</title>

    <jsp:include page="/jsp/blocks/header.jsp"/>

    <link href="${pageContext.request.contextPath}/resources/css/metisMenu.min.css" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/resources/css/sb-admin-2.css" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <link href="${pageContext.request.contextPath}/resources/css/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/dataTables.responsive.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/datepicker.css">


    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

    <script>

        $(function () {
            $('#faculties').on('change', function () {
                refreshSpecialities(this.value, 0);
            })
        });


        function refreshSpecialities(id, val) {
            $.ajax({
                url: '/getSpecialitiesByFacultyId/' + id,
                dataType: 'json',
                success: function (data) {
                    $('#specs').find('option').remove();
                    var options = "";
                    $.each(data, function (index, value) {
                        options += '<option value="' + value.idSpec + '">' + value.nameSpec + '</option>';
                    });
                    $('#specs').html(options);
                    if (val) {
                        $('#specs').val(val);
                    }

                }
            });
        }

        function init() {

            $('#request_add').ajaxForm({
                dataType: 'json',
                success: function (data) {
                    myFunction();
                }
            });

            $('#faculties').val(data.idFaculty);
            $('#faculties1').val(data.idFaculty);
            refreshSpecialities(data.idFaculty, data.idSpec);
        }
        function myFunction() {
            location.reload();
        }
    </script>
</head>
<body onload="init()">


<div id="wrapper">

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">

        <div class="nav navbar-bot-links navbar-right" style="margin: 5px">
            <p>loggined as ${currentAuth.lastName}</p>
            <a href="/logout" class="btn btn-primary btn-block"><b>Выйти</b></a>
        </div>

    </nav>


    <div class="col-lg-12">
        <div class="col-lg-12">
            <h1 class="page-header">HEAD PAGE</h1>
        </div>
        <div class="panel panel-default">
            <div class="panel-body">
        <div class="row">
            <button class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                Add request
            </button>
        </div>
        <div class="row">
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title" id="myModalLabel">Create request</h4>
                        </div>
                        <div class="modal-body">
                            <div class="container-fluid">
                                <form action="/createRequest?${_csrf.parameterName}=${_csrf.token}" id="request_add" method="post" role="form"
                                      class="form-horizontal"
                                      data-fv-framework="bootstrap"
                                      data-fv-icon-valid="glyphicon glyphicon-ok"
                                      data-fv-icon-invalid="glyphicon glyphicon-remove"
                                      data-fv-icon-validating="glyphicon glyphicon-refresh">
                                    <div class="row">
                                        <div class="col-md-5"><label>Company name</label></div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-5"><label><input id="cname" name="companyName" minlength="2" type="text" required="" aria-required="true" class="error" aria-invalid="true"></label></div>
                                        <div class="col-md-5"><label> <input name="idHead" style="visibility: hidden" value="${hop.idUsers}"></label></div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-4"><label>From</label></div>
                                        <div class="col-md-4"><label>To</label></div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="input-group date">
                                                <div class="input-group-addon">
                                                    <i class="fa fa-calendar"></i>
                                                </div>
                                                <input type="text" class="form-control pull-right" id="datepicker" name="dateFrom">
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="input-group date">
                                                <div class="input-group-addon">
                                                    <i class="fa fa-calendar"></i>
                                                </div>
                                                <input type="text" class="form-control pull-right" id="datepicker1" name="dateTo">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-3 "><label>faculties</label></div>
                                        <div class="col-md-6 col-md-offset-1"><label>specialities</label></div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-4"><select id="faculties" name="idFaculty" class="form-control">
                                            <c:forEach items="${listFaculties}" var="faculty">
                                                <option value="${faculty.idFaculty}">${faculty.facultyName}</option>
                                            </c:forEach>
                                        </select></div>
                                        <div class="col-md-4"><select id="specs" name="idSpec" class="form-control">
                                        </select>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-3"><label>Quantity</label></div>
                                        <div class="col-md-3"><label>Min avg ball</label></div>
                                        <div class="col-md-3"><label>status</label></div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-3"><input  id="quantity" name="quantity"></div>
                                        <div class="col-md-3"><input id="minAvg"  name="minAvgBall"></div>
                                        <div class="col-md-3"><select class="form-control" name="isBudget">
                                            <option value="1">budget</option>
                                            <option value="0">obligated</option>
                                        </select></div>
                                    </div>
                                    <div class="row">
                                        <button type="submit" class="btn btn-primary" >Create</button>
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                    </div>
                                </form>

                            </div>
                        </div>
                        <div class="modal-footer">

                        </div>
                    </div>
                    <!-- /.modal-content -->
                </div>
                <!-- /.modal-dialog -->
            </div>
        </div>
            </div>
        </div>
        <ul class="nav nav-tabs">
            <li class="active"><a href="#home" data-toggle="tab" aria-expanded="true">My students</a>
            </li>
            <li class=""><a href="#profile" data-toggle="tab" aria-expanded="false">My requests</a>
            </li>
        </ul>

        <div class="tab-content">
            <div class="tab-pane fade active in" id="home">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                    <tr>
                                        <th></th>
                                        <th>First name</th>
                                        <th>Last name</th>
                                        <th>Faculty</th>
                                        <th>Speciality</th>
                                        <th>Group</th>
                                        <th>Is budget</th>
                                        <th>Average ball</th>
                                        <th>Status</th>
                                        <th>Company</th>
                                        <th>Period</th>
                                        <th>show info</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${listStudents}" var="student" >
                                        <tr>
                                            <td><div class="checkbox">
                                                <label><input type="checkbox" name="checkboxlist" value="${student.idUser}"></label>
                                            </div></td>
                                            <td>${student.firstName}</td>
                                            <td>${student.lastName}</td>
                                            <td>${student.facName}</td>
                                            <td>${student.specName}</td>
                                            <td>${student.idGroup}</td>
                                            <td>${student.isBudget}</td>
                                            <td>${student.avgBall}</td>
                                            <td>${student.status}</td>
                                            <td>${student.companyName}</td>
                                            <td>${student.period}</td>
                                            <td><a href="/profile/${student.idUser}" target="_blank"><button>show</button></a></td>
                                        </tr>
                                    </c:forEach>

                                    </tbody>
                                </table>
                                <!-- /.table-responsive -->

                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
            </div>
            <div class="tab-pane fade" id="profile" name="profile">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Table of the students
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example1">
                                    <thead>
                                    <tr>
                                        <th>CB</th>
                                        <th>Company name</th>
                                        <th>Date from</th>
                                        <th>Date to</th>
                                        <th>Faculty</th>
                                        <th>Speciality</th>
                                        <th>Min avg ball</th>
                                        <th>Total quantity</th>
                                        <th>Available quantity</th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>

                                    <c:forEach items="${listRequests}" var="request" >
                                        <tr>
                                            <td><div class="checkbox">
                                                <label><input type="checkbox" value=""></label>
                                            </div></td>
                                            <td>${request.companyName}</td>
                                            <td>${request.dateFrom.toString()}</td>
                                            <td>${request.dateTo.toString()}</td>
                                            <td>${request.nameFaculty}</td>
                                            <td>${request.nameSpec}</td>
                                            <td>${request.minAvg}</td>
                                            <td>${request.quantity}</td>
                                            <td>${request.availableQuantity}</td>
                                            <td><a href="<c:url value='/removeRequest/${request.idRequest}'/>"><button>delete</button></a></td>
                                            <td><a href="<c:url value='/findForRequest/${request.idRequest}'/>"><button>assign</button></a></td>
                                        </tr>
                                    </c:forEach>

                                    </tbody>
                                </table>
                                <!-- /.table-responsive -->

                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                    </div>
                    <!-- /.col-lg-12 -->

                </div>

            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <p>
                        <div id="response"></div>
                        <button type="button" class="btnadd" id="btnadd" visibility:visibility: ${visible}>assign to practice</button>

                        </p>
                    </div>
                    <%--   <script>

                           $('#btnadd').click(function() {

                               $.ajax({
                                   url: "testcb",
                                   type: "post",
                                   data: $('.ids:checked').serialize(),
                                   success: function(data) {
                                       $('#response').html(data);
                                   }
                               });

                           });
                       </script>--%>


                </div>
            </div>
        </div>

    </div>
    <!-- /#page-wrapper -->

</div>

<script src="../resources/js/jquery.dataTables.min.js"></script>
<script src="../resources/js/dataTables.bootstrap.min.js"></script>
<script src="../resources/js/dataTables.responsive.js"></script>
<script src="../resources/js/datepicker.js"></script>

<script type="text/javascript">

    $(document).ready(function(){
        $('.btnadd').click(function(){
            var checkValues = $('input[name=checkboxlist]:checked').map(function()
            {
                return $(this).val();
            }).get();

            $.ajax({
                url: '/assignRequest/${requestId}?${_csrf.parameterName}=${_csrf.token}',
                type: 'POST',
                data: { 'id': checkValues },
                success:function(data){
                    myFunction();
                }
            });
        });
    });

</script>

<script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
        $('#dataTables-example1').DataTable({
            responsive: true
        });
    });
</script>
<script>
    $('#datepicker').datepicker({
        autoclose: true
    })
    $('#datepicker1').datepicker({
        autoclose: true
    })

</script>
<script>
    $( "#request_add" ).validate({
        rules: {
            quantity: {
                required: true,
                range: [1, 15]
            },
            minAvgBall: {
                required: true,
                range: [4, 10],
                number: true
            },
            dateFrom:{
                required: true
            },
            dateTo:{
                required: true
            },
            idSpec:{
                required: true
            }
        }
    });
</script>

</body>
</html>
