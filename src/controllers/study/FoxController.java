package controllers.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/study")
public class FoxController {

	/*
	 * @RequestBody 
	 *  : POST 요청일때, 넘어온 내용을 param 처리하지 않고, 바로 얻어다가 사용
	 *  AJAX post 처리용으로 readLine() 처리한 결과물을 확보해줌.
	 */
	@RequestMapping("/13.do")
	public String study13Handle() {
		return "/WEB-INF/views/send.jsp";
	}
	
	@RequestMapping("/13ajax.do")
	public void study13handle(@RequestBody String body) {
		System.out.println(body);	// GSON 객체 fromJSON
	}
	
}
