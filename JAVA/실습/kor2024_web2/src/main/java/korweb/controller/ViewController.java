package korweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("")
    // http://localhost:8080/
    public String index(){
        return "/index.html";
    }

    @GetMapping("/member/signup")
    public String signup() {
        return "/member/signup.html";
    }

    @GetMapping("/member/login")
    public String login(){
        return "/member/login.html";
    }

    @GetMapping("/member/mypage")
    public String mypage() {
        return "/member/mypage.html";
    }

    @GetMapping("/member/info")
    public String myinfo() {
        return "/member/info.html";
    }
}
