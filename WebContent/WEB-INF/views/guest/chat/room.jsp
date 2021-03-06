<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h4>Chat Room <small id="chatType">(All Departments)</small>
<small><button class="btn btn-dark" id="chatMode">부서 채팅</button></small></h4>
<div class="row">
  <div class="col-sm-8">
	<div style="height: 400px; overflow-y: scroll; " id="chatView">
	
	
	</div>
  </div>
   <div class="col-sm-4">
   	<ul class="list-group" style="height: 400px; overflow-y: scroll; color: gray" >
	   	<li class="list-group-item list-group-item-action list-group-item-secondary" value="${info.ID}"> ${info.NAME}(${info.DNAME}/${info.PNAME})</li>
			<li id="connectedList">
			
			</li>
		</ul>
   </div>
</div>
<div class="row">
	<div class="col-sm-8">
		<div class="input-group mb-3">
		  <div class="input-group-prepend">
		    <span class="input-group-text" id="basic-addon1">CHAT</span>
		  </div>
		  <input type="text" class="form-control" aria-describedby="basic-addon1" id="input">
			</div>
	</div>
	<div class="col-sm-4">
		버튼 하나 만들면댐
	</div>
</div>
<script>
	var mode ="public";
	
	var n = 1;
	document.getElementById("chatMode").onclick = function(){
		if(n%2==1){
			document.getElementById("chatType").innerHTML = "Department Chatting";
			document.getElementById("chatMode").innerHTML = "전체채팅";
			document.getElementById("chatView").innerHTML = "";
			mode ="department";
			n++;
		}else {
			document.getElementById("chatType").innerHTML = "All Departments";
			document.getElementById("chatMode").innerHTML = "부서채팅";
			document.getElementById("chatView").innerHTML = "";
			mode ="public";
			n--;
		}
		
		
	}
	var chatws = new WebSocket("ws://"+location.host+
			"${pageContext.servletContext.contextPath}/chat.do");
	chatws.onmessage = function(evt) {
		console.log("evt : "+evt.data);
		var obj = JSON.parse(evt.data);
		console.log(obj);
		switch(obj.mode) {
		case "public" :
			publicHandle(obj);
			break;
		case "department" :
			depHandle(obj);
			break;
		case "newUser":
			newUserHandle(obj);
			break;
		case "userLeft":
			newUserHandle(obj);
			break;
		}
	}

	
	var newUserHandle = function(obj){
		var chatSockets = obj.chatSockets;
		console.log(chatSockets);
		var html = "";
		for (var i =0; i<chatSockets.length; i++){
			var userId = "${info.ID}";
			console.log("userid:"+userId);
			
			var id = chatSockets[i].ID;
			var name = chatSockets[i].NAME;
			var dname = chatSockets[i].DNAME;
			var pname = chatSockets[i].PNAME;
			if(userId != id){
			html += "<li class=\"list-group-item list-group-item-action list-group-item-secondary\" value="+id+"> "+name+"("+dname+"/"+pname+")</li>";
			}
		}
		
		if(obj.mode=="newUser"){
			document.getElementById("chatView").innerHTML += obj.who+" 님이 입장하셨습니다.<br\>";
		}
		if(obj.mode=="userLeft"){
			document.getElementById("chatView").innerHTML += obj.who+" 님이 퇴장하셨습니다.<br\>";
		}
		document.getElementById("connectedList").innerHTML = html;
	};
	
	var depHandle = function(obj) {
		
	}
		
	var publicHandle = function(obj) {
		var rep = obj;
		console.log(rep);
		var html = "<div class=\"alert alert-secondary\" role=\"alert\" style=\"padding:3px; margin-bottom:3px;\">";
		html += obj.name +"("+obj.dname+"/"+obj.pname+") : ";
		html += obj.text;
		html +="</div>";
		document.getElementById("chatView").innerHTML += html;
		document.getElementById("chatView").scrollTop = document.getElementById("chatView").scrollHeight; 
	}
	
	document.getElementById("input").onchange = function(){
		console.log(this.value);
		var msg= {
				//({"_id":"em1014", "name":"구구구", "text" : "채팅내용.","date": "14:31","read" :["em1040","em9999"]});
				"mode" : mode,	
				"_id" : "${info.ID}",
				"name" : "${info.NAME}",
				"dname" : "${info.DNAME}",
				"pname" : "${info.PNAME}",
 				"text" : this.value
		};
		chatws.send(JSON.stringify(msg));
		this.value="";
	}
	
	
</script>