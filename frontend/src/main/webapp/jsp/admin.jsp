<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <jsp:include page="/jsp/blocks/header.jsp"/>

    <title>Admin page</title>

    <link href="../resources/css/metisMenu.min.css" rel="stylesheet">

    <link href="../resources/css/sb-admin-2.css" rel="stylesheet">

    <link href="../resources/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <link href="../resources/css/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="../resources/css/dataTables.responsive.css" rel="stylesheet">
    <link href="../resources/css/datepicker.css">


    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>


    <script>

        $(function () {
            $('#faculties').on('change', function () {
                refreshSpecialities(this.value, 0);
            })
            $('#faculties1').on('change', function () {
                refreshSpecialities(this.value, 0);
            })
        });


        function refreshSpecialities(id, val) {
            $.ajax({
                url: 'getSpecialitiesByFacultyId/' + id,
                dataType: 'json',
                success: function (data) {
                    $('#specs').find('option').remove();
                    var options = "";
                    $.each(data, function (index, value) {
                        options += '<option value="' + value.idSpec + '">' + value.nameSpec + '</option>';
                    });
                    $('#specs1').find('option').remove();
                    var options = "";
                    $.each(data, function (index, value) {
                        options += '<option value="' + value.idSpec + '">' + value.nameSpec + '</option>';
                    });
                    $('#specs').html(options);
                    if (val) {
                        $('#specs').val(val);
                    }
                    $('#specs1').html(options);
                    if (val) {
                        $('#specs').val(val);
                    }

                }
            });

        }


        function init() {


            $('#faculty_add').ajaxForm({
                dataType: 'json',
                success: function (data) {

                }
            });
            $('#speciality_add').ajaxForm({
                dataType: 'json',
                success: function (data) {

                }
            });
            $('#student_add').ajaxForm({
                dataType: 'json',
                success: function (data) {

                }
            });

            $('#request_add').ajaxForm({
                dataType: 'json',
                success: function (data) {

                }
            });
            $('#head_add').ajaxForm({
                dataType: 'json',
                success: function (data) {

                }
            });

            $('#faculties').val(data.idFaculty);
            $('#faculties1').val(data.idFaculty);
            refreshSpecialities(data.idFaculty, data.idSpec);
            $.validate({
                lang: 'ru'
            });
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

            <a href="/logout" class="btn btn-primary btn-block"><b>Выйти</b></a>
        </div>
    </nav>



    <div class="col-md-12">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">ADMIN PAGE</h1>
            </div>
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <button class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                            Add request
                        </button>
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
                                                <div class="col-md-5 "><label>Head of Practice</label></div>

                                            </div>
                                                <div class="row">
                                                    <div class="col-md-5"><label><input id="cname" name="companyName" minlength="2" type="text" required="" aria-required="true" class="error" aria-invalid="true"></label></div>
                                                    <div class="col-md-5"><select id="listHops" name="idHead" class="form-control">
                                                        <c:forEach items="${listHops}" var="head">
                                                            <option value="${head.idHead}">${head.lastName}</option>
                                                        </c:forEach>
                                                    </select></div>
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
                                                <div class="col-md-3 "><label>Quantity</label></div>
                                                <div class="col-md-6 col-md-offset-1"><label>Min avg ball</label></div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-3"><input  id="quantity" name="quantity"></div>
                                                <div class="col-md-6 col-md-offset-1"><input id="minAvg"  name="minAvgBall"></div>
                                            </div>
                                                <div class="row">
                                                 <button type="submit" class="btn btn-primary" onclick="myFunction()">Create</button>
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
                        <button class="btn btn-primary" data-toggle="modal" data-target="#myModal1">
                            Add student
                        </button>
                        <div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                        <h4 class="modal-title" id="myModalLabel1">Add student</h4>
                                    </div>
                                    <div class="modal-body">
                                        <div class="container-fluid">
                                            <form action="/createStudent?${_csrf.parameterName}=${_csrf.token}" id="student_add" method="post" role="form">
                                            <div class="row">
                                                <div class="col-md-5"><label>First name</label></div>
                                                <div class="col-md-5 col-md-offset-1 "><label>Last name</label></div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-5"><input class="form-control" name="firstName"></div>
                                                <div class="col-md-5 col-md-offset-1 "><input class="form-control" name="lastName"></div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-4"><label>Faculty</label></div>
                                                <div class="col-md-4"><label>Speciality</label></div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-4"><select id="faculties1" name="idFaculty" class="form-control">
                                                    <c:forEach items="${listFaculties}" var="faculty">
                                                        <option value="${faculty.idFaculty}">${faculty.facultyName}</option>
                                                    </c:forEach>
                                                </select></div>
                                                <div class="col-md-4"><select id="specs1" name="idSpec" class="form-control">
                                                </select>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-3 "><label>Avg ball</label></div>
                                                <div class="col-md-3 col-md-offset-1"><label>Is budget</label></div>
                                                <div class="col-md-3 "><label>num group</label></div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-3"><input type="number" name="avgBall"></div>
                                                <div class="col-md-3 col-md-offset-1"><select class="form-control" name="isBudget">
                                                    <option>budget</option>
                                                    <option>obligated</option>
                                                </select></div>
                                                <div class="col-md-3"><input type="number" name="idGroup"></div>
                                            </div>
                                                <div class="row">
                                                    <div class="col-md-4 "><label>login</label></div>
                                                    <div class="col-md-4 col-md-offset-1"><label>pass</label></div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-5"><input class="form-control" name="login"></div>
                                                    <div class="col-md-5"><input class="form-control" name="password"></div>
                                                </div>
                                                <button type="submit" class="btn btn-primary" onclick="myFunction()">Create</button>
                                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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
                        <button type="button" class="btn btn-primary" data-target="#myModal5" data-toggle="modal">Create spec</button>
                        <div class="modal fade" id="myModal5" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                        <h4 class="modal-title" id="myModalLabel5">Add student</h4>
                                    </div>
                                    <div class="modal-body">
                                        <div class="container-fluid">
                                            <form action="/createSpeciality?${_csrf.parameterName}=${_csrf.token}" id="speciality_add" method="post" role="form">
                                            <div class="row">
                                                <div class="col-md-5"><label>available faculties</label></div>
                                                <div class="col-md-5 col-md-offset-1"><label>spec name</label></div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-4"><select id="listFaculties" name="facultyId" class="form-control">
                                                    <c:forEach items="${listFaculties}" var="faculty">
                                                        <option value="${faculty.idFaculty}">${faculty.facultyName}</option>
                                                    </c:forEach>
                                                </select></div>
                                                <div class="col-md-5 col-md-offset-1 "><input class="form-control" name="specName"></div>
                                            </div>
                                                <button type="submit" class="btn btn-primary" onclick="myFunction()">Create</button>
                                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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

                        <button type="button" class="btn btn-primary" data-target="#myModal7" data-toggle="modal">Register HOP</button>
                        <div class="modal fade" id="myModal7" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                        <h4 class="modal-title" id="myModalLabel7">Add faculty</h4>
                                    </div>
                                    <div class="modal-body">
                                        <div class="container-fluid">
                                            <form action="/addhead?${_csrf.parameterName}=${_csrf.token}" id="head_add" method="post" role="form">
                                            <div class="row">
                                                <div class="col-md-5"><label>first name</label></div>
                                                <div class="col-md-5 col-md-offset-1 " ><label>last name</label></div>

                                            </div>
                                                <div class="row">
                                                    <div class="col-md-5"><input class="form-control" name="hopFirstName"></div>
                                                    <div class="col-md-5 col-md-offset-1 "><input class="form-control" name="hopLastName"></div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-5"><label>login</label></div>
                                                    <div class="col-md-5 col-md-offset-1 "><label>password</label></div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-5 "><input class="form-control" name="hopLogin"></div>
                                                    <div class="col-md-5 col-md-offset-1 "><input class="form-control" name="hopPassword"></div>
                                                </div>
                                                <button type="submit" class="btn btn-primary" onclick="myFunction()">Create</button>
                                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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

                        <button type="button" class="btn btn-primary" data-target="#myModal6" data-toggle="modal">Create fac</button>
                        <div class="modal fade" id="myModal6" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                        <h4 class="modal-title" id="myModalLabel6">Add faculty</h4>
                                    </div>
                                    <div class="modal-body">
                                        <c:if test="${not empty result}">
                                            <div class="alert alert-danger alert-dismissible">${result}</div>
                                        </c:if>
                                        <div class="container-fluid">
                                            <form action="/createFaculty?${_csrf.parameterName}=${_csrf.token}" id="faculty_add" method="post" role="form">
                                                <div class="row">
                                                    <div class="col-md-5"><label>faculty name</label></div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-5 col-md-offset-1 "><input class="form-control" name="facName"></div>
                                                </div>
                                                <button type="submit" class="btn btn-primary" onclick="myFunction()">Create</button>
                                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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
        </div>
        <!-- /.row -->
        <div class="panel-body">

            <!-- Nav tabs -->
            <ul class="nav nav-tabs">
                <li class="active"><a href="#home" data-toggle="tab" aria-expanded="true">Students tab</a>
                </li>
                <li class=""><a href="#profile" data-toggle="tab" aria-expanded="false">Requests tab</a>
                </li>
                <li class=""><a href="#messages" data-toggle="tab" aria-expanded="false">faculties tab</a>
                </li>
                <li class=""><a href="#hops" data-toggle="tab" aria-expanded="false">heads of practice</a>
                </li>
            </ul>

            <!-- Tab panes -->
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
                                            <th>CB</th>
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
                                            <th></th>
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
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td><a href="<c:url value='/removeStudent/${student.idUser}'/>"><button>delete</button></a></td>
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
                                                <td></td>
                                                <td><a href="<c:url value='/removeRequest/${request.idRequest}'/>"><button>delete</button></a></td>
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
                <div class="tab-pane fade" id="messages">
                    <h4>Faculties Tab</h4>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Table of the students
                                </div>
                                <!-- /.panel-heading -->
                                <div class="panel-body">
                                    <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example3">
                                        <thead>
                                        <tr>
                                            <th>cb</th>
                                            <th>speciality</th>
                                            <th>Faculty</th>
                                            <th></th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${listSpecialities}" var="speciality" >
                                                <tr>
                                                    <td><div class="checkbox">
                                                        <label><input type="checkbox" value=""></label>
                                                    </div></td>
                                                    <td>${speciality.nameSpec}</td>
                                                    <td>${speciality.nameFaculty}</td>
                                                    <td><a href="<c:url value='/removeSpec/${speciality.idSpec}'/>"><button>delete</button></a></td>
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
                <div class="tab-pane fade" id="hops">
                    <h4>Faculties Tab</h4>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Table of the students
                                </div>
                                <!-- /.panel-heading -->
                                <div class="panel-body">
                                    <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example4">
                                        <thead>
                                        <tr>
                                            <th>First name</th>
                                            <th>Last name</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${listHops}" var="hop" >
                                            <tr>
                                                <td>${hop.firstName}</td>
                                                <td>${hop.lastName}</td>
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
        </div>

        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <p>
                        <div id="response"></div>
                            <button type="button" class="btnadd" id="btnadd">delete selected students</button>
                            <button type="button" class="btn btn-primary btn-lg">Assign student</button>
                            <button type="button" class="btn btn-primary btn-lg">Release student</button>
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
                    <script type="text/javascript">

                        $(document).ready(function(){
                            $('.btnadd').click(function(){
                                var checkValues = $('input[name=checkboxlist]:checked').map(function()
                                {
                                    return $(this).val();
                                }).get();



                                $.ajax({
                                    url: 'removeCheckedStudents?${_csrf.parameterName}=${_csrf.token}',
                                    type: 'POST',
                                    data: { 'id': checkValues },
                                    success:function(data){
                                    }
                                });
                            });
                        });

                    </script>

                </div>
            </div>
        </div>
        <!-- /.row -->
    </div>
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->

<script src="../resources/js/jquery.dataTables.min.js"></script>
<script src="../resources/js/dataTables.bootstrap.min.js"></script>
<script src="../resources/js/dataTables.responsive.js"></script>
<script src="../resources/js/datepicker.js"></script>
<!-- Page-Level Demo Scripts - Tables - Use for reference -->
<script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
        $('#dataTables-example1').DataTable({
            responsive: true
        });
        $('#dataTables-example3').DataTable({
            responsive: true
        });
        $('#dataTables-example4').DataTable({
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
<%--<script>
    $("#request_add").validate();
    jQuery.validator.addClassRules("inputQ", {
        required: true,
        range: [0, 15]
    });
    jQuery.validator.addClassRules("inputAvg", {
        required: true,
        range: [4, 10],
        number: true
    });
</script>--%>
<script>
    $( "#request_add" ).validate({
        rules: {
            quantity: {
                required: true,
                range: [1, 15]
            },
            minAvg: {
                required: true,
                range: [4, 10],
                number: true
            }

        }
    });

    $( "#student_add" ).validate({
        rules: {
            firstName: {
                required: true,
                minlength: 2
            },

            lastName: {
                required: true,
                minlength: 2
            },
            speciality: {
            required: true
            },
            avgB: {
                required: true,
                range: [4, 10],
                number: true
            },
            login: {
                required: true,
                minlength: 5
            },
            pass: {
                required: true,
                minlength: 5
            },
            group: {
                required: true,
                minlength: 6,
                maxlength: 6
            }
        }
    });

    $( "#speciality_add" ).validate({
        rules: {
            sname: {
                required: true,
                minlength: 2
            }
        }
    });

    $( "#faculty_add" ).validate({
        rules: {
            fname: {
                required: true,
                minlength: 2
            }
        }
    });

    $( "#head_add" ).validate({
        rules: {
            firstName: {
                required: true,
                minlength: 2
            },
            lastName: {
                required: true,
                minlength: 2
            },
            login: {
                required: true,
                minlength: 5
            },
            password: {
                required: true,
                minlength: 5
            }
        }
    });
</script>

</body>
</html>
