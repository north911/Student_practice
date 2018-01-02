<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/jsp/blocks/header.jsp"/>
    <title>profile</title>

    <link href="../resources/css/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../resources/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../resources/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <link href="../resources/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <script src="../https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>

    <script src="../https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

<script>
    function myFunction() {
        location.reload();
    }
</script>
</head>
<body>



<div id="wrapper">

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">

        <div class="nav navbar-bot-links navbar-right" style="margin: 5px">
            <p>loggined as ${currentAuth.lastName}</p>
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

                                </div>

                                <br>

                                <!-- /input-group -->
                            </div>
                            <div class="col-sm-6">
                                <h4 style="color:#00b1b1;">${student.firstName} ${student.lastName}</h4>
                                <span><p>Student</p></span>
                            </div>
                            <div class="clearfix"></div>
                            <hr style="margin:5px 0 5px 0;">


                            <div class="col-sm-5 col-xs-6 tital ">First Name:</div><div class="col-sm-7 col-xs-6 ">${student.firstName}</div>
                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital ">Last Name:</div><div class="col-sm-7">${student.lastName}</div>
                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital ">Group:</div><div class="col-sm-7">${student.idGroup}</div>

                            <div class="clearfix"></div>
                            <div class="bot-border"></div>


                            <div class="col-sm-5 col-xs-6 tital ">Faculty:</div><div class="col-sm-7">${student.facName}</div>

                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital ">Speciality:</div><div class="col-sm-7">${student.specName}</div>

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
                        <li class=""><a href="#profile" data-toggle="tab" aria-expanded="false">My practices</a>
                        </li>
                        <li class=""><a href="#messages" data-toggle="tab" aria-expanded="true">Science</a>
                        </li>
                        <li class=""><a href="#settings" data-toggle="tab" aria-expanded="false">Practice status</a>
                        </li>
                    </ul>

                    <!-- Tab panes -->
                    <div class="tab-content">
                        <div class="tab-pane fade" id="home">
                            <h4>Home Tab</h4>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                        </div>
                        <div class="tab-pane fade" id="profile">
                            <h4>Practice tab</h4>
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>cb</th>
                                        <th>Company name</th>
                                        <th>Date from</th>
                                        <th>Date to</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${listPractices}" var="practice" >
                                        <tr>
                                            <td><div class="checkbox">
                                                <label><input type="checkbox" name="checkboxlist" value="${practice.idRequest}"></label>
                                            </div></td>
                                            <td>${practice.companyName}</td>
                                            <td>${practice.dateFrom}</td>
                                            <td>${practice.dateTo}</td>

                                        </tr>
                                    </c:forEach>

                                    </tbody>
                                </table>
                                <button type="button" class="btn btn-danger" id="btn123">remove from checked</button>
                            </div>
                        </div>
                        <div class="tab-pane fade active in" id="messages">
                            <h4>Messages Tab</h4>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                        </div>
                        <div class="tab-pane fade" id="settings">
                            <h4>Status tab</h4>
                            <p>today is ${student.status}</p>
                            <p>${student.companyName}</p>
                            <p>${student.period}</p>
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

<script type="text/javascript">

    $(document).ready(function(){

        $('#btn123').click(function(){
            var checkValues = $('input[name=checkboxlist]:checked').map(function()
            {
                return $(this).val();
            }).get();
            if (checkValues.length > 0) {
            $.ajax({
                url: '/removeStudentFromPractice?${_csrf.parameterName}=${_csrf.token}',
                type: 'POST',
                data: { 'id': checkValues,
                    'id2': ${student.idUser}},
                success:function(data){
                    myFunction();
                },
                error:function(data){
                    alert("you dont have access");
            }
            });
            }
             else alert("nothing checked");
        });
    });

</script>
<script src="../resources/js/libs/jquery-3.2.1.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="../resources/js/libs/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="../resources/js/metisMenu.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="../resources/js/sb-admin-2.js"></script>

</body>
</html>
