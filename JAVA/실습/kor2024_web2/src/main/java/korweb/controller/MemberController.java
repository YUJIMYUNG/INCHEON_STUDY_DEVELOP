package korweb.controller;

import korweb.model.dto.MemberDto;
import korweb.model.dto.PointDto;
import korweb.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;
import java.util.List;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    // 1. 회원가입
//    @PostMapping("/member/signup.do")
//    public boolean signup(@RequestBody MemberDto memberDto){
//        return memberService.signup(memberDto);
//    }

    // 1-1. 첨부파일이 포함된 회원가입 HTTP 매핑
    // 첨부파일은 JSON타입이 아닌 multipart/form-data 타입으로 @RequestBody를 사용하지 않는다.
    @PostMapping("/member/signup.do")
    public boolean signup(MemberDto memberDto){
        return memberService.signup(memberDto);
    }

    // security 사용시에는 아래 기능 사용하지 않음
    // 2. 로그인
//    @PostMapping("/member/login.do")
//    public boolean login(@RequestBody MemberDto memberDto){
//        return memberService.login(memberDto);
//    }

    // 3. 현재 로그인된 회원 아이디 http 매핑
    @GetMapping("/member/login/id.do")
    public String loginId() {
        return memberService.getSession();
    }

    // security 사용시에는 아래 기능 사용하지 않음
    // 4. 현재 로그인된 회원 로그아웃
//    @GetMapping("/member/logout.do")
//    public boolean logout() {
//        return memberService.deleteSession();
//    }

    // 5. 현재 로그인된 회원 정보 반환
    @GetMapping("/member/login/myinfo.do")
    public MemberDto getMyInfo() {
        return memberService.getMyInfo();
    }

     // 6. 현재 로그인된 회원 탈퇴
    @DeleteMapping("/member/login/delete.do")
    public boolean myDelete() {
        return memberService.myDelete();
    }

    // 7. 현재 로그인된 회원 정보 수정
    @PutMapping("/member/login/update.do")
    public boolean myDelete(@RequestBody MemberDto memberDto){
        return memberService.myUpdate(memberDto);
    }

    // [10] 내 포인트 지급 전제 내역 조회
    @GetMapping("/member/point/list.do")
    public List<PointDto> pointList(){
        return memberService.pointList();
    }
    // [11] 현재 내 포인트 조회
    @GetMapping("/member/point/info.do")
    public int pointInfo(){
        return memberService.pointInfo();
    }

}
