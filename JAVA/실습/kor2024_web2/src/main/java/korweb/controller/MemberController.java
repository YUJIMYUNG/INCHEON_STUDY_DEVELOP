package korweb.controller;

import korweb.model.dto.MemberDto;
import korweb.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;
import java.util.List;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/member/signup.do")
    public boolean signup(@RequestBody MemberDto memberDto){
        return memberService.signup(memberDto);
    }

    @PostMapping("/member/login.do")
    public boolean login(@RequestBody MemberDto memberDto){
        return memberService.login(memberDto);
    }

    // 3. 현재 로그인된 회원 아이디 http 매핑
    @GetMapping("/member/login/id.do")
    public String loginId() {
        return memberService.getSession();
    }

    // 4. 현재 로그인된 회원 로그아웃
    @GetMapping("/member/logout.do")
    public boolean logout() {
        return memberService.deleteSession();
    }

    // 5. 현재 로그인된 회원 정보 반환
    @GetMapping("/member/login/mypage.do")
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
}
