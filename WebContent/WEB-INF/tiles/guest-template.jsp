<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath }/css/dashboard.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
<link href="${pageContext.servletContext.contextPath }/css/bootstrap.css" rel="stylesheet">

    


<title>사내 관리 프로그램</title>

<title>그룹웨어</title>
</head>
<body>
	<nav
		class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
		<tiles:insertAttribute name="nav" />
	</nav>
	<div class="container-fluid">
		<div class="row">
			<nav class="col-md-2 d-none d-md-block bg-light sidebar">
				<tiles:insertAttribute name="left" />
			</nav>	
			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
			<h1 class="h2">GROUPWARE</h1>
	
				<div class="d-flex align-items-center p-3 my-3 text-white-50 bg-purple rounded shadow-sm">
			        <div class="lh-100">
			          <h6 class="mb-0 text-white lh-100">${info.NAME}님</h6>
			          <small>${info.DNAME}-${info.PNAME} // 접속시간 : ${info.loginTime}</small>
			        </div>
	    		  </div>
			<tiles:insertAttribute name="center" /> </main>
		</div>
	</div>
</body>
</html>