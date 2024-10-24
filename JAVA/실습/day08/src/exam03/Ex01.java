package exam03;

public class Ex01 {
    public static void main(String[] args) {
        A a = new A(); // 클래스 외부
        a.num1 = 10; // default
        System.out.println(a.num1);

        a.num2 = 20; // protected
        System.out.println(a.num2);

        // a.num4 - privat
    }
}
