package day63.model.dto;

import day63.model.entity.MemberEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MemberDto {
    private int mno;
    private String mid;
    private String mname;
    private String mpwd;
    private String mphone;
    private String cdate; // 회원가입 날짜
    private  String udate;// 회원정보 수정 날짜

    public MemberEntity toEntity() {

        return MemberEntity.builder()
                .mno(this.mno)
                .mid(this.mid)
                .mpwd(this.mpwd)
                .mname(this.mname)
                .mphone(this.mphone)
                .build();
    }

}
