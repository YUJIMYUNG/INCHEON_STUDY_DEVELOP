package day64.JPA연관관계.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
@Getter @Setter @Builder @ToString
@NoArgsConstructor @AllArgsConstructor
public class MemberEntity extends BaseTime {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int mno; // 회원번호

    @Column(columnDefinition = "varchar(50)", unique = true)
    private String mid; // 회원아이디

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String mpwd; // 회원 비밀번호

    @Column(columnDefinition = "varchar(30)", unique = true, nullable = false)
    private String mname; // 회원이름

    @Column(columnDefinition = "varchar(50)", unique = true, nullable = false)
    private String memail; // 회원 이메일

    // 양방향 : 데이터베이스에서 지원하진 않지만 , ORM에서 지원한다.
    @OneToMany(mappedBy = "memberEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)// 1대다 관계,
                                        // mappendBy : 단방향의 멤버변수명을 넣어야함, 자바에서만 양뱡향을 사용하겠다는 설정(DB X)
    @ToString.Exclude // 양방향에서 순환참조를 대비하기 위한 ToString 사용 제외
    @Builder.Default // 빌더 패턴 사용시 자동으로 초기값을 주입하는 어노테이션
    private List<BoardEntity> boardEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "memberEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    @Builder.Default
    private List<ReplyEntity> replyEntityList = new ArrayList<>();

}
