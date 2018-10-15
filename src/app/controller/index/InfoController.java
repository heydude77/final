package app.controller.index;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import models.AlertService;
import models.EmployeeRepository;



@Controller
public class InfoController {
	@Autowired
	EmployeeRepository er;
	
	@Autowired 
	AlertService service;
	
	@Autowired
	Gson gson;
	
	@GetMapping("/infoChange.do")
	public ModelAndView infoChangeHandle(WebRequest wr) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mypage.change.auth");
		mav.addObject("center", "/WEB-INF/views/guest/changeInfoAuth.jsp");
		
		return mav;
	}
	
	@PostMapping("/infoChange.do")
	public ModelAndView changPostHandle(@RequestParam Map param, WebRequest wr) {
		System.out.println(param);
		if(er.getPasswordById(param)) {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("mypage.change");
			mav.addObject("center", "/WEB-INF/views/guest/changeInfo.jsp");
			
			return mav;
		} else {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("mypage.change.auth");
			mav.addObject("center", "/WEB-INF/views/guest/changeInfoAuth.jsp");
			return mav;
		}		
	}
	
	@GetMapping("/changePassword.do")
	@ResponseBody
	public String changePasswordHandle(@RequestParam Map param) {
		
		System.out.println("param :"+param);
		int r = er.changePassword(param);
		System.out.println(r);
		String json = gson.toJson(r);
	
		return json;	
		
	}
	
}
