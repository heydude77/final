<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<body>
<div class="btn-group btn-group-toggle" data-toggle="buttons"> 
  <label class="btn btn-secondary">
    <a type="radio"  id="received" onclick="received()" > 받은메세지 </a>
  </label>
  <label class="btn btn-secondary">
    <a type="radio"  id="sent" onclick="sent()" > 보낸메세지 </a>
  </label>
</div>
<a href="${pageContext.servletContext.contextPath}/sendMessage.do">
 <button class="btn btn-dark">메세지 보내기</button></a>
<div class="row" id="showMessage">
        <div class="col-md-3">보낸사람</div>
        <div class="col-md-6">메세지</div>
        <div class="col-md-3">받은시간</div>
</div>

<script>
	
	var received = function(){
		console.log("r");
		var received = "<div class=\"col-md-2\">보낸사람</div>";
        received += "<div class=\"col-md-6\">메세지</div>";
        received += "<div class=\"col-md-2\">받은시간</div>";
        document.getElementById("showMessage").innerHTML = received;
	};
	
	var sent = function(){
		console.log("s");
		var sent =  "<div class=\"col-md-2\">받은사람</div>";
        sent += "<div class=\"col-md-6\">메세지</div>";
        sent += "<div class=\"col-md-2\">받은시간</div>";
        sent += "<div class=\"col-md-2\">상태</div>";
      	
		document.getElementById("showMessage").innerHTML = sent;
	};
</script>

</body>