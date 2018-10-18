package app.controller.index;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import app.controller.webSocket.ChatSocketController;

@Controller
@RequestMapping("/chat")
public class ChatController {
	@Autowired
	ChatSocketController csc;
	
	@GetMapping("/room.do")
	public String chatRoomHandle(Map map, ModelMap mm) {
		//List list = (List) csc.getWsList();		
		//System.out.println("cscList : "+list);
		//mm.addAttribute(list);
		map.put("uri", "chat");
		return "guest.chat";
	}
}
