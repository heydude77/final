package controllers.study;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

/*
 * DispatcherServlet이 연결시켜야될 Controller를 Mapping 처리하는법에 
 * 대해서 알아보았고, 이번에 요청Handle 메서드를 만드는 방식에 대해서 알아보려고 한다.
 * 
 * handle 메서드는 특정한 형태가 없고, 
 * 매개변수나 리턴타입에 유연한 방식을 제공하는데 지원되는것들에 선택해서 사용하면 된다.
 * 
 * ※ handle 메서드에 설정가능한 매개변수들 !
 */
@Controller
@RequestMapping("/study")
public class AlphaController {

	// 1. HttpServletRequest , HttpServletResponse, HttpSession 을 설정할수 있다.
	// 이 handle Method 가 작동될때 Spring에 의해서 객체가 설정되서 호출되게 되고,
	// 사용할수 있게된다. (Dependency Injection 라는 것.)
	@RequestMapping("/01.do")
	public void study01Handle(HttpServletRequest request, HttpSession session) {
		System.out.println("study01Handle()");
		
		String addr= request.getRemoteAddr();
		boolean is = session.isNew();
		System.out.println("is = " + is + " / addr = " + addr);
		session.setAttribute("auth", "on");
	}
	
	// 2. WebRequest : 파라미터나 request,session 에 attribute 를 
	// HttpServletRequest, HttpSession 없이 직접 제어하고자 할때.
	@RequestMapping("/02.do")
	public void study02Handle(WebRequest webRequest) {
		System.out.println("study02Handle()");
		
		String no = webRequest.getParameter("no");		
		String auth = (String)webRequest.getAttribute("auth", WebRequest.SCOPE_SESSION);
		webRequest.setAttribute("limit", 5, webRequest.SCOPE_SESSION);
		
	}
	
	// 3. Map, Model, ModelMap : 뷰로 넘어가게 됬을때 사용할 데이터들을 저장시키고자 할때
	@RequestMapping("/03.do")
	public String study03Handle(ModelMap modelMap) {
		modelMap.put("arr", new String[] {"model","view","controller"});
		modelMap.addAttribute("visit", 45121);
		
		return "/WEB-INF/views/test.jsp";		
	}
	

	// 4. Locale, HttpMethod : 클라이언트접속지역정보, 요청방식에 관해 알아내고자 할때
	@RequestMapping("/04.do")
	public String study04Handle(Locale locale, HttpMethod method) {
		System.out.println("study04Handle..");
		System.out.println(locale +" / " + method );
		return "/WEB-INF/views/test.jsp";
	}


	
}





