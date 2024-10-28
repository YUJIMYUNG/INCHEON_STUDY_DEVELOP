package exam01;

public class Ex05 {
    public static void main(String[] args) {
        C c = new C();
        A a = c;
        B b = c;

        System.out.printf("a == b : %s%n", a == b); // a, b가 가지고 있는 주소가 같니?
        System.out.printf("b == c : %s%n", b ==c); // b, c가 가지고 있는 주소가 같니?
    }
}
