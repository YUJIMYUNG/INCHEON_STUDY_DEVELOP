package exam01;

public class Ex04 {
    public static void main(String[] args) {
        int num1 = 10; //10은 재료가 되는 수 : 리터럴 상수
        int num2 = 10;

        char ch1 = 'A';
        char ch2 = 'A';

        System.out.println(num1 == num2); // == : 자원의 위치(주소)에 대한 비교
        System.out.println(ch1 == ch2); // ch1, ch2는 동일한 재료를 참조
    }
}
