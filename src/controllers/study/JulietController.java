package controllers.study;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import models.IssueRepository;

@Controller
@RequestMapping("/study")
public class JulietController {
	
	@Autowired
	IssueRepository ir;	
	
	@RequestMapping("/22.do")
	public void study22Handle() throws IOException {
		System.out.println(ir.getAllIssue());
		System.out.println(ir.getAllWithOpinionCount());
	}
	

}
