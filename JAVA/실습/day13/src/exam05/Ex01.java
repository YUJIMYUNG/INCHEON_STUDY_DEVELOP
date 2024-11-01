package exam05;

public class Ex01 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 0;

        try{
            int result = num1 / num2; // 예외가 발생하면 프로그램이 중단!
            //throw new AritbhmeticEception();
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("예외 발생 발생!");
        }

        System.out.println("매우 중요한 코드... 실행이 안되면 아주 큰 문제 발생!!!");


    }
}
