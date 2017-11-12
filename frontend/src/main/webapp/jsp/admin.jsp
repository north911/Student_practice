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
        }
    </script>

</head>
<body onload="init()">


<div id="wrapper">

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">

        <div class="nav navbar-bot-links navbar-right" style="margin: 5px">

            <form action="/logout" method="post">
                <div class="form-group">
                    <input class="btn btn-xs btn-success btn-block" type="submit" value="logout">
                </div>
            </form>
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
                                            <div class="row">
                                                <div class="col-md-8"><label>Company name</label></div>
                                                <div class="col-md-8"><label><input type="text"></label></div>
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
                                                        <input type="text" class="form-control pull-right" id="datepicker">
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="input-group date">
                                                        <div class="input-group-addon">
                                                            <i class="fa fa-calendar"></i>
                                                        </div>
                                                        <input type="text" class="form-control pull-right" id="datepicker1">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-3 "><label>quantity</label></div>
                                                <div class="col-md-6 col-md-offset-1"><label>faculty</label></div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-3"><input class="form-control"></div>
                                                <div class="col-md-6 col-md-offset-1"><input class="form-control"></div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-3 "><label>Availabe spec</label></div>
                                                <div class="col-md-6 col-md-offset-1"><label>Min avg ball</label></div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-3"><input class="form-control"></div>
                                                <div class="col-md-6 col-md-offset-1"><input class="form-control"></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-primary">Create</button>
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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
                                            <div class="row">
                                                <div class="col-md-5"><label>First name</label></div>
                                                <div class="col-md-5 col-md-offset-1 "><label>Last name</label></div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-5"><input class="form-control"></div>
                                                <div class="col-md-5 col-md-offset-1 "><input class="form-control"></div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-4"><label>Faculty</label></div>
                                                <div class="col-md-4"><label>Speciality</label></div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-4"><select class="form-control">
                                                    <option>fkp</option>
                                                    <option>fksis</option>
                                                    <option>ief</option>
                                                    <option>vf</option>
                                                    <option>fre</option>
                                                </select></div>
                                                <div class="col-md-4"><select class="form-control">
                                                    <option>fkp</option>
                                                    <option>fksis</option>
                                                    <option>ief</option>
                                                    <option>vf</option>
                                                    <option>fre</option>
                                                </select></div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-3 "><label>Avg ball</label></div>
                                                <div class="col-md-6 col-md-offset-1"><label>Is budget</label></div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-3"><input></div>
                                                <div class="col-md-6 col-md-offset-1"><label>
                                                    <input type="checkbox" value="">
                                                </label></div>
                                            </div>

                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-primary">Create</button>
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                    </div>
                                </div>
                                <!-- /.modal-content -->
                            </div>
                            <!-- /.modal-dialog -->
                        </div>
                        <button class="btn btn-primary" data-toggle="modal" data-target="#myModal2">
                            Asign student
                        </button>
                        <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                        <h4 class="modal-title" id="myModalLabel2">Asign student</h4>
                                    </div>
                                    <div class="modal-body">
                                        <div class="container-fluid">
                                            <div class="row">
                                                <div class="col-md-4"><label>Faculty</label></div>
                                                <div class="col-md-4"><label>Speciality</label></div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-4"><select class="form-control">
                                                    <option>fkp</option>
                                                    <option>fksis</option>
                                                    <option>ief</option>
                                                    <option>vf</option>
                                                    <option>fre</option>
                                                </select></div>
                                                <div class="col-md-4"><select class="form-control">
                                                    <option>fkp</option>
                                                    <option>fksis</option>
                                                    <option>ief</option>
                                                    <option>vf</option>
                                                    <option>fre</option>
                                                </select></div>
                                            </div>

                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-primary">Create</button>
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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
                                            <div class="row">
                                                <div class="col-md-5"><label>available faculties</label></div>
                                                <div class="col-md-5 col-md-offset-1"><label>spec name</label></div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-4"><select class="form-control">
                                                    <option>fkp</option>
                                                    <option>fksis</option>
                                                    <option>ief</option>
                                                    <option>vf</option>
                                                    <option>fre</option>
                                                </select></div>
                                                <div class="col-md-5 col-md-offset-1 "><input class="form-control"></div>
                                            </div>

                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="submit" class="btn btn-primary">Create</button>
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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
                                        <div class="container-fluid">
                                            <form action="/add" id="faculty_add" method="post" role="form">
                                            <div class="row">
                                                <div class="col-md-5"><label>faculty name</label></div>
                                                <div class="col-md-5 col-md-offset-1 "><input class="form-control" name="fname"></div>
                                            </div>
                                                <button type="submit" class="btn btn-primary">Create</button>
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
                                            <th>Last name</th>
                                            <th>First name</th>
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
                                        <tr class="gradeA">
                                            <td><div class="checkbox">
                                                <label><input type="checkbox" value=""></label>
                                            </div></td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center"><button type="button" class="btn btn-primary btn-circle"><i class="fa fa-list"></i>
                                            </button></td>
                                        </tr>
                                        <tr class="gradeA">
                                            <td><div class="checkbox">
                                                <label><input type="checkbox" value=""></label>
                                            </div></td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center"><button type="button" class="btn btn-primary btn-circle"><i class="fa fa-list"></i>
                                            </button></td>
                                        </tr>
                                        <tr class="gradeA">
                                            <td><div class="checkbox">
                                                <label><input type="checkbox" value=""></label>
                                            </div></td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center"><button type="button" class="btn btn-primary btn-circle"><i class="fa fa-list"></i>
                                            </button></td>
                                        </tr>
                                        <tr class="gradeA">
                                            <td><div class="checkbox">
                                                <label><input type="checkbox" value=""></label>
                                            </div></td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center"><button type="button" class="btn btn-primary btn-circle"><i class="fa fa-list"></i>
                                            </button></td>
                                        </tr>
                                        <tr class="gradeA">
                                            <td><div class="checkbox">
                                                <label><input type="checkbox" value=""></label>
                                            </div></td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center"><button type="button" class="btn btn-primary btn-circle"><i class="fa fa-list"></i>
                                            </button></td>
                                        </tr>
                                        <tr class="gradeA">
                                            <td><div class="checkbox">
                                                <label><input type="checkbox" value=""></label>
                                            </div></td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center"><button type="button" class="btn btn-primary btn-circle"><i class="fa fa-list"></i>
                                            </button></td>
                                        </tr>
                                        <tr class="gradeA">
                                            <td><div class="checkbox">
                                                <label><input type="checkbox" value=""></label>
                                            </div></td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center"><button type="button" class="btn btn-primary btn-circle"><i class="fa fa-list"></i>
                                            </button></td>
                                        </tr>
                                        <tr class="gradeA">
                                            <td><div class="checkbox">
                                                <label><input type="checkbox" value=""></label>
                                            </div></td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center"><button type="button" class="btn btn-primary btn-circle"><i class="fa fa-list"></i>
                                            </button></td>
                                        </tr>
                                        <tr class="gradeA">
                                            <td><div class="checkbox">
                                                <label><input type="checkbox" value=""></label>
                                            </div></td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center"><button type="button" class="btn btn-primary btn-circle"><i class="fa fa-list"></i>
                                            </button></td>
                                        </tr>
                                        <tr class="gradeA">
                                            <td><div class="checkbox">
                                                <label><input type="checkbox" value=""></label>
                                            </div></td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center"><button type="button" class="btn btn-primary btn-circle"><i class="fa fa-list"></i>
                                            </button></td>
                                        </tr>
                                        <tr class="gradeA">
                                            <td><div class="checkbox">
                                                <label><input type="checkbox" value=""></label>
                                            </div></td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center"><button type="button" class="btn btn-primary btn-circle"><i class="fa fa-list"></i>
                                            </button></td>
                                        </tr>
                                        <tr class="gradeA">
                                            <td><div class="checkbox">
                                                <label><input type="checkbox" value=""></label>
                                            </div></td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center"><button type="button" class="btn btn-primary btn-circle"><i class="fa fa-list"></i>
                                            </button></td>
                                        </tr>
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
                <div class="tab-pane fade" id="profile">
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
                                            <th>Dates</th>
                                            <th>Status</th>
                                            <th>Faculty</th>
                                            <th>Speciality</th>
                                            <th>Min avg ball</th>
                                            <th>Total quantity</th>
                                            <th>Available quantity</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr class="gradeA">
                                            <td><div class="checkbox">
                                                <label><input type="checkbox" value=""></label>
                                            </div></td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>

                                        </tr>
                                        <tr class="gradeA">
                                            <td><div class="checkbox">
                                                <label><input type="checkbox" value=""></label>
                                            </div></td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>

                                        </tr>
                                        <tr class="gradeA">
                                            <td><div class="checkbox">
                                                <label><input type="checkbox" value=""></label>
                                            </div></td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>

                                        </tr>
                                        <tr class="gradeA">
                                            <td><div class="checkbox">
                                                <label><input type="checkbox" value=""></label>
                                            </div></td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>

                                        </tr>
                                        <tr class="gradeA">
                                            <td><div class="checkbox">
                                                <label><input type="checkbox" value=""></label>
                                            </div></td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>

                                        </tr>
                                        <tr class="gradeA">
                                            <td><div class="checkbox">
                                                <label><input type="checkbox" value=""></label>
                                            </div></td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>

                                        </tr>
                                        <tr class="gradeA">
                                            <td><div class="checkbox">
                                                <label><input type="checkbox" value=""></label>
                                            </div></td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>

                                        </tr>
                                        <tr class="gradeA">
                                            <td><div class="checkbox">
                                                <label><input type="checkbox" value=""></label>
                                            </div></td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>

                                        </tr>
                                        <tr class="gradeA">
                                            <td><div class="checkbox">
                                                <label><input type="checkbox" value=""></label>
                                            </div></td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>

                                        </tr>
                                        <tr class="gradeA">
                                            <td><div class="checkbox">
                                                <label><input type="checkbox" value=""></label>
                                            </div></td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>

                                        </tr>
                                        <tr class="gradeA">
                                            <td><div class="checkbox">
                                                <label><input type="checkbox" value=""></label>
                                            </div></td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>

                                        </tr>
                                        <tr class="gradeA">
                                            <td><div class="checkbox">
                                                <label><input type="checkbox" value=""></label>
                                            </div></td>
                                            <td>Internet Explorer 4.0</td>
                                            <td>Win 95+</td>
                                            <td class="center">4</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>
                                            <td class="center">X</td>

                                        </tr>
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
                                            <th>idFac</th>
                                            <th>Fac</th>
                                        </tr>
                                        </thead>
                                        <tbody>


                                            <c:forEach items="${listFaculties}" var="faculty" >
                                                <tr>
                                                    <td><div class="checkbox">
                                                        <label><input type="checkbox" value=""></label>
                                                    </div></td>
                                                    <td>${faculty.idFaculty}</td>
                                                    <td>${faculty.facultyName}</td>
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
                            <button type="button" class="btn btn-primary btn-lg">Delete student</button>
                            <button type="button" class="btn btn-primary btn-lg">Assign student</button>
                            <button type="button" class="btn btn-primary btn-lg">Release student</button>
                        </p>
                    </div>
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

</body>
</html>
