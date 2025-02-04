package korweb.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "board")
public class BoardEntity extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bno;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String btitle; // 게시물 제목

    @Column(columnDefinition = "longText")
    private String bcontent; // 게시물 내용

    @Column(columnDefinition = "int")
    private int bview; // 게시물 조회수

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mno")
    private MemberEntity memberEntity; // 작성자번호(fk)

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cno")
    private CategoryEntity categoryEntity; // 카테고리번호(fk)


}
