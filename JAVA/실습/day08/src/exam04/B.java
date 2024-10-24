package exam04;

import exam03.A;

public class B extends A{
    public void method() {
        num2 = 30; // protected 접근 범위는 다른 패키지인 경우 상속을 통해서 클래스 내부에서 접근 가능(private 범위와 동일)
        System.out.println(num2);
    }
}
