package korweb.model.dto;

import jakarta.persistence.*;
import korweb.model.entity.CategoryEntity;
import korweb.model.entity.MemberEntity;
import lombok.*;

@Getter @Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {

    private int bno;
    private String btitle; // 게시물 제목
    private String bcontent; // 게시물 내용
    private int bview; // 게시물 조회수
}
