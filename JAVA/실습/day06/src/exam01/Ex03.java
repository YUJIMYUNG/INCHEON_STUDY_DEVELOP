package exam01;

public class Ex03 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;
        int result1 = add(num1, num2); // 일때 num1과 add 함수의 num1이 같을까? 다르다!



        int result = add(3, 4);
        System.out.println(result);
    }

    // 매개변수 2개 넣어보기
    // num1, num2, result - 함수가 호출 될 때만 변수
    //                    - 함수 지역 내에서만 의미가 있는 변수
    //                    - 지역변수 라고 한다.
    static int add(int num1, int num2){ // 함수 지역
       int result = num1 + num2;

       return result;
    }
}
