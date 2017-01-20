<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel='stylesheet' href='webjars/bootstrap/3.3.6/css/bootstrap.min.css'>

<style>
body {
	background: #eee !important;	
}

.wrapper {	
	margin-top: 80px;
  margin-bottom: 80px;
}

.form-signin {
  max-width: 380px;
  padding: 15px 35px 45px;
  margin: 0 auto;
  background-color: #fff;
  border: 1px solid rgba(0,0,0,0.1);  

  .form-signin-heading,
	.checkbox {
	  margin-bottom: 30px;
	}

	.checkbox {
	  font-weight: normal;
	}

	.form-control {
	  position: relative;
	  font-size: 16px;
	  height: auto;
	  padding: 10px;
		@include box-sizing(border-box);

		&:focus {
		  z-index: 2;
		}
	}

	input[type="text"] {
	  margin-bottom: -1px;
	  border-bottom-left-radius: 0;
	  border-bottom-right-radius: 0;
	}

	input[type="password"] {
	  margin-bottom: 20px;
	  border-top-left-radius: 0;
	  border-top-right-radius: 0;
	}
}

</style>


<title>Insert title here</title>
</head>
<body>

<div class="wrapper">
		<form id="loginForm" class="form-signin" method="post" action="loginCheck">
		<h2 class="form-signin-heading">Please login</h2>

			            User Name:

			            <input type="text"  class="form-control" id="username" name="username" value="${cookie.user.value}"/><br>

			            Password:

			            <input type="password"  class="form-control" id="password" name="password"/><br>
<label class="checkbox">
			 			<input type="checkbox" name="rememberMe" id="rememberMe" <c:if test="${cookie.containsKey('user')}">checked</c:if> /> Remember Me 
</label>
				            <input type="submit" class="btn btn-lg btn-primary btn-block" value="Submit" />

</form>
</div>

<script type="text/javascript" src="webjars/jquery/2.0.3/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>