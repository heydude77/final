<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<body>
 <h5>정보변경 페이지</h5>
 <small>보안을위해 한번더 로그인을 진행합니다.</small>
 <form class="form-inline"
 action="${pageContext.servletContext.contextPath }/infoChange.do" method="post">
  <div class="form-group mb-2">
    <label for="staticEmail2" class="sr-only">${info.ID}</label>
    <input type="text" readonly class="form-control-plaintext" value="${info.ID}" name="id">
  </div>
  <div class="form-group mx-sm-3 mb-2">
    <label for="inputPassword2" class="sr-only">Password</label>
    <input type="password" class="form-control" id="inputPassword" placeholder="Password" name="pw">
  </div>
  <button type="submit" class="btn btn-primary mb-2">Confirm identity</button>
</form>
</body>
