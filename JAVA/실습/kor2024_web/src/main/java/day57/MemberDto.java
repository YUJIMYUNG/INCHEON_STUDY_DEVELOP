package day57;

import lombok.*;

@NoArgsConstructor //디폴트 생성자 주입
@AllArgsConstructor // 모든 매개변수의 생성자 코드 주입
@ToString // toString 메서드 코드 주입
@Getter // getter 메소드 코드 주입
@Setter // setter 메소드 코드 주입
@Builder // builder패턴 메소드 지원
public class MemberDto {
    private String id;
    private String name;
}

