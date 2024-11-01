package exam02;

public class Outer {

    int num1 = 10;

    static int num2 = 20;

    // 정적 내부 클래스 생성
    static class Inner {
        void method(){
           //  System.out.println(num1); // 외부클래스의 객체 자원은 접근 불가능
            System.out.println(num2); // 객체 생성과 관련없는 정적 자원은 모두 접근 가능
        }
    }
}
