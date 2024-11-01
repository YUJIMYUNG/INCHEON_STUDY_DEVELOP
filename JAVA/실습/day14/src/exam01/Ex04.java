package exam01;

public class Ex04 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 2;
        try {
            int result = num1 / num2; // ArithmeticException
            System.out.println(result);

            String str = null;
            str = str.toUpperCase(); // 어떤 예외가 발생할지 모르는 경우라고 가정할 때
        } catch (ArithmeticException e){
            System.out.println(e.getMessage());
        } catch (Exception e){ // 모든 예외는 Exception 하위 클래스이므로 무조건 처리된다.
            System.out.println(e.getMessage());
        }

        System.out.println("계속 실행...");
    }
}
