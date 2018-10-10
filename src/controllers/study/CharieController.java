package controllers.study;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * Controller 클래스 만들면서 요청 핸들 메서드에 설정할수 있는 남아있는 인자들은
 *  지금까지 살펴본거 쓰는 방법 익히고 살펴보자.
 *
 * View 처리하는 방법부터 2개 살펴보자.
 */
@Controller
@RequestMapping("/study")
public class CharieController {

	@RequestMapping("/99.do")
	public String study99Handle(Map map) {
		// ViewResolver로 InternalResourceViewResolver를 등록시켜둔 상황이기 때문에
		// 리턴타입 String 잡고, 뷰로 사용할 JSP 위치 리턴시키면 DispatcherServlet이 해당 jsp로
		// forward를 시켜줄꺼다.
		map.put("no", 45);
		
		return "/WEB-INF/views/default.jsp";
	}
	
	@RequestMapping("/98.do")
	public String study98Handle(Map map) {
		// 만약, 리다이렉트를 하고 싶다면 (다른 컨트롤러로 사용자를 보내고 싶다)
		// cf# 데이터 설정할 Map을 Inject 받아서, 값 설정후 redirect 처리하면,
		// 리다이렉트 시킬때 파라미터로 붙여서 설정시켜준다.
		map.put("no", 45);
		
		return "redirect:/index.do";	// 앞에 redirect: 붙이고 경로 설정
	}
}
