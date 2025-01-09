package day59.controller;

import day59.model.dto.MemberDto;
import day59.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController //스프링컨테이너(메모리)에 bean(인스턴스) 주입
public class MemberController {

    //객체(값)을 반환하는 메소드들을 모아둔 클래스 + @ResponseBody

    @Autowired
    private MemberService memberService;

    //1. 회원가입 메소드
    @PostMapping("/signup.do")
    public boolean signup(@RequestBody MemberDto memberDto){
        boolean reseult = memberService.signup(memberDto);
        return true;
    }

    //2. 로그인 메소드
    @GetMapping("/login.do")
    public boolean login(@RequestParam String mid, @RequestParam String mpwd){
        boolean result = memberService.login(mid, mpwd);
        return true;
    }
}
