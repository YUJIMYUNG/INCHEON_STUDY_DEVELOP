package korweb.model.dto;

import lombok.*;

@Getter @Setter @ToString @Builder
@NoArgsConstructor @AllArgsConstructor
public class PageDto {
    private long totalcount; //조회될 자료의 갯수
    private int page; //현재페이지
    private int totalpage; //전체 페이지
    private int startbtn; //시작페이지
    private int endbtn; //끝페이지

    // Object클래스는 자바의 최상위 클래스이므로 모든 파입들의 자료들을 저장할 수 있다.
    // 즉 data에는 List<board> 혹은 List<ReplyDto> 등등 다양하게 페이징처리한 정보를 넣을 수 있음
    private Object data;
}
