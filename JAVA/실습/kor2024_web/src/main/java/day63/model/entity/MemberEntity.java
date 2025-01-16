package day63.model.entity;

import day63.model.dto.MemberDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "member")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  int mno;

    @Column(columnDefinition = "varchar(30)",
            nullable = false, unique = true)
    private  String mid;

    @Column(columnDefinition = "varchar(20)", nullable = false)
    private  String mpwd;

    @Column(columnDefinition = "varchar(10)", nullable = false)
    private  String mname;

    @Column(columnDefinition = "varchar(13)", nullable = false, unique = true)
    private  String mphone;

    public MemberDto todoDto() {
        return MemberDto.builder()
                .mno(this.mno)
                .mid(this.mid)
                // 패스워드는 보안상 생략
                .mphone(this.mphone)
                .cdate(this.getCdate().toString())
                .udate(this.getUdate().toString())
                .build();
    }

}
