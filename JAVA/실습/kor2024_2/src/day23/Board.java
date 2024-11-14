package day23;

// 클래스의 사용처 : 1. main함수를 갖는 실행클래스 2. 객체를 생성하기 위한 설계클래스
// 클래스(도면지/설계도) vs 객체(설계도기반의 메모리공간)
public class Board{ // 게시물 타입 클래스

    // 클래스 구성멤버
    // 1. 필드(멤버변수)
        //  필드는 초기값이 없으면 정수:0, 실수:0.0, boolean:false, 참조타입:null
        // 주의할 점 : 일반 지역변수는 초기값이 없으면 쓰레기(임의) 값이 들어간다. (오류남)
    private String content; //내용
    private String writer; // 작성자
    private int pwd; // 비밀번호
        // private : 다른 클래스에 접근을 차단하는 키워드. 즉 현재 클래스에서만 사용 가능
            // 왜? 외부로부터 지정한 펠드의 직접접근을 차단하기 위해

    // 2. 생성자(객체초기화함수)
        // 생성자는 클래스명과 이름이 동일해야 한다. 동일하지 않으면 함수로 취급된다.
        // 생성자는 매개변수(함수 안으로 들어오는 값들 저장하는 변수)가 있지만
        // 반환타입(함수가 종료될때 반환하는 값의 타입)이 없다.
        // 오버로딩 : 동일한 함수명 / 생성자명으로 선언은 불가능 하지만 배개변수의 타입, 개수, 순서에 따라
        //          식별 가능한 함수를 선언하는 방법

    // 2-1. 매개변수가 없는 기본생성자
    Board() {

    }
    // 2-2. 매개변수 1개가 존재하는 생성자
    Board(String content){
        this.content = content;
        // this. 현재 클래스의 필드를 식별할 때 사용하는 키워드
        // 함수내 매ㅐ개변수(지역변수) 와 클래스의 필드명이 충돌(중복)일 떄 사용
    }
    // 2-3. 매개변수 2개가 존재하는 생성자
    Board(String content, String writer){
        this.content = content;
        this.writer = writer;
    }
    // 2-4. 매개변수 3개(전체) 존재하는 생성자
    Board(String content, String writer, int pwd){
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

        // -toString : 객체의 정보를 반환할 때 사용되는 함수. Object 객체(자바의 최상의 클래스)의 메서드
        // 재정의 : Object 클래스 내 toStirng 함수를 재정의한다.
    // 원래 toString() 함수를 객체의 주소값을 반환하는 함수인데
    // 주소값 대신에 객체의 필드 정보를 출력하기 위해 재정의한다.
    @Override
    public String toString() {
        return "Board{" +
                "content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", pwd=" + pwd +
                '}';
    }
}
