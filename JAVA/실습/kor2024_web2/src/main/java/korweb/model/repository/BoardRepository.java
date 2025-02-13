package korweb.model.repository;

import korweb.model.entity.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

    // repository의 함수명은 반드시 카멜표기법을 쓴다

    // 1. findBy필드명 (int 필드명)
    // 만약에 cno가 참조키(fk)일 경우에는 엔티티 필드명을 넣는다.
    // Page<BoardEntity> findByCno (int cno, Pageable pageable);


    Page<BoardEntity> findByCategoryEntity_Cno (int cno, Pageable pageable);

    // 2. JPA nativeQuery( SQL 문법) 이용한 조회 : 함수명 조건없음
        // 1. 특정한 카테고리 번호에 해당하는 모든 게시물 조회
        // @Query( value = "SQL문법", nativeQuery = true)
        // JPA(nativeQuery) : select *from board where cno = :매개변수명
    @Query( value = "select *from board where cno = :cno", nativeQuery = true)
    List<BoardEntity> findByQuery1(int cno);

        // 2. 게시물 제목에 키워드를 포함하는 모든 게시물을 조회
        // DAO(sql) : select * from board where btitle like %?%
        // JPA(nativeQuery): select * from board where btitle lick %:매개변수명%
    @Query(value = "select * from board where btitle like %:keyword", nativeQuery = true)
    List<BoardEntity> findByQuery2(String keyword);

        // 3. 특정 카테고리 번호에 게시물제목에서 키워드를 포함하는 모든 게시물 조회
        // DAO(sql) : select * from board where con = ? and btitle lick %?%
        // JPA(nativeQuery) : select * from board where cno = :cno and btitle like %:keyword%
    @Query(value = "select * from board where cno = :cno and btitle like %:keyword%", nativeQuery = true)
    List<BoardEntity> findByQuery3(int cno, String keyword);


        // 4. 매개변수 속엉에 키워드를 포함하는 모든 게시물 조회, 필드명의 값에 따른(if(조건, 참, 거짓) 조건추가
    @Query(value = "select * from board where if( :key = 'btitle', btitle like %:keyword%, bcontent lick %:keyword%", nativeQuery = true)
    List<BoardEntity> findByQuery4 (String key, String keyword);

        // 5. 카테고리별(1, 전체조회(검색키워드가 존재하지 않으면), 2. 제목 검색, 3 내용 검색) + 페이징처리
    @Query(value = "select * from board where cno= :cno and if( :keyword = '', true ," +
            "if( :key = 'btitle' , btitle like %:keyword%," +
            "if( :key = 'bcontent', bcontent like %:keyword%, true ) ) )" , nativeQuery = true)
    Page<BoardEntity> findBySearch (int cno, String key, String keyword, Pageable pageable);


}
