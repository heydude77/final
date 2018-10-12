<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body>


 <h5>정보변경 페이지</h5>
  <div class="form-group row">
    <label class="col-sm-2 col-form-label">아이디</label>
    <div class="col-sm-10">
      <input type="text" readonly class="form-control-plaintext"value="${info.ID}">      
    </div>
  </div>
  
  <div class="form-group row">
    <label class="col-sm-2 col-form-label">이름</label>
    <div class="col-sm-10">
      <input type="text" readonly class="form-control-plaintext"value="${info.NAME}">      
    </div>
  </div>
  
  <div class="form-group row">
    <label for="inputPassword" class="col-sm-2 col-form-label">비밀번호 변경</label>
    <div class="col-sm-10">
      <input type="password" placeholder="New Password" name="newPw" id="newPw">  <span id="error"></span><br/>
      <input type="password" placeholder="Confirm New Password" name="confirmPw" id="confirmPw"> 
      <button onclick="changePw(this);" class="btn btn-dark mb-1">비밀번호 변경!</button>
    </div>
  </div>
  
  <div class="form-group row">
    <label class="col-sm-2 col-form-label">부서 / 직급</label>
    <div class="col-sm-10">
      <input type="text" readonly class="form-control-plaintext"value="${info.DNAME} / ${info.PNAME}">      
    </div>
  </div>
  <button type="submit" class="btn btn-primary mb-2" >메인으로</button>
</body>

<script>	
	
	var changePw = function(pw){
		var pw = document.getElementById("newPw").value;
		var confirm = document.getElementById("confirmPw").value;
		console.log(pw);
		console.log(confirm);
		if(pw != confirm){
			document.getElementById("error").innerHTML = "비밀번호 값이 일치하지 않음";
		}else {
			ajax();
		}
	}
	
	var ajax= function(){
		var pw = document.getElementById("newPw").value;
		var id = "${info.ID}";
		var xhr = new XMLHttpRequest();
		xhr.open("get","${pageContext.servletContext.contextPath}/changePassword.do?id="+id+"+&pass="+pw, true);
		xhr.onreadystatechange =function(){
			if(this.readyState==4) {
				var obj = this.responseText;
				console.log("obj2="+obj);
							
				if(obj==1) {					
					window.alert("비번 바뀜 ㅋㅋ");
				} else {
					window.alert("에러남 ㅋㅋ");
				}
			}
		}	
		xhr.send();
	};


</script>