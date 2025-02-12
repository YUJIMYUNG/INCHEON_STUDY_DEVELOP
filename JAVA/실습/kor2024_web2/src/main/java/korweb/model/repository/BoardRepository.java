package korweb.model.repository;

import korweb.model.entity.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

    // repository의 함수명은 반드시 카멜표기법을 쓴다

    // 1. findBy필드명 (int 필드명)
    // 만약에 cno가 참조키(fk)일 경우에는 엔티티 필드명을 넣는다.
    // Page<BoardEntity> findByCno (int cno, Pageable pageable);
    Page<BoardEntity> findByCategoryEntity_Cno (int cno, Pageable pageable);
}
