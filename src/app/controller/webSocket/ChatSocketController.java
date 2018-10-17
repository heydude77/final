package app.controller.webSocket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;

import models.AlertService;

@Controller
public class ChatSocketController extends TextWebSocketHandler{
	@Autowired
	Gson gson;
	
	@Autowired
	AlertService service;
	
	List<WebSocketSession> sockets;
	List<WebSocketSession> notHere;
	List<WebSocketSession> notInTheRoom;
	
	public ChatSocketController() {
		sockets = new ArrayList<>();
		
	}	
	public List<WebSocketSession> getWsList(){
		notHere = service.getConnetionList();		
		
		
		for (int i = 0; i < notHere.size(); i++) {
			System.out.println("cl:"+notHere.get(i).getAttributes());
			System.out.println("socket:"+sockets.get(i).getAttributes());
			if(notHere.get(i).getAttributes().get("userId")
					.equals(sockets.get(i).getAttributes().get("userId"))) {
				notHere.remove(notHere.get(i));
			}
		}
		return notHere;
	}
	
	
	public List<WebSocketSession> getChatConnectors() {
		return sockets;
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sockets.add(session);
		Map map = new HashMap();
			map.put("mode", "newUser");
		service.sendToList(gson.toJson(map),getWsList());
		System.out.println("sent : "+gson.toJson(map));
				
	}
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sockets.remove(session);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		
		
		String got = message.getPayload();
		Map map = gson.fromJson(got, Map.class);
		System.out.println(map.get("mode"));
		if(map.get("mode").equals("public")) {
			System.out.println("attrs :"+session.getAttributes());
			Map info = (Map) session.getAttributes().get("info");
				String name = (String) info.get("NAME");
				String dname = (String) info.get("DNAME");
				String pname = (String) info.get("PNAME");
				map.put("name", name);
				map.put("dname", dname);
				map.put("pname", pname);			
			TextMessage tm = new TextMessage(gson.toJson(map));
			
			for (int i = 0; i < sockets.size(); i++) {
				try {				
					sockets.get(i).sendMessage(tm);
					
				} catch (Exception e) {
					e.printStackTrace();
				}			
			}			
			Map newM = gson.fromJson(got, Map.class);
				newM.put("mode", "newMessage");
				newM.put("name", name);
				newM.put("dname", dname);
				newM.put("pname", pname);
			System.out.println(newM);
			TextMessage alertNewMessage = new TextMessage(gson.toJson(newM));
			for (int i = 0; i < notHere.size(); i++) {
				notHere.get(i).sendMessage(alertNewMessage);
			}
		}else {
			Map info = (Map) session.getAttributes().get("info");
				String name = (String) info.get("NAME");
				String dname = (String) info.get("DNAME");
				String pname = (String) info.get("PNAME");
				map.put("name", name);
				map.put("dname", dname);
				map.put("pname", pname);	
			TextMessage tm = new TextMessage(gson.toJson(map));
			for (int i = 0; i < sockets.size(); i++) {
				try {				
					System.out.println("socketATT!! : "+sockets.get(i).getAttributes());
					Map socketInfo = (Map) sockets.get(i).getAttributes().get("info");
					if(socketInfo.get("PNAME").equals(pname)) {
						sockets.get(i).sendMessage(tm);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}			
			}
		}
	}
}
