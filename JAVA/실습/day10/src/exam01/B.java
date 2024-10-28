package exam01;

public class B extends A{ //A가 부모클래스 B가 자식클래스
    //B로 객체를 생성하면 A의 자원도 생상이 된다.
    int numB = 20;

    public B(){
        super(); // 따로 정의  안되어 있으면 컴파일러가 자동 추가한다. - A()
        System.out.println("B 생성자!");
    }
}
