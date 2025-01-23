package korweb.model.repository;

import korweb.model.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {
    // 인터페이스는 추상메소드를 가질 수 있는 타입이다.
    // DAO 조회 : select * from member where mid = ?
    // JPA 특정 값 조회 : 반환엔티티 findBy필드명(타입 조건값)

    // 1. 로그인 추상 메소드
    boolean existsByMidAndMpwd(String mid, String mpwd);

    // 2. 아이디로 엔티티 조회 : findBy필드명
    MemberEntity findByMid(String mid);
}
