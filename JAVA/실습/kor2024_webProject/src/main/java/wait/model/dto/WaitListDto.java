package wait.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class WaitListDto {
    private int gno;
    private String gphone;
    private int gpersonel;
    private int waite_num;
}
