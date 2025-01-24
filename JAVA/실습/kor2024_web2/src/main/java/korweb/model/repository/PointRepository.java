package korweb.model.repository;

import korweb.model.entity.PointEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRepository extends JpaRepository<PointEntity, Integer> {

    // 아이디로 엔티티 조회 : findBy필드명
    PointEntity findByMid(String mid);
}
