package day59.service;

import day59.model.dao.MemberDao;
import day59.model.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired private MemberDao memberDao;

    // 회원가입 서비스
    public boolean signup(MemberDto memberDto){
        boolean result = memberDao.signup(memberDto);
        return result;
    }

    // 로그인 서비스
    public boolean login(String mid, String mpwd){
        boolean result = memberDao.login(mid, mpwd);
        return result;
    }
}
