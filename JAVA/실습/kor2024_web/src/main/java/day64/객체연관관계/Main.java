package day64.객체연관관계;

public class Main {
    // 회원 객체 / 게시물 객체 / 댓글 객체 관계
    public static void main(String[] args) {
        // 단방향 연관관계 , PK ----- FK 관계

        // 1. 강호동 회원 가입 진행
        회원 m1 = 회원.builder().mno(1).mid("QWE").mname("강호동").build();
            // 빌더패턴 인스턴스 생성 vs 생성자 인스턴스 생성
        //회원 m2 = new 회원(2, "RTY", "유재석");

        // 2. 강호동 회원이 게시물 작성
        게시물 b1 = 게시물.builder().gno(1).gtitle("제목1").gcontent("내용1").build();

        // 강호동이 게시물을 작성하게 관계를 하기 위해서 두 객체는 어떻게 관계를 표현할까?
        // 히원 (상위) <----> 게시물(하위)s
        b1.setGwriterFK(m1); // 회원객체를 개세물 객체에 대입한다.

        // 3. 1번 게시물의 작성자 확인
            // 게시물의 객체만으로 회원객체의 정보를 알 수 있다.
        System.out.println("1번 게시물 작성자" + b1.getGwriterFK().getMid());
        System.out.println("1번 게시물 작성자 이름" + b1.getGwriterFK().getMname());

        // 4. 회원 객체의 게시물 확인
        // 게시물은 회원객체를 참조하지만 회원은 게시물을 참조하지 않는다.
        // System.out.println("강호동의 게시물 확인 : " + m1.??????);


        // ========= 양방향 (서로 참조) 연관관계 , DB에서 표현은 불가능함
        // 5. 양방향 설정 - 2번에서 게시물에 '강호동' 회원객체를 대입. (회원객체에 게시물 객체 대입)
        m1.getBoardList().add(b1) ; // m1(강호동)객체에 b1(1번째 게시물) 객체를 대입한다.
    }
}
