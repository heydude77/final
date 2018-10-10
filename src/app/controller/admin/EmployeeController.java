package app.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/employee")
public class EmployeeController {

	
	@GetMapping("/add.do")
	public String addGetHandle() {
		
		return "admin.employee.add";
	}
}
