<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test</title>
</head>
<body>
   <h1>WebSocket</h1>
   <p>
      웹소켓은  ws 프로토콜 기반으로 작동하는 기술로 ,<br/>
      서버와 클라이언트가 연결을 유지한 채로 데이터를 주고 받고자 할때 사용되게 된다.
   </p>
   <p>
      스크립트로 객체 생성을 하면 되고 , 연결하고자 하는 서버측의 주소를 설정해두면 된다.
      이걸 받아서 처리할 server가 필요한데 , TomCate은 이 http요청 외에 ws 프로토콜도 받을수있고 <br/>
      ws 프로토콜 처리용 프로그램을 따로 설정을 해야 되는데 <br/>
      Spring은 별도로 따로 만들지 않더라도 , http 와 같이 처리가 가능하다 .      
   </p>
   <p>
      maven 에서 spring websocket 를 찾아서 연동.
   </p>
   
   <button type="button" onclick="dataSend();">WS에 data 전송!!</button>
      
   <script>
   console.log(location.host);
   console.log(location.hostname);
   console.log(location.origin);
   
   var ws = new WebSocket("ws://"+location.host+
         "${pageContext.servletContext.contextPath}/conn.do");
   
   ws.onmessage=function(ex){   
      //매개 변수 설정하면 받은 내용에 관련된 객체를 넘겨주면서 콜이 일어나고 , 
      console.log(ex.data);
      var ojb=JSON.parse(ex.data);
      switch (ojb) {
      case "welcome":
         break;
      case "login":
         break;
      }
   };
   
   var dataSend = function(){
      var data = {"mode":1,"text":"웹소켓으로 데이터 전송"};
      ws.send(JSON.stringify(data));
   };
   
   </script>
   
   
   
</body>
</html>