package day63.service;

import day63.model.dto.MemberDto;
import day63.model.entity.MemberEntity;
import day63.model.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public boolean signup(MemberDto memberDto){
        //1. 저장할 DTO를 entity로 변호나한다.
        MemberEntity memberEntity = memberDto.toEntity();

        //2. 변환된 Entity를 save한다.
        //3. save 결과 entity를 반환받는다.
        MemberEntity saveEntity = memberRepository.save(memberEntity);

        //4. 회원번호를 확인하여 엔티티가 잘 생성 했는지 확인
        if(saveEntity.getMno() > 0){
            return true;
        }else {
            return false;
        }
    }

    public List<MemberDto> infolist(){
        // 1. 모든 엔티티를 조회한다.
        List<MemberEntity> entityList = memberRepository.findAll();
        //2. 모든 엔티티를 DTO로 변환한다.
        List<MemberDto> list =  new ArrayList<>(); // 변환된 dto를 저장할 리스트 선언
        for(int i = 0; i <= entityList.size() ; i++) {
            // 0부터 엔티티리스트의 마지막 인덱스까지 1씩 증가 반복
            MemberEntity entity = entityList.get(i);
            // i번째 엔티티 1개 반환
            list.add(entity.todoDto());
        }
        return list;
    }

}
