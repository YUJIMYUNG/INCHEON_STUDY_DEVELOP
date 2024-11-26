package day31.boardService11MVC.model;

public class BoardDto {

    // 1.필드
    // 주로 DB의 테이블 필드와 동일하게 사용해도 된다.
    // 왜? Dto 결국에는 DB에 저장된 데이터를 View까지 이동하는 객체
    private int num; // 게시물 번호
    private String content; //내용
    private String writer; // 작성자
    private int pwd; // 비밀번호

    // 2. 생성자
    // DTO 주로 생성시 개발자(본인) 초기화할 필드로 생성자를 구분한다.
    // 2-1. 게시물 쓰기에서 필요한 생성자
    public BoardDto(String content, String writer, int pwd){
        this.content = content;
        this.writer = writer;
        this.pwd = pwd;
    }

    // 2-2. 게시물 출력에서 필요한 생성자
    public BoardDto(int num, String content, String writer) {
        this.num = num;
        this.content = content;
        this.writer = writer;
    }

    // 2-3. 게시물 삭제 : 객체 필요 없어보임


    // 2-4. 게시물 수정할때 필요한 생성자
    public BoardDto(int num, String content) {
        this.num = num;
        this.content = content;
    }

    // 3. 메소드(멤버함수)
    // -getter 함수(필드 값 호출) : private선언된 필드를 public으로 함수를 외부 클래스로부터 간접접근을 허용
    public String getContent() {
        return content;
    }

    // - setter 함수(필드 값 저장) : private 선언된 필드를 public 함수로 외부 클래스로부터 간접접근을 허용
    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getPwd() {
        return pwd;
    }

    public void setPwd(int pwd) {
        this.pwd = pwd;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "num=" + num +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", pwd=" + pwd +
                '}';
    }
}
