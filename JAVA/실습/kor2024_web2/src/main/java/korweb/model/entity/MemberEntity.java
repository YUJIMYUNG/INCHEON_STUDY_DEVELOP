package korweb.model.entity;

import jakarta.persistence.*;
import korweb.model.dto.MemberDto;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity @Setter @Getter @Builder @ToString
@NoArgsConstructor @AllArgsConstructor
@Table(name = "member")
public class MemberEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mno;

    @Column(columnDefinition = "varchar(20)", unique = true, nullable = false)
    private String mid; // 회원아이디

    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String mpwd; // 회원비밀번호

    @Column(columnDefinition = "varchar(20)", nullable = false)
    private String mname; // 회원이름

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String memail; // 회원이메일

    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String mimg; // 회원 프로필사진명


    public MemberDto toMemberDto() {
        return MemberDto.builder()
                .mno(this.mno)
                .mid(this.mid)
                .mpwd(this.mpwd)
                .memail(this.memail)
                .mname(this.mname)
                .mimg(this.mimg)
                .build();
    }

    @OneToMany(mappedBy = "memberEntity", cascade = CascadeType.ALL)
    @Builder.Default
    List<PointEntity> pointEntityList = new ArrayList<>();


}
