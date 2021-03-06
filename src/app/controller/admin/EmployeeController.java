package app.controller.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import models.EmployeeRepository;

@Controller
@RequestMapping("/admin/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository er;
	
	@GetMapping("/add.do")
	public String addGetHandle(ModelMap map) {
		
		map.put("departments", er.getDepartments());
		map.put("positions", er.getPositions());
		
		return "admin.employee.add";
	}
	
	@PostMapping("/add.do")
	public String addPostHandle(@RequestParam Map param, ModelMap map) {
			
		param.put("id", er.getEmployeeSeq());
		param.put("pass", "1111");
		
		try {
			int r = er.addEmployee(param);
			map.put("employee", param);
			return "admin.employee.add";
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put("departments", er.getDepartments());
			map.put("positions", er.getPositions());
			map.put("err","on");
			return "admin.employee.add";
		}
	
	}
}
