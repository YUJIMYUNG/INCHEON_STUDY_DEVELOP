package day64.JPA연관관계.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "board")
@Getter
@Setter
@ToString @Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert // @ColumnDefault 어노테이션을 사용하기 위해 사용되는 어노테이션
public class BoardEntity extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bno; // 게시물 번호

    @Column(columnDefinition = "varchar(100)", nullable = false)
    private String btitle;

    @Column(columnDefinition = "longtext", nullable = false)
    private String bcontent;

    @Column(columnDefinition = "int")
    @ColumnDefault("0")
    private int bview;

    // 단방향
    @JoinColumn(name = "mno") // FK필드의 이름정의
    @ManyToOne // 다대일
    private MemberEntity memberEntity;

    // 양방향
        // board가 삭제되면 reply도 삭제/수정/저장 된다.
        // board에서 reply를 참조할때는 .getReply() 사용시 댓글 데이터를 가져온다.(지연로딩)
    @OneToMany(mappedBy = "boardEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    @Builder.Default
    List<ReplyEntity> replyEntityList = new ArrayList<>();
}


