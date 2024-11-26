package day30.boardService10MVC.model;

public class BoardDto {

    private String content; //내용
    private String writer; // 작성자
    private int pwd; // 비밀번호

    BoardDto() {

    }
    // 2-2. 매개변수 1개가 존재하는 생성자
    BoardDto(String content){
        this.content = content;

    }
    // 2-3. 매개변수 2개가 존재하는 생성자
    BoardDto(String content, String writer){
        this.content = content;
        this.writer = writer;
    }
    // 2-4. 매개변수 3개(전체) 존재하는 생성자
    public BoardDto(String content, String writer, int pwd){
        this.content = content;
        this.writer = writer;
        this.pwd = pwd;
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


    @Override
    public String toString() {
        return "Board{" +
                "content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", pwd=" + pwd +
                '}';
    }
}
