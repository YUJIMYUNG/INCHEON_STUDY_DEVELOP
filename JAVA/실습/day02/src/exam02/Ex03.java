package exam02;

public class Ex03 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;

        //연산은 같은 자료형끼리 가능함
        int result = num1 + num2;

        System.out.println(result);

        int num3 = 10; // 4byte
        double num4 = 20.0; //(소수점이 붙으면 실수로 받아들여짐) //8byte
        double result2 = num3 + num4; // int num3 -> double num3 으로 자동 변환됨

        System.out.println(result2);
    }
}
