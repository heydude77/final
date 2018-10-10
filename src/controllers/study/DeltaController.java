package controllers.study;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.request.WebRequest;

/*
 *  요청처리메서드에 사용할수 있는 인자들을 좀더 살펴보자.
 *  
 */

@Controller
@RequestMapping("/study")
public class DeltaController {

	@RequestMapping("/09.do")
	public void study09handle(WebRequest wr) {
		wr.setAttribute("auth", true, WebRequest.SCOPE_SESSION);
		Map one = new HashMap();
			one.put("ID", "saan");
			one.put("NAME", "윤형호");
			one.put("grade", 3);
		wr.setAttribute("user", one, WebRequest.SCOPE_SESSION);
		
	}
	//================================================================
	
	@RequestMapping("/10.do")
	public void study10handle(@SessionAttribute(required=false) Boolean auth, @SessionAttribute(required=false) Map user) {
		System.out.println(auth);
		System.out.println(user);
	}
	
	
	
	
	
	
}





