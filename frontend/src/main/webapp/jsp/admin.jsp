<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 17.10.2017
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Admin page</title>

    <link href="../resources/css/metisMenu.min.css" rel="stylesheet">

    <link href="../resources/css/sb-admin-2.css" rel="stylesheet">

    <link href="../resources/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <link href="../resources/css/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="../resources/css/dataTables.responsive.css" rel="stylesheet">



    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

</head>
<body>
<jsp:include page="/jsp/blocks/header.jsp"/>

<div id="wrapper">

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-static-top" role="navigation"  style="background-color: darkcyan" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <!-- /.navbar-header -->

        <!-- /.navbar-static-side -->
    </nav>



    <div class="col-md-12">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">ADMIN PAGE</h1>
            </div>
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <button type="button" class="btn btn-primary">Show all req</button>
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
                                                <div class="col-md-4"></div>
                                                <div class="col-md-4"><input></div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-3 "><label>quantity</label></div>
                                                <div class="col-md-6 col-md-offset-1"><label>faculty</label></div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-3"><input></div>
                                                <div class="col-md-6 col-md-offset-1"><input></div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-3 "><label>Availabe spec</label></div>
                                                <div class="col-md-6 col-md-offset-1"><label>Min avg ball</label></div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-3"><input></div>
                                                <div class="col-md-6 col-md-offset-1"><input></div>
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
                                                <div class="col-md-5"><input></div>
                                                <div class="col-md-5 col-md-offset-1 "><input></div>
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
                        <button type="button" class="btn btn-primary">Create spec???</button>
                        <button type="button" class="btn btn-primary">Create fac???</button>
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
                <li class=""><a href="#messages" data-toggle="tab" aria-expanded="false">Reserved tab</a>
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
                    <h4>Messages Tab</h4>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
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

<!-- jQuery -->
<!-- jQuery -->
<script src="../resources/js/libs/jquery-3.2.1.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="../resources/js/libs/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="../resources/js/metisMenu.min.js"></script>

<script src="../resources/js/jquery.dataTables.min.js"></script>
<script src="../resources/js/dataTables.bootstrap.min.js"></script>
<script src="../resources/js/dataTables.responsive.js"></script>

<!-- Page-Level Demo Scripts - Tables - Use for reference -->
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

</body>
</html>
