package wait.model.response;

import lombok.*;
import wait.model.dto.WaitListDto;

import java.util.ArrayList;

// 대기 팀의 수의 값을 포함한 목록을 별도로 관리하기 위해 Response 생성
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WaitListResponse {
    private ArrayList<WaitListDto> waitList;
    private int totalWaitCount;
}
