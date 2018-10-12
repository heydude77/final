<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
<title>사내 관리 프로그램</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">


<!-- Custom styles for this template -->
<link href="${pageContext.servletContext.contextPath }/css/signin.css" rel="stylesheet">
</head>

<body class="text-center">
	<form action="${pageContext.servletContext.contextPath}/login.do" method="post" class="form-signin">
		 <img class="mb-4" src="${pageContext.servletContext.contextPath }/image/dal.jpg" alt="" width="200" height="250">
		<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
		<c:if test="${err}">
			
		</c:if>
		<label  class="sr-only">Employee Number</label> <input
			type="text" id="inutId" class="form-control"
			placeholder="Employee Number" required autofocus name="id"> <label
			 class="sr-only">Password</label> <input
			type="password" id="inputPassword" class="form-control"
			placeholder="Password" required name="pw">
			<small>최초 비밀번호는 1111로 설정되어 있습니다.</small>
		<div class="checkbox mb-3">
			<label> <input type="checkbox" value="remember-me">
				Remember me
			</label>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
			in</button>
		<p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
	</form>
</body>
</html>
