package day62.service;

import day62.model.entity.BoardEntity;
import day62.model.repository.BoardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
// 주요 MVC 공통 : 컴포넌트 스캔을 통해 자동으로 스프링 컨테이너에 빈(인스턴스) 주입이 된다.(싱글톤 필요 없음)
// 1. Spring mvc패턴에서 추가된 레이어/구역으로 자바의 비지니스 로직을 담당
    // 비지니스 로직이란 ? 기능에 실질적인 코드 ( ex : : 타입변환, 유효성 검사, 자료 가공역할이 아닌 기능의 실질적인 코드)
public class BoardService {

    // 서비스는 무조건 리포지토리를 이용하여 엔티티를 조작하고 요청과 응답을 받는다.
        // 규칙 : 서비스에서 컨트롤러 객체를 사용하면 안된다.
     @Autowired private BoardRepository boardRepository;


    // C : 게시물 쓰기
    public boolean write(@RequestBody BoardEntity boardEntity){
        boardRepository.save(boardEntity);
        // insert SQL 문을 작성하지 않아도 된다. 왜? 자동으로 쿼리가 생성된다.
        return true;
    }

    // R : 게시물 전체 조회
    public List<BoardEntity> printAll(){
        List<BoardEntity> list = boardRepository.findAll();

        return list;
    }

    // R : 게시물 개별 조회
    public BoardEntity print(@RequestParam int bno){
        BoardEntity entity = boardRepository.findById(bno).get();
        return entity;
    }

    // U : 게시물 수정
    @Transactional // 여러가지 처리 코드를 하나의 묶음 처리 해주는 기능
    public boolean update(@RequestBody BoardEntity boardEntity){
        // update SQL 문을 작성하지 않고 자동으로 쿼리가 생성된다.
        // 1. 수정할 게시물번호를 이용하여 수정할 엔티티를 찾는다.
        BoardEntity updateEntity = boardRepository.findById(boardEntity.getBno()).get();

        // 2. 수정할 엔티티의 값을 setter 을 이용하여 수정한다.
        // 영속성 : 엔티티/인스턴스를 수정하면 자동으로 DB도 같이 수정된다.
        // 특징
            // 원자성 : 처리 단위가 모두 성공하거나 모두 실패하게 만들어서 데이터 무결성 유지
            // 일관성 : 처리 이후 데이터가 유효한(사용가능한) 상태를 유지
            // 격리성 : 다른 트랙잭션과 서로 영향을 주지 않음
            // 지속성 : 작업이 완료되면 데이터는 영구적으로 저장된다.
        updateEntity.setBtitle(boardEntity.getBtitle());
        updateEntity.setBcontent(boardEntity.getBcontent());

        return true;
    }

    // D : 게시물 삭제
    public boolean delete(@RequestParam int bno){
        boardRepository.deleteById(bno);
        return true;
    }
}
