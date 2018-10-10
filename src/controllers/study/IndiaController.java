package controllers.study;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import models.IssueDao;

@Controller
@RequestMapping("/study")
public class IndiaController {
	public IndiaController() {
		System.out.println("IndiaController created..");
		System.out.println("gson is null? " + (gson==null) );
	//	JFrame r = new JFrame();
	}
	
	@Autowired
	JFrame frame2;
	
	@Autowired	// Spring에 의해 이 객체가 생성될때만 작동하게 됨.
	Gson gson;
	
	
	
	@RequestMapping("/21.do")
	public void study21Handle(@Autowired IssueDao idao) throws IOException {
		System.out.println("in study21Handle..gson is null? " + (gson==null));
		List<Map> li = idao.getAllIssue();
		System.out.println(gson.toJson(li));
		frame2.removeAll();
		for(int cnt=1; cnt<=6; cnt++) {
			frame2.add(new JButton());
		}
		frame2.setVisible(true);
	}
	
	
}
