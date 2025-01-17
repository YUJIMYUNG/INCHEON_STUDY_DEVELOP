package day64.객체연관관계;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class 회원 {
    private int mno;
    private String mid;
    private String mname;

    // 양방향 : 회원 객체는 여러개 게시물을 작성할 수 있으므로 List타입
        // 주의할 점 : 두 객체가 서로 참조할떄는 순환참조(무한호출)에 주의해야한다.
        // 해결방안1 : tostring 메소드를 사용하지 않는다.
        // 해결방안2 : 참조멤버변수만 tostring 메소드를 사용하지 않는다. -> @ToString.Exclude
    @Builder.Default // 빌드패턴 사용시 초기값이 대입되지 않는 멤버변수에 대해서는 초기값을 자동으로 대입한다.
    @ToString.Exclude
    List<게시물> boardList = new ArrayList<>();

    @Builder.Default
    @ToString.Exclude
    List<댓글> commentList = new ArrayList<>();
}
