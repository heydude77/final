package controllers.study;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 * 
 * 요청 핸들 메서드에 return type 으로 지정가능한 것
 * 	void, String, ModelAndView 은 이렇게 3개를 주로 사용한다.
 *  
 */
@Controller
@RequestMapping("/study")
public class GolfController {
	
	@RequestMapping("/97.do")
	public void study97handle(Map map) {
		map.put("friends", new String[] {"루피","조로","나미"});
		// 따로 뷰이름을 설정하지 않고, handle 종료를 시키면, 
		// Spring이  "study/97"을 뷰이름으로 사용하게 된다.
		// ViewResolver를 개조시키면, 알아서 뷰로 포워드되는 효과가 나타난다.
	}
	@RequestMapping("/96.do")
	public String study96Handle(Map map) {
		// 핸들 처리 이후 뷰이름을 Spring쪽으로 알려줘야 할때
		if(Math.random()>0.5) {
			map.put("err", true);
			return "study/96";	//
		} else {
			return "redirect:/index.do";
		}
	}
	
	@RequestMapping("/95.do")
	public ModelAndView study95Handle() {
		// Spring 으로부터 뷰로 넘기는데 필요한 데이터 설정객체를 이용해서 처리하지않고,
		// 직접 처리하고자할때
		ModelAndView mav = new ModelAndView();
		if(Math.random()>0.5) {
			mav.setViewName("study/95");
			mav.addObject("err", true);
			return mav;
		} else {
			mav.setViewName("redirect:/index.do");
			mav.addObject("mode", "success");
			return mav;
		}
	}
	
	
}
