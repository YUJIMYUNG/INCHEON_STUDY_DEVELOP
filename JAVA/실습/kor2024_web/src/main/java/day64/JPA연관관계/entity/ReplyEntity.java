package day64.JPA연관관계.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reply")
@Getter @Setter @ToString @Builder
@NoArgsConstructor @AllArgsConstructor
public class ReplyEntity extends BaseTime{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int rno; // 댓글번호

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String rcontent; //댓글 내용

    // 단방향 FK : 게시물PK ----> 댓글FK
    @ManyToOne
    @JoinColumn(name = "bno")
    private BoardEntity boardEntity;

    // 단방향 FK : 회원PK ---> 댓글 FK
    @ManyToOne
    @JoinColumn(name = "mno")
    private MemberEntity memberEntity;

}
