package exam02;

import java.sql.SQLOutput;

public class Ex01 {
    public static void main(String[] args) {
        int num = 10;
        if (num == 10) { //if (조건식 : 참/거짓을 판별)
            System.out.println("num은 10입니다."); //참일때 실행
        } else {
            System.out.println("num은 10이 아닙니다."); //거짓일때 실행

        }
        //간단한 조건문은 삼항 조건 연산식으로 대체 가능하다.
        String result = num == 10 ? "10입니다." : "10이 아닙니다.";
        System.out.println(result);


        //실행 코드가 한줄이면 {...}생략 가능
        if(num == 10)
            System.out.println("num은 10입니다.");
        else
            System.out.println("num은 10이 아닙니다.");
    }

}
