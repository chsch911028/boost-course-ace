package kr.or.connect.pj3be.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String home(){
        System.out.println("___________GET MAPPED______");
        return "index";
    }
}
