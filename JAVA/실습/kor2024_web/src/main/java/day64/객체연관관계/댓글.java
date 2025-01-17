package day64.객체연관관계;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class 댓글 {
    private int cno;
    private String ccontent;
    private 게시물 cboardFK;
    private 회원 cwriterFK;
}
