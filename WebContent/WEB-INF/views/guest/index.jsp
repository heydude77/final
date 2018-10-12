<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <body> 
      <div class="my-3 p-3 bg-white rounded shadow-sm">
        <h6 class="border-bottom border-gray pb-2 mb-0">Recent updates</h6>
        <div id="recent">
        
        </div>
        <div class="media text-muted pt-3">
          <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
            <strong class="d-block text-gray-dark">타이틀값</strong>
          	최근 소식 입력칸 
          </p>
        </div>
        <div class="media text-muted pt-3">
          <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
            <strong class="d-block text-gray-dark">@username</strong>
            Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.
          </p>
        </div>
       
        <small class="d-block text-right mt-3">
          <a href="#">All updates</a>
        </small>
      </div>

      <div class="my-3 p-3 bg-white rounded shadow-sm">
        <h6 class="border-bottom border-gray pb-2 mb-0">Suggestions</h6>
        <div class="media text-muted pt-3">        
          <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
            <div class="d-flex justify-content-between align-items-center w-100">
              <strong class="text-gray-dark">Full Name</strong>
              <a href="#">Follow</a>
            </div>
            <span class="d-block">@username</span>
          </div>
        </div>
        <div class="media text-muted pt-3">        
          <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
            <div class="d-flex justify-content-between align-items-center w-100">
              <strong class="text-gray-dark">Full Name</strong>
              <a href="#">Follow</a>
            </div>
            <span class="d-block">@username</span>
          </div>
        </div>
        <div class="media text-muted pt-3">      
          <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
            <div class="d-flex justify-content-between align-items-center w-100">
              <strong class="text-gray-dark">Full Name</strong>
              <a href="#">Follow</a>
            </div>
            <span class="d-block">@username</span>
          </div>
        </div>
        <small class="d-block text-right mt-3">
          <a href="#">All suggestions</a>
        </small>
      </div>
      
   <script>
   
   /*
   
   var ws = new WebSocket("ws://"+location.host+
         "${pageContext.servletContext.contextPath}/conn.do");
   
   ws.onmessage = function(got){   
      //매개 변수 설정하면 받은 내용에 관련된 객체를 넘겨주면서 콜이 일어나고 ,      
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
   
  </body>
