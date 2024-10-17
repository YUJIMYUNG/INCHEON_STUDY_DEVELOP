package exam01;

public class Ex05 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = ++num1; // 1) num1에 ++증가연산되고 2)증가 된 num1값이 num2로 대입
        System.out.println(num1); //11출력
        System.out.println(num2); //11출력
    }
}
