package app.controller.index;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import models.EmployeeRepository;

@Controller

public class IndexController {
	@Autowired
	EmployeeRepository er;
	
	@GetMapping("/index.do")
	public String indexHandle(WebRequest wr) {
		//wr.setAttribute("auth", true, wr.SCOPE_SESSION);
		if(wr.getAttribute("auth", wr.SCOPE_SESSION)==null) {
			return "login"; //"redirect:/login.do";
		}else {
			return "index";
		}
	}
	
	@PostMapping("/login.do")
	public String loginPostHandle(@RequestParam Map param, WebRequest wr) {
		if(er.getPasswordById(param)) {
			wr.setAttribute("auth", true, wr.SCOPE_SESSION);
			return "index";
		}else {
			return "redirect:/login.do";
		}
	}
	
	@GetMapping("/index2.do")
	public String index2Handle(){
		return "index";
	}

}
