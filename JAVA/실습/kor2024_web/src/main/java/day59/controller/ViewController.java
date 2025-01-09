package day59.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    // 템플릿 파일들(view)을 반환하는 메소들을 모아둔 클래스

    @GetMapping("")
    public String main(){
        return "/day59/index.html";
    }

    @GetMapping("/signup")
    public String signup(){
        return "/day59/signup.html";
    }

    @GetMapping("/login")
    public String login(){
        return "/day59/login.html";
    }
}
