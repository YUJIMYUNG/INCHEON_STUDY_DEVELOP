package korweb.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import korweb.model.dto.MemberDto;
import korweb.model.entity.MemberEntity;
import korweb.model.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;


    // 1. 회원가입 서비스
    @Transactional
    public boolean signup(@RequestBody MemberDto memberDto){
        // 1. ㅎ저장할 Dto를 entity로 변환한다.
        MemberEntity memberEntity = memberDto.toMemberEntity();

        // 2. 변환된 entity를 Save한다.
        // 3. Save(영속성/연결된) gks 엔티티를 반호나 받는다.
        MemberEntity saveEntity = memberRepository.save(memberEntity);

        if(saveEntity.getMno() > 0 ) {
            return true;
        } else {
            return false;
        }

    }

    @Transactional
    public boolean login(@RequestBody MemberDto memberDto){
        // 방법1

//        // 1. 모든 회원 엔티티를 조회
//        List<MemberEntity> memberEntityList = memberRepository.findAll();
//        // 2. 모든 회원 엔티티를 하나씩 조회
//        for( int i = 0; i < memberEntityList.size() ; i++) {
//            // 3. i 번째의 엔티티를 꺼ㄴ기
//            MemberEntity memberEntity = memberEntityList.get(i);
//            if(memberEntity.getMid().equals(memberDto.getMid())){
//                if(memberEntity.getMpwd().equals(memberDto.getMpwd())){
//                    return true;
//                }// if end
//            } // if end
//        }// for end

        // 방법2
        // jpa Repository 추상메소드 활용
        boolean result = memberRepository.existsByMidAndMpwd(memberDto.getMid(), memberDto.getMpwd());

        if(result == true){
            System.out.println("로그인 성공");
            setSession(memberDto.getMid()); // 로그인성공시 세션에 아이디 저장
            return true;
        } else {
            System.out.println("로그인 실패");
            return false;
        }// if else end



    }// login end

    // ==================== 세션 관리 함수 ===============
    // 1). 내장된 톰캣 서버의 요청 객체
    @Autowired
    private HttpServletRequest request;

    // 3. 세션 객체에 로그인된 회원아이디를 추가하는 함수.
    public boolean setSession(String mid){

        // 2) 요청 객체를 ㅣ용한 톰캣내 세션 객체를 반환
        HttpSession httpSession = request.getSession();

        // 3)세션 객체에 속성(새로운 값을)추가한다.
        httpSession.setAttribute("loginId", mid);
        return true;
    }

    // 4. 세션 객체에 로그인된 회원아이디 반환하는 함수
    public String getSession() {
        HttpSession httpSession = request.getSession();
        // 세션 객체 속성명의 값 반환
        // 주의!! 반환타입이 Object임
        Object object = httpSession.getAttribute("loginId");

        // 검사 후 타입변환
        if(object != null) { // 만약 object에 값이 있으면
            String mid = (String)object; // 타입변환
            return mid;
        } else{
            return null;
        }// if - else end
    }// getSession end

    // 5. 세션객체 내 정보 초기화 - 로그아웃
    public boolean deleteSession() {
        HttpSession httpSession = request.getSession();
        httpSession.removeAttribute("loginId");
        return true;
    }


    //. 6. 현재 로그인된 회원의 정보 조회
    public MemberDto getMyInfo() {
        // 1. 현재 세션에 저장된 회원 아이디 조회
        String mid = getSession();
        //2. 만약에 로그인 상태이면
        if(mid != null ) {
            // 3. 회원 아이디로 엔티티 조회
            MemberEntity memberEntity = memberRepository.findByMid(mid);
            // 4. 엔티티를 Dto로 변환
            MemberDto memberDto = memberEntity.toMemberDto();
            // 5. 반환
            return memberDto;
        }
        return null;
    }// getMyInfo end

    // 6. 현재 로그인된 회원 탈퇴하기
    public boolean myDelete() {
        String mid = getSession();
        if( mid != null ) {
            MemberEntity memberEntity = memberRepository.findByMid(mid);
            memberRepository.delete(memberEntity);
            deleteSession(); // 탈퇴하면 로그아웃 처리
            return true;
        }
        return false;
    }// mydelete() end

    // 7. 현재 로그인된 회원 수정
    @Transactional
    public boolean myUpdate(MemberDto memberDto) {
        String mid = getSession();
        if(mid != null) {
            MemberEntity memberEntity = memberRepository.findByMid(mid);
            memberEntity.setMname( memberDto.getMname());
            memberEntity.setMemail(memberDto.getMemail());
            return true;
        }
        return false;
    }// myUpdate end

}
