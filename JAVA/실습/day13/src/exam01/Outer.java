package exam01;

public class Outer {
    int num2 = 20;

    class Inner { // 인스턴스 내부 클래스
        int num2 = 10;
        static int num1; // JDK15 버전까지는 에러, JDK16 부터는 가능

        void method(){
            System.out.println("Inner 클래스에 정의된 인스턴스 메서드!");
            System.out.printf("num2=%d%n", num2); // Inner num2;
            System.out.printf("Outer.num2=%d%n", Outer.this.num2); // Outer num2;
        }
    }
}
