package app.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import models.EmployeeRepository;

@Controller
@RequestMapping("/test")
public class test {
	
	@Autowired
	EmployeeRepository er;
	
	@GetMapping("/test.do")
	public String addGetHandle(ModelMap map) {
		
		map.put("departments", er.getDepartments());
		map.put("positions", er.getPositions());
		
		return "test";
	}
}
