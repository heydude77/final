package app.controller.index;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {

	@GetMapping("/room.do")
	public String chatRoomHandle(Map map) {
		map.put("uri", "chat");
		return "guest.chat";
	}
}
