package app.controller.webSocket;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import models.ChatRepository;

@Controller
public class ChatSocketController extends TextWebSocketHandler{
	@Autowired
	Gson gson;
	
	@Autowired
	AlertService service;
	
	@Autowired
	ChatRepository cr;
	
	List<WebSocketSession> sockets;
	List<WebSocketSession> notHere;
	List<WebSocketSession> notInTheRoom;
	
	public ChatSocketController() {
		sockets = new ArrayList<>();
		
	}	
	/*===========채팅접속자 관리 리스트 만들다가 일단 보류 =======
	 * 
	 * public List<WebSocketSession> getChatConnectionList(){
		notHere = service.getConnetionList();		
				
		for (int i = 0; i < notHere.size(); i++) {
			if(notHere.get(i).getAttributes().get("userId")
					.equals(sockets.get(i).getAttributes().get("userId"))) {
				notHere.remove(notHere.get(i));
			}
		}
		return notHere;
	}
	*/
	
	public List<Map> getSocketsAttributes() {
		List<Map> list = new ArrayList<>();
			for (int i = 0; i < sockets.size(); i++) {
				Map info = (Map) sockets.get(i).getAttributes().get("info");
				list.add(info);
			}
		return list;
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sockets.add(session);
		Map info = (Map) session.getAttributes().get("info");
		System.out.println("chatSocket:"+info);
		System.out.println("chatController..afterConnections established");
		System.out.println("sockets : "+sockets);
		Map map = new HashMap();
			map.put("mode", "newUser");
			map.put("chatSockets", getSocketsAttributes());
			map.put("who", info.get("NAME"));
		service.sendToList(gson.toJson(map),sockets);
		System.out.println("sent : "+gson.toJson(map));
				
	}
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sockets.remove(session);
		Map info = (Map) session.getAttributes().get("info");
		System.out.println("chatSocket:"+info);
		Map map = new HashMap();
		map.put("mode", "userLeft");
		map.put("chatSockets", getSocketsAttributes());
		map.put("who", info.get("NAME"));
		service.sendToList(gson.toJson(map),sockets);
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
			
			String hid = (String) map.get("_id");
			String htext = (String) map.get("text");
			String hname = (String) map.get("name");
			String hdname = (String) map.get("dname");
			String hpname = (String) map.get("pname");
			
			Date current = new Date();
			SimpleDateFormat smt = new SimpleDateFormat("HH:mm:ss");
			String typeTime = smt.format(current.getTime());
			
			Map history =  new HashMap();
				history.put("id", hid);
				history.put("text", htext);
				history.put("name", hname+"("+hname+"/"+hname+")");
				List read = new ArrayList();
					read.add(hid);
				history.put("read", read);
				history.put("date", typeTime);
				
			cr.insertOne(history);
			
			
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
