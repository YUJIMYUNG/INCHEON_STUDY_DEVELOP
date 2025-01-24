package korweb.model.entity;

import jakarta.persistence.*;
import korweb.model.dto.PointDto;
import lombok.*;

import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "point")
@Getter @Setter @Builder @ToString
@NoArgsConstructor @AllArgsConstructor
public class PointEntity extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pno;

    @Column(columnDefinition = "int", nullable = false)
    private int pcount;

    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String pcontent;

    @ManyToOne //fk
    @JoinColumn MemberEntity memberEntity;

    public PointDto toPointDto() {
        return PointDto.builder()
                .pno(this.pno)
                .pcount(this.pcount)
                .pcontent(this.pcontent)
                //.cdate(this.getCdate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) )
                .build();
    }
}
