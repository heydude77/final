package controllers.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/study")
public class LimaController {
	
	
	/*
	 *  Spring 은 View 처리를 하기위해 InternalResourceViewResolver 를 이용해서 
	 *  jsp로 바로 보내서 꾸미는게 아니라, 다른 view 기술을 이용해서도 응답을 만들어 낼 수 있게
	 *  viewResolver들을 더 지원하고 있다.
	 *  
	 *  뷰 처리기술도 다양한데, 그중에서 Tiles 라는 View Framework를 이용해서 응답을
	 *  만들어 내보자.
	 *  
	 *  tiles.apache.org : 
	 *  tiles ?  template framework for modern Java applications.
	 *    the easiest and most elegant way to work alongside any MVC technology.
	 * 
	 * Spring bean configuration 에서 viewResolver
	 */
	
	@RequestMapping("/31.do")
	public String study31Handle() {
		
		return "";
	}
}
