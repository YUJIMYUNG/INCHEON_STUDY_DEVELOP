package korweb.model.dto;

import korweb.model.entity.PointEntity;
import lombok.*;

@Getter @Setter @Builder @ToString
@NoArgsConstructor @AllArgsConstructor
public class PointDto {
    private int pno; // 포인트번호
    private int pcount; // 포인트 수
    private String pcontent; // 포인트 지급 내용

    public PointEntity toPointEntity() {
        return PointEntity
                .builder()
                .pno(this.pno)
                .pcontent(this.pcontent)
                .pcount(this.pcount)
                .build();
    }

}
