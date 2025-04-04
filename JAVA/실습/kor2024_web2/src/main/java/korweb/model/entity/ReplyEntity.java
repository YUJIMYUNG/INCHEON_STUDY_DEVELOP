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
@Table(name = "reply")
public class ReplyEntity extends BaseTime{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int rno; // 1. 댓글번호

    @Column( nullable = false , columnDefinition = "varchar(255)" )
    private String rcontent; // 2. 댓글내용

    // 3. 댓글작성자 : 작성자번호 : 단방향
    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "mno" )
    private MemberEntity memberEntity;

    // 4. 게시물번호 : 단방향
    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "bno")
    private BoardEntity boardEntity;
}
