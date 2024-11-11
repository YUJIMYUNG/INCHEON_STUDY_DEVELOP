package exam02;

import java.util.function.Function;

// 함수의 결합
public class Ex02 {
    public static void main(String[] args) {
        Function<String, Integer> func1 = s -> s.length(); //문자열 - 문자열의 길이
        Function<Integer, Integer> func2 = x -> x * x; // 숫자 - 숫자의 제곱

        // 문자열 -> 문자열 길이 -> 제곱
        Function<String, Integer> func3 = func1.andThen(func2);

        int result = func3.apply("가나다라마바");
        System.out.println(result);
    }
}
