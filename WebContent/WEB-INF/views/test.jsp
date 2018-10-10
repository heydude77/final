<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title></title>
</head>
<body>
		
		map.put("departments", er.getDepartments());
		map.put("positions", er.getPositions());
		
	<c:forEach var="d" items="${departments}">
		바로뽑는거 ${d.DID },${d.DNAME }
	</c:forEach>
</body>
</html>