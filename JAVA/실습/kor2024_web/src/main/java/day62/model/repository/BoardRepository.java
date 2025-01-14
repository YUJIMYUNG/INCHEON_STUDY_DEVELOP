package day62.model.repository;

import day62.model.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// 주요 MVC 공통 : 컴포넌트 스캔을 통해 자동으로 스프링 컨테이너에 빈(인스턴스) 주입이 된다.(싱글톤 필요 없음)
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
}
