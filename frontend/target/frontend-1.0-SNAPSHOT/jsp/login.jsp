<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Login page</title>
    <link type="text/css" rel="stylesheet" href="resources/css/style.css"/>
</head>
<body>
<jsp:include page="/jsp/blocks/header.jsp"/>

<div class="container" style="max-width: 500px ">
            <form role="form">
                <fieldset>
                    <h2>Sign In</h2>
                    <hr class="colorgraph">
                    <div class="form-group">
                        <input type="email" name="email" id="email" class="form-control input-lg" placeholder="Email Address">
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" id="password" class="form-control input-lg" placeholder="Password">
                    </div>
                    <span class="button-checkbox">
					<button type="button" class="btn" data-color="info"><input type="checkbox" name="remember_me" id="remember_me" checked="checked" class="hidden"> Remember Me</button>

				</span>
                    <hr class="colorgraph">
                    <div class="row">
                        <div class="col-xs-12 col-sm-8 col-md-6">
                            <input type="submit" class="btn btn-lg btn-success btn-block" value="Sign In">
                        </div>
                    </div>
                </fieldset>
            </form>
</div>
</body>
</html>