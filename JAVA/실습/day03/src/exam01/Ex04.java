package exam01;

public class Ex04 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = num1++; // ++연산자가 num1뒤에 있으면 ++연산자를 뒤에 오는 값에 대입한다.
                           // 1) 대입(=) : 10, 2) ++(증가연산) : 11
        System.out.println(num2); //10출력
        System.out.println(num1); //11출력

    }
}
