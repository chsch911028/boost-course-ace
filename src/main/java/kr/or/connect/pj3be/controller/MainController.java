package kr.or.connect.pj3be.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class MainController {
    @GetMapping("/")
    public String main(){
        return "index";
    }

}
