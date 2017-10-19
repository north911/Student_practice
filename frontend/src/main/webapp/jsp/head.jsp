<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 17.10.2017
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Head of practice page</title>

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
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">

        <div class="nav navbar-bot-links navbar-right" style="margin: 5px">

            <form action="/logout" method="post">
                <div class="form-group">
                    <input class="btn btn-xs btn-success btn-block" type="submit" value="logout">
                </div>
            </form>
        </div>

    </nav>



    <div class="col-lg-12">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Requests</h1>
            </div>

        </div>

        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Table of the students
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
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
                                <th>Show info</th>
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
                                <td><button></button></td>
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
                                <td><button></button></td>
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
                                <td><button></button></td>
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
                                <td><button></button></td>
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
                                <td><button></button></td>
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
                                <td><button></button></td>
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
                                <td><button></button></td>
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
                                <td><button></button></td>
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
                                <td><button></button></td>
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
                                <td><button></button></td>
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
                                <td><button></button></td>
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
                                <td><button></button></td>
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
        <!-- /.row -->


    </div>
    <!-- /#page-wrapper -->

</div>

<script src="../resources/js/libs/jquery-3.2.1.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="../resources/js/libs/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="../resources/js/metisMenu.min.js"></script>

<script src="../resources/js/jquery.dataTables.min.js"></script>
<script src="../resources/js/dataTables.bootstrap.min.js"></script>
<script src="../resources/js/dataTables.responsive.js"></script>

<script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
</script>

</body>
</html>
