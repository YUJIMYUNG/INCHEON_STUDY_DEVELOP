package day61;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BoardEntity {
    // 1. 멤버변수
    @Id
    private int bno; // 게시물 번호
    @Column
    private String btitle; // 게시물 제목
    @Column
    private String bcontent; // 게시물 내용

    // 2. 생성자
    public BoardEntity(int bno, String btitle, String bcontent) {
        this.bno = bno;
        this.btitle = btitle;
        this.bcontent = bcontent;
    }


    // 3. 메소드
}
