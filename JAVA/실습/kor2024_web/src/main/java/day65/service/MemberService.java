package day65.service;

import day65.model.dto.BoardDto;
import day65.model.entity.BoardEntity;
import day65.model.entity.MemberEntity;
import day65.repository.BoardRepository;
import day65.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BoardRepository boardRepository;

    // 1. 내가 쓴 글 조회하기
    public List<BoardDto> myBoardList(@RequestParam int mno){
        // 1. 지정한 mno의 회원 엔티티를 찾는다.
            // Optional 클래스 : null 값을 포함할 수 있는 객체
            // 특징 : Null값을 안전하게 유무 판단
        Optional<MemberEntity> optionalMember = memberRepository.findById(mno);
        if (optionalMember.isPresent()) {

            // 만약에 findById 함수로 찾응 mno의 엔티티가 존재하면
            MemberEntity entity = optionalMember.get();//optional객체에서 엔티티를 꺼낸다.

            // 2. 찾으 엔티티에서 양방향으로 설정된 게시물 조회
            List<BoardEntity> boardEntityList = entity.getBoardEntityList();

            // 3. 모든 게시물 엔티티를 dto로 변환
                // 방법1 : 일반 For문
//            List<BoardDto> list = new ArrayList<>();
//            for(int i = 0 ; i < boardEntityList.size() ; i++) {
//                BoardEntity boardEntity = boardEntityList.get(i);
//                BoardDto boardDto = boardEntity.toDto();// 엔티티로 dto반환
//                list.add(boardDto);
//            }
                // 방법2 : forEach
//            List<BoardDto> list = new ArrayList<>();
//            boardEntityList.forEach(boardEntity -> {
//                list.add(boardEntity.toDto());
//            });

                // 방법 3 : map(타입 :: 실행함수명).collect(Collectors.반환할 컬렉션타입)
            List<BoardDto> list = boardEntityList.stream()
                    .map(BoardEntity :: toDto)
                    .collect(Collectors.toList());

            return list;
        } // if end
        return null;
    }// myBoardList end

    @Transactional // 함수 안에서 insert, update, delete 쿼리문을 트랜잭션으로 사용
    public boolean myBoardWrite(@RequestBody BoardDto boardDto){
        // 현재 로그인된 회원이 게시물을 작성한다는 가정
        // 1. 현재 로그인된 회원번호를 세션에서 조회한다.
        int loginMno = 1;  // sample - 1번 회원이 로그인된 상태
            // 1-2 : 현재 회원번호의 회원엔티티 조회
        Optional<MemberEntity> optionalMember = memberRepository.findById(loginMno);
            // Optional : null 값을 저장/관리 할 수 있는 객체
        if(optionalMember.isPresent() == false) { // 조회된 엔티티가 없으면
            return false; // false로 반환
        }

        // get() : Optional 객체  엔티티 꺼내기
        MemberEntity memberEntity = optionalMember.get(); // 엔티티 꺼내기

        // 2. 게시물 엔티티를 생성한다.
        BoardEntity boardEntity  = boardDto.toEntity();

        // 3. 게시물 엔티티에 회원번호 넣어주기
        boardEntity.setMemberEntity(memberEntity);

        // 4. 게시물 엔티티 꺼내기
        BoardEntity saveEntity = boardRepository.save(boardEntity);

        // 5. .save(엔티티) : 엔티티의 저장을 성공하면 Pk번호를 확인하여 0보다 크면 성공
        if(saveEntity.getBno() > 0 ) {
            return true;
        } else {
            return  false;
        }

    }



}
