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

    // 수정페이지 반환 메서드
    @GetMapping("/member/update")
    public String myupdate() {
        return "/member/update.html";
    }

    /**
     *     회원가입했을 때 100point 지급, 로그인 했을 때 1point 지급
     *     마이페이지에 포인트 내역 전체 조회 출력
     *     헤더(상단메뉴)에는 로그인된 아이디 옆에 현재포인트 출력
     *     구현할 서비스 : 포인트 지급 서비스, 내 포인트 내역 전체 조회 서비스 , 현재 내 포인트 조회 서비스
     *
     */

    // 현재 내 포인트 조회 서비스
    @GetMapping("/member/mypoint")
    public String mypoint() {
        return "/member/mypoint.html";
    }





}
