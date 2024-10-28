package exam01;

public class C extends B{
    int numC = 30;

    public C(){ // 기본생성자
        super(); //  따로 정의되어 있지 않다면 컴파일러가 추가함 - B()
        System.out.println("C 생성자!");
    }

}
