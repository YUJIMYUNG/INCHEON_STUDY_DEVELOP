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
@Table(name = "file")
public class FileEntity extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fno; // 첨부파일번호

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String fname; // 첨부파일명

    //첨부파일이 위치한 게시물 번호(fk)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="bno")
    private BoardEntity boardEntity;
}
