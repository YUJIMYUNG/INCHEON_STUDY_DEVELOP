package day65.model.dto;

import day65.model.entity.BoardEntity;
import lombok.*;

@Getter @Setter @Builder @ToString
@NoArgsConstructor @AllArgsConstructor
public class BoardDto {

    private int bno;
    private  String btitle;
    private String bcontent;

    // dto --> entity
    public BoardEntity toEntity() {
        return BoardEntity.builder()
                .btitle(this.btitle)
                .bno(this.bno)
                .bcontent(this.bcontent)
                .build();
    }
}
