package day63.model.repository;

import day63.model.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository  extends JpaRepository<MemberEntity, Integer> {

}
