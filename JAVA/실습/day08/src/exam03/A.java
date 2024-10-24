package exam03;

public class A {
    int num1; // default 접근 제어자 - 동일 패키지 내엥서만 접근 가능
    protected int num2; // 동일 패키지 내에서 접근 가능(default)
                        // 다른 패키지이더라도 클래스 내부(private)에서 접근 가능
    public int num3; // 동일 패키지, 다른 패키지 모두 접근 가능

    private int num4; // 클래스 내부에서만 접근 가능

    void method1() { // 인스턴스 메서드 : 객체가 생성되어야 호출 될 수 있는 메서드
        System.out.println("메서드1");
        num4 = 40;
        System.out.println(num4); // private 범위 변수는 인스턴스 메서드 내부에서반 접근 가능
    }


}
