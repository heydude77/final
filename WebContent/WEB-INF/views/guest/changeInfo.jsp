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
      <input type="password" placeholder="Password" name="newPassword"> 
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

