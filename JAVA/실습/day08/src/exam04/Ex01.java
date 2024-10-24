package exam04;

import exam03.A;

public class Ex01 {
    public static void main(String[] args) {
        A a = new A();
        // a.num1 = 10; - default 접근 제어자, 동일 패키지가 아니므로 접근 불가능함
        // a.num2 = 20; - protected 접근 제어자, 동일 패키지가 아니므로 접근 불가능함
        a.num3 = 30; // public 접근 제어자, 모든 범위에서 접근 가능함

        B b = new B();
        // b.num2
        b.method();
    }
}
