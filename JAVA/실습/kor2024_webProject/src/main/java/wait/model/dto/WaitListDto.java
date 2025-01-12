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
    private int wait_num;
    private int wait_time;
    private boolean wait_state;

    public WaitListDto(String gphone, int gpersonel, int wait_num, int wait_time) {
        this.gphone = gphone;
        this.gpersonel = gpersonel;
        this.wait_num = wait_num;
        this.wait_time = wait_time;
    }
}
