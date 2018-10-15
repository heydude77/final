package app.controller.webSocket;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;

@Controller
public class ChatSocketController extends TextWebSocketHandler{
	@Autowired
	Gson gson;
	
	List<WebSocketSession> sockets;
	
	public ChatSocketController() {
		sockets = new ArrayList<>();
	}
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sockets.add(session);
	}
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sockets.remove(session);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		
		String got = message.getPayload();
		Map map = gson.fromJson(got, Map.class);
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
