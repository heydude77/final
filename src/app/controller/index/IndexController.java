package app.controller.index;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import models.AlertService;
import models.EmployeeRepository;

@Controller

public class IndexController {
	Map<String, HttpSession> sessions;
	
	public IndexController() {
		sessions = new HashMap<>();
	}
	@Autowired
	EmployeeRepository er;
	
	@Autowired 
	AlertService service;
	
	@GetMapping("/index.do")
	public String indexHandle(WebRequest wr) {
		//wr.setAttribute("auth", true, wr.SCOPE_SESSION);
		if(wr.getAttribute("auth", WebRequest.SCOPE_SESSION)==null) {
			return "login"; //"redirect:/login.do";
		}else {
			return "guest.home";
		}
		
	}
	
	@PostMapping("/login.do")
	public String loginPostHandle(@RequestParam Map param, WebRequest wr, HttpSession session) {
		if(er.getPasswordById(param)) {
			//==================================
			String id2 = (String)param.get("id");
			if(sessions.containsKey(id2)) {
				System.out.println(sessions.get(id2));
				Map data = new HashMap();
					data.put("mode", "invalidated");
				System.out.println(id2);
				service.sendOne(data, id2);
				sessions.get(id2).invalidate();
			}
			sessions.put(id2, session);
			//==================================
			Date current = new Date();
			SimpleDateFormat smt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String loginTime = smt.format(current.getTime());
			String id = (String) param.get("id");
			wr.setAttribute("auth", "on", WebRequest.SCOPE_SESSION);
			wr.setAttribute("userId", id, wr.SCOPE_SESSION);
			Map info = new HashMap();
			info = (Map) er.getEmployee(id);
			info.put("loginTime", loginTime);	
			wr.setAttribute("info", info, wr.SCOPE_SESSION);			
			
			Map map = new HashMap();			
		    	map.put("mode", "login");
		      	map.put("user", info);
			service.sendAll(map);
			return "redirect:/index.do";
		}else {
			wr.setAttribute("err", true, WebRequest.SCOPE_REQUEST);
			return "redirect:/";
		}
	}	
	
	@GetMapping("/logout.do")
	public String logoutHandle(HttpSession session) {
		String user = (String) session.getAttribute("userId");		
		sessions.remove(user);
		session.invalidate();
		return "redirect:/index.do";
	}
}
