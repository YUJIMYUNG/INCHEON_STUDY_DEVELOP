package day57task.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class StudendtDto {
    private int sNo;
    private String sName;
    private int sKor;
    private int sMath;
    private int sEng;
}
