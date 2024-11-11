package exam01;

@FunctionalInterface // 람다식) 하나의 단일 기능을 정의하기 위함을 체크한다
public interface Calculator {
    int add(int num1, int num2);
    // int minus(int num1, int num2); 람다식 -> 단일기능

}
