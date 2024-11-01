package exam01;

public class Ex02 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 2;
        try {
            int result = num1 / num2; // ArithmeticException
            System.out.println(result);

            String str = null;
            str = str.toUpperCase(); // NullPointerException
        } catch (ArithmeticException | NullPointerException e){ // 실행 코드가 같으면 이와같이 다중예외처리 할 수 있음
            System.out.println(e.getMessage());
        }

        System.out.println("계속 실행...");
    }
}
