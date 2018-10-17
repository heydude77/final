<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="sidebar-sticky">
	<ul class="nav flex-column">
		<li class="nav-item"><a class="nav-link active" href="#"> <span
				data-feather="home"></span> Dashboard <span class="sr-only">(current)</span>
		</a></li>
		<li class="nav-item"><a class="nav-link" href="#"> <span
				data-feather="file"></span> Orders
		</a></li>
		<li class="nav-item"><a class="nav-link" href="${pageContext.servletContext.contextPath }/chat/room.do"> <span
				data-feather="shopping-cart"></span> chat
		</a></li>		
	</ul>
	<h6
		class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
		<span>My Page</span> <a
			class="d-flex align-items-center text-muted" href="#"> <span
			data-feather="plus-circle"></span>
		</a>
	</h6>
	<ul class="nav flex-column mb-2">
		<li class="nav-item"><a class="nav-link" href="${pageContext.servletContext.contextPath }/messageList.do"> <span
				data-feather="users"></span> 쪽지함
		</a></li>
		<li class="nav-item"><a class="nav-link" href="${pageContext.servletContext.contextPath }/infoChange.do"> <span
				data-feather="file-text"></span> 내 정보 변경
		</a></li>
	</ul>
	<hr/>
	<h6
		class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
		<span>Alerts</span> <a
			class="d-flex align-items-center text-muted" href="#"> <span
			data-feather="plus-circle"></span>
		</a>
	</h6>
	<div id="alert" style="font-size: .75em">
	
	</div>
	
	<script>		
	   var ws = new WebSocket("ws://"+location.host+
	         "${pageContext.servletContext.contextPath}/conn.do");
		ws.onmessage = function(evt) {			
			var obj = JSON.parse(evt.data);
			switch(obj.mode) {
			case "login":
				loginAlertHandle(obj);
				break;
			case "invalidated" :
				invalidatedHandle();
				break;
			case "newMessage" :
				newMessageHandle(obj);
				break;
			}
		};		
		
		var newMessageHandle = function(obj){
			html += obj.name +"("+obj.dname+"/"+obj.pname+") : ";
			var html = "<div class=\"alert alert-warning alert-dismissible fade show\" role=\"alert\">";
			html += "<strong>【NewChatting】</strong><br/> 새로운 채팅이 있습니다.</br>";
			html += obj.name +"("+obj.dname+"/"+obj.pname+") : "+obj.text;
			html += "<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">";
			html += "<span aria-hidden=\"true\">&times;</span>";
			html += "</div>";
			document.getElementById("alert").innerHTML += html;
		}
		
		var loginAlertHandle = function(obj) {
			var name = obj.user.NAME;
	    	var dep = obj.user.DNAME;
	    	var posi = obj.user.PNAME;
	    	var time = obj.user.loginTime;
			var html = "<div class=\"alert alert-warning alert-dismissible fade show\" role=\"alert\">";
			html += "<strong>【로그인】</strong><br/>" + name+"(" + dep+"/"+ posi+"/"+time+")";
			html += "<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">";
			html += "<span aria-hidden=\"true\">&times;</span>";
			html += "</div>";
			document.getElementById("alert").innerHTML += html;
		};
		
		var invalidatedHandle = function(){
			var html = "<div class=\"alert alert-warning alert-dismissible fade show\" role=\"alert\">";
			html += "<strong>【중복로그인】</strong><br/> 사용하시는 아이디로 로그인이 감지 되었습니다. 다시 로그인 해주세요";
			html += "<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">";
			html += "<span aria-hidden=\"true\">&times;</span>";
			html += "</div>";
			document.getElementById("alert").innerHTML += html;
		}
		
		   /*
		  var ws = new WebSocket("ws://"+location.host+
		         "${pageContext.servletContext.contextPath}/conn.do");
		   
		   ws.onmessage = function(got){   		       
		      var obj = JSON.parse(got.data);     
		      switch (obj.mode) {
			      case "needId":	    	  
			    	  var info = {"mode":"login","userId":"${userId}"};
			    	  ws.send(JSON.stringify(info));
			         break;
			      case "login":	    	  
			    	  var name = obj.user.NAME;
			    	  var dep = obj.user.DNAME;
			    	  var posi = obj.user.PNAME;
			    	  var time = obj.user.loginTime;
			    	  var html = 
			    		 "<div class=\"media text-muted pt-3\"><p class=\"media-body pb-3 mb-0 small lh-125 border-bottom border-gray\">";
			          html += "<strong class=\"d-block text-gray-dark\">"+name+" 님 ("+dep+"-"+posi+")</strong>";
			          html += "로그인 하셨습니다. ("+time+") </p> </div>";
			          document.getElementById("recent").innerHTML+=html;
			          break;
		      }
		   };
		   */
		   
		  
		   
	</script>
</div>
