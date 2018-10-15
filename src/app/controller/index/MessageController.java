package app.controller.index;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import models.EmployeeRepository;

@Controller

public class MessageController {
	
	@Autowired
	EmployeeRepository er;
	
	@Autowired
	Gson gson;
	@GetMapping("/messageList.do")
	public ModelAndView MessageListGetHandle(@RequestParam Map param, WebRequest wr) {
		
			ModelAndView mav = new ModelAndView();
			mav.setViewName("message.list");
			mav.addObject("center", "/WEB-INF/views/guest/messageList.jsp");		
			return mav;			
	}		
	@GetMapping("/sendMessage.do")
	public ModelAndView sendMessageHandle() {
		
		
		ModelAndView mav = new ModelAndView();
		List<Map> departments = er.getDepartments();
		mav.addObject("departments", departments);		
		mav.setViewName("message.list");
		mav.addObject("center", "/WEB-INF/views/guest/sendMessage.jsp");
		return mav;
		
	}
	
	@GetMapping(path="/messageAjax.do", produces="application/json;charset=UTF-8")	
	@ResponseBody
	public String messageAjaxHandle(@RequestParam Map param) {	
		List<Map> employees = er.getEmployeeByDep(param);
		String json = gson.toJson(employees);	
		System.out.println(json);
		return json;			
	}
	
}
