package exam01;

public class Ex01 {
    public static void main(String[] args) {
        // 외부 클래스인 Outer가 반드시 먼저 객체가 되어야한다.
        Outer outer = new Outer();
        Outer.Inner in = outer.new Inner();
        in.method();
    }
}
