package controllers.study;


import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import models.Pet;

@Controller
@RequestMapping("/study")
public class BravoController {
	
	/*
	 *	@RequestParam 
	 *	  파라미터를 바로 확보해서 요청처리 하고 싶을때
	 */
	
	
	@RequestMapping("/05.do")
	public void study05Handle(@RequestParam String[] word, @RequestParam int p) {
		System.out.println("study05Handle()");
		System.out.println("word = " + word);
		for (int i = 0; i < word.length; i++) {
			System.out.println("word=" +word[i]);
		}
		System.out.println("p = " + p);
	}	

	@RequestMapping("/06.do")
	public void study06Handle(@RequestParam Map param, @RequestParam int a) {
		// RequestParam 을 설정한 Map에 데이터들은 String,String 으로 확보된다.
		// cf, MultiValue 처리 안되고, 수치형데이터도 이건 String으로 설정됨.
		System.out.println("study06Handle..");
		String ment = (String)param.get("ment");
		String score = (String)param.get("score");
		System.out.println("score="+score+"/ment="+ment);
	}
	
	@RequestMapping("/07.do")
	public void study06Handle(@RequestParam MultiValueMap param) {
		// RequestParam 을 설정한 MulitValueMap에 데이터들은 String, List<String> 으로 확보된다.
		// cf, 같은이름으로 넘어온 데이터들이 List로 뽑히는데, 하나가 넘어와도 List다.
		System.out.println("study07Handle..");		
		List<String> ment = (List<String>)param.get("ment");
		List<String> score = (List<String>)param.get("score");
		System.out.println("score="+score+"/ment="+ment);				
	}
	
	@RequestMapping("/08.do")
	public void study08handle(@ModelAttribute Pet pet) {
		System.out.println("study08Handle");
		System.out.println(pet.toString());
	}
	
}
