package exam01;

public class A {
    int numA = 10; // 객체가 됐을 때 대입!

    public A () {
        super(); // 따로 정의  안되어 있으면 컴파일러가 자동 추가한다.
        System.out.println("생성자 A!");
    }
}
