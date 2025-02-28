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


    @GetMapping("/board/view")
    public String boardView() {
        return "/board/view.html";
    }


    // 공공데이터 API페이지 반환 메서드
    @GetMapping("/api1")
    public String api1() {
        return "/api/api1.html";
    }
    // 공공데이터 API페이지 반환 메서드
    @GetMapping("/api2")
    public String api2() {
        return "/api/api2.html";
    }

    //chat
    @GetMapping("/chat")
    public String chat() {
        return "/api/chat.html";
    }


    /*
    알림메시지 실습 활용
    만약에 하나의 회원이 로그인을 성공하면 현재 페이지에 접속된 모든 유저에게 메시지를 알린다.
    주제 : 소켓 이용한 알람메시지 만들기
    1. 조건 : 로그인 성공했을 떄 현재 홈페이지에 접속된 모든 사람들에게 메시지를 알란ㄷ.ㅏ
    2. 조건 : 메시지 내ㅔ용은 '000님이 로그인했습니다."
    3. 조건 : 메시지는 프론트 포트스트렙 토스트
    4. 서버소켓과 클라이언트 소켓 새로 만들어서 진행
    클라이언트호켓은 header.js에서 작업

     */
    // 로그인 된 유저 알람
    @GetMapping("/loginAlram")
    public String loginAlram() {
        return "/header.html";
    }




}
