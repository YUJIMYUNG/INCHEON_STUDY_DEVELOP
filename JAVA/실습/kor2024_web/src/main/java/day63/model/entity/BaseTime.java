package day63.model.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass // 슈퍼클래스 목적으로
@Getter
public class BaseTime {
    @CreatedDate
    private LocalDateTime cdate; //엔티티 생성 날짜 /시간
    @LastModifiedDate
    private  LocalDateTime udate; // 엔티티 수정된 날짜/시간

}
