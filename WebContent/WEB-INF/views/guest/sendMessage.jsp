<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h5>쪽지 보내기</h5>
<a href="${pageContext.servletContext.contextPath}/messageList.do">
 <button class="btn btn-dark">쪽지함</button></a>
 <hr>
<form class="form-inline">
  <label class="my-1 mr-2" for="inlineFormCustomSelectPref">보낼사람</label>
  <select class="custom-select my-1 mr-sm-2" id="departments" onchange="department(this);">
   		<c:forEach var="d" items="${departments}">
			<option value="${d.DID}"> ${d.DNAME }</option>    
   	 	</c:forEach>    
  </select>
  <select class="custom-select my-1 mr-sm-2" id="name" >
  
  </select>

  <button type="submit" class="btn btn-primary my-1">Submit</button>
</form>

<script>
	var department =  function(did){		
		var did = did.value;	
		var xhr = new XMLHttpRequest();
		xhr.open("get","${pageContext.servletContext.contextPath}/messageAjax.do?did="+did, true);
		xhr.onreadystatechange =function(){
			if(this.readyState==4) {
				var obj = JSON.parse(this.responseText);
				console.log("obj="+obj);
				var html="<option value=\"all\">전체</option>";
				for (var i =0; i<obj.length; i++){	
					console.log(obj[i].NAME);
					html += "<option value="+obj[i].NAME+">"+obj[i].NAME+"</option>";
				}				
				document.getElementById("name").innerHTML = html;
			}
		}	
		xhr.send();
	}
	


</script>

