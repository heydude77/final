package app.controller.webSocket;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.digester.xmlrules.FromXmlRuleSet;
import org.apache.ibatis.javassist.ClassMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;
import com.google.gson.annotations.JsonAdapter;

import models.AlertService;

@Controller
public class WebSocketController extends TextWebSocketHandler {
	@Autowired
	   Gson gson;

	   @Autowired
	   AlertService service;

	   @Override
	   public void afterConnectionEstablished(WebSocketSession session) throws Exception {
	      // 클라이언트 측에서 WebSocket 객체를 생성해서 연결이 될때
	      service.addSocket(session);
	      System.out.println("afterConnectionEstablished..\n"+session+" / "+ service.totalSize());

	      Map data = new HashMap();
		      data.put("mode", "needId");
	      TextMessage msg=new TextMessage(gson.toJson(data));
	      session.sendMessage(msg);

	   }

	   @Override
	   public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
	      // 클라이언트 측에서 사용중인 WebSocket 이 종료 될때   
	      System.out.println("afterConnectionClosed..");
	      service.removeSocket(session);
	   }

	   @Override
	   protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
	      // 클라이언트 측에서 Websocket 객체를 통해 데이터를 전송했을때.
	      String payload=message.getPayload();
	      System.out.println("handleTextMessage >> "+payload);
	      Map map = gson.fromJson(payload, Map.class);
	      if(map.get("mode").equals("login")) {
	    	Map data = new HashMap();  
	    	data.put("mode", "login");
	      	data.put("user", map.get("userId"));
	      	service.sendAll(data);
	      	System.out.println("data sent..");
	      }	      	     

	   }
}
