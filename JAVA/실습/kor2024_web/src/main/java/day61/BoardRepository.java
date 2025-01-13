package day61;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Spring MVC 패턴에서 Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
}
