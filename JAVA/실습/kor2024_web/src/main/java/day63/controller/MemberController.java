package day63.controller;

import day63.model.dto.MemberDto;
import day63.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {

    @Autowired private MemberService memberService;

    //1. 회원각입
    @PostMapping("/member/signup")
    public boolean signup(@RequestBody MemberDto memberDto){
        return memberService.signup(memberDto);
    }

    //2. 모든 회원목록 조회
    @GetMapping("/member/infolist")
    public List<MemberDto> intolist() {
        return memberService.infolist();
    }
}
