package day62.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
// 1. 해당 클래스를 DB의 테이블과 매핑
@Table(name = "board")

// 2. 롬복 어노테이션
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardEntity {
    @Id // 1. 해당 필드/속성 제약조건에 primary key를 정의하는 어노테이션
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int bno;

    @Column( columnDefinition =  "varchar(10)", nullable = false)// 1. 해당 필드/속성에 타입, 제약조건 정의하는 어노테이션
    private String btitle;

    @Column( columnDefinition = "longtext", nullable = false)
    private String bcontent;

    @Column( columnDefinition = "varchar(30)", nullable = false)
    private String bwriter;

    @Column( columnDefinition = "varchar(30)", nullable = false)
    private String bpwd;
}
