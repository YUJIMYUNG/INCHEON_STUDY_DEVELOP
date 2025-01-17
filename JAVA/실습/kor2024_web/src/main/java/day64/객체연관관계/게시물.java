package day64.객체연관관계;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class 게시물 {
    private int gno;
    private String gtitle;
    private String gcontent;
    private 회원 gwriterFK;

    @Builder.Default
    @ToString.Exclude
    List<댓글> commentList = new ArrayList<>();
}
