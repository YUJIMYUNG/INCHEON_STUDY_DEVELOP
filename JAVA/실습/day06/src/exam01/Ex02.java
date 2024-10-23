package exam01;

public class Ex02 {
    public static void main(String[] args) {

        int result = calc(5);
        System.out.println(result);
    }

    // 함수의 기본적인 구성
    // int x : 매개변수
    static int calc(int x) {
        int y = x * 2 + 3;

        return y;
    }
}
