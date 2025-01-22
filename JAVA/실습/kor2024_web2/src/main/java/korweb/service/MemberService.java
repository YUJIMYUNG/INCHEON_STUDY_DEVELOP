package korweb.service;

import jakarta.transaction.Transactional;
import korweb.model.dto.MemberDto;
import korweb.model.entity.MemberEntity;
import korweb.model.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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
            return true;
        } else {
            System.out.println("로그인 실패");
            return false;
        }

    }// login end
}
