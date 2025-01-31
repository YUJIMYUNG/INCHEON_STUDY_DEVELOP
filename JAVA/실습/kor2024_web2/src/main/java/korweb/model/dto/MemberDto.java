package korweb.model.dto;

import korweb.model.entity.MemberEntity;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter @Setter @Builder @ToString
@AllArgsConstructor @NoArgsConstructor
public class MemberDto {
    private int mno; // 회원번호
    private String mid; // 회원아이디
    private String mpwd; // 회원비밀번호
    private String mname; // 회원이름
    private String memail; // 회원이메일
    private String mimg; // 회원 프로필사진명
    private MultipartFile uploadfile; // 업로드 파일 객체

    public MemberEntity toMemberEntity(){
        return MemberEntity.builder()
                .mno(this.mno)
                .mid(this.mid)
                .mpwd(this.mpwd)
                .memail(this.memail)
                .mname(this.mname)
                .mimg(this.mimg)
                .build();
    }
}
