package exam01;

public class Ex08 {
    static int num1; // 정수
    static double num2; // 실수
    static boolean result; // 논리값

    static String str; // 참조 변수

    public static void main(String[] args) {
        // 기본 자료형
        System.out.printf("num1=%d%n", num1); // 기본값 0
        System.out.printf("num2=%f%n", num2); // 기본값 0.0
        System.out.printf("result=%s%n", result); // 기본값 false

        // 참조 자료형
        System.out.printf("str=%s%n", str); // 기본값 null
    }
}
