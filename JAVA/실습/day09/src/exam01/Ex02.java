package exam01;

public class Ex02 {
    public static void main(String[] args) {
        Student.id = 1000; // 정적 변수는 객체를 생성하지 않아도 접근 가능하다.
        System.out.println(Student.id);


        // 객체를 생성하지 않아도 클래스명으로 함수에 접근 가능 (정적메서드)
        Student.staticMethod();

    }
}
