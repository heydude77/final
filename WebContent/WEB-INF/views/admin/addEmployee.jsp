<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>사원등록</h2>
<form action="${pageContext.servletContext.contextPath}/admin/employee/add.do" method="post">
	<div class="form-group">
	<label>이름</label> <input
			type="text" class="form-control" placeholder="Example input" name="name">
	</div>
	<div class="form-group">
		<label>부서/직책</label>
		<div class="row">
			<div class="col">
				<select class="form-control" name= "did">
					<c:forEach var="d" items="${departments}">
						<option value="${d.DID}"> ${d.DNAME }</option>
					</c:forEach>					
				</select>
			</div>
			<div class="col">
				<select class="form-control" name= "pid">
					<c:forEach var="p" items="${positions}">
						<option value="${p.PID}"> ${p.PNAME}</option>
					</c:forEach>
				</select>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label>입사일</label> <input
			type="date" class="form-control" placeholder="Another input" name="date">
	</div>
	<div class="form-group">
		<button type="submit"  class="form-control btn btn-outline-primary">사원등록</button>
	</div>
</form>