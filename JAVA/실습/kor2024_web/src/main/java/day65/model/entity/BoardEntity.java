package day65.model.entity;

import day65.model.dto.BoardDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "board")
@Builder @Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bno;

    @Column(columnDefinition = "varchar(100)", nullable = false)
    private String btitle;

    @Column(columnDefinition = "longtext")
    private String bcontent;

    @ManyToOne // FK
    @JoinColumn(name = "mno") // fk 필드명
    private MemberEntity memberEntity;

    // entity -> dto
    public BoardDto toDto () {
        return BoardDto.builder()
                .bno(this.bno)
                .btitle(this.btitle)
                .bcontent(this.bcontent)
                .build();
    }
}
