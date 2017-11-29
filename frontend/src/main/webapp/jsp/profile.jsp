<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>profile</title>

    <link href="../resources/css/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../resources/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../resources/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <link href="../resources/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <script src="../https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>

    <script src="../https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

</head>
<body>

<jsp:include page="/jsp/blocks/header.jsp"/>

<div id="wrapper">

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">

        <div class="nav navbar-bot-links navbar-right" style="margin: 5px">
            <a href="/logout" class="btn btn-primary btn-block"><b>Выйти</b></a>
        </div>

    </nav>

    <!-- Page Content -->
    <div class="col-lg-12">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Student page</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>

        <div class="col-md-4 ">

            <div class="panel panel-default">
                <div class="panel-heading">  <h4>User Profile</h4></div>
                <div class="panel-body">

                    <div class="box box-info">

                        <div class="box-body">
                            <div class="col-sm-6">
                                <div align="center"> <img alt="User Pic" src="https://x1.xingassets.com/assets/frontend_minified/img/users/nobody_m.original.jpg" id="profile-image1" class="img-circle img-responsive">

                                    <input id="profile-image-upload" class="hidden" type="file">
                                    <div style="color:#999;">click here to change profile image</div>
                                    <!--Upload Image Js And Css-->



                                </div>

                                <br>

                                <!-- /input-group -->
                            </div>
                            <div class="col-sm-6">
                                <h4 style="color:#00b1b1;">${user.firstName} ${user.lastName}</h4>
                                <span><p>Student</p></span>
                            </div>
                            <div class="clearfix"></div>
                            <hr style="margin:5px 0 5px 0;">


                            <div class="col-sm-5 col-xs-6 tital ">First Name:</div><div class="col-sm-7 col-xs-6 ">${user.firstName}</div>
                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital ">Last Name:</div><div class="col-sm-7">${user.lastName}</div>
                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital ">Group:</div><div class="col-sm-7">${student.idGroup}</div>

                            <div class="clearfix"></div>
                            <div class="bot-border"></div>


                            <div class="col-sm-5 col-xs-6 tital ">Faculty:</div><div class="col-sm-7">${listFaculties.stream().filter(FacultiesEntity -> FacultiesEntity.getIdFaculty()==(listSpecialities.stream().filter(SpecialityEntity -> SpecialityEntity.getIdSpec()==student.getIdSpec()).findFirst().get().getIdFaculty())).findFirst().get().getFacultyName()}</div>

                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital ">Speciality:</div><div class="col-sm-7">${listSpecialities.stream().filter(SpecialityEntity -> SpecialityEntity.getIdSpec()==student.getIdSpec()).findFirst().get().getNameSpec()}</div>

                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital ">Avg ball:</div><div class="col-sm-7">${student.avgBall}</div>


                            <!-- /.box-body -->
                        </div>
                        <!-- /.box -->

                    </div>


                </div>
            </div>
        </div>
        <div class="col-lg-8">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Info about student
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <!-- Nav tabs -->
                    <ul class="nav nav-tabs">
                        <li class="active"><a href="#home" data-toggle="tab" aria-expanded="false">About</a>
                        </li>
                        <li class=""><a href="#profile" data-toggle="tab" aria-expanded="false">Rating</a>
                        </li>
                        <li class=""><a href="#messages" data-toggle="tab" aria-expanded="true">Science</a>
                        </li>
                        <li class=""><a href="#settings" data-toggle="tab" aria-expanded="false">Practice info</a>
                        </li>
                    </ul>

                    <!-- Tab panes -->
                    <div class="tab-content">
                        <div class="tab-pane fade" id="home">
                            <h4>Home Tab</h4>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                        </div>
                        <div class="tab-pane fade" id="profile">
                            <h4>Profile Tab</h4>
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>First Name</th>
                                        <th>Last Name</th>
                                        <th>Username</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>Mark</td>
                                        <td>Otto</td>
                                        <td>@mdo</td>
                                    </tr>
                                    <tr>
                                        <td>2</td>
                                        <td>Jacob</td>
                                        <td>Thornton</td>
                                        <td>@fat</td>
                                    </tr>
                                    <tr>
                                        <td>3</td>
                                        <td>Larry</td>
                                        <td>the Bird</td>
                                        <td>@twitter</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="tab-pane fade active in" id="messages">
                            <h4>Messages Tab</h4>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                        </div>
                        <div class="tab-pane fade" id="settings">
                            <h4>Settings Tab</h4>
                            <p>NA INTEGRALE</p>
                            <button type="button" class="btn btn-success">SNYAT" S PRAKTIKI</button>
                            <button type="button" class="btn btn-success">NAZNACHIT' NA PRAKTIKU</button>
                        </div>
                    </div>
                </div>
                <!-- /.panel-body -->
            </div>
            <!-- /.panel -->
        </div>
        <!-- /.container-fluid -->
    </div>
    <!-- /#page-wrapper -->

</div>

<script src="../resources/js/libs/jquery-3.2.1.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="../resources/js/libs/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="../resources/js/metisMenu.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="../resources/js/sb-admin-2.js"></script>

</body>
</html>
