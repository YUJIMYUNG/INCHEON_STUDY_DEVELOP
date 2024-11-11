package exam01;

public class Ex03 {
    public static void main(String[] args) {
       // MyLambda my = (s) -> System.out.println(s);
        // 매개변수 하나일 때는 소괄호도 생략 가능
        MyLambda my = s -> System.out.println(s);
        my.print("message");
    }
}
