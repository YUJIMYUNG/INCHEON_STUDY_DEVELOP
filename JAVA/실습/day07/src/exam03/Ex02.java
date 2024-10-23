package exam03;

public class Ex02 {
    public static void main(String[] args) {
       int result = add(10, 20); // int num1 = 10, int num2 = 20, // 값을 대입하는 지점에서 변수가 됨
       // System.out.println(result);
    }

    static int add(int num1, int num2){
        int result = num1 + num2;

        return result;
    }
}
