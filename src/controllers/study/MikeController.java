package controllers.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/study")
public class MikeController {
   
   @RequestMapping("/41.do")
   public String study41Handle() {
      System.out.println("request Handle..");
      return "example";
   }
   
}