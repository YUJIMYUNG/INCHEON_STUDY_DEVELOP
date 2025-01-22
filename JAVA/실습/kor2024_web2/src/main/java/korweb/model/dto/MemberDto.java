package korweb.model.dto;

import korweb.model.entity.MemberEntity;
import lombok.*;

@Getter @Setter @Builder @ToString
@AllArgsConstructor @NoArgsConstructor
public class MemberDto {
    private int mno; // 회원번호
    private String mid; // 회원아이디
    private String mpwd; // 회원비밀번호
    private String mname; // 회원이름
    private String memail; // 회원이메일


    public MemberEntity toMemberEntity(){
        return MemberEntity.builder()
                .mno(this.mno)
                .mid(this.mid)
                .mpwd(this.mpwd)
                .memail(this.memail)
                .mname(this.mname)
                .build();
    }
}
